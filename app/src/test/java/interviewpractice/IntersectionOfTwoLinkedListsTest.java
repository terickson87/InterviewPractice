package interviewpractice;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class IntersectionOfTwoLinkedListsTest {
    @Test
    void example1() {
        Io2LL_ListNode listA = new Io2LL_ListNode(new int[] {4,1,8,4,5});
        Io2LL_ListNode listB = new Io2LL_ListNode(new int[] {5,6,1,8,4,5});
        int expected = 8;
        int expectedNext = 4;

        IntersectionOfTwoLinkedLists intersectionOfTwoLinkedLists = new IntersectionOfTwoLinkedLists();
        Io2LL_ListNode result = intersectionOfTwoLinkedLists.getIntersectionNode(listA, listB);
        assertTrue(expected == result.val);
        assertTrue(expectedNext == result.next.val);
    }

    void example2() {
        
    }

    void example3() {
        
    }
}
