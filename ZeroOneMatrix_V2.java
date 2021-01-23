import java.util.*;
import java.util.spi.CurrencyNameProvider;
import java.io.*;
import java.lang.*;

public class ZeroOneMatrix_V2 {
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
      Queue<int[]> queue = new LinkedList<>();
      int rows = matrix.length;
      int cols = matrix[0].length;
      boolean[][] isVisited = new boolean[rows][cols];
      MatrixBoundsCheck matrixBoundsCheck = new MatrixBoundsCheck(rows, cols);

      // find all zeros and add to queue
      for (int i = 0; i < rows; i++) {
         for (int j = 0; j < cols; j++) {
            if (matrix[i][j] == 0) {
               queue.offer(new int[]{i,j});
               distances[i][j] = 0;
               isVisited[i][j] = true;
            }
         }
      }

      // Do BFS on the queue
      int[][] offsets = {{-1,0},{1,0},{0,-1},{0,1}};
      while (!queue.isEmpty()) {
         int[] currentPoint = queue.poll();
         int x = currentPoint[0];
         int y = currentPoint[1];
         for (int[] off : offsets) {
            int thisX = x + off[0];
            int thisY = y + off[1];
            if (matrixBoundsCheck.isIndexInMatrix(thisX, thisY) && !isVisited[thisX][thisY]) {
               isVisited[thisX][thisY] = true;
               distances[thisX][thisY] = distances[x][y] + 1;
               queue.offer(new int[]{thisX,thisY});
            }
         }
      }
      return distances;
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

   public MatrixBoundsCheck(int rows, int cols) {
      this.maxX = rows - 1;
      this.maxY = cols - 1;
   }

   public boolean isIndexInMatrix(int x, int y) {
      return ( (x >= minX && x <= maxX) && (y >= minY && y <= maxY));
   }
}