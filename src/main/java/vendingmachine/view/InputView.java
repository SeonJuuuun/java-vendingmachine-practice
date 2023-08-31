package vendingmachine.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;
import vendingmachine.domain.Product;

public class InputView {

    private static final String LINE_BREAK = "\n";
    private static final int PRODUCT_SIZE = 3;

    public static int inputVendingMachinePrice() {
        System.out.println("자판기가 보유하고 있는 금액을 입력해 주세요.");
        String price = Console.readLine();
        validateInput(price);
        return Integer.parseInt(price);
    }

    public static List<Product> inputProducts() {
        System.out.println("상품명과 가격, 수량을 입력해 주세요.");
        String input = Console.readLine();
        String[] productStrings = input.split(";");
        return parseProducts(productStrings);
    }

    private static List<Product> parseProducts(String[] productStrings) {
        List<Product> products = new ArrayList<>();
        for (String productString : productStrings) {
            validateProductInputSeparator(productString);
            String[] fields = productString.replaceAll("[\\[\\]]", "").split(",");
            if (fields.length == PRODUCT_SIZE) {
                products.add(new Product(fields[0], Integer.parseInt(fields[1]),
                    Integer.parseInt(fields[2])));
            }
        }
        if (products.isEmpty()) {
            throw new IllegalArgumentException("[ERROR] 유효한 상품 정보가 없습니다.");
        }
        return products;
    }

    public static int inputPrice() {
        System.out.print(LINE_BREAK);
        System.out.println("투입 금액을 입력해 주세요.");
        String price = Console.readLine();
        validateInput(price);
        return Integer.parseInt(price);
    }

    public static String inputProductName() {
        System.out.println("구매할 상품명을 입력해 주세요.");
        return Console.readLine();
    }

    private static void validateInput(String price) {
        validateBlank(price);
        checkInteger(price);
    }

    private static void checkInteger(String input) {
        try {
            Integer.valueOf(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 입력은 숫자만 가능합니다.");
        }
    }

    private static void validateBlank(String input) {
        if (input.length() == 0) {
            throw new IllegalArgumentException("[ERROR] 값을 입력해주세요.");
        }
    }

    private static void validateProductInputSeparator(String input) {
        String[] productSets = input.split(";");
        for (String productSet : productSets) {
            validateBrackets(productSet);
            String productInfoString = productSet.replaceAll("\\[|\\]", "");
            String[] productInfo = productInfoString.split(",");
            validateProduct(productInfo);
            validateSemiColon(productInfo);
        }
    }

    private static void validateSemiColon(String[] productInfo) {
        if (productInfo.length > PRODUCT_SIZE) {
            throw new IllegalArgumentException("[ERROR] 세트들은 세미콜론(;)로 구분되어야 합니다.");
        }
    }

    private static void validateProduct(String[] productInfo) {
        if (productInfo.length < PRODUCT_SIZE) {
            throw new IllegalArgumentException("[ERROR] 세트에 상품명, 가격, 수량을 모두 입력해주세요.");
        }
    }

    private static void validateBrackets(String productSet) {
        if (!productSet.matches("\\[.*\\]")) {
            throw new IllegalArgumentException("[ERROR] 세트는 대괄호([])로 묶여야 합니다.");
        }
    }
}
