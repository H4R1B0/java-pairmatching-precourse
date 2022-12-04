package pairmatching.utils;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Calculator {
    public static List<String> getStringToList(String courseLevelMission) {
        return Arrays.stream(courseLevelMission.split(",")).map(String::trim).collect(Collectors.toList());
    }
}
