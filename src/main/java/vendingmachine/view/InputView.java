package vendingmachine.view;

import static vendingmachine.view.InputValidator.validateInputPrice;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    private static final String ASK_VENDING_MACHINE_PRICE = "자판기가 보유하고 있는 금액을 입력해 주세요.";

    public int inputVendingMachinePrice() {
        System.out.println(ASK_VENDING_MACHINE_PRICE);
        String price = Console.readLine();
        validateInputPrice(price);
        return Integer.parseInt(price);
    }
}
