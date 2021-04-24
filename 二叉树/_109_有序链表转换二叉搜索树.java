package 二叉树;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/convert-sorted-list-to-binary-search-tree/
 * 此题也可以用快慢指针解决。
 * @author 涛宝宝
 *
 */
public class _109_有序链表转换二叉搜索树 {
	List<Integer> list = new ArrayList<Integer>();

	public TreeNode sortedListToBST(ListNode head) {

		if (head == null) {
			return null;
		}

		if (head.next == null) {
			return new TreeNode(head.val);
		}

		// 放到一个数组中；
		while (head != null) {
			list.add(head.val);
			head = head.next;
		}

		System.out.println(list);
		System.out.println(list.size());
		return bfs(0, list.size());
	}

	/**
	 * 左闭右开的区间。[start,end)
	 * 
	 * @return
	 */
	private TreeNode bfs(int start, int end) {
		if (start > end) {
			return null;
		}
		int mid = (start + end) >> 1;
		TreeNode node = new TreeNode(list.get(mid));
		node.left = bfs( start, mid);
		node.right = bfs( mid + 1, end);
		return node;
	}
	

}
