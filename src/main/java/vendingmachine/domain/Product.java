package vendingmachine.domain;

public class Product {

    private static final int MIN_PRODUCT_EXCEPTION = 10;
    private static final int START_PRODUCT_PRICE = 100;

    private final String name;
    private final int price;

    private int quantity;

    public Product(String name, int price, int quantity) {
        validatePrice(price);
        validateQuantity(quantity);
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public boolean isSoldOut() {
        return this.quantity == 0;
    }

    public void decreaseQuantity() {
        this.quantity--;
    }

    private void validateQuantity(int quantity) {
        checkInteger(quantity);
    }

    private void validatePrice(int price) {
        checkInteger(price);
        checkPriceRange(price);
    }

    private void checkInteger(int input) {
        try {
            Integer.valueOf(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 입력은 숫자만 가능합니다.");
        }
    }

    private void checkPriceRange(int input) {
        if (input < START_PRODUCT_PRICE) {
            throw new IllegalArgumentException("[ERROR] 상품 가격은 100원부터 시작합니다.");
        }
        if (!(input % MIN_PRODUCT_EXCEPTION == 0)) {
            throw new IllegalArgumentException("[ERROR] 상품 가격은 10원으로 나누어 떨어져야 합니다.");
        }
    }
}
