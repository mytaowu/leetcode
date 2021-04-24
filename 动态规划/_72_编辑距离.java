package 动态规划;

/**
 * https://leetcode-cn.com/problems/edit-distance/ 困难题，典型的动态规划的解法;
 * 
 * @author 涛宝宝
 *
 */
public class _72_编辑距离 {

	public int minDistance(String word1, String word2) {
		if (word1 == null || word2 == null) {
			return 0;
		}

		if (word1.length() == 0) {
			return word2.length();
		}

		if (word2.length() == 0) {
			return word1.length();
		}

		char[] array1 = word1.toCharArray();
		char[] array2 = word2.toCharArray();

		int[][] dp = new int[array2.length + 1][array1.length + 1];
		// 设置我们的初始状态;
		dp[0][0] = 0;
		for (int i = 1; i <= array1.length; i++) {
			dp[0][i] = i;
		}

		for (int i = 1; i <= array2.length; i++) {
			dp[i][0] = i;
		}

		for (int i = 1; i <= array2.length; i++) {
			for (int j = 1; j <= array1.length; j++) {
				int leftTop;
				if (array1[j - 1] == array2[i - 1]) {
					leftTop = dp[i - 1][j - 1];
				} else {
					leftTop = dp[i - 1][j - 1] + 1;
				}

				dp[i][j] = Math.min(Math.min(dp[i - 1][j] + 1, dp[i][j - 1] + 1), leftTop);
			}
		}

		return dp[array2.length][array1.length];

	}

}
