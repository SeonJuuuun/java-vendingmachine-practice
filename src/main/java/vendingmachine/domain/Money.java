package vendingmachine.domain;

public class Money {

    private int money;

    public Money(int money) {
        this.money = money;
    }

    public int getMoney() {
        return money;
    }

    public void spend(int money) {
        this.money -= money;
    }

    public boolean isBiggerOrSame(int money) {
        return this.money >= money;
    }

    public boolean isEmpty() {
        return money == 0;
    }
}
