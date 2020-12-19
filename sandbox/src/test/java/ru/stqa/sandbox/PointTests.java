package ru.stqa.sandbox;

import org.junit.Test;
import org.testng.Assert;

public class PointTests {

    @Test
    public void testDistnce() {
        Point p1 = new Point(1,1);
        Point p2 = new Point(2,-1);
        Assert.assertEquals(p1.distance(p2),2.23606797749979);
    }
}
