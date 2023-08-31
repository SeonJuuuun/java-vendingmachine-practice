package vendingmachine.domain;

public class Money {

    private static final int START_MONEY_PRICE = 10;

    private int money;

    public Money(int money) {
        validateMoney(money);
        this.money = money;
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

    public int getMoney() {
        return money;
    }

    private void validateMoney(int money) {
        checkInteger(money);
        checkMoneyRange(money);
    }

    private void checkInteger(int input) {
        try {
            Integer.valueOf(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 입력은 숫자만 가능합니다.");
        }
    }

    private void checkMoneyRange(int input) {
        if (input < START_MONEY_PRICE) {
            throw new IllegalArgumentException("[ERROR] 자판기의 동전은 10원이상 입력 가능합니다.");
        }
    }
}
