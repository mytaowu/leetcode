package 二叉树;

import java.util.LinkedList;
import java.util.Queue;

/**
 * https://leetcode-cn.com/problems/balanced-binary-tree/
 * @author 涛宝宝
 */
public class _110_平衡二叉树 {
	
	//解法2
	public boolean isBalanced2(TreeNode root) {
		if (root == null) {
			return true;
		}
		
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.offer(root);
		while (!queue.isEmpty()) {
			TreeNode node = queue.poll();
			if (Math.abs(balance(node.left) - balance(node.right)) > 1) {
				return false;
			}
			if (node.left != null) {
				queue.offer(node.left);
			}
			if (node.right != null) {
				queue.offer(node.right);
			}
		}
		
		return true;
	}
	
	
	
	/**
	 * 给出二叉树的node节点，计算出树的高度；
	 * @param node
	 * @return
	 */
	private int balance(TreeNode node) {
		if (node ==  null) {
			return 0;
		}
		
		return Math.max(balance(node.left), balance(node.right)) + 1;
	}

	
	
	//解法1；
	boolean flag = true;

	public boolean isBalanced(TreeNode root) {
		if (root == null) {
			return true;
		}
		balance1(root);
		return flag;
	}
	
	
	
	/**
	 * 给出二叉树的node节点，计算出树的高度；
	 * @param node
	 * @return
	 */
	private int balance1(TreeNode node) {
		if (node ==  null) {
			return 0;
		}
		
		int leftHight = balance(node.left);
		int rightHight = balance(node.right);
		
		if (Math.abs(leftHight-rightHight)>1) {
			flag = false;
		}
		
		return Math.max(leftHight, rightHight) + 1;
	}

}
