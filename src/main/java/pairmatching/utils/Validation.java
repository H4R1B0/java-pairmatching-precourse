package pairmatching.utils;

import pairmatching.Course;
import pairmatching.ErrorMessage;
import pairmatching.Level;
import pairmatching.Mission;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class Validation {
    private static final String MATCH = "1";
    private static final String CHECK = "2";
    private static final String RESET = "3";
    private static final String QUIT = "Q";
    private static final String YES = "네";
    private static final String NO = "아니오";

    public static void isFunction(String function) {
        if (!function.equals(MATCH) && !function.equals(CHECK) && !function.equals(RESET) && !function.equals(QUIT)) {
            throw new IllegalArgumentException(ErrorMessage.INPUT_FUNCTION.getMessage());
        }
    }

    public static void isCourseLevelMission(List<String> courseLevelMission) {
        isCommandsSizeThree(courseLevelMission);
        String course = courseLevelMission.get(0), level = courseLevelMission.get(1), mission = courseLevelMission.get(2);
        isCourse(course);
        isLevel(level);
        isMission(mission);
        isMissionEqualLevel(mission, level);
    }

    private static void isCommandsSizeThree(List<String> courseLevelMission) {
        if (courseLevelMission.size() != 3)
            throw new IllegalArgumentException(ErrorMessage.INPUT_COURSE_LEVEL_MISSION.getMessage());
    }

    private static void isCourse(String course) {
        HashSet<String> courses = new HashSet<>();
        for (Course value : Course.values()) {
            courses.add(value.getCourse());
        }
        if (!courses.contains(course))
            throw new IllegalArgumentException(ErrorMessage.INPUT_COURSE_LEVEL_MISSION.getMessage());
    }

    private static void isLevel(String level) {
        HashSet<String> levels = new HashSet<>();
        for (Level value : Level.values()) {
            levels.add(value.getLevel());
        }
        if (!levels.contains(level))
            throw new IllegalArgumentException(ErrorMessage.INPUT_COURSE_LEVEL_MISSION.getMessage());
    }

    private static void isMission(String mission) {
        HashSet<String> missions = new HashSet<>();
        for (Mission value : Mission.values()) {
            missions.add(value.getMission());
        }
        if (!missions.contains(mission))
            throw new IllegalArgumentException(ErrorMessage.INPUT_COURSE_LEVEL_MISSION.getMessage());
    }

    private static void isMissionEqualLevel(String mission, String level) {
        for (Mission value : Mission.values()) {
            if (mission.equals(value.getMission()) && level.equals(value.getLevel())) {
                return;
            }
        }
        throw new IllegalArgumentException(ErrorMessage.INPUT_COURSE_LEVEL_MISSION.getMessage());
    }

    public static void isResultInMatched(HashMap<List<String>, List<List<String>>> matchedResult, List<String> commands) {
        List<List<String>> result = matchedResult.getOrDefault(commands, new ArrayList<>());
        if (result.equals(new ArrayList<>()))
            throw new IllegalArgumentException(ErrorMessage.NOT_EXIST_RESULT.getMessage());
    }

    public static void isYesOrNo(String rematching) {
        if (!rematching.equals(YES) && !rematching.equals(NO))
            throw new IllegalArgumentException(ErrorMessage.INPUT_YES_OR_NO.getMessage());
    }
}
