package 二叉树;

/*
 * https://leetcode-cn.com/problems/recover-binary-search-tree/
 */
public class _99_恢复二叉搜索树 {
	
	private TreeNode prev;
	
	private TreeNode fristNode;
	
	private TreeNode secendNode;

	// 利用中序遍历来实现我们的回复二叉搜索树;
	public void recoverTree(TreeNode root) {
		inOrder(root);
		int temp = fristNode.val;
		fristNode.val = secendNode.val;
		secendNode.val = temp;
	}
	
	private void inOrder(TreeNode node) {
		if (node == null) return;
		inOrder(node.left);
		
		if (prev != null && node.val < prev.val) {
			secendNode = node;
			if (fristNode != null) return;
			fristNode = prev;
		}
		prev = node;
		inOrder(node.right);
	}

}
