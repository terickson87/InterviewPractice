package interviewpractice;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class NumIslands {
    private static final char LAND = '1';
    private static final char WATER = '0';

    int yMax;
    int xMax;

    static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int hashCode() {
            final int prime = 31;
            int result = 1;
            result = prime * result + x;
            result = prime * result + y;
            return result;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj)
                return true;
            if (obj == null)
                return false;
            if (getClass() != obj.getClass())
                return false;
            Point other = (Point) obj;
            if (x != other.x)
                return false;
            if (y != other.y)
                return false;
            return true;
        }
    }

    public int numIslands(char[][] grid) {
        yMax = grid.length;
        xMax = grid[0].length;
        List<HashSet<Point>> islands = new ArrayList<HashSet<Point>>();

        for (int i = 0; i < yMax; i++) {
            for (int j = 0; j < xMax; j++) {
                Point iPoint = new Point(j, i);
                if (isLand(grid, iPoint)) {
                    HashSet<Point> island = findExistingIsland(islands, iPoint, grid);
                    if (island != null) {
                        island.add(iPoint);
                    } else {
                        HashSet<Point> newIsland = new HashSet<>();
                        newIsland.add(iPoint);
                        islands.add(newIsland);
                    }
                }
            }
        }

        return islands.size();
    }

    // THis is a wrond implementation, need to do a BFS on every node
    public HashSet<Point> findExistingIsland(List<HashSet<Point>> islands, Point point, char[][] grid) {
        if (grid[point.y][point.x] == LAND) {
            for (HashSet<Point> island : islands) {
                Point left = new Point(point.x-1,point.y);
                Point right = new Point(point.x+1,point.y);
                Point up = new Point(point.x,point.y+1);
                Point down = new Point(point.x,point.y-1);
                if (isInGrid(left) && island.contains(left) // contains is failing, test contains
                || isInGrid(right) && island.contains(right)
                || isInGrid(up) && island.contains(up)
                || isInGrid(down) && island.contains(down))
                    return island;
            }
        }
        return null;
    }

    public boolean isWater(char[][] grid, Point point) {
        boolean result = !isLand(grid, point);
        return result;
    }

    public boolean isLand(char[][] grid, Point point) {
        boolean result = isInGrid(point) && grid[point.y][point.x] == LAND;
        return result;
    }

    public boolean isInGrid(Point point) {
        boolean result = (point.x >= 0 && point.x < xMax && point.y >= 0 && point.y < yMax) ? true : false;
        return result;
    }
}
