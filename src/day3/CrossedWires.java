package day3;

import util.FileUtil;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class CrossedWires {

    public static void main(String[] args) throws IOException {
        FileUtil fu = new FileUtil();
        String fileName = "day3.txt";
        File file = fu.getFileFromResources(fileName);
        List<List<String>> items = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                items.add(Arrays.asList(line.split(",")));
            }
        }
        HashSet<String> wiresA = getWires(items.get(0));
        HashSet<String> wiresB = getWires(items.get(1));
        wiresA.retainAll(wiresB);
        System.out.println("Intersections are:");
        System.out.println(wiresA.toString());
        String closest = getClosestIntersectionPoint(wiresA);
        System.out.println("Closest intersection point is: " + closest);
        int result = Math.abs(Integer.parseInt(closest.split("/")[0])) + Math.abs(Integer.parseInt(closest.split("/")[1]));
        System.out.println("Manhatten distance from central port to the cloest intersection is: " + result);
    }

    private static String getClosestIntersectionPoint(HashSet<String> intersections) {
        HashSet<String> set = new HashSet<>(intersections);
        set.remove("0/0");
        String result = "0/0";
        int smallest = 999999999;
        for (String s : set) {
            int a = Integer.parseInt(s.split("/")[0]);
            int b = Integer.parseInt(s.split("/")[1]);
            int check = (int) Math.sqrt(Math.pow(a, 2) + Math.pow(b, 2));
            if (check < smallest) {
                result = s;
                smallest = check;
            }
        }
        return result;
    }

    private static HashSet<String> getWires(List<String> item) {
        int x = 0;
        int y = 0;
        HashSet<String> wires = new HashSet<>();
        wires.add(x + "/" + y);
        for (int i = 0; i < item.size(); i++) {
            int value = Integer.parseInt(item.get(i).substring(1));
            switch (item.get(i).substring(0, 1)) {
                case "R":
                    for (int j = 0; j < value; j++) {
                        x++;
                        wires.add(x + "/" + y);
                    }
                    break;
                case "L":
                    for (int j = 0; j < value; j++) {
                        x--;
                        wires.add(x + "/" + y);
                    }
                    break;
                case "U":
                    for (int j = 0; j < value; j++) {
                        y++;
                        wires.add(x + "/" + y);
                    }
                    break;
                case "D":
                    for (int j = 0; j < value; j++) {
                        y--;
                        wires.add(x + "/" + y);
                    }
                    break;
            }
        }
        return wires;
    }
}
