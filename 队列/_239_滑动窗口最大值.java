package 队列;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * https://leetcode-cn.com/problems/sliding-window-maximum/
 * @author 涛宝宝
 * 困难题，运用双端队列进行求解;
 */
public class _239_滑动窗口最大值 {
	public int[] maxSlidingWindow(int[] nums, int k) {

		if (nums == null) {
			return new int[0];
		}
		if (nums.length == 0 || k < 1) {
			return new int[0];
		}
		if (k == 1) {
			return nums;
		}
		
		int [] maxArr = new int[nums.length - k + 1];
		//正片开始，运用滑动双端队列解决这个问题；
		Deque<Integer> deque = new LinkedList<Integer>();
		for (int i = 0; i < nums.length; i++) {
			while (!deque.isEmpty() && nums[deque.peekLast()] <= nums[i]) {
				deque.pollLast();
			}
			deque.addLast(i);
			int m = i - k + 1;
			if (m < 0) continue;
			if (deque.peekFirst() < m) {
				deque.pollFirst();
			}
			maxArr[m] = nums[deque.peekFirst()];
		}
		return maxArr;
    }
}
