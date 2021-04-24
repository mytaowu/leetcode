package 数组;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CountDownLatch;

/**
 * https://leetcode-cn.com/problems/3sum/
 * 
 * @author 涛宝宝
 *
 */
public class _15_三数之和 {

	// 利用三指针进行扫描。
	public List<List<Integer>> threeSum(int[] nums) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		if (nums == null) return res;
		if (nums.length < 3) return res;
		// 进行一个排序;
		Arrays.sort(nums);

		for (int i = 0 ; i < nums.length - 2 ; i++) {
			// 主要是去重的一个操作。
			if (i > 0 && nums[i] == nums[i - 1]) continue;
			// 定义我们的双指针;
			int l = i + 1;
			int r = nums.length - 1;
			// 进行循环的扫描;
			while (l < r) {
				int result = nums[i] + nums[l] + nums[r];
				// 判断我们的条件;
				if (result == 0) {
					res.add(Arrays.asList(nums[i],nums[l],nums[r]));
					// 我们进行一个去重的操作。
					while (l < r && nums[l] == nums[l + 1]) l++;
					while (l < r && nums[r] == nums[r - 1]) r--;
					l++; 
					r--;
				}else if (result < 0) {
					l++;
				}else {
					r--;
				}
			}
		}
		return res;
	}
}
