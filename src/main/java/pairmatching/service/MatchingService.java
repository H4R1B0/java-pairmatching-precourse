package pairmatching.service;

import pairmatching.ErrorMessage;
import pairmatching.utils.MatchingFileReader;

import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class MatchingService {
    private static final String BACKEND = "백엔드";
    private static final String FRONTEND = "프론트엔드";
    private static final String BACKEND_PATH = "src/main/resources/backend-crew.md";
    private static final String FRONTEND_PATH = "src/main/resources/frontend-crew.md";
    private static MatchingFileReader matchingFileReader;

    public MatchingService() {
        matchingFileReader = new MatchingFileReader();
    }

    public List<String> getCrews(String course) {
        if (course.equals(BACKEND))
            return validateCrews(BACKEND_PATH);
        return validateCrews(FRONTEND_PATH);
    }

    private List<String> validateCrews(String path) {
        List<String> crews = new ArrayList<>();
        try {
            crews = matchingFileReader.getListFromFile(path);
        } catch (IOException e) {
            throw new IllegalArgumentException(ErrorMessage.NOT_EXIST_FILE.getMessage());
        }
        return crews;
    }
}