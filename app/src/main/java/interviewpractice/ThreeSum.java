package interviewpractice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 https://leetcode.com/problems/3sum/
 Given an integer array nums, return all the triplets `[nums[i], nums[j], nums[k]]` such that `i != j`, `i != k`, and `j != k`, and `nums[i] + nums[j] + nums[k] == 0`.

Notice that the solution set must not contain duplicate triplets.

Example 1:
Input: nums = [-1,0,1,2,-1,-4]
Output: [[-1,-1,2],[-1,0,1]]
Explanation: 
nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0.
nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0.
nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0.
The distinct triplets are [-1,0,1] and [-1,-1,2].
Notice that the order of the output and the order of the triplets does not matter.

Example 2:
Input: nums = [0,1,1]
Output: []
Explanation: The only possible triplet does not sum up to 0.

Example 3:
Input: nums = [0,0,0]
Output: [[0,0,0]]
Explanation: The only possible triplet sums up to 0.
 */
public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> outlist = new ArrayList<>();
        
        for (int i = 0; i<nums.length-2; i++) {
            for (int j = i+1; j<nums.length-1; j++) {
                for (int k = i+2; k<nums.length; k++) {
                    if (isNoTwoMatching(i,j,k) && nums[i] + nums[j] + nums[k] == 0) {
                        List<Integer> sublist = new ArrayList<>(Arrays.asList(nums[i],nums[j],nums[k]));
                        if (!outlistContainsSublist(outlist, sublist)) {
                            outlist.add(sublist);
                        }
                    }
                }
            }
        }
        return outlist;
    }

    public boolean outlistContainsSublist(List<List<Integer>> outlist, List<Integer> sublist) {
        for (List<Integer> iOutList: outlist) {
            if (iOutList.containsAll(sublist) && sublist.containsAll(iOutList)) {
                return true;
            }
        }
        return false;
    }

    public boolean isNoTwoMatching(int i, int j, int k) {
        return i!=j && i!=k && j!=k;
    }
}
