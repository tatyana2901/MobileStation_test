import org.example.Point;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PointTest {
    @Test
    void calcDistTo1(){
        Point a = new Point(0,0);
        Point b = new Point(0,0);
        Assertions.assertEquals(0,a.calcDistTo(b));
        Assertions.assertEquals(0,b.calcDistTo(a));
    }
    @Test
    void calcDistTo2(){
        Point a = new Point(0,0);
        Point b = new Point(0,100);
        Assertions.assertEquals(100,a.calcDistTo(b));
        Assertions.assertEquals(100,b.calcDistTo(a));
    }
    @Test
    void calcDistTo3(){
        Point a = new Point(3,0);
        Point b = new Point(0,4);
        Assertions.assertEquals(5,a.calcDistTo(b));
        Assertions.assertEquals(5,b.calcDistTo(a));
    }
    @Test
    void calcDistTo4(){
        Point a = new Point(3265,5655);
        Point b = new Point(0,100);
        Assertions.assertEquals(b.calcDistTo(a),a.calcDistTo(b));

    }
    @Test
    void calcDistTo5(){
        Point a = new Point(1,-10);
        Point b = new Point(-10,0);
        Assertions.assertEquals(b.calcDistTo(a),a.calcDistTo(b));

    }
}
