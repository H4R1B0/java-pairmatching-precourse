package pairmatching;

import pairmatching.controller.PairMatchingController;

import java.util.List;

public class PairMatching {
    private static final String MATCH = "1";
    private static final String CHECK = "2";
    private static final String RESET = "3";
    private static final String QUIT = "Q";
    private static PairMatchingController pairMatchingController;

    public PairMatching() {
        pairMatchingController = new PairMatchingController();

    }

    public void run() {
        while (true) {
            String function = pairMatchingController.inputFunction();
            if (function.equals(QUIT))
                return;
            if (function.equals(MATCH)) {
                functionMatch();
            }
            if(function.equals(CHECK)){
                functionCheck();
            }
        }
    }

    private void functionMatch() {
        List<String> courseLevelMission = pairMatchingController.inputCourseLevelMission();
        if(pairMatchingController.isResultInMatched(courseLevelMission)){
            courseLevelMission = pairMatchingController.inputReMatching(courseLevelMission);
        }
        pairMatchingController.matching(courseLevelMission);
    }

    private void functionCheck(){
        List<String> courseLevelMission = pairMatchingController.inputCourseLevelMission();
        pairMatchingController.printExistMatchedResult(courseLevelMission);
    }
}
