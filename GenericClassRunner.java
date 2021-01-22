import java.util.*;
import java.io.*;
import java.lang.*;

public class GenericClassRunner {
   public static void main(String[] args) {
      SayHello sayHello = new SayHello();
      sayHello.sayHello("World");
   }
   
}

class SayHello {
   public void sayHello(String string) {
      System.out.println("Hello " + string);
   }
}

