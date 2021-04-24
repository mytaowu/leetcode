package 剑指offer;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/shu-zu-zhong-zhong-fu-de-shu-zi-lcof/
 * 
 * @author 涛宝宝
 *
 */
public class 剑指_Offer_03_数组中重复的数字 {

	public int findRepeatNumber(int[] nums) {
		
		if (nums == null || nums.length == 1) {
			return -1;
		}
		
		Arrays.sort(nums);
		for (int i = 0; i < nums.length-1; i++) {
			if (nums[i] == nums[i+1]) {
				return nums[i];
			}
		}
		return -1;
	}

}
