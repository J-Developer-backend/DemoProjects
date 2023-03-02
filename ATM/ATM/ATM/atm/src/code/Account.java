package code;

public class Account {
   private String name;
   private String password;
   private int moneyLimit;
   private String cardNumber;
   private int money;

    public Account() {
    }

    public Account(String name, String password, int moneyLimit, String cardNumber) {
        this.name = name;
        this.password = password;
        this.moneyLimit = moneyLimit;
        this.cardNumber = cardNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    public int getMoneyLimit() {
        return moneyLimit;
    }

    public void setMoneyLimit(int moneyLimit) {
        this.moneyLimit = moneyLimit;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }
}
