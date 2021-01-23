import java.util.*;
import java.io.*;
import java.lang.*;

public class RandomizedCollectionRunner {
   public static void main(String[] args) {
      RandomizedCollection randomizedCollection = new RandomizedCollection();
      System.out.println(randomizedCollection.insert(1) == true);
      System.out.println(randomizedCollection.insert(1) == false);
      System.out.println(randomizedCollection.insert(2) == true);
      System.out.println(randomizedCollection.getRandom());
      System.out.println(randomizedCollection.remove(1) == true);
      System.out.println(randomizedCollection.getRandom() == 2);

      System.out.println();

      randomizedCollection = new RandomizedCollection();
      System.out.println(randomizedCollection.insert(0) == true);
      System.out.println(randomizedCollection.remove(0) == true);
      System.out.println(randomizedCollection.insert(0) == true);

      randomizedCollection = new RandomizedCollection();
      System.out.println(randomizedCollection.insert(1) == true);
      System.out.println(randomizedCollection.remove(1) == true);
      System.out.println(randomizedCollection.insert(1) == true);
   }
}

class RandomizedCollection {
   Random mRandom;
   ArrayList<Integer> mArray;
   HashMap<Integer, LinkedHashSet<Integer>> mMap;
   
   /** Initialize your data structure here. */
   public RandomizedCollection() {
       mRandom = new Random();
       mArray = new ArrayList<>();
       mMap = new HashMap<>();
   }
   
   /** Inserts a value to the collection. Returns true if the collection did not already contain the specified element. */
   public boolean insert(int val) {
       boolean isInMap = mMap.containsKey(val);
       if (!isInMap) {
           mMap.put(val, new LinkedHashSet<>());
       }
       mMap.get(val).add(mArray.size());
       mArray.add(val);
       return !isInMap;
   }
   
   /** Removes a value from the collection. Returns true if the collection contained the specified element. */
   public boolean remove(int val) {
       boolean isInMap = mMap.containsKey(val);
       if (isInMap) {
           if (mArray.size() == 1) {
                mArray.clear();
                mMap.clear();
           } else {
                LinkedHashSet<Integer> valSet = mMap.get(val);
                int valIndexInArray = valSet.iterator().next();

                int lastVal = mArray.get(mArray.size() - 1);
                LinkedHashSet<Integer> lastValSet = mMap.get(lastVal);

                mArray.set(valIndexInArray, lastVal);
                valSet.remove(valIndexInArray);

                if (valIndexInArray != mArray.size() - 1) {
                    lastValSet.remove(mArray.size() - 1);
                    lastValSet.add(valIndexInArray);
                }
                mArray.remove(mArray.size() - 1);

                if (valSet.isEmpty()) {
                    mMap.remove(val);
                }
           }
       }
       return isInMap;
   }
   
   /** Get a random element from the collection. */
   public int getRandom() {
       int index = mRandom.nextInt(mArray.size());
       return mArray.get(index);
   }
}

class NumberData {
   private LinkedList<Integer> mIndicies = new LinkedList<>();
   private int mCount = 0;
   
   public NumberData(int arrayIndex) {
       pushIndex(arrayIndex);
   }
   
   public int getCount() {
       return mCount;
   }
   
   public void pushIndex(int arrayIndex) {
       mIndicies.addLast(arrayIndex);
       mCount++;
   }
   
   public int popIndex() {
       return mIndicies.removeLast();
   }
   
   
}
