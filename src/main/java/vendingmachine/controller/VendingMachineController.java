package vendingmachine.controller;

import java.util.List;
import vendingmachine.domain.CoinGroup;
import vendingmachine.domain.Money;
import vendingmachine.domain.Product;
import vendingmachine.domain.Products;
import vendingmachine.domain.VendingMachine;
import vendingmachine.view.InputView;
import vendingmachine.view.OutputView;

public class VendingMachineController {

    public void play() {
        start();
    }

    private void start() {
        Money money = vendingMachineMoney();
        CoinGroup coinGroup = new CoinGroup();
        OutputView.printMap(coinGroup.separateCoin(money));
        Products products = new Products(insertProduct());
        VendingMachine vendingMachine = new VendingMachine(products, insertPrice());
        soldOutOrEmptyPrice(vendingMachine);
    }

    private void soldOutOrEmptyPrice(VendingMachine vendingMachine) {
        while (!vendingMachine.isSoldOut()) {
            OutputView.printPrice(vendingMachine.getPrice());
            String productName = inputProductName();
            vendingMachine.purchaseProduct(productName);
        }
    }

    private String inputProductName() {
        return InputView.inputProductName();
    }

    private Money vendingMachineMoney() {
        return new Money(InputView.inputVendingMachinePrice());
    }

    private List<Product> insertProduct() {
        return InputView.inputProducts();
    }

    private int insertPrice() {
        return InputView.inputPrice();
    }
}
