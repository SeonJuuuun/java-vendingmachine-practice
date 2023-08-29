package vendingmachine.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;
import vendingmachine.domain.Product;

public class InputView {

    private static final String INPUT_VENDING_MACHINE_PRICE = "자판기가 보유하고 있는 금액을 입력해 주세요.";
    private static final String INVALID_INPUT_INTEGER = "[ERROR] 입력은 숫자만 가능합니다.";
    private static final String INVALID_INPUT_BLANK = "[ERROR] 값을 입력해주세요.";
    private static final String INVALID_INPUT_NATURAL = "[ERROR] 보유 금액은 0보다 커야 합니다.";

    public static int inputVendingMachinePrice() {
        System.out.println(INPUT_VENDING_MACHINE_PRICE);
        String price = Console.readLine();
        validateInput(price);
        return Integer.parseInt(price);
    }

    public static List<Product> inputProducts() {
        System.out.println("상품명과 가격, 수량을 입력해 주세요.");
        String input = Console.readLine();
        String[] productStrings = input.split(";");
        return parseProductStrings(productStrings);
    }

    private static List<Product> parseProductStrings(String[] productStrings) {
        List<Product> products = new ArrayList<>();

        for (String productString : productStrings) {
            String[] fields = productString.replaceAll("[\\[\\]]", "").split(",");
            if (fields.length == 3) {
                products.add(new Product(fields[0], Integer.parseInt(fields[1]), Integer.parseInt(fields[2])));
            }
        }

        if (products.isEmpty()) {
            throw new IllegalArgumentException("유효한 상품 정보가 없습니다.");
        }

        return products;
    }

    public static int inputPrice() {
        System.out.println("투입 금액을 입력해 주세요.");
        String price = Console.readLine();
        validateInput(price);
        return Integer.parseInt(price);
    }

    public static String inputProductName() {
        System.out.println("구매할 상품명을 입력해 주세요.");
        return Console.readLine();
    }

    public static void validateInput(String price) {
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
