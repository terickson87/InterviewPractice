package interviewpractice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

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
        boolean[][] visited = new boolean[yMax][xMax]; //False default
        Queue<Point> queue = new LinkedList<Point>();
        Point firstPoint = new Point(0, 0);
        queue.offer(firstPoint);

        while (!queue.isEmpty()) {
            Point point = queue.poll();

            if (visited[point.y][point.x] == true){
                continue;
            } else {
                visited[point.y][point.x] = true;
            }
            addAdjacentPointsToQueue(visited, queue, point);

            if (isLand(grid, point)) {
                HashSet<Point> island = checkIfAdjacentPointsIsInAnExistingIsland(islands, point, grid);
                if (island != null) {
                    island.add(point);
                } else {
                    HashSet<Point> newIsland = new HashSet<>();
                    newIsland.add(point);
                    islands.add(newIsland);
                }
            }
        }

        boolean isChanged;
        do {
            isChanged = combineConnectedIslands(grid, islands);
        } while (isChanged == true);

        return islands.size();
    }

    public boolean combineConnectedIslands(char[][] grid, List<HashSet<Point>> islands) {
        for (HashSet<Point> island : islands) {
            for (Point point : island) {
                HashSet<Point> adjIsland = checkIfAdjacentPointsIsInAnExistingIsland(islands, point, grid);
                if (null != adjIsland && adjIsland != island) {
                    islands.remove(adjIsland);
                    island.addAll(adjIsland);
                    return true;
                }
            }    
        }
        return false;
    }

    public void addAdjacentPointsToQueue(boolean[][] visited, Queue<Point> queue, Point point) {
        Point left = new Point(point.x-1,point.y);
        addPointToQueueIfNotVisited(visited, queue, left);
        Point right = new Point(point.x+1,point.y);
        addPointToQueueIfNotVisited(visited, queue, right);
        Point up = new Point(point.x,point.y+1);
        addPointToQueueIfNotVisited(visited, queue, up);
        Point down = new Point(point.x,point.y-1);
        addPointToQueueIfNotVisited(visited, queue, down);
    }

    public void addPointToQueueIfNotVisited(boolean[][] visited, Queue<Point> queue, Point point) {
        if (isInGrid(point) && visited[point.y][point.x] == false) {
            queue.offer(point);
        }
    }

    public HashSet<Point> checkIfAdjacentPointsIsInAnExistingIsland(List<HashSet<Point>> islands, Point point, char[][] grid) {
        Point left = new Point(point.x-1,point.y);
        Point right = new Point(point.x+1,point.y);
        Point up = new Point(point.x,point.y+1);
        Point down = new Point(point.x,point.y-1);
        HashSet<Point> island;
        island = findExistingIslandForPoint(islands, left, grid);
        if (island != null)
            return island;
        island = findExistingIslandForPoint(islands, right, grid);
        if (island != null)
            return island;
        island = findExistingIslandForPoint(islands, up, grid);
        if (island != null)
            return island;
        island = findExistingIslandForPoint(islands, down, grid);
        if (island != null)
            return island;
        return null;
    }

    public HashSet<Point> findExistingIslandForPoint(List<HashSet<Point>> islands, Point point, char[][] grid) {
        if (isInGrid(point) && grid[point.y][point.x] == LAND) {
            for (HashSet<Point> island : islands) {
                if (island.contains(point))
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
