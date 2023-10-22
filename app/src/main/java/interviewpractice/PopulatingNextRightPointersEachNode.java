package interviewpractice;

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
