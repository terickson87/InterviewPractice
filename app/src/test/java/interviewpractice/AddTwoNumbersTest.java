package interviewpractice;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class AddTwoNumbersTest {
    @Test
    void example1() {
        A2N_ListNode l1 = new A2N_ListNode(2, new A2N_ListNode(4, new A2N_ListNode(3)));
        A2N_ListNode l2 = new A2N_ListNode(5, new A2N_ListNode(6, new A2N_ListNode(4)));
        A2N_ListNode expected = new A2N_ListNode(7, new A2N_ListNode(0, new A2N_ListNode(8)));

        AddTwoNumbers addTwoNumbers = new AddTwoNumbers();
        A2N_ListNode result = addTwoNumbers.addTwoNumbers(l1, l2);
        assertEquals(expected.val, result.val);
        assertEquals(expected.next.val, result.next.val);
        assertEquals(expected.next.next.val, result.next.next.val);
    }

    @Test
    void example2() {
        A2N_ListNode l1 = new A2N_ListNode(0);
        A2N_ListNode l2 = new A2N_ListNode(0);
        A2N_ListNode expected = new A2N_ListNode(0);

        AddTwoNumbers addTwoNumbers = new AddTwoNumbers();
        A2N_ListNode result = addTwoNumbers.addTwoNumbers(l1, l2);
        assertEquals(expected.val, result.val);
    }

    @Test
    void example3() {
        A2N_ListNode l1 = new A2N_ListNode(9, new A2N_ListNode(9, new A2N_ListNode(9, new A2N_ListNode(9, new A2N_ListNode(9, new A2N_ListNode(9, new A2N_ListNode(9)))))));
        A2N_ListNode l2 = new A2N_ListNode(9, new A2N_ListNode(9, new A2N_ListNode(9, new A2N_ListNode(9))));
        A2N_ListNode expected = new A2N_ListNode(8, new A2N_ListNode(9, new A2N_ListNode(9, new A2N_ListNode(9, new A2N_ListNode(0, new A2N_ListNode(0, new A2N_ListNode(0, new A2N_ListNode(1))))))));

        AddTwoNumbers addTwoNumbers = new AddTwoNumbers();
        A2N_ListNode result = addTwoNumbers.addTwoNumbers(l1, l2);
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
