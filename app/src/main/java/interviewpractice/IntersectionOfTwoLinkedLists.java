package interviewpractice;

import java.util.ArrayList;
import java.util.HashMap;

class Io2LL_ListNode {
     int val;
     Io2LL_ListNode next;
     Io2LL_ListNode(int x) {
         val = x;
         next = null;
     }
     Io2LL_ListNode(int[] arr) {
         Io2LL_ListNode dummyHead = new Io2LL_ListNode(0);
        Io2LL_ListNode prev = dummyHead;
        for (int i = 0; i < arr.length; i++) {
            Io2LL_ListNode newNode = new Io2LL_ListNode(arr[i]);
            prev.next = newNode;
            prev = newNode;
        }
        val = dummyHead.next.val;
        next = dummyHead.next.next;
     }
 }
 
public class IntersectionOfTwoLinkedLists {
    public Io2LL_ListNode getIntersectionNode(Io2LL_ListNode headA, Io2LL_ListNode headB) {
        HashMap<Integer, Io2LL_ListNode> arrayBValNodeMap = new HashMap<>();
        ArrayList<Integer> arrayB = new ArrayList<>();
        
        Io2LL_ListNode lA = headA;
        while (lA != null) {

            Io2LL_ListNode lB = headB;
            while (lB != null) {
                if(lA == lB) {
                    return lA;
                }

                lB = (lB != null) ? lB.next : null;
            }

            lA = (lA != null) ? lA.next : null;
        }
        
        return null;
    }

    public static Io2LL_ListNode createIo2LL_ListNodeFromArray(int[] arr) {
        Io2LL_ListNode dummyHead = new Io2LL_ListNode(0);
        Io2LL_ListNode prev = dummyHead;
        for (int i = 0; i < arr.length; i++) {
            Io2LL_ListNode newNode = new Io2LL_ListNode(arr[i]);
            prev.next = newNode;
            prev = newNode;
        }

        return dummyHead.next;
    }
}
