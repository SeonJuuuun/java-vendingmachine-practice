package vendingmachine.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.HashMap;
import java.util.Map;

public class CoinGroup {

    public final Map<Coin, Integer> coins = new HashMap<>();
    
    private void initMap() {
        for (Coin coin : Coin.values()) {
            coins.put(coin, 0);
        }
    }

    public Map<Coin, Integer> separateCoin(Money money) {
        initMap();
        while (!money.isEmpty()) {
            Coin coin = Coin.getCoin(Randoms.pickNumberInList(Coin.toList()));
            if (money.isBiggerOrSame(coin.getAmount())) {
                coins.replace(coin, coins.get(coin) + 1);
                money.spend(coin.getAmount());
            }
        }
        return coins;
    }
}