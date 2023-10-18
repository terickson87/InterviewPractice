package interviewpractice;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    public int[] run(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            int complement = target - num;
            if (map.containsKey(complement)) {
                return new int[] { i, map.get(complement) };
            } else {
                map.put(num, i);
            }
        }

        return new int[] { 0, 0 };
    }
}
