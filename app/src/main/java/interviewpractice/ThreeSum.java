package interviewpractice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
