package vendingmachine.domain;

import java.util.HashMap;
import java.util.Map;

public class CoinGroup {

    public final Map<Coin, Integer> coins = new HashMap<>();

    public CoinGroup(Money money) {
        initMap();
    }

    private void initMap() {
        for (Coin coin : Coin.values()) {
            coins.put(coin, 0);
        }
    }
}