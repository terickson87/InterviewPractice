import java.util.*;
import java.io.*;
import java.lang.*;

public class RandomSetRunner {
   public static void main(String[] args) {
      RandomizedSet randomizedSet = new RandomizedSet();
      System.out.println(randomizedSet.insert(1) == true);
      System.out.println(randomizedSet.remove(2) == false);
      System.out.println(randomizedSet.insert(2) == true);
      System.out.println(randomizedSet.getRandom());
      System.out.println(randomizedSet.remove(1) == true);
      System.out.println(randomizedSet.insert(2) == false);
      System.out.println(randomizedSet.getRandom() == 2);

      System.out.println();

      randomizedSet = new RandomizedSet();
      System.out.println(randomizedSet.remove(0) == false);
      System.out.println(randomizedSet.remove(0) == false);
      System.out.println(randomizedSet.insert(0) == true);
      System.out.println(randomizedSet.getRandom() == 0);
      System.out.println(randomizedSet.remove(0) == true);
      System.out.println(randomizedSet.insert(0) == true);
   }
}

class RandomizedSet {
   Random random;
   ArrayList<Integer> array;
   Map<Integer,Integer> map;
   
   /** Initialize your data structure here. */
   public RandomizedSet() {
       random = new Random();
       array = new ArrayList<>();
       map = new HashMap<>();
   }
   
   /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
   public boolean insert(int val) {
       boolean isInMap = this.map.containsKey(val);
       if (!isInMap) {
           this.array.add(val);
           this.map.put(val, this.array.size() - 1);
       }
       return !isInMap;
   }
   
   /** Removes a value from the set. Returns true if the set contained the specified element. */
   public boolean remove(int val) {
       boolean isInMap = this.map.containsKey(val);
       if (isInMap) {
            int valIndexInArray = this.map.get(val);
            int lastIndex = this.array.size() - 1;
            int lastVal = this.array.get(lastIndex);
            this.array.set(valIndexInArray, lastVal);
            this.array.remove(lastIndex);
            this.map.put(lastVal, valIndexInArray);
            this.map.remove(val);
       }
       return isInMap;
   }
   
   /** Get a random element from the set. */
   public int getRandom() {
       int index = this.random.nextInt(this.array.size());
       return this.array.get(index);
   }
}