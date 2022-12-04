package pairmatching.controller;

import camp.nextstep.edu.missionutils.Randoms;
import pairmatching.service.MatchingService;
import pairmatching.utils.Validation;
import pairmatching.view.InputView;
import pairmatching.view.OutputView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class PairMatchingController {
    private static InputView inputView;
    private static OutputView outputView;
    private static MatchingService matchingService;
    private static HashMap<List<String>, List<List<String>>> matchedResult;

    public PairMatchingController() {
        inputView = new InputView();
        outputView = new OutputView();
        matchingService = new MatchingService();
        matchedResult = new HashMap<>();
    }

    public String inputFunction() {
        outputView.printInputFunction();
        return inputView.readFunction();
    }

    public List<String> inputCourseLevelMission() {
        outputView.printInformation();
        outputView.printInputCourseLevelMission();
        return inputView.readCourseLevelMission();
    }

    public void matching(List<String> commands) {
        String course = commands.get(0);
        List<String> crews = matchingService.getCrews(course);
        List<String> shuffledCrews = Randoms.shuffle(crews);
        List<List<String>> dividedCrews = divideCrews(shuffledCrews);
        matchedResult.put(commands, dividedCrews);
        outputView.printMatchingResult(dividedCrews);
    }

    private List<List<String>> divideCrews(List<String> crews) {
        List<List<String>> result = new ArrayList<>();
        if (crews.size() % 2 != 0) {
            for (int i = 0; i < crews.size() - 3; i += 2)
                result.add(crews.subList(i, i + 2));
            result.add(crews.subList(crews.size() - 3, crews.size()));
            return result;
        }
        for (int i = 0; i < crews.size(); i += 2)
            result.add(crews.subList(i, i + 2));
        return result;
    }

    public void printExistMatchedResult(List<String> commands) {
        try {
            Validation.isResultInMatched(matchedResult, commands);
        } catch (IllegalArgumentException e) {
            outputView.printException(e);
            return;
        }
        List<List<String>> result = matchedResult.get(commands);
        outputView.printMatchingResult(result);
    }
}
