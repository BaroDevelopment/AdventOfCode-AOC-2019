package day2.part2;

import util.FileUtil;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ProgramAlarm2 {

    public static void main(String[] args) throws IOException {
        FileUtil fu = new FileUtil();
        String fileName = "day2.txt";
        File file = fu.getFileFromResources(fileName);
        List<Integer> values = fu.getValuesasPerComma(file);
        int target = 19690720;
        search:
        for (int i = 0; i < 100; i++){
            for (int j = 0; j < 100; j++){
                List<Integer> guess = run(values, i, j);
                if (guess.get(0) == target){
                    System.out.println("Result is: " + 100 * i + j);
                    break search;
                }
            }
        }
    }

    private static List<Integer> run(List<Integer> values, int first, int second) {
        List<Integer> result = new ArrayList<>(values);
        result.set(1, first);
        result.set(2, second);
        for (int i = 0; i < result.size(); i += 4) {
            try {
                int opcode = result.get(i);
                int indexInput1 = result.get(i + 1);
                int indexInput2 = result.get(i + 2);
                int indexOutput = result.get(i + 3);

                if (opcode == 1) {
                    result.set(indexOutput, result.get(indexInput1) + result.get(indexInput2));
                } else if (opcode == 2) {
                    result.set(indexOutput, result.get(indexInput1) * result.get(indexInput2));
                } else break;
            } catch (IndexOutOfBoundsException ioobe) {
                return result;
            }
        }
        return result;
    }
}
