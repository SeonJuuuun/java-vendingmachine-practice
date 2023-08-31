package vendingmachine.domain;

import java.util.List;

public class Products {

    private final List<Product> productGroup;

    public Products(List<Product> productGroup) {
        this.productGroup = productGroup;
    }

    public Product getProductByName(String productName) {
        for (Product product : productGroup) {
            if (product.getName().equals(productName)) {
                return product;
            }
        }
        throw new IllegalArgumentException("[ERROR] 입력하신 상품은 자판기에 팔지 않습니다.");
    }

    public void decreaseQuantity(String productName) {
        Product product = getProductByName(productName);
        product.decreaseQuantity();
    }

    public int getMinProductPrice() {
        return productGroup.stream()
            .mapToInt(Product::getPrice)
            .min()
            .orElse(0);
    }
}
