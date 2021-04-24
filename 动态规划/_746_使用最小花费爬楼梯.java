package 动态规划;

/**
 * @author TMingYi
 * @description https://leetcode-cn.com/problems/min-cost-climbing-stairs/
 * @date 2020年12月21日
 */
public class _746_使用最小花费爬楼梯 {

//	public int minCostClimbingStairs(int[] cost) {
//		return dfs(cost,cost.length - 1);
//	}
//
//	
//	private int dfs(int[] cost, int i) {
//		if (i <= 1) return cost[i];
//		return Math.min(dfs(cost, i - 2), dfs(cost, i - 1)) + cost[i];
//	}
	
	public int minCostClimbingStairs(int[] cost) {
		
		int [] dp = new int [cost.length + 1];
		
		dp[0] = cost[0];
		dp[1] = cost[1];
		for (int i = 2; i < dp.length; i++) {
			int temp = 0;
			if (i != cost.length) {
				dp[i] = Math.min(dp[i-1], dp[i - 2]) + cost[i];
			}else {
				dp[i] = Math.min(dp[i-1], dp[i - 2]);
			}
		}
		// 这里要考虑最后一个位置下一个位置，可能会从倒数第二个直接跳两格。
		return Math.min(dp[cost.length], dp[cost.length - 1]);
	}

}
