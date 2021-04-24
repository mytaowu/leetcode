package 数组;

import java.util.HashMap;

/**
 * https://leetcode-cn.com/problems/two-sum/
 * 
 * @author 涛宝宝
 */
public class _1_两数之和 {
//	这种方式使用我们的数组来完成，效率较低
//	public int[] twoSum(int[] nums, int target) {
//
//		if (nums == null || nums.length < 1) {
//			return null;
//		}
//
//		int start = 0;
//		int end = 0;
//		for (; start < nums.length; start++) {
//			for (end = start + 1; end < nums.length; end++) {
//				if ((nums[start] + nums[end]) == target) {
//					return new int[] { start, end };
//				}
//			}
//		}
//		return new int[] { start, end };
//	}
	
	public int[] twoSum(int[] nums, int target) {

		if (nums == null || nums.length < 1) {
			return null;
		}
		
		//我们使用哈希表的映射来完成；运用一个补数的原理；
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 0; i < nums.length; i++) {
			if (map.containsKey(nums[i])) {
				return new int[] {  map.get(nums[i]),i };
			}
			map.put(target - nums[i], i);
		}
		return null;
	}
}
