package interviewpractice.hackerrank;

import java.util.Scanner;

// https://www.hackerrank.com/challenges/java-stdin-and-stdout-1/problem
public class StdinAndStdoutI {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int a = scan.nextInt();
        int b = scan.nextInt();
        int c = scan.nextInt();
        scan.close();

        System.out.println(a);
        System.out.println(b);
        System.out.println(c);
    }
    
}
