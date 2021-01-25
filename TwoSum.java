import java.util.*;
import java.io.*;
import java.lang.*;

class TwoSum {
   public int[] twoSum(int[] nums, int target) {
      Map<Integer,Integer> map = new HashMap<>();
      
      for (int i=0; i<nums.length; i++) {
          int num = nums[i];
          int complement = target - num;
          if (map.containsKey(complement)) {
              return new int[]{i, map.get(complement)};
          } else {
              map.put(num,i);
          }
      }
      
      return new int[]{0, 0};
  }
}