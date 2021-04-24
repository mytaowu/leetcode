package 并查集;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/longest-consecutive-sequence/
 * 
 * @author 涛宝宝
 *
 */
public class _128_最长连续序列 {
	public int longestConsecutive(int[] nums) {
		if (nums == null) {
			return -1;
		}
		if (nums.length == 0) {
			return 0;
		}
		if (nums.length == 1) {
			return 1;
		}
		Arrays.sort(nums);
		int[] dp = new int[nums.length];
		dp[0] = 1;
		int max = dp[0];
		for (int i = 1; i < nums.length; i++) {
			if (nums[i] - nums[i - 1] == 1) {
				dp[i] = dp[i - 1] + 1;
			}else if(nums[i] == nums[i-1]){
				dp[i] = dp[i - 1];
			}else {
				dp[i] = 1;
			}
			if (dp[i] > max) {
				max = dp[i];
			}
		}
		return max;
	}
	
	public static void main(String[] args) {
		System.out.println(new _128_最长连续序列().longestConsecutive(new int[] {100,4,200,1,3,2}));
	}
}
