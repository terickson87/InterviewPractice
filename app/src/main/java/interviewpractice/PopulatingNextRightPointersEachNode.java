package interviewpractice;

/*
 https://leetcode.com/problems/populating-next-right-pointers-in-each-node/description/
 You are given a perfect binary tree where all leaves are on the same level, and every parent has two children. The binary tree has the following definition:

struct Node {
  int val;
  Node *left;
  Node *right;
  Node *next;
}
Populate each next pointer to point to its next right node. If there is no next right node, the next pointer should be set to NULL.

Initially, all next pointers are set to NULL.
Example 1:
Input: root = [1,2,3,4,5,6,7]
Output: [1,#,2,3,#,4,5,6,7,#]
Explanation: Given the above perfect binary tree (Figure A), your function should populate each next pointer to point to its next right node, just like in Figure B. The serialized output is in level order as connected by the next pointers, with '#' signifying the end of each level.

Example 2:
Input: root = []
Output: []

Constraints:

The number of nodes in the tree is in the range [0, 2^(12 - 1)].
-1000 <= Node.val <= 1000
 */

class PNRPEN_Node {
    public int val;
    public PNRPEN_Node left;
    public PNRPEN_Node right;
    public PNRPEN_Node next;

    public PNRPEN_Node() {}
    
    public PNRPEN_Node(int _val) {
        val = _val;
    }

    public PNRPEN_Node(int _val, PNRPEN_Node _left, PNRPEN_Node _right, PNRPEN_Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};

public class PopulatingNextRightPointersEachNode {
    class Solution {
    public void connectNodes(PNRPEN_Node left, PNRPEN_Node right) {
        if (left == null || right == null) {
            return;
        }
        left.next = right;

        connectNodes(left.left, left.right);
        connectNodes(left.right, right.left);
        connectNodes(right.left, right.right);
    }

    public PNRPEN_Node connect(PNRPEN_Node root) {
        if (root == null) {
            return null;
        }

        connectNodes(root.left, root.right);
        return root;
    }
}
}
