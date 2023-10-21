package interviewpractice;

/*
 https://leetcode.com/problems/add-two-numbers/

You are given two non-empty linked lists representing two non-negative integers.
The digits are stored in reverse order, and each of their nodes contains a
single digit. Add the two numbers and return the sum as a linked list.

You may assume the two numbers do not contain any leading zero, except the
number 0 itself.

Example 1:
Input: l1 = [2,4,3], l2 = [5,6,4]
Output: [7,0,8]
Explanation: 342 + 465 = 807.

Example 2:
Input: l1 = [0], l2 = [0]
Output: [0]

Example 3:
Input: l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
Output: [8,9,9,9,0,0,0,1]

 */

 // Definition for singly-linked list.
class A2N_ListNode {
    int val;
    A2N_ListNode next;
    A2N_ListNode() {}
    A2N_ListNode(int val) { this.val = val; }
    A2N_ListNode(int val, A2N_ListNode next) { this.val = val; this.next = next; }
}

public class AddTwoNumbers {
    public A2N_ListNode addTwoNumbers(A2N_ListNode l1, A2N_ListNode l2) {
        A2N_ListNode dummyHead = new A2N_ListNode(0);
        A2N_ListNode tail = dummyHead;
        int carry = 0;

        while (l1 != null || l2 != null || carry != 0) {
            // get new values
            int val1 = (l1 != null) ? l1.val : 0;
            int val2 = (l2 != null) ? l2.val : 0;

            // Compute the sum and the carry digit
            int sum = val1 + val2 + carry;
            int digit = sum % 10;
            carry = sum / 10;

            // Add the new digit
            A2N_ListNode newNode = new A2N_ListNode(digit);

            // Move the tail pointer
            tail.next = newNode;
            tail = tail.next;

            // Move the list pointers
            l1 = (l1 != null) ? l1.next : null;
            l2 = (l2 != null) ? l2.next : null;
        }

        A2N_ListNode result = dummyHead.next;
        dummyHead.next = null;
        return result;
    }
}