package vendingmachine.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    private static final String INPUT_VENDING_MACHINE_PRICE = "[ERROR] 자판기가 보유하고 있는 금액을 입력해 주세요.";
    private static final String INVALID_INPUT_INTEGER = "[ERROR] 입력은 숫자만 가능합니다.";
    private static final String INVALID_INPUT_BLANK = "[ERROR] 값을 입력해주세요.";
    private static final String INVALID_INPUT_NATURAL = "[ERROR] 보유 금액은 0보다 커야 합니다.";

    public static int inputVendingMachinePrice() {
        System.out.println(INPUT_VENDING_MACHINE_PRICE);
        String price = Console.readLine();
        validateInputPrice(price);
        return Integer.parseInt(price);
    }

    public static void validateInputPrice(String price) {
        validateBlank(price);
        checkInteger(price);
        validateNatural(price);
    }

    private static void checkInteger(String input) {
        try {
            Integer.valueOf(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INVALID_INPUT_INTEGER);
        }
    }

    private static void validateBlank(String input) {
        if (input.length() == 0) {
            throw new IllegalArgumentException(INVALID_INPUT_BLANK);
        }
    }

    private static void validateNatural(String input) {
        if(Integer.parseInt(input) < 1 ){
            throw new IllegalArgumentException(INVALID_INPUT_NATURAL);
        }
    }
}
