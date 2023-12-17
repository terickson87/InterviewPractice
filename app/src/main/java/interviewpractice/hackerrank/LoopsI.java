package interviewpractice.hackerrank;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

// https://www.hackerrank.com/challenges/java-loops-i/problem
public class LoopsI {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(bufferedReader.readLine().trim());
        
        for (int i = 1; i < 11; i++) {
            System.out.printf("%d x %d = %d\n", N, i, N*i);
        }

        bufferedReader.close();
    }
}
