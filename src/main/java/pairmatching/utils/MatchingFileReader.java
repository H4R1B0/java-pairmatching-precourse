package pairmatching.utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MatchingFileReader {
    public List<String> getListFromFile(String path) throws IOException {
        List<String> fileResult = new ArrayList<>();
        BufferedReader reader = new BufferedReader(
                new FileReader(path)
        );

        String crew;
        while ((crew = reader.readLine()) != null) {
            fileResult.add(crew);
        }
        reader.close();
        return fileResult;
    }
}
