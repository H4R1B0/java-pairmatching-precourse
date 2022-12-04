package pairmatching.view;

import camp.nextstep.edu.missionutils.Console;
import pairmatching.utils.Calculator;
import pairmatching.utils.Validation;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputView {
    private static String INPUT_FUNCTION = "기능을 선택하세요.\n" +
            "1. 페어 매칭\n" +
            "2. 페어 조회\n" +
            "3. 페어 초기화\n" +
            "Q. 종료";
    private static String INPUT_COURSE_LEVEL_MISSION = "과정, 레벨, 미션을 선택하세요.\n" +
            "ex) 백엔드, 레벨1, 자동차경주";
    private static String PRINT_EXIST_MATCH_RESULT = "매칭 정보가 있습니다. 다시 매칭하시겠습니까?\n" +
            "네 | 아니오";
    public String readFunction() {
        while (true) {
            System.out.println(INPUT_FUNCTION);
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
            System.out.println(INPUT_COURSE_LEVEL_MISSION);
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

    public String readYesOrNo(){
        while (true) {
            System.out.println(PRINT_EXIST_MATCH_RESULT);
            String rematching = Console.readLine();
            if (validateYesOrNo(rematching))
                return rematching;
        }
    }

    private boolean validateYesOrNo(String rematching){
        try {
            Validation.isYesOrNo(rematching);
        } catch (IllegalArgumentException e) {
            System.out.println(e);
            return false;
        }
        return true;
    }
}
