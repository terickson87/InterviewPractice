package interviewpractice;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.jupiter.api.Test;

public class TwoSumTest {
    @Test
    void example1() {
        TwoSum twoSum = new TwoSum();
        int[] nums = new int[]{2,7,11,15};
        int target = 9;
        int[] result = twoSum.run(nums, target);
        int[] expected = new int[]{0,1};
        assertEquals(result.length, expected.length);
        List<Integer> resultList = Arrays.stream(result)
                .boxed()
                .collect(Collectors.toList());
        List<Integer> expectedList = Arrays.stream(expected)
                .boxed()
                .collect(Collectors.toList());
        assertTrue(resultList.containsAll(expectedList));
        assertTrue(expectedList.containsAll(resultList));
    }

    @Test
    void example2() {
        TwoSum twoSum = new TwoSum();
        int[] nums = new int[]{3,2,4};
        int target = 6;
        int[] result = twoSum.run(nums, target);
        int[] expected = new int[]{1,2};
        assertEquals(result.length, expected.length);
        List<Integer> resultList = Arrays.stream(result)
                .boxed()
                .collect(Collectors.toList());
        List<Integer> expectedList = Arrays.stream(expected)
                .boxed()
                .collect(Collectors.toList());
        assertTrue(resultList.containsAll(expectedList));
        assertTrue(expectedList.containsAll(resultList));
    }

    @Test
    void example3() {
        TwoSum twoSum = new TwoSum();
        int[] nums = new int[]{3,3};
        int target = 6;
        int[] result = twoSum.run(nums, target);
        int[] expected = new int[]{0,1};
        assertEquals(result.length, expected.length);
        List<Integer> resultList = Arrays.stream(result)
                .boxed()
                .collect(Collectors.toList());
        List<Integer> expectedList = Arrays.stream(expected)
                .boxed()
                .collect(Collectors.toList());
        assertTrue(resultList.containsAll(expectedList));
        assertTrue(expectedList.containsAll(resultList));
    }
}
