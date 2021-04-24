package 数组;

/**
 * https://leetcode-cn.com/problems/find-first-and-last-position-of-element-in-sorted-array/
 * 使用二分法进行查找。
 * 
 * @author 涛宝宝
 *
 */
public class _34_在排序数组中查找元素的第一个和最后一个位置 {

	public int[] searchRange(int[] nums, int target) {

		if (nums == null || nums.length == 0)
			return new int[] { -1, -1 };

		int start = 0;
		int end = nums.length - 1;

		int startIndex = -1;
		int endIndex = -1;

		// 求出开始开始的索引
		while (start <= end) {
			int mid = (start + end) >> 1;
			if (nums[mid] >= target) {
				end = mid - 1;
			} else {
				start = mid + 1;
			}
		}

		startIndex = start;

		start = 0;
		end = nums.length - 1;

		// 求出结束的索引
		while (start <= end) {
			int mid = (start + end) >> 1;
			if (nums[mid] > target) {
				end = mid - 1;
			} else {
				start = mid + 1;
			}
		}

		endIndex = start;
		endIndex--;

		// 一定要注意这里的条件判断，要是不判断，一定会出错。
		if (startIndex <= endIndex && endIndex < nums.length && nums[startIndex] == target
				&& nums[endIndex] == target) {
			return new int[] { startIndex, endIndex };
		}
		return new int[] { -1, -1 };
	}

}
