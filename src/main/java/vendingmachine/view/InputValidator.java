package vendingmachine.view;

public class InputValidator {

    public static void validateInputPrice(String price) {
        validateBlank(price);
        checkInteger(price);
    }

    private static Integer checkInteger(String input) {
        try {
            return Integer.valueOf(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("입력은 숫자만 가능합니다.");
        }
    }

    private static void validateBlank(String input) {
        if (input.isBlank()) {
            throw new IllegalArgumentException("값을 입력해주세요.");
        }
    }
}
