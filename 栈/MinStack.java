package 栈;
/**
 * https://leetcode-cn.com/problems/min-stack-lcci/
 * @author 涛宝宝
 *
 */
public class MinStack{
	
	private Node head;
	
    /** initialize your data structure here. */
    public MinStack() {
    	//这里就相当于我们的虚拟头结点;
    	head = new Node(0, Integer.MAX_VALUE, null);
    }
    
    public void push(int x) {
    	head = new Node(x, Math.min(x, head.min), head);
    }
    
    public void pop() {
    	if (head.next != null) {
    		head = head.next;
    	}
    }
    
    public int top() {
    	return head.val;
    }
    
    public int getMin() {
    	return head.min;
    }
    

    /**
     * 定义我们的静态内部类；
     * @author 涛宝宝
     *
     */
    private static class Node{
    	int val;
    	int min;
    	Node next;
		public Node(int val, int min, Node next) {
			super();
			this.val = val;
			this.min = min;
			this.next = next;
		}
    }
}
