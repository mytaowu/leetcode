package 数组;

import org.omg.PortableServer.ID_ASSIGNMENT_POLICY_ID;

/**
 * https://leetcode-cn.com/problems/find-minimum-in-rotated-sorted-array/
 *     二分法解题
 * @author 涛宝宝
 *
 */
public class _153_寻找旋转排序数组中的最小值 {
	public int findMin(int[] nums) {

		if (nums.length == 1) return nums[0];
		
		int start = 0;
		int end = nums.length - 1;
		while (start <= end) {
			int mid = (start + end) >> 1;
			if (nums[mid] > nums[end]) {
				start = mid + 1;
			}else if (nums[mid] < nums[end]) {
				end = mid;
			}else {
				end--;
			}
		}
		
		return nums[start];
    }
}
