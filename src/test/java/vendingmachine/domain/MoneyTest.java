package vendingmachine.domain;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import vendingmachine.Application;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class MoneyTest extends NsTest {

    @DisplayName("1000원에서 500원을 쓰면 500원이 남는다")
    @Test
    void spendMoney() {
        Money money = new Money(1000);
        money.spend(500);
        assertEquals(500, money.getMoney());
    }

    @DisplayName("1000원보다 작은값과 큰값 테스트")
    @Test
    void checkIfBiggerOrSame() {
        Money money = new Money(1000);

        assertTrue(money.isBiggerOrSame(500));
        assertFalse(money.isBiggerOrSame(1500));
    }

    @DisplayName("1000원에서 1000원을 쓰면 0원이 된다")
    @Test
    void checkIfEmpty() {
        Money money = new Money(1000);
        money.spend(1000);
        assertTrue(money.isEmpty());
    }

    @Test
    void validateMoney() {
        assertThrows(IllegalArgumentException.class, () -> new Money(5));
    }

    @DisplayName("자판기 금액에 영어가 들어오면 예외가 발생한다.")
    @Test
    void validateEnglishMoney() {
        assertSimpleTest(
            () -> {
                runException("a");
                assertThat(output()).contains("[ERROR]");
            }
        );
    }

    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}
