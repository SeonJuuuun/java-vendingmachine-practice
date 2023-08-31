package vendingmachine.domain;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ProductsTest {

    @Test
    void getProductByName_nonExistingProduct() {
        List<Product> productList = new ArrayList<>();
        productList.add(new Product("Cola", 1500, 10));
        productList.add(new Product("Pepsi", 1200, 5));
        Products products = new Products(productList);
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            products.getProductByName("Fanta");
        });
        String expectedMessage = "[ERROR] 입력하신 상품은 자판기에 팔지 않습니다.";
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    void getMinProductPrice() {
        List<Product> productList = new ArrayList<>();
        productList.add(new Product("Cola", 1500, 10));
        productList.add(new Product("Pepsi", 1200, 5));
        productList.add(new Product("Sprite", 1000, 3));
        Products products = new Products(productList);

        assertEquals(1000, products.getMinProductPrice());
    }
}
