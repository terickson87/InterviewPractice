package interviewpractice.hackerrank;

import java.util.Scanner;

// https://www.hackerrank.com/challenges/java-end-of-file/problem
public class EndOfFile {
    public static void main(String[] args) {
        int lineNum = 0;
        
        Scanner in = new Scanner(System.in);
        while(in.hasNext()) {
            String str = in.nextLine();
            System.out.printf("%d %s\n", ++lineNum, str);
        }
        
        in.close();
    }
}
