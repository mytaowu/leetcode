package 动态规划;

import javax.crypto.Mac;

/**
 * https://leetcode-cn.com/problems/maximum-subarray/
 * 
 * @author 涛宝宝
 *
 */
public class _53_最大子序和 {
	
	

	// 方法4，我们使用动态规划进行优化；
	public static int maxSubArray(int[] nums) {
		if (nums == null || nums.length == 0) return 0;
		int dp = nums[0];
		int max = nums[0];
		for (int i = 1; i < nums.length; i++) {
			if (dp > 0) {
				dp += nums[i];
			}else {
				dp = nums[i];
			}
			max = Math.max(max, dp);
		}
		return max;
	}
//
//	// 方法3，我们使用动态规划来求解；
//	public static int maxSubArray(int[] nums) {
//		if (nums == null || nums.length == 0) return 0;
//		int dp[] = new int [nums.length];
//		dp[0] = nums[0];
//		int max = nums[0];
//		for (int i = 1; i < dp.length; i++) {
//			if (dp[i - 1] > 0) {
//				dp[i] = dp[i-1] + nums[i];
//			}else {
//				dp[i] = nums[i];
//			}
//			max = Math.max(max, dp[i]);
//		}
//		return max;
//	}


//	//方法1，我们使用暴力法来求解；
//	public int maxSubArray(int[] nums) {
//		if (nums == null || nums.length == 0) return 0;
//		int max = Integer.MIN_VALUE;
//		//使用暴力破解；
//		for (int begin = 0; begin < nums.length; begin++) {
//			int sum = 0;
//			for (int end = begin; end < nums.length; end++) {
//				sum += nums[end];
//				max = Math.max(sum, max);
//			}
//		}
//		return max;
//    }

	public static void main(String[] args) {
		int[] sums = { 2,0,3,-2};
		System.out.println(maxSubArray(sums));
	}

}
