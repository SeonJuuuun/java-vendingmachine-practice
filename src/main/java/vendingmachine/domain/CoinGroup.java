package vendingmachine.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CoinGroup {

    public final Map<Coin, Integer> coins = new HashMap<>();

    public CoinGroup() {
        initMap();
    }

    private void initMap() {
        for (Coin coin : Coin.values()) {
            coins.put(coin, 0);
        }
    }

    public Map<Coin, Integer> separateCoin(Money money) {
        while (!money.isEmpty()) {
            Coin coin = Coin.getCoin(Randoms.pickNumberInList(Coin.toList()));
            if (money.isBiggerOrSame(coin.getAmount())) {
                coins.replace(coin, coins.get(coin) + 1);
                money.spend(coin.getAmount());
            }
        }
        return sortCoinGroup(coins);
    }

    private LinkedHashMap<Coin, Integer> sortCoinGroup(Map<Coin, Integer> map) {
        return map.entrySet().stream()
            .sorted(
                Map.Entry.<Coin, Integer>comparingByKey(Comparator.comparingInt(Coin::getAmount))
                    .reversed())
            .collect(Collectors.toMap(
                Map.Entry::getKey,
                Map.Entry::getValue,
                (oldValue, newValue) -> oldValue,
                LinkedHashMap::new
            ));
    }
}