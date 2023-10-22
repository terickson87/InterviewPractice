package interviewpractice;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.HashSet;

import org.junit.jupiter.api.Test;

import interviewpractice.NumIslands.Point;

public class NumIslandsTest {
    @Test
    void given_pointInHashSet_when_PointIsTested_then_returnsTrue() {
        Point point = new Point(0,0);
        HashSet<Point> island = new HashSet<Point>();
        island.add(point);

        Point newPointWithSameCoordinates = new Point(0, 0);

        boolean result = island.contains(newPointWithSameCoordinates);

        assertEquals(true, result);
    }

    @Test
    void given_pointNOtInHashSet_when_PointIsTested_then_returnsFalse() {
        Point point = new Point(0,0);
        HashSet<Point> island = new HashSet<Point>();
        island.add(point);

        Point newPointWithDiffCoordinates = new Point(0, 1);

        boolean result = island.contains(newPointWithDiffCoordinates);

        assertEquals(false, result);
    }

    @Test
    void example1() {
        char [][] grid = {
            {'1','1','1','1','0'},
            {'1','1','0','1','0'},
            {'1','1','0','0','0'},
            {'0','0','0','0','0'}
        };
        int expected = 1;
        NumIslands numIslands = new NumIslands();
        int result = numIslands.numIslands(grid);
        assertEquals(expected, result);
    }

    @Test
    void example2() {
        char [][] grid = {
            {'1','1','0','0','0'},
            {'1','1','0','0','0'},
            {'0','0','1','0','0'},
            {'0','0','0','1','1'}
        };
        int expected = 3;
        NumIslands numIslands = new NumIslands();
        int result = numIslands.numIslands(grid);
        assertEquals(expected, result);
    }

    @Test
    void example34() {
        char [][] grid = {
            {'1','1','1'},
            {'0','1','0'},
            {'1','1','1'}
        };
        int expected = 1;
        NumIslands numIslands = new NumIslands();
        int result = numIslands.numIslands(grid);
        assertEquals(expected, result);
    }
}
