package 二叉树;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

/**
 * https://leetcode-cn.com/problems/populating-next-right-pointers-in-each-node/
 * 
 * @author 涛宝宝
 *
 */
public class _116_填充每个节点的下一个右侧节点指针 {
	public NodeT connect(NodeT root) {
		if (root == null) {
			return root;
		}
		Queue<NodeT> queue = new LinkedList<NodeT>();
		queue.offer(root);
		List<NodeT> list = new ArrayList<NodeT>();
		while (!queue.isEmpty()) {
			NodeT curNode = queue.poll();
			list.add(curNode);
			if (curNode.left != null) {
				queue.offer(curNode.left);
			}
			if (curNode.right != null) {
				queue.offer(curNode.right);
			}
		}
		int index = 1;
		for (int i = 0 ; i < list.size() - 1 ; i++) {
			if (i == ((int)(Math.pow(2, index)) - 2)) {
				index++;
				list.get(i).next = null;
			}else {
				list.get(i).next = list.get(i + 1) ;
			}
		}
		list.get(list.size() - 1).next = null;
		return root;
	}
	
}
