package vendingmachine.domain;

public class VendingMachine {

    private final Products products;
    private int price;

    public VendingMachine(Products products, int price) {
        this.products = products;
        this.price = price;
    }

    public int getPrice() {
        return price;
    }

    public void purchaseProduct(String productName) {
        Product product = products.getProductByName(productName);
        if (price < product.getPrice()) {
            throw new IllegalArgumentException("[ERROR] 돈이 부족합니다.");
        }
        if (price >= product.getPrice()) {
            price -= product.getPrice();
            products.decreaseQuantity(productName);
        }
    }

    public void soldOut(String productName) {
        Product product = products.getProductByName(productName);
        if (product.isSoldOut()) {
            throw new IllegalArgumentException("[ERROR] 상품 재고가 없습니다.");
        }
    }

    public boolean priceOfRemainingProductPrice() {
        return price < products.getMinProductPrice();
    }
}
