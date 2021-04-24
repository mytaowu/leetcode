package 二叉树;

import java.util.LinkedList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/unique-binary-search-trees-ii/
 * 
 * @author 涛宝宝
 *
 */
public class _95_不同的二叉搜索树II {
	public List<TreeNode> generateTrees(int n) {
		if (n == 0) {
			return new LinkedList<TreeNode>();
		}

		return generateTrees(1, n);
	}

	// 说白了这题也是分治的思想
	private List<TreeNode> generateTrees(int begin, int end) {
		List<TreeNode> list = new LinkedList<TreeNode>();
		if (begin > end) {
			list.add(null);
			return list;
		}

		for (int i = begin; i <= end; i++) {
			List<TreeNode> leftChil = generateTrees(begin, i - 1);
			List<TreeNode> rightChil = generateTrees(i+1, end);
			for (TreeNode left : leftChil) {
				for (TreeNode right : rightChil) {
					TreeNode node = new TreeNode(i);
					node.left = left;
					node.right = right;
					list.add(node);
				}
			}
		}
		
		return list;

	}
}
