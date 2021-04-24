package 二叉树;

/**
 * https://leetcode-cn.com/problems/minimum-depth-of-binary-tree/
 * 
 * @author 涛宝宝
 *
 */
public class _111_二叉树的最小深度 {
	public int minDepth(TreeNode root) {
		if (root == null) return 0;
		if (root.left != null && root.right != null) {
			return Math.min(minDepth(root.left), minDepth(root.right)) + 1; 
		}
		if (root.left == null && root.right == null) return 1;
		return (root.left == null ? minDepth(root.right): minDepth(root.left)) + 1;
	}
	
}
