package interviewpractice.permutations;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

public class PermutationsTest {
    @Test
    void example1() {
        int[] nums = new int[]{1,2,3};
        List<List<Integer>> expected = Arrays.asList(
            Arrays.asList(1,2,3),
            Arrays.asList(1,3,2),
            Arrays.asList(2,1,3),
            Arrays.asList(2,3,1),
            Arrays.asList(3,1,2),
            Arrays.asList(3,2,1)
        );
        Permutations permutations = new Permutations();
        List<List<Integer>> result = permutations.permute(nums);
        assertTrue(containsAll2D(expected, result));
        assertTrue(containsAll2D(result, expected));
    }

    @Test
    void example2() {
        int[] nums = new int[]{0,1};
        List<List<Integer>> expected = Arrays.asList(
            Arrays.asList(0,1),
            Arrays.asList(1,0)
        );
        Permutations permutations = new Permutations();
        List<List<Integer>> result = permutations.permute(nums);
        assertTrue(containsAll2D(expected, result));
        assertTrue(containsAll2D(result, expected));
    }

    @Test
    void example3() {
        int[] nums = new int[]{1};
        List<List<Integer>> expected = Arrays.asList(
            Arrays.asList(1)
        );
        Permutations permutations = new Permutations();
        List<List<Integer>> result = permutations.permute(nums);
        assertTrue(containsAll2D(expected, result));
        assertTrue(containsAll2D(result, expected));
    }

    public boolean containsAll2D(List<List<Integer>> first, List<List<Integer>> second) {
        for (List<Integer> iFirst : first) {
            for (List<Integer> iSecond : second) {
                if (!second.containsAll(first)) {
                    return false;
                }
            }
        }
        return true;
    }
}
