package com.cat.www.impl;

import com.cat.www.dao.DeleteDao;
import com.cat.www.dao.InsertDao;
import com.cat.www.dao.SearchDao;
import com.cat.www.dao.UpdateDao;
import com.cat.www.po.*;
import com.cat.www.service.EventService;
import com.xiedafeng.www.po.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EventServiceImpl implements EventService {
    private Condition condition=new Condition();
    private SearchDao searchDao=new SearchDao();
    private InsertDao insertDao=new InsertDao();
    private UpdateDao updateDao=new UpdateDao();
    private DeleteDao deleteDao=new DeleteDao();
    @Override
    public boolean thumbUp(User user, Event event) throws Exception {
        Thumbup thumbup=new Thumbup();
        if(searchDao.relationSearch(1,event,user,condition.eventAndUser(user,event),thumbup).size()==0){
            insertDao.insert(thumbup,searchDao.searchId(event,condition.event(event)),searchDao.searchId(user,condition.user(user)));
            event.setThumbUp(event.getThumbUp()+1);
            String[] target={"ThumbUp"};
            updateDao.update(event,searchDao.searchId(event,condition.event(event)),target);
            return true;
        }
        else {
            deleteDao.deleteRelation(event,user,searchDao.searchId(event,condition.event(event)),searchDao.searchId(user,condition.user(user)),thumbup, condition.noCondition());
            event.setThumbUp(event.getThumbUp()-1);
            String[] target={"ThumbUp"};
            updateDao.update(event,searchDao.searchId(event,condition.event(event)),target);
            return false;
        }
    }

    @Override
    public boolean collect(User user, Event event) throws Exception {
        Collect collect=new Collect();
        if(searchDao.relationSearch(1,event,user,condition.eventAndUser(user,event),collect).size()==0){
            insertDao.insert(collect,searchDao.searchId(event,condition.event(event)),searchDao.searchId(user,condition.user(user)));
            event.setCollect(event.getCollect()+1);
            String[] target={"Collect"};
            updateDao.update(event,searchDao.searchId(event,condition.event(event)),target);
            return true;
        }
        else {
            deleteDao.deleteRelation(event,user,searchDao.searchId(event,condition.event(event)),searchDao.searchId(user,condition.user(user)),collect, condition.noCondition());
            event.setCollect(event.getCollect()-1);
            String[] target={"Collect"};
            updateDao.update(event,searchDao.searchId(event,condition.event(event)),target);
            return false;
        }
    }

    @Override
    public List<Remark> showEventRemark(Event event) throws Exception {
        User user=new User();
        Remark remark=new Remark();
        return searchDao.relationSearch(3,event,user,condition.event(event),remark);
    }

    @Override
    public List<User> showRemarkUserName(Event event) throws Exception {
        Remark remark=new Remark();
        User user=new User();
        return searchDao.relationSearch(2,event,user,condition.event(event),remark);
    }

    @Override
    public void createRemark(User user, Event event, Remark remark) throws Exception {
        if (searchDao.relationSearch(1,event,user,condition.eventAndUser(user,event),remark).size()==0){
            searchDao.searchId(user,condition.user(user));
            InsertDao insertDao=new InsertDao();
            insertDao.insert(remark,searchDao.searchId(event,condition.event(event)),searchDao.searchId(user,condition.user(user)));
            UpdateDao updateDao=new UpdateDao();
            event.setRemark(event.getRemark()+1);
            String[] target={"Remark"};
            updateDao.update(event,searchDao.searchId(event,condition.event(event)),target);
        }
    }

    @Override
    public boolean deleteRemark(User user, Event event, Remark remark) throws Exception {
        List<Remark> remarkList=searchDao.relationSearch(3,event,user,condition.eventAndUser(user,event),remark);
        List<User> eventCreatorList=searchDao.relationSearch(2,event,user,condition.eventAndUser(user,event),null);
        if (remarkList.size()>0){
            for (int i = 0; i < remarkList.size(); i++) {
                if (remark.getRemarkContent().equals(remarkList.get(i).getRemarkContent())) {
                    deleteDao.deleteRelation(event,user,searchDao.searchId(event,condition.event(event)),searchDao.searchId(user,condition.user(user)),remark,condition.remark(remark));
                    event.setRemark(event.getRemark()-1);
                    String[] target={"Remark"};
                    updateDao.update(event,searchDao.searchId(event,condition.event(event)),target);
                    return true;
                }
            }
        }
        if (eventCreatorList.get(0).getUserName().equals(user.getUserName())){
            deleteDao.deleteRelation(event,user,searchDao.searchId(event,condition.event(event)),searchDao.searchId(user,condition.event(event)),remark,condition.remark(remark));
            event.setRemark(event.getRemark()-1);
            String[] target={"Remark"};
            updateDao.update(event,searchDao.searchId(event,condition.event(event)),target);
            return true;
        }
        return false;
    }

    @Override
    public void tipOff(User user, Event event, Notice notice) throws Exception {
        /*获取event所属的circle，从而找到管理员，将notice发给他（她），并为notice中的成员变量赋值*/
        Circle circle=new Circle();
        List<Circle> circleList=searchDao.relationSearch(2,event,circle,condition.event(event),null);
        notice.setSender(user.getUserName());
        notice.setCircle(circleList.get(0).getCircleName());
        notice.setEventContent(event.getContent());
        /*将notice插入到数据库对应表中，返回id值，然后在notice与发送notice的user的关联表中插入数据*/
        int noticeId=insertDao.inesrt(notice);
        insertDao.insert(notice,user,noticeId,searchDao.searchId(user,condition.user(user)));
        /*查找event所属的circle的创建者（管理员），也即notice的接收者，然后在notice与接收notice的user的关联表中插入数据*/
        User circleCreator=new User();
        List<User> circleCreatorList=searchDao.relationSearch(2,circleList.get(0),circleCreator,condition.circle(circle),null);
        insertDao.insert(circleCreatorList.get(0),notice,searchDao.searchId(circleCreatorList.get(0),condition.user(circleCreatorList.get(0))),noticeId);
    }

    @Override
    public int createEvent(User user, Circle circle, Event event) throws Exception {
        int eventId=insertDao.inesrt(event);
        insertDao.insert(event,circle,eventId,searchDao.searchId(circle,condition.circle(circle)));
        return insertDao.insert(event,user,eventId,searchDao.searchId(user,condition.user(user)));
    }

    @Override
    public boolean deleteEvent(User user, Event event) throws Exception {
        Circle circle=new Circle();
        List<Circle> circleList=searchDao.relationSearch(2,event,circle,condition.event(event),null);
        List<User> userlist=searchDao.relationSearch(2,event,user,condition.eventAndUser(user,event),null);
        List<User> circleCreateorList=searchDao.relationSearch(2,circleList.get(0),user,condition.circle(circle),null);
        if (userlist.size()==1||circleCreateorList.size()==1){
            Map userCondition=new HashMap();
            userCondition.put("UserName",userlist.get(0).getUserName());
            Map noCondition=new HashMap();
            deleteDao.deleteRelation(event,circleList.get(0),searchDao.searchId(event,condition.event(event)),searchDao.searchId(circleList.get(0),condition.circle(circle)),null,noCondition);
            deleteDao.deleteRelation(event,userlist.get(0),searchDao.searchId(event,condition.event(event)),searchDao.searchId(userlist.get(0),userCondition),null,noCondition);
            deleteDao.delete(event,searchDao.searchId(event,condition.event(event)));
            return true;
        }
        return false;
    }
}
