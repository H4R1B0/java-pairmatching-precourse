package pairmatching.view;

import camp.nextstep.edu.missionutils.Console;
import pairmatching.utils.Validation;

public class InputView {
    public String readFunction() {
        while (true) {
            String inputtedFunction = Console.readLine();
            if (validateFunction(inputtedFunction))
                return inputtedFunction;
        }
    }

    private boolean validateFunction(String function) {
        try {
            Validation.isFunction(function);
        } catch (IllegalArgumentException e) {
            System.out.println(e);
            return false;
        }
        return true;
    }
}
