package util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FileUtil {

    public File getFileFromResources(String fileName) {

        ClassLoader classLoader = getClass().getClassLoader();

        URL resource = classLoader.getResource(fileName);
        if (resource == null) {
            throw new IllegalArgumentException("file is not found!");
        } else {
            return new File(resource.getFile());
        }
    }

    public List<Integer> getValuesasPerLine(File file) throws IOException {

        List<Integer> result = new ArrayList<>();

        if (file == null) return result;

        try (FileReader reader = new FileReader(file);
             BufferedReader br = new BufferedReader(reader)) {

            String line;
            while ((line = br.readLine()) != null) {
                result.add(Integer.parseInt(line));
            }
        }
        return result;
    }

    public List<Integer> getValuesasPerComma(File file) throws IOException {

        List<Integer> result = new ArrayList<>();

        if (file == null) return result;

        try (FileReader reader = new FileReader(file);
             BufferedReader br = new BufferedReader(reader)) {
            // read just first line
            String[] line = br.readLine().split(",");
            for (String s : line) {
                result.add(Integer.parseInt(s));
            }
        }
        return result;
    }
}
