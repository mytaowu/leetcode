package 二叉树;

import java.util.LinkedList;
import java.util.Queue;

//此题已经写废；
/**
 * https://leetcode-cn.com/problems/delete-node-in-a-bst/
 * @author 涛宝宝
 *
 */
public class _450_删除二叉搜索树中的节点 {
	//这就需要考虑很多情况了;
	public TreeNode deleteNode(TreeNode root, int key) {
		if (root == null) {
			return null;
		}
		
		TreeNode node = null;
		TreeNode p = root;
		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(root);
		while (!queue.isEmpty()) {
			TreeNode poll = queue.poll();
			if (key == poll.val) {
				node = poll;
				break;
			}
			if (poll.left != null) {
				queue.offer(poll.left);
			}
			if (poll.left != null) {
				queue.offer(poll.right);
			}
		}
		if (node == null) return root;
		if (node.left == null && node.right == null) {
			
		}else if (node.left != null && node.right == null) {
			if (root == node) {
				root = root.left;
				root.left = null;
			}else {
				node = node.left;
				node.left = null;
			}
		}else if (node.left == null && node.right != null) {
			if (root == node) {
				root = root.right;
				root.right = null;
			}else {
				node = node.right;
				node.right = null;
			}
			
		}else {
			if (root == node) {
				TreeNode tempNode = root.right;
				TreeNode parentNode = root.right;
				TreeNode greadParentNode = root.right;
				int i = 0;
				while ((tempNode = tempNode.left) != null) {
					i++;
					if (i > 1) {
						greadParentNode = greadParentNode.left;
					}
					parentNode = tempNode;
				}
				
				//度为2，且不是根节点。
//				TreeNode proNode = process(node);
//				System.out.println(proNode.val);
				root.val = parentNode.val;
				if (i == 0) {
					root.right = null;
				}else {
					greadParentNode.left = null;
				}
			}else {
				TreeNode tempNode = node.right;
				TreeNode parentNode = node.right;
				TreeNode greadParentNode = node.right;
				int i = 0;
				while ((tempNode = tempNode.left) != null) {
					i++;
					if (i > 1) {
						greadParentNode = greadParentNode.left;
					}
					parentNode = tempNode;
				}
				
				//度为2，且不是根节点。
//				TreeNode proNode = process(node);
//				System.out.println(proNode.val);
				node.val = parentNode.val;
				if (i == 0) {
					node.right = null;
				}else {
					greadParentNode.left = null;
				}
			}
			
		}
		
		return root;
    }

	//返回后继节点;
	private TreeNode process(TreeNode node) {
		TreeNode tempNode = node;
		tempNode = tempNode.right;
		TreeNode parentNode = tempNode;
		while ((tempNode = tempNode.left) != null) {
			parentNode = tempNode;
		}
		return parentNode;
	}
}
