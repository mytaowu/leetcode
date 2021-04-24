package 动态规划;

import javax.xml.crypto.dsig.spec.DigestMethodParameterSpec;

/**
 * https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock/
 * 
 * @author 涛宝宝
 *
 */
public class _121_买卖股票的最佳时机 {

	// 第一种方法；
	public int maxProfit2(int[] prices) {

		if (prices.length == 0) {
			return 0;
		}

		// 最小价格；
		int minPrices = prices[0];
		int maxProfit = 0;
		for (int i = 0; i < prices.length; i++) {
			if (prices[i] < minPrices) {
				minPrices = prices[i];
			} else {
				maxProfit = Math.max(maxProfit, prices[i] - minPrices);
			}
		}

		return maxProfit;
	}

	// 动态规划的解法；
	public int maxProfit(int[] prices) {

		if (prices.length == 0) {
			return 0;
		}

		int temp[] = new int[prices.length];
		temp[0] = 0;
		for (int i = 1; i < temp.length; i++) {
			temp[i] = prices[i] - prices[i - 1];
		}

		int dp[] = new int[temp.length];
		// 问题就转换成了最大连续子序列的题目了,以dp[i]结尾的最大子序列。
		dp[0] = temp[0];
		int maxProfit = 0;
		for (int i = 1; i < dp.length; i++) {
			if (dp[i - 1] <= 0) {
				dp[i] = temp[i];
			} else {
				dp[i] = dp[i - 1] + temp[i];
			}
			maxProfit = Math.max(maxProfit, dp[i]);
		}

		return maxProfit;
	}

}
