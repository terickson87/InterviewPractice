package interviewpractice;

import java.util.HashSet;
import java.util.Set;

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
     Io2LL_ListNode(Io2LL_ListNode head1, Io2LL_ListNode head2) {
        Io2LL_ListNode ptr = head1;

        while (ptr != null) {
            if (ptr.next == null) {
                ptr.next = head2;
                break;
            }
            ptr = ptr.next;
        }

        val = head1.val;
        next = head1.next;
     }
 }
 
public class IntersectionOfTwoLinkedLists {
    public Io2LL_ListNode getIntersectionNode(Io2LL_ListNode headA, Io2LL_ListNode headB) {
        // HashMap<Integer, Io2LL_ListNode> arrayBValNodeMap = new HashMap<>();
        // ArrayList<Integer> arrayB = new ArrayList<>();
        
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

     public Io2LL_ListNode getIntersectionNode_2(Io2LL_ListNode headA, Io2LL_ListNode headB) {
        // Create a hash set to store nodes from headA
        Set<Io2LL_ListNode> nodeSet = new HashSet<>();

        // Traverse and store nodes from headA in the hash set
        Io2LL_ListNode nodeA = headA;
        while (nodeA != null) {
            nodeSet.add(nodeA);
            nodeA = nodeA.next;
        }

        // Traverse headB and check if any of its nodes are in the hash set
        Io2LL_ListNode nodeB = headB;
        while (nodeB != null) {
            if (nodeSet.contains(nodeB)) {
                return nodeB; // Intersection found
            }
            nodeB = nodeB.next;
        }

        return null; // No intersection found
    }
}
