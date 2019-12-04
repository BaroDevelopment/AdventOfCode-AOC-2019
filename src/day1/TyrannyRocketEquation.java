package day1;

import util.FileUtil;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class TyrannyRocketEquation {

    public static void main(String[] args) throws IOException {
        FileUtil fu = new FileUtil();
        String fileName = "day1.txt";
        File file = fu.getFileFromResources(fileName);
        List<Integer> values = fu.getValuesasPerLine(file);
        int result = 0;
        for (int v : values) {
            v = v / 3 - 2;
            result += v;
        }
        System.out.println("Result is: " + result);
    }
}
