package day2.part1;

import util.FileUtil;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class ProgramAlarm {

    public static void main(String[] args) throws IOException {
        FileUtil fu = new FileUtil();
        String fileName = "day2.txt";
        File file = fu.getFileFromResources(fileName);
        List<Integer> values = fu.getValuesasPerComma(file);

        // change values before running the program
        values.set(1, 12);
        values.set(2, 2);

        for (int i = 0; i < values.size(); i += 4) {
            try {
                int opcode = values.get(i);
                int indexInput1 = values.get(i + 1);
                int indexInput2 = values.get(i + 2);
                int indexOutput = values.get(i + 3);

                if (opcode == 1) {
                    values.set(indexOutput, values.get(indexInput1) + values.get(indexInput2));
                } else if (opcode == 2) {
                    values.set(indexOutput, values.get(indexInput1) * values.get(indexInput2));
                } else break;
            } catch (IndexOutOfBoundsException ioobe) {
                // ignore - we are done
            }
        }
        System.out.println("New Intcode is:");
        System.out.println(values);
        System.out.println("Result is: " + values.get(0));
    }
}
