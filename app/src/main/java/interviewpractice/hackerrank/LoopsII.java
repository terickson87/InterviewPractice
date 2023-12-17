package interviewpractice.hackerrank;

import java.util.Scanner;

// https://www.hackerrank.com/challenges/java-loops/problem
public class LoopsII {
    public static void main(String []argh){
        Scanner in = new Scanner(System.in);
        int t=in.nextInt();
        for(int i=0;i<t;i++){
            int a = in.nextInt();
            int b = in.nextInt();
            int n = in.nextInt();
            int sum = a;
            for (int j=0;j<n;j++) {
                int val = calc(sum,b,j);
                sum += val;
                if (j != 0) {
                    System.out.printf(" ");
                }
                System.out.printf("%d", sum);
            }
            
            System.out.println();
        }
        in.close();
    }
    
    public static int calc(int sum, int b, int e) {
        return (int) Math.pow(2, e) * b;
    }
    
}
