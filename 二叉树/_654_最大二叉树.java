package 二叉树;

import java.util.Arrays;
import java.util.Stack;

import javax.activation.MailcapCommandMap;

/**
 * https://leetcode-cn.com/problems/maximum-binary-tree/
 * 
 * @author 涛宝宝 中等题
 *
 */
public class _654_最大二叉树 {
	
//	public TreeNode constructMaximumBinaryTree(int[] nums) {
//
//		if (nums == null) {
//			return null;
//		}
//		
//		if (nums.length == 0) {
//			return null;
//		}
//		
//		if (nums.length == 1) {
//			return new TreeNode(nums[0]);
//		}
//		
//		//左闭右开的一个区间；
//		return getMaxTree(nums, 0, nums.length);
//	}
//	
//	//调用递归函数;
//	private TreeNode getMaxTree(int num[], int start, int end) {
//		if (start == end) {
//			return null;
//		}
////		找出我们区间的最大值,以及最大值的索引
//		int max = num[start];
//		int maxIndex = start;
//		for (int i = start + 1; i < end; i++) {
//			if (max < num[i]) {
//				max = num[i];
//				maxIndex = i;
//			}
//		}
//		TreeNode node = new TreeNode(max);
//		node.left = getMaxTree(num, start, maxIndex);
//		node.right = getMaxTree(num, maxIndex + 1, end);
//		return node;
//	}
	
	/**
	 * 题目变形，求形成一个二叉树，他的父节点的索引值。
	 * 返回一个索引数组，根节点就返回-1;
	 * 利用栈的思想可以很轻松的找到，左边，或者右边第一个比该元素大的数;
	 * @param nums
	 * @return
	 */
	public int[] constructMaximumBinaryTree(int[] nums) {

		//找到一个数组中每个元素左边第一个比他大的数，和右边比他大的数，然后
		//比较大小，就可以找到父元素；维护一个单调栈，单调递减
		//每次加入栈，检测栈顶元素，如果栈顶元素 < 小于加入的元素
		//设置栈顶元素的右边最大的数组，然后弹出。
		//加入的时候，看一下栈顶的元素，栈顶元素，就是加入元素的左边最大元素。
		
		//左边最大的数组;
		int [] lm = new int[nums.length];
		//右边最大的数组;
		int [] rm = new int[nums.length];
		
		//单调递减栈,放置我们的索引;
		Stack<Integer> stack = new Stack<Integer>();
		
		for (int i = 0; i < nums.length; i++) {
			lm[i] = rm[i] = -1;
			while (!stack.isEmpty() && nums[i] > nums[stack.peek()]) {
				Integer index = stack.pop();
				//设置右边最大,注意，这里的是索引的值;
				rm[index] = i;
			}
			if (stack.isEmpty()) {
				lm[i] = -1;
			}else {
				lm[i] = stack.peek();
			}
			stack.add(i);
		}
		
		int [] root = new int[nums.length];
		
		for (int i = 0; i < rm.length; i++) {
			if (lm[i] == -1) {
				root[i] = rm[i];
				continue;
			}
			if (rm[i] == -1) {
				root[i] = lm[i];
				continue;
			}
			
			if (nums[lm[i]] > nums[rm[i]]) {
				root[i] = rm[i];
			}else {
				root[i] = lm[i];
			}
		}
		System.out.println(Arrays.toString(lm));
		System.out.println(Arrays.toString(rm));
		System.out.println(Arrays.toString(root));
		return null;
	}
	
	public static void main(String[] args) {
		int [] nums = {3,2,1,6,0,5};
		new _654_最大二叉树().constructMaximumBinaryTree(nums);
	}
}
