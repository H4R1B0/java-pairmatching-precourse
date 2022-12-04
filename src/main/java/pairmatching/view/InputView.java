package pairmatching.view;

import camp.nextstep.edu.missionutils.Console;
import pairmatching.utils.Calculator;
import pairmatching.utils.Validation;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

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

    public List<String> readCourseLevelMission() {
        while (true) {
            String inputtedCourseLevelMission = Console.readLine();
            List<String> courseLevelMission = Calculator.getStringToList(inputtedCourseLevelMission);
            if (validateCourseLevelMission(courseLevelMission))
                return courseLevelMission;
        }
    }

    private boolean validateCourseLevelMission(List<String> courseLevelMission) {
        try {
            Validation.isCourseLevelMission(courseLevelMission);
        } catch (IllegalArgumentException e) {
            System.out.println(e);
            return false;
        }
        return true;
    }
}
