package vendingmachine.view;

import java.util.Map;
import vendingmachine.domain.Coin;

public class OutputView {

    private static final String HAVE_COIN = "자판기가 보유한 동전";

    public static void printMap(Map<Coin, Integer> coins) {
        System.out.println(HAVE_COIN);
        for (Coin coin : coins.keySet()) {
            System.out.println(coin.getAmount() + "원 - " + coins.get(coin) + "개");
        }
    }
}
