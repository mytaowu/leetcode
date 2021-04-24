package 二叉树;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode-cn.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
 * 
 * @author 涛宝宝
 *
 */
//dat <<= 1 就可以等价bat = bat 
public class _105_从前序与中序遍历序列构造二叉树 {

	/*
	 * 根据 前序遍历 和 中序遍历 的特点构建二叉树
	 * 
	 * 前序遍历： [根节点 | 左子树 | 右子树] 中序遍历： [左子树 | 根节点 | 右子树]
	 * 
	 * 方法：递归
	 * 
	 * 使用 字典 存储中序遍历遍历中各个节点的值及其索引 前序遍历第一个元素一定为根节点 根据根节点值与 字典找到 中序遍历中根节点索引 因为 前序遍历：
	 * [根节点 | 左子树 | 右子树] 我们不知道左子树的结束位置 所以我们需要 根据 中序遍历中根节点索引 记录左子树节点个数 右子树节点个数
	 * 左子树节点个数 = 中序遍历中根节点索引 - 开始位置 右子树节点个数 = 结束位置 - 中序遍历中根节点索引
	 */
	   public TreeNode buildTree(int[] preorder, int[] inorder) {
	        if (preorder == null || preorder.length == 0) {
	            return null;
	        }
	        int len = preorder.length;
	        Map<Integer, Integer> treeMap = new HashMap<>();

	        for (int i = 0; i < len; i++) {
	            treeMap.put(inorder[i], i);
	        }
	        return buildTree(preorder, 0, len - 1, inorder, 0, len - 1, treeMap);
	    }

	    public TreeNode buildTree(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd, Map<Integer, Integer> map) {
	        if (preStart > preEnd) {
	            return null;
	        }
	        
	        int rootIndex = map.get(preorder[preStart]);
	        int leftNum = rootIndex - inStart;
	        int rightNum = inEnd - rootIndex;
	        if (preStart == preEnd) {
	            return new TreeNode(preorder[preStart]);
	        }

	        TreeNode root = new TreeNode(preorder[preStart]);
	        root.left = buildTree(preorder, preStart + 1, preStart + leftNum, inorder, inStart, rootIndex - 1, map);
	        root.right = buildTree(preorder, preStart + leftNum + 1, preEnd, inorder, rootIndex + 1, inEnd, map);
	        return root;
	    }

	@SuppressWarnings("unused")
	public static void main(String[] args) {
		int array1[] = {1,2,4,7,5,3,6,8};
		int array2[] = {4,7,2,5,1,6,8,3};
		@SuppressWarnings("unused")
		TreeNode tree = new _105_从前序与中序遍历序列构造二叉树().buildTree(array1, array2);
		int a = 2;
	}

}
