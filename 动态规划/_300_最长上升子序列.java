package 动态规划;

/**
 * https://leetcode-cn.com/problems/longest-increasing-subsequence/
 * 
 * @author 涛宝宝
 *
 */
public class _300_最长上升子序列 {

	public static int lengthOfLIS(int[] nums) {
		if (nums == null || nums.length == 0) return 0;
		int dp[] = new int [nums.length];
		int max = 1;
		for (int i = 0; i < dp.length; i++) {
			dp[i] = 1;
			for (int j = 0; j < i; j++) {
				if (nums[i] > nums[j]) {
					dp[i] = Math.max(dp[i], dp[j] + 1);
				}
			}
			max = Math.max(max, dp[i]);
		}
		
		return max;
	}
	
	public static void main(String[] args) {
		System.out.println(lengthOfLIS(new int[]{10,9,2,5,3,7,101,18}));
	}

}
