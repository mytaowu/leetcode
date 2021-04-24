package 剑指offer;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import 二叉树.ListNode;

/**
 * 
 * @author 涛宝宝
 *
 */
public class 剑指_Offer_06_从尾到头打印链表 {
	public int[] reversePrint(ListNode head) {
		
		Stack<Integer> stack = new Stack<Integer>();
		ListNode currentNode = head;
		while (currentNode != null) {
			stack.push(currentNode.val);
			currentNode = currentNode.next;
		}
		List<Integer> list = new ArrayList<Integer>();
		while(!stack.isEmpty()) {
			list.add(stack.pop());
		}
		
        int [] result = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
			result[i] = list.get(i);
		}
        return result;
	}
}
