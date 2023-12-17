package interviewpractice.hackerrank;

import java.util.Scanner;

// https://www.hackerrank.com/challenges/java-static-initializer-block/problem
public class StaticInitializerBlock {
static int B;
static int H;
static boolean flag = true;

static {
    Scanner in = new Scanner(System.in);
    B = in.nextInt();
    in.nextLine();
    H = in.nextInt();
    in.close();
    
    if(B <= 0 || H <= 0) {
        System.out.println("java.lang.Exception: Breadth and height must be positive");
        flag = false;
    }
}
    
}
