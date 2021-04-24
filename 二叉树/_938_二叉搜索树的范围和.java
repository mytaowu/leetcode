package 二叉树;
/**
 * https://leetcode-cn.com/problems/range-sum-of-bst/
 * @author 涛宝宝
 *
 */
public class _938_二叉搜索树的范围和 {
	int num = 0;
	boolean flag = false;
	public int rangeSumBST(TreeNode root, int L, int R) {
		if (root == null) return 0;
		if (L == R) {
			return L;
		}
		preorder(root,L,R);
		return num;
    }
	//进行前序遍历。
	private void preorder(TreeNode root,int L,int R) {
		if (root == null) return;
		preorder(root.left, L, R);
		if (root.val == R) {
			flag = false;
			num += root.val;
			return;
		}else if (flag) {
			num += root.val;
		}else if (root.val == L) {
			flag = true;
			num += root.val;
		}
//		System.out.println(root.val);
		preorder(root.right, L, R);
	}
}
