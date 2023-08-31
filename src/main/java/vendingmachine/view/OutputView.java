package vendingmachine.view;

import java.util.LinkedHashMap;
import java.util.Map;
import vendingmachine.domain.Coin;
import vendingmachine.domain.CoinGroup;
import vendingmachine.domain.VendingMachine;

public class OutputView {

    private static final String LINE_BREAK = "\n";

    public static void printMap(Map<Coin, Integer> coins) {
        System.out.print(LINE_BREAK);
        System.out.println("자판기가 보유한 동전");
        for (Coin coin : coins.keySet()) {
            System.out.println(coin.getAmount() + "원 - " + coins.get(coin) + "개");
        }
        System.out.print(LINE_BREAK);
    }

    public static void printPrice(int price) {
        System.out.print(LINE_BREAK);
        System.out.println("투입 금액: " + price + "원");
    }

    public static void printRemainingCoin(VendingMachine vendingMachine, CoinGroup coinGroup) {
        System.out.println("잔돈");
        int remainingChange = vendingMachine.getPrice();
        Map<Coin, Integer> remainingCoins = new LinkedHashMap<>(coinGroup.getCoins());
        printCoinNumber(remainingChange, remainingCoins);
    }

    private static void printCoinNumber(int remainingChange, Map<Coin, Integer> remainingCoins) {
        for (Map.Entry<Coin, Integer> entry : remainingCoins.entrySet()) {
            Coin coin = entry.getKey();
            int coinCount = entry.getValue();
            int numCoinsToReturn = remainingChange / coin.getAmount();
            int numCoinsReturned = Math.min(numCoinsToReturn, coinCount);
            if (numCoinsReturned > 0) {
                System.out.println(coin.getAmount() + "원 - " + numCoinsReturned + "개");
                remainingChange -= numCoinsReturned * coin.getAmount();
            }
        }
    }
}
