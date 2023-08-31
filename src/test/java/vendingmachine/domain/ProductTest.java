package vendingmachine.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class ProductTest {

    @Test
    void 상품가격이_100원_미만_테스트() {
        assertThatThrownBy(() -> new Product("콜라", 50, 10)).isInstanceOf(
            IllegalArgumentException.class);
    }

    @DisplayName("상품 가격 테스트")
    @Test
    void decreaseQuantity() {
        Product product = new Product("Cola", 200, 5);
        product.decreaseQuantity();
        assertEquals(4, product.getQuantity());
    }
}
