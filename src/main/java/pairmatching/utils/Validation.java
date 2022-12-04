package pairmatching.utils;

import pairmatching.ErrorMessage;

public class Validation {
    private static final String MATCH = "1";
    private static final String CHECK = "2";
    private static final String RESET = "3";
    private static final String QUIT = "Q";

    public static void isFunction(String function) {
        if (!function.equals(MATCH) && !function.equals(CHECK) && !function.equals(RESET) && !function.equals(QUIT)) {
            throw new IllegalArgumentException(ErrorMessage.INPUT_FUNCTION.getMessage());
        }
    }
}
