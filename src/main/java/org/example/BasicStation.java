package org.example;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class BasicStation {
    private String operator;
    private Point coordinate;
    private int radius;

    public BasicStation(String operator, Point coordinate, int radius) {
        this.operator = operator;
        this.coordinate = coordinate;
        this.radius = radius;
    }

    public String getOperator() {
        return operator;
    }

    public boolean isUserWithinRadius(Point userCoordinate) {
        return !(coordinate.doubleCalcDistTo(userCoordinate) > radius*radius);
    }

    public static LinkedHashMap<String, Integer> consolidate(ArrayList<BasicStation> array, Point userCoordinate) {
        LinkedHashMap<String, Integer> hm = new LinkedHashMap<>();
        array.forEach(basicStation -> {
            if (!basicStation.isUserWithinRadius(userCoordinate)) {
                if (hm.containsKey(basicStation.getOperator())) {
                    int x;
                } else {
                    hm.put(basicStation.getOperator(), 0);
                }
            } else {
                if (hm.containsKey(basicStation.getOperator())) {
                    Integer result = hm.get(basicStation.getOperator()) + 1;
                    hm.put(basicStation.getOperator(), result);
                } else {
                    hm.put(basicStation.getOperator(), 1);
                }
            }
        });
        return hm;
    }

    public static void writeResult(LinkedHashMap<String, Integer> hashMap, String fileName) {
        try (FileWriter fw = new FileWriter(fileName, false)) {
            fw.write(hashMap.size() + "\n");
            hashMap.forEach((s, integer) -> {
                try {
                    fw.write(s + " " + integer + "\n");
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            });
            fw.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }

    public static Point getUserCoordinateFromFile(String filename) {
        List<String> data = null;
        try {
            data = Files.readAllLines(Paths.get(filename));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        String[] strings = data.getLast().split(" ");
        int x = Integer.parseInt(strings[0]);
        int y = Integer.parseInt(strings[1]);
        return new Point(x, y);
    }

    @Override
    public String toString() {
        return "BasicStation{" +
                "operator='" + operator + '\'' +
                ", coordinate=" + coordinate.getX() + coordinate.getY() +
                ", radius=" + radius +
                '}';
    }

    public static ArrayList<BasicStation> getDataFromFile(String fileName) {
        List<String> data = null;
        try {
            data = Files.readAllLines(Paths.get(fileName));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        data.removeLast();
        data.removeFirst();
        ArrayList<BasicStation> bc = new ArrayList<>();
        for (int i = 0; i < data.size(); i = i + 2) {
            String[] strings = data.get(i + 1).split(" ");
            int x = Integer.parseInt(strings[0]);
            int y = Integer.parseInt(strings[1]);
            int r = Integer.parseInt(strings[2]);
            bc.add(new BasicStation(data.get(i), new Point(x, y), r));
        }
        return bc;
    }


}
