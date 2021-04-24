package 数组;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/wiggle-sort-ii/
 * @author 涛宝宝
 *
 */
public class _324_摆动排序II {
	public void wiggleSort(int[] nums) {
		Arrays.sort(nums);
		int first = 0;
		int scend = first + 1;
		Boolean falg = true;

		for (int i = 0; i < nums.length; i++) {
			if (falg) {
				for (int j = scend; j < nums.length; j++) {
					if (nums[j] > nums[i]) {
						//
					}
				}
			}else {
				for (int j = scend; j < nums.length; j++) {
					if (nums[j] > nums[i]) {
						//
					}
				}
			}
		}
		
		
		

    }
}
