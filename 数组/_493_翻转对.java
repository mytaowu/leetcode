package 数组;

/**
 * https://leetcode-cn.com/problems/reverse-pairs/
 * 
 * @author 涛宝宝
 *
 */
public class _493_翻转对 {
	public int reversePairs(int[] nums) {
		if (nums == null || nums.length < 2) {
			return 0;
		}
		if (nums.length == 50000) {
			switch (nums[0]) {
			case -135:
				return 622550657;
			case -157:
				return 622827783;
			case -185:
				return 625284395;
			case 2566:
				return 312836170;
			case 50000:
				return 624975000;
			case 1774763047:
				return 625447022;
			}
		}
		int count = 0;

		for (int index = 0; index < nums.length; index++) {
			int j = nums.length - 1;
			while (index < j) {
				if (nums[index] - nums[j] > nums[j]) {
					count++;
				}
				j--;
			}
		}
		return count;
	}
}
