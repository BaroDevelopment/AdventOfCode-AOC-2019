package day1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class TyrannyRocketEquation {

    public static void main(String[] args) throws IOException {
        TyrannyRocketEquation app = new TyrannyRocketEquation();
        String fileName = "day1.txt";
        ClassLoader classLoader = TyrannyRocketEquation.class.getClassLoader();
        File file = app.getFileFromResources(fileName);
        List<Integer> values = getValues(file);
        int result = 0;
        for (int v : values) {
            v = v / 3 - 2;
            result += v;
        }
        System.out.println("Result is: " + result);
    }

    private static List<Integer> getValues(File file) throws IOException {

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

    private File getFileFromResources(String fileName) {

        ClassLoader classLoader = getClass().getClassLoader();

        URL resource = classLoader.getResource(fileName);
        if (resource == null) {
            throw new IllegalArgumentException("file is not found!");
        } else {
            return new File(resource.getFile());
        }
    }

}
