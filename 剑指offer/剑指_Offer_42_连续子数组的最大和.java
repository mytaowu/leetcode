package 剑指offer;
/**
 * https://leetcode-cn.com/problems/lian-xu-zi-shu-zu-de-zui-da-he-lcof/
 * @author 涛宝宝
 *
 */
public class 剑指_Offer_42_连续子数组的最大和 {

	public int maxSubArray(int[] nums) {
		if (nums == null || nums.length == 0) return 0;
		int max = nums[0];
		int [] dp = new int [nums.length];
		dp[0] = nums[0];
		// 一定要定义好我们的状态；
		for (int i = 1; i < nums.length; i++) {
			if (dp[i - 1] >= 0) {
				dp[i] = dp[i - 1] + nums[i];
			}else {
				dp[i] = nums[i];
			}
			max = Math.max(max, dp[i]);
		}
		
		return max;
    }
	
}
