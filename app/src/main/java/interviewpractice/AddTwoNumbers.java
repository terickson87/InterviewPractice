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
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        int l1val = convertListNodeToInt(l1);
        int l2val = convertListNodeToInt(l2);
        int resultVal = l1val + l2val;
        ListNode result = convertIntToListNode(resultVal);

        return result;
    }

    public Integer convertListNodeToInt(ListNode listNode) {
        ListNode current = listNode;
        int resultVal = 0;
        int placeVal = 1;
        while (current != null) {
            resultVal += current.val*placeVal;
            placeVal *= 10;
            current = current.next;
        }
        return resultVal;
    }

    public ListNode convertIntToListNode(int resultVal) {
        
        int val = resultVal;
        ListNode resultList = new ListNode();
        ListNode current = resultList;
        // int mod = resultVal % 10;
        // ListNode resultList = new ListNode(mod);
        // val = val / 10;
        do {
            int mod = val % 10;
            current.val = mod;
            val = val / 10;
            if (val > 0) {
                current.next = new ListNode();
                current = current.next;
            }
        } while (val > 0);

        return resultList;
    }
}