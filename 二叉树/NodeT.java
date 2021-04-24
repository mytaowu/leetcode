package 二叉树;

public class NodeT {
	public int val;
    public NodeT left;
    public NodeT right;
    public NodeT next;

    public NodeT() {}
    
    public NodeT(int _val) {
        val = _val;
    }

    public NodeT(int _val, NodeT _left, NodeT _right, NodeT _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
}
