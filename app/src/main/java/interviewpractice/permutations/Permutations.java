package interviewpractice.permutations;

import java.util.ArrayList;
import java.util.List;

public class Permutations {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new  ArrayList<>();
        backtrack(result, nums, new ArrayList());
        return result;
    }

    void backtrack(List<List<Integer>> result, int[] nums, List<Integer> current) {
        if (current.size() == nums.length) {
            result.add(new ArrayList(current));
            return;
        }
        for (int num : nums) {
            if (current.contains(num))
                continue;
            List<Integer> adddedTo = new ArrayList(current);
            adddedTo.add(num);
            backtrack(result, nums, adddedTo);
        }
    }
}
