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
        Money money = inputVendingMachineMoney();
        CoinGroup coinGroup = new CoinGroup();
        OutputView.printMap(coinGroup.separateCoin(money));
        Products products = new Products(insertProduct());
        VendingMachine vendingMachine = new VendingMachine(products, insertPrice());
        vendingMachineCalculate(vendingMachine);
        OutputView.printPrice(vendingMachine.getPrice());
        OutputView.printRemainingCoin(vendingMachine, coinGroup);
    }

    private void vendingMachineCalculate(VendingMachine vendingMachine) {
        while (!vendingMachine.priceOfRemainingProductPrice()) {
            OutputView.printPrice(vendingMachine.getPrice());
            String productName = inputProductName();
            vendingMachine.soldOut(productName);
            vendingMachine.purchaseProduct(productName);
        }
    }

    private String inputProductName() {
        while (true) {
            try {
                return InputView.inputProductName();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private Money inputVendingMachineMoney() {
        while (true) {
            try {
                return new Money(InputView.inputVendingMachinePrice());
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private List<Product> insertProduct() {
        while (true) {
            try {
                return InputView.inputProducts();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private int insertPrice() {
        while (true) {
            try {
                return InputView.inputPrice();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
