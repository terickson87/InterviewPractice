package interviewpractice;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

public class ThreeSumTest {
    @Test
    void example1() {
        int[] nums = new int[]{-1,0,1,2,-1,-4};
        List<List<Integer>> expected = new ArrayList<>();
        List<Integer> sublist1 = new ArrayList<>(Arrays.asList(-1,-1,2));
        List<Integer> sublist2 = new ArrayList<>(Arrays.asList(-1,0,1));
        expected.add(sublist1);
        expected.add(sublist2);

        ThreeSum threeSum = new ThreeSum();
        List<List<Integer>> result = threeSum.threeSum(nums);
        assertEquals(expected.size(), result.size());
        assertTrue(outlistContainsSublist(result, sublist1));
        assertTrue(outlistContainsSublist(result, sublist2));
    }

    @Test
    void example2() {
        int[] nums = new int[]{0,1,1};
        List<List<Integer>> expected = new ArrayList<>();

        ThreeSum threeSum = new ThreeSum();
        List<List<Integer>> result = threeSum.threeSum(nums);
        assertEquals(expected.size(), result.size());
    }

    @Test
    void example3() {
        int[] nums = new int[]{0,0,0};
        List<List<Integer>> expected = new ArrayList<>();
        List<Integer> sublist1 = new ArrayList<>(Arrays.asList(-0,0,0));
        expected.add(sublist1);

        ThreeSum threeSum = new ThreeSum();
        List<List<Integer>> result = threeSum.threeSum(nums);
        assertEquals(expected.size(), result.size());
        assertTrue(outlistContainsSublist(result, sublist1));
    }

    @Test
    void example4() {
        int[] nums = new int[]{3,0,-2,-1,1,2};
        List<List<Integer>> expected = new ArrayList<>();
        List<Integer> sublist1 = new ArrayList<>(Arrays.asList(-2,-1,3));
        List<Integer> sublist2 = new ArrayList<>(Arrays.asList(-2,0,2));
        List<Integer> sublist3 = new ArrayList<>(Arrays.asList(-1,0,1));
        expected.add(sublist1);
        expected.add(sublist2);
        expected.add(sublist3);
        ThreeSum threeSum = new ThreeSum();
        List<List<Integer>> result = threeSum.threeSum(nums);
        assertEquals(expected.size(), result.size());
        assertTrue(outlistContainsSublist(result, sublist1));
        assertTrue(outlistContainsSublist(result, sublist2));
        assertTrue(outlistContainsSublist(result, sublist3));
    }

    @Test
    void example5() {
        int[] nums = new int[]{-4,-2,1,-5,-4,-4,4,-2,0,4,0,-2,3,1,-5,0};
        List<List<Integer>> expected = new ArrayList<>();
        List<Integer> sublist1 = new ArrayList<>(Arrays.asList(-5,1,4));
        List<Integer> sublist2 = new ArrayList<>(Arrays.asList(-4,0,4));
        List<Integer> sublist3 = new ArrayList<>(Arrays.asList(-4,1,3));
        List<Integer> sublist4 = new ArrayList<>(Arrays.asList(-2,-2,4));
        List<Integer> sublist5 = new ArrayList<>(Arrays.asList(-2,1,1));
        List<Integer> sublist6 = new ArrayList<>(Arrays.asList(0,0,0));
        expected.add(sublist1);
        expected.add(sublist2);
        expected.add(sublist3);
        expected.add(sublist4);
        expected.add(sublist5);
        expected.add(sublist6);
        ThreeSum threeSum = new ThreeSum();
        List<List<Integer>> result = threeSum.threeSum(nums);
        assertEquals(expected.size(), result.size());
        assertTrue(outlistContainsSublist(result, sublist1));
        assertTrue(outlistContainsSublist(result, sublist2));
        assertTrue(outlistContainsSublist(result, sublist3));
        assertTrue(outlistContainsSublist(result, sublist4));
        assertTrue(outlistContainsSublist(result, sublist5));
        assertTrue(outlistContainsSublist(result, sublist6));
    }

    public boolean outlistContainsSublist(List<List<Integer>> outlist, List<Integer> sublist) {
        for (List<Integer> iOutList: outlist) {
            if (iOutList.containsAll(sublist)) {
                return true;
            }
        }
        return false;
    }
}
