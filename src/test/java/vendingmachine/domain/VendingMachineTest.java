package vendingmachine.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class VendingMachineTest {

    @DisplayName("돈이 부족하면 예외가 발생한다")
    @Test
    void purchaseProduct_insufficientMoney() {
        List<Product> productList = new ArrayList<>();
        productList.add(new Product("Cola", 1500, 5));
        productList.add(new Product("Pepsi", 1200, 3));
        Products products = new Products(productList);

        VendingMachine vendingMachine = new VendingMachine(products, 1000);

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            vendingMachine.purchaseProduct("Cola");
        });

        String expectedMessage = "돈이 부족합니다.";
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));
    }

    @DisplayName("재고가 0이면 예외가 발생한다.")
    @Test
    void soldOut_soldOutProduct() {
        List<Product> productList = new ArrayList<>();
        productList.add(new Product("Cola", 1500, 0));
        productList.add(new Product("Pepsi", 1200, 3));
        Products products = new Products(productList);

        VendingMachine vendingMachine = new VendingMachine(products, 2000);

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            vendingMachine.soldOut("Cola");
        });

        String expectedMessage = "[ERROR] 상품 재고가 없습니다.";
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));
    }

    @DisplayName("돈이 상품가격보다 더 많이 있으면 상품을 살 수 있다.")
    @Test
    void priceOfRemainingProductPrice_sufficientMoney() {
        List<Product> productList = new ArrayList<>();
        productList.add(new Product("Cola", 1500, 5));
        productList.add(new Product("Pepsi", 1200, 3));
        productList.add(new Product("Sprite", 1000, 4));
        Products products = new Products(productList);

        VendingMachine vendingMachine = new VendingMachine(products, 2500);

        assertFalse(vendingMachine.priceOfRemainingProductPrice());
    }

    @DisplayName("돈이 상품가격보다 더 많이 있으면 상품을 살 수 없다.")
    @Test
    void priceOfRemainingProductPrice_insufficientMoney() {
        List<Product> productList = new ArrayList<>();
        productList.add(new Product("Cola", 1500, 5));
        productList.add(new Product("Pepsi", 1200, 3));
        productList.add(new Product("Sprite", 1100, 4));
        Products products = new Products(productList);

        VendingMachine vendingMachine = new VendingMachine(products, 1000);

        assertTrue(vendingMachine.priceOfRemainingProductPrice());
    }
}
