package interviewpractice.hackerrank;

import java.util.Scanner;

// https://www.hackerrank.com/challenges/java-output-formatting/problem
public class OutputFormatting {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("================================");
        for(int i=0;i<3;i++){
            String s1=sc.next();
            int x=sc.nextInt();
            System.out.printf("%1$-15s%2$03d\n", s1, x);
        }
        System.out.println("================================");
        sc.close();
    }
}
