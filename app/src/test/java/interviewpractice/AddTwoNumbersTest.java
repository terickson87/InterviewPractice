package interviewpractice;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class AddTwoNumbersTest {
    @Test
    void example1() {
        ListNode l1 = new ListNode(2, new ListNode(4, new ListNode(3)));
        ListNode l2 = new ListNode(5, new ListNode(6, new ListNode(4)));
        ListNode expected = new ListNode(7, new ListNode(0, new ListNode(8)));

        AddTwoNumbers addTwoNumbers = new AddTwoNumbers();
        ListNode result = addTwoNumbers.addTwoNumbers(l1, l2);
        assertEquals(expected.val, result.val);
        assertEquals(expected.next.val, result.next.val);
        assertEquals(expected.next.next.val, result.next.next.val);
    }

    @Test
    void example2() {
        ListNode l1 = new ListNode(0);
        ListNode l2 = new ListNode(0);
        ListNode expected = new ListNode(0);

        AddTwoNumbers addTwoNumbers = new AddTwoNumbers();
        ListNode result = addTwoNumbers.addTwoNumbers(l1, l2);
        assertEquals(expected.val, result.val);
    }

    @Test
    void example3() {
        ListNode l1 = new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9)))))));
        ListNode l2 = new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9))));
        ListNode expected = new ListNode(8, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(0, new ListNode(0, new ListNode(0, new ListNode(1))))))));

        AddTwoNumbers addTwoNumbers = new AddTwoNumbers();
        ListNode result = addTwoNumbers.addTwoNumbers(l1, l2);
        assertEquals(expected.val, result.val);
        assertEquals(expected.next.val, result.next.val);
        assertEquals(expected.next.next.val, result.next.next.val);
        assertEquals(expected.next.next.next.val, result.next.next.next.val);
        assertEquals(expected.next.next.next.next.val, result.next.next.next.next.val);
        assertEquals(expected.next.next.next.next.next.val, result.next.next.next.next.next.val);
        assertEquals(expected.next.next.next.next.next.next.val, result.next.next.next.next.next.next.val);
        assertEquals(expected.next.next.next.next.next.next.next.val, result.next.next.next.next.next.next.next.val);
    }
    
}
