import org.example.Point;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PointTest {
    @Test
    void doubleCalcDistTo1(){
        Point a = new Point(0,0);
        Point b = new Point(0,0);
        Assertions.assertEquals(0,a.doubleCalcDistTo(b));
        Assertions.assertEquals(0,b.doubleCalcDistTo(a));
    }
    @Test
    void doubleCalcDistTo2(){
        Point a = new Point(0,0);
        Point b = new Point(0,100);
        Assertions.assertEquals(10000,a.doubleCalcDistTo(b));
        Assertions.assertEquals(10000,b.doubleCalcDistTo(a));
    }
    @Test
    void doubleCalcDistTo3(){
        Point a = new Point(3,0);
        Point b = new Point(0,4);
        Assertions.assertEquals(25,a.doubleCalcDistTo(b));
        Assertions.assertEquals(25,b.doubleCalcDistTo(a));
    }
    @Test
    void doubleCalcDistTo4(){
        Point a = new Point(3265,5655);
        Point b = new Point(0,100);
        Assertions.assertEquals(b.doubleCalcDistTo(a),a.doubleCalcDistTo(b));

    }
    @Test
    void doubleCalcDistTo5(){
        Point a = new Point(1,-10);
        Point b = new Point(-10,0);
        Assertions.assertEquals(b.doubleCalcDistTo(a),a.doubleCalcDistTo(b));

    }
}
