package 剑指offer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

/**
 * https://leetcode-cn.com/problems/he-wei-sde-liang-ge-shu-zi-lcof/
 * 
 * @author 涛宝宝
 *
 */
public class 剑指_Offer_57_和为s的两个数字 {
	
	// set法
	public int[] twoSum(int[] nums, int target) {
		Set<Integer> list = new TreeSet<Integer>();
		Arrays.stream(nums).forEach(e -> {
			list.add(e);
		});
		
		int [] result = new int [2];

		int fristNum = 0;
		int second = target;
		
		while (fristNum < second) {
			if (fristNum + second == target && list.contains(fristNum) && list.contains(second)) {
				result[0] = fristNum;
				result[1] = second;
				return result;
			}else if (fristNum + second > target) {
				second--;
			}else {
				fristNum++;
			}
		}
		return result;
		
	}
	
	// 双指针
//	public int[] twoSum(int[] nums, int target) {
//		int [] result = new int [2];
//
//		if (nums.length == 1 && nums[0] == target) return result; 
//
//		int fristNum = 0;
//		int second = nums.length - 1;
//		while (fristNum < second) {
//			if (nums[fristNum] + nums[second] == target) {
//				result[0] = nums[fristNum];
//				result[1] = nums[second];
//				return result;
//			}else if (nums[fristNum] + nums[second] < target) {
//				fristNum++;
//			}else {
//				second--;
//			}
//		}
//		return result;
//	}
}
