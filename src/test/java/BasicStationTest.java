import org.example.BasicStation;
import org.example.Point;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;

public class BasicStationTest {
    @Test
    void isUserWithinRadius1() {
        Point point = new Point(10, 15);
        BasicStation bs = new BasicStation("q", new Point(77, 14), 100);
        Assertions.assertTrue(bs.isUserWithinRadius(point));
    }

    @Test
    void isUserWithinRadius2() {
        Point point = new Point(0, 1);
        BasicStation bs = new BasicStation("q", new Point(77, 14), 2);
        Assertions.assertFalse(bs.isUserWithinRadius(point));
    }

    @Test
    void isUserWithinRadius3() {
        Point point = new Point(2, 4);
        BasicStation bs = new BasicStation("l", new Point(77, 14), 100);
        Assertions.assertTrue(bs.isUserWithinRadius(point));
    }

    @Test
    void isUserWithinRadius4() {
        Point point = new Point(-88, 77);
        BasicStation bs = new BasicStation("a", new Point(50, 14), 50);
        Assertions.assertFalse(bs.isUserWithinRadius(point));
    }

    @Test
    void isUserWithinRadius5() {
        Point ab = new Point(0, 5);
        BasicStation station = new BasicStation("Ele-ele", new Point(0, 0), 5);
        Assertions.assertTrue(station.isUserWithinRadius(ab));
    }
    @Test
    void isUserWithinRadius6() {
        Point point = new Point(1, 0);
        BasicStation bs = new BasicStation("a", new Point(0, 0), 1);
        Assertions.assertTrue(bs.isUserWithinRadius(point));
    }
    @Test
    void isUserWithinRadius7() {
        Point point = new Point(0, 0);
        BasicStation bs = new BasicStation("a", new Point(0, 0), 0);
        Assertions.assertTrue(bs.isUserWithinRadius(point));
    }

    @Test
    void consolidate1() {
        ArrayList<BasicStation> stations = new ArrayList<>();
        Point ab = new Point(5, 5);
        LinkedHashMap<String, Integer> actual = BasicStation.consolidate(stations, ab);
        LinkedHashMap<String, Integer> expected = new LinkedHashMap<>();
        Assertions.assertIterableEquals(expected.entrySet(), actual.entrySet());
    }

    @Test
    void consolidate2() {
        BasicStation s = new BasicStation("T", new Point(1, 1), 1);
        ArrayList<BasicStation> stations = new ArrayList<>();
        stations.add(s);
        Point ab = new Point(5, 5);
        LinkedHashMap<String, Integer> actual = BasicStation.consolidate(stations, ab);
        LinkedHashMap<String, Integer> expected = new LinkedHashMap<>();
        expected.put("T", 0);
        Assertions.assertIterableEquals(expected.entrySet(), actual.entrySet());
    }

    @Test
    void consolidate3() {
        ArrayList<BasicStation> stations = new ArrayList<>();
        stations.add(new BasicStation("XXX", new Point(1, 1), 10));
        Point ab = new Point(5, 5);
        LinkedHashMap<String, Integer> actual = BasicStation.consolidate(stations, ab);
        LinkedHashMap<String, Integer> expected = new LinkedHashMap<>();
        expected.put("XXX", 1);
        Assertions.assertIterableEquals(expected.entrySet(), actual.entrySet());
    }

    @Test
    void consolidate4() {
        ArrayList<BasicStation> stations = new ArrayList<>();
        stations.add(new BasicStation("Megahorn", new Point(0, 0), 10));
        stations.add(new BasicStation("BeepLine", new Point(10, 10), 10));
        stations.add(new BasicStation("MPS", new Point(0, 0), 10));
        stations.add(new BasicStation("Ele2", new Point(0, 0), 1));
        stations.add(new BasicStation("SkyPink", new Point(100, 100), 10));
        Point ab = new Point(5, 5);
        LinkedHashMap<String, Integer> actual = BasicStation.consolidate(stations, ab);
        LinkedHashMap<String, Integer> expected = new LinkedHashMap<>();
        expected.put("Megahorn", 1);
        expected.put("BeepLine", 1);
        expected.put("MPS", 1);
        expected.put("Ele2", 0);
        expected.put("SkyPink", 0);
        Assertions.assertIterableEquals(expected.entrySet(), actual.entrySet());
    }

    @Test
    void consolidate5() {
        ArrayList<BasicStation> stations = new ArrayList<>();
        stations.add(new BasicStation("Megahorn", new Point(0, 0), 10));
        stations.add(new BasicStation("Megahorn", new Point(0, 0), 10));
        stations.add(new BasicStation("Megahorn", new Point(0, 0), 10));
        stations.add(new BasicStation("Megahorn", new Point(0, 0), 10));
        stations.add(new BasicStation("Megahorn", new Point(0, 0), 10));
        Point ab = new Point(5, 5);
        LinkedHashMap<String, Integer> actual = BasicStation.consolidate(stations, ab);
        LinkedHashMap<String, Integer> expected = new LinkedHashMap<>();
        expected.put("Megahorn", 5);
        Assertions.assertIterableEquals(expected.entrySet(), actual.entrySet());
    }

    @Test
    void consolidate6() {
        Point ab = new Point(0, 0);
        ArrayList<BasicStation> stations = new ArrayList<>();
        stations.add(new BasicStation("Megahorn", ab, 10));
        stations.add(new BasicStation("Megahorn", ab, 10));
        stations.add(new BasicStation("123", ab, 10));
        stations.add(new BasicStation("AB", ab, 10));
        stations.add(new BasicStation("Megahorn", ab, 10));

        LinkedHashMap<String, Integer> actual = BasicStation.consolidate(stations, ab);
        LinkedHashMap<String, Integer> expected = new LinkedHashMap<>();
        expected.put("Megahorn", 3);
        expected.put("123",1);
        expected.put("AB",1);
        Assertions.assertIterableEquals(expected.entrySet(), actual.entrySet());
    }
    @Test
    void consolidate7() {
        ArrayList<BasicStation> stations = new ArrayList<>();
        stations.add(new BasicStation("Megahorn", new Point(0, 0), 10));
        stations.add(new BasicStation("megahorn", new Point(0, 0), 5));
        stations.add(new BasicStation("megahorn", new Point(0, 0), 10));
        stations.add(new BasicStation("Megahorn", new Point(0, 0), 10));
        stations.add(new BasicStation("Megahorn", new Point(0, 0), 10));
        Point ab = new Point(0, 0);
        LinkedHashMap<String, Integer> actual = BasicStation.consolidate(stations, ab);
        LinkedHashMap<String, Integer> expected = new LinkedHashMap<>();
        expected.put("Megahorn", 3);
        expected.put("megahorn",2);
        Assertions.assertIterableEquals(expected.entrySet(), actual.entrySet());
    }


}



