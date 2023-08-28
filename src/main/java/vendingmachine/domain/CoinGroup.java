package vendingmachine.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.HashMap;
import java.util.Map;

public class CoinGroup {

    public final Map<Coin, Integer> coins = new HashMap<>();

    public CoinGroup(Money money) {
        initMap();
        separateCoin(money);
    }

    private void initMap() {
        for (Coin coin : Coin.values()) {
            coins.put(coin, 0);
        }
    }

    private void separateCoin(Money money) {
        while (!money.isEmpty()) {
            Coin coin = Coin.getCoin(Randoms.pickNumberInList(Coin.toList()));
            if (money.isBiggerOrSame(coin.getAmount())) {
                coins.replace(coin, coins.get(coin) + 1);
                money.spend(coin.getAmount());
            }
        }
    }
}