package vendingmachine.domain;

public class VendingMachine {

    private final Products products;
    private int price;

    public VendingMachine(Products products, int price) {
        this.products = products;
        this.price = price;
    }

    public Products getProducts() {
        return products;
    }

    public int getPrice() {
        return price;
    }

    public void purchaseProduct(String productName) {
        Product product = products.getProductByName(productName);
        if (product != null) {
            if (price >= product.getPrice()) {
                price -= product.getPrice();
                products.decreaseQuantity(productName);
            }
        }
    }

    public boolean isSoldOut() {
        return products.isSoldOut();
    }
}
