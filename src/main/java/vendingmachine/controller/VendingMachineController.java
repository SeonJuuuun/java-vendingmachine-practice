package vendingmachine.controller;

import vendingmachine.domain.CoinGroup;
import vendingmachine.domain.Money;
import vendingmachine.view.InputView;
import vendingmachine.view.OutputView;

public class VendingMachineController {

    private final CoinGroup coinGroup;

    public VendingMachineController(CoinGroup coinGroup) {
        this.coinGroup = coinGroup;
    }

    public void play() {
        Money money = insertMoney();
        OutputView.printMap(coinGroup.separateCoin(money));
    }

    public Money insertMoney() {
       return new Money(InputView.inputVendingMachinePrice());
    }
}
