package code;


import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class ATM {
    public static void main(String[] args) {
        ArrayList<Account> accounts = new ArrayList<>();
        boolean flag = true ;
    while (flag){
        //ATM系统界面
        System.out.println("============欢迎登录ATM系统===========");
        System.out.println("1、登录账号");
        System.out.println("2、注册账号");
        System.out.println("3、退出ATM系统");
        System.out.println("请您输入操作命令：");
        Scanner sc = new Scanner(System.in);
        int choice = sc.nextInt();
        switch (choice){
            case 1 : {
                login(accounts, sc);
                break;
            }
            case 2 :{
                register(accounts,sc);
            break;
            }
            case 3  : {
                flag = false;
                break;
            }
            }
            }
        }
    //ATM账户登录界面
    public static void login(ArrayList<Account> accounts,Scanner sc){
        if(accounts.size()==0){
            System.out.println("该系统还没有账户，请先注册账户然后再登录！");
            return;
        }
        System.out.println("==========欢迎进入账号登录界面============");
        String password ;
        String cardNumber ;
        Account account = new Account();
        boolean flag = true;
        while(flag){
            System.out.println("请您输入登录的卡号");
            cardNumber = sc.next();
            for (int i = 0; i < accounts.size() ; i++) {
                account = accounts.get(i);
                if(account.getCardNumber().equals(cardNumber)){
                    flag = false ;
                    break;
                }
                if(i == accounts.size() - 1){
                    System.out.println("卡号不存在，请重新输入登录的卡号");
                }
            }
        }
        while(true){
            System.out.println("请您输入登录的密码");
            password = sc.next();
            if(account.getPassword().equals(password)){
                break;
            }else {
                System.out.println("密码不正确，请重新输入登录的密码");
            }
        }
        System.out.println("欢迎您，" + account.getName() + "先生/女士进入ATM系统，" + "您现在可以办理业务了！");
        functionMenu(accounts,account,sc);
    }
    //ATM账户注册界面
    public static void register(ArrayList<Account> accounts,Scanner sc){
        Account account = new Account();
        System.out.println("=========欢迎进入账户注册界面=========");
        System.out.println("请您输入帐户名称");
        String name = sc.next();
        account.setName(name);
        System.out.println("请您输入帐户密码");
        String firstPassword = sc.next();
        System.out.println("请您再次输入帐户密码进行确认");
        String secondPassword = sc.next();
        while (!firstPassword.equals(secondPassword)){
            System.out.println("两次输入的密码不同，请您重新输入确认密码");
            secondPassword = sc.next();
        }
        System.out.println("密码设置成功！");
        account.setPassword(firstPassword);
        System.out.println("请您设置当次取现额度");
        int moneyLimit = sc.nextInt();
        account.setMoneyLimit(moneyLimit);
        Random r = new Random();
        String s = "";
        for (int i = 0; i < 8;i++){
            s = s + r.nextInt(10);
        }
        account.setCardNumber(s);
        accounts.add(account);
        System.out.println("恭喜您，"+account.getName()+"先生/女士，"+"您开户成功！"+"您的卡号为"+account.getCardNumber());
    }
    //功能界面
    public static void functionMenu(ArrayList<Account> accounts,Account account,Scanner sc){
        while(true){
            System.out.println("=========欢迎进入功能界面============");
            System.out.println("1、查询余额");
            System.out.println("2、存款");
            System.out.println("3、取款");
            System.out.println("4、转账");
            System.out.println("5、修改密码");
            System.out.println("6、注销账号");
            System.out.println("7、退出界面");
            System.out.println("请您输入操作命令：");
            int choice = sc.nextInt();
            switch (choice) {
                case 1 :{
                    checkMoney(account);
                    break;
                }
                case 2 :{
                    putInMoney(account, sc);
                    break;
                }
                case 3 :{
                    putOutMoney(account, sc);
                    break;
                }
                case 4 :{
                    transferMoney(accounts, account, sc);
                    break;
                }
                case 5 :{
                    changePassword(account, sc);
                    break;
                }
                case 6 :{
                    delAccount(accounts,account);
                    return;
                }
                case 7 :{
                    return;
                }
            }
        }
    }
    //账号查询余额功能
    public static void checkMoney(Account account){
        System.out.println("==========当前账户余额信息==========");
        System.out.println("卡号：" + account.getCardNumber());
        System.out.println("账户："+account.getName());
        System.out.println("余额：" + account.getMoney());
        System.out.println("当次取款额度：" + account.getMoneyLimit());
    }
    //账号存款功能
    public static void putInMoney(Account account,Scanner sc){
        System.out.println("===========账号存款界面==========");
        System.out.println("请您输入存款金额：");
        int money = sc.nextInt();
        while(true){
            if(money < 0){
                System.out.println("存款金额不合理，请您重新输入！");
                System.out.println("请您输入存款金额：");
                money = sc.nextInt();
            }else{
                break;
            }
        }
        account.setMoney(account.getMoney() + money);
        System.out.println("存款成功！");
    }
    //账号取款功能
    public static void putOutMoney(Account account,Scanner sc){
        System.out.println("==========账号取款界面============");
        boolean flag = true;
        while(flag){
            System.out.println("请您输入取款的金额：");
            int money = sc.nextInt();
            while(true){
                if(money < 0){
                    System.out.println("取款金额不合理，请您重新输入！");
                    System.out.println("请您输入取款金额：");
                    money = sc.nextInt();
                }else{
                    break;
                }
            }
            if(account.getMoney() < money){
                System.out.println("您的余额不足！");
            } else if (money > account.getMoneyLimit()){
                System.out.println("取款金额超出额度，请重新输入取款金额");
            } else {
                account.setMoney(account.getMoney() - money);
                flag = false ;
            }
        }
        System.out.println("取款成功！");
    }
    //账户转账功能
    public static void transferMoney(ArrayList<Account> accounts,Account account,Scanner sc){
        System.out.println("==========账户转账界面==========");
        String cardNumber;
        while(true){
            System.out.println("请您输入收款方的卡号");
            cardNumber = sc.next();
            if(account.getCardNumber().equals(cardNumber)){
                System.out.println("您输入的卡号为本人卡号，请重新输入");
            } else {
                break;
            }
        }
            for (Account account1 : accounts) {
                if (account1.getCardNumber().equals(cardNumber)) {
                    System.out.println("=========收款方的信息========");
                    System.out.println("卡号：" + account1.getCardNumber());
                    String name = account1.getName();
                    char fName = name.charAt(0);
                    char[] names = name.toCharArray();
                    names[0] = '*';
                    String endName = new String(names);
                    System.out.println("账号：" + endName);
                    while (true){
                        System.out.println("请您输入收款方的姓氏，来确认收款方的信息");
                        char fInName = sc.next().charAt(0);
                        if (fInName == fName) {
                            System.out.println("姓氏匹配成功！");
                            while(true){
                                System.out.println("请您输入转账金额");
                                int money = sc.nextInt();
                                if(money < 0){
                                    System.out.println("输入的转账金额不合理，请重新输入");
                                    continue;
                                }
                                if (money > account.getMoney()) {
                                    System.out.println("您的余额不足！");
                                } else {
                                    account.setMoney(account.getMoney() - money);
                                    account1.setMoney(account1.getMoney() + money);
                                    System.out.println("转账成功！");
                                    return ;
                                }
                            }
                        } else {
                            System.out.println("姓氏与收款方的姓氏不匹配，请重新输入");
                        }
                    }

                }
            }
        System.out.println("该系统没有该账户，查无此人！需要注册账号才有该账户！");
    }
    //账户修改密码功能
    public static void changePassword(Account account, Scanner sc){
        System.out.println("=========账户修改密码界面==========");
        while(true){
            System.out.println("请输入原始密码");
            String oldPassword = sc.next();
            if(!account.getPassword().equals(oldPassword)){
                System.out.println("原始密码不正确，请您重新输入");
            } else {
                break;
            }
        }
        System.out.println("请输入新密码");
        String newPassword1 = sc.next();
        while(true){
            System.out.println("请重新输入，确认新密码");
            String newPassword2 = sc.next();
            if(newPassword1.equals(newPassword2)){
                account.setPassword(newPassword1);
                System.out.println("密码修改成功！");
                return ;
            }else {
                System.out.println("两次密码输入不一致，请重新输入新密码确认");
            }
        }
    }
    //账户注销账户功能
    public static void delAccount(ArrayList<Account> accounts,Account account){
        System.out.println("==========账户注销账户界面==========");
        System.out.println("当前账户信息");
        System.out.println("卡号：" + account.getCardNumber());
        System.out.println("账户：" + account.getName());
        System.out.println("余额：" + account.getMoney());
        System.out.println("当次取款额度：" + account.getMoneyLimit());
        accounts.remove(account);
        System.out.println("账户注销成功！");
        }

}
