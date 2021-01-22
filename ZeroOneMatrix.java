import java.util.*;
import java.io.*;
import java.lang.*;

public class ZeroOneMatrix {
   public static void main(String[] args) {
      int[][] arr = {{0,0,0}, {0,1,0}, {0,0,0}};
      print2dArray(arr);
      int[][] distances = solve(arr);
      print2dArray(distances);

      int[][] arr2 = {{0,0,0}, {0,1,0}, {1,1,1}};
      print2dArray(arr2);
      int[][] distances2 = solve(arr2);
      print2dArray(distances2);
   }

   public static int[][] solve(int[][] matrix) {
      int[][] distances = new int[matrix.length][matrix[0].length];

      for (int i = 0; i < matrix.length; i++) {
         for (int j = 0; j < matrix[i].length; j++) {
            distances[i][j] = findMinDistanceToZero(i, j, matrix);
         }
      }

      return distances;
   }

   public static int findMinDistanceToZero(int x, int y, int[][] matrix) {
      int min = Integer.MAX_VALUE;
      Queue<Point> queue = new LinkedList<>();
      MatrixBoundsCheck matrixBoundsCheck = new MatrixBoundsCheck(matrix.length - 1, matrix[0].length - 1);
      Set<Point> visistedPoints = new HashSet<>();

      addPointAndOffsetsToQueue(queue, x, y, matrixBoundsCheck, visistedPoints);
      while (!queue.isEmpty()) {
         Point point = queue.poll();
         visistedPoints.add(point);

         if (matrix[point.getX()][point.getY()] == 0) {
            int thisDis = rectangularDistance(x, y, point.getX(), point.getY());
            if (thisDis < min) {
               min = thisDis;
            }
            return min;

         } else {
            addPointAndOffsetsToQueue(queue, point.getX(), point.getY(), matrixBoundsCheck, visistedPoints);
         }
      }

      return min;
   }

   public static void addPointAndOffsetsToQueue(Queue<Point> queue, int x, int y, MatrixBoundsCheck matrixBoundsCheck, Set<Point> visistedPoints) {
      int[] offsets = {0,-1,1};
      for (int xOff : offsets) {
         int thisX = x + xOff;
         for (int yOff : offsets) {
            int thisY = y + yOff;

            boolean isGoodIndex = matrixBoundsCheck.isIndexInMatrix(thisX, thisY);
            boolean isVisited = visistedPoints.contains(new Point(thisX, thisY));
            if (isGoodIndex && !isVisited) {
               queue.offer(new Point(thisX, thisY));
            }
         }
      }
   }

   public static int rectangularDistance(int x1, int y1, int x2, int y2) {
      return Math.abs((x2 - x1)) + Math.abs((y2 - y1));
   }

   public static void print2dArray(int[][] arr) {
      String raw = Arrays.deepToString(arr);
      String inLines = raw.replace("],", "]\n");
      System.out.println(inLines);
      System.out.println();
   }
}

class MatrixBoundsCheck {
   private final int maxX;
   private final int maxY;
   private final int minX = 0;
   private final int minY = 0;

   public MatrixBoundsCheck(int maxX, int maxY) {
      this.maxX = maxX;
      this.maxY = maxY;
   }

   public boolean isIndexInMatrix(int x, int y) {
      return ( (x >= minX && x <= maxX) && (y >= minY && y <= maxY));
   }
}

class Point {
   private final int x;
   private final int y;

   public Point(int x, int y) {
      this.x = x;
      this.y = y;
   }

   public int getX() {
      return this.x;
   }

   public int getY() {
      return this.y;
   }
}