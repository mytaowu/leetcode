package 动态规划;

/**
 * https://leetcode-cn.com/problems/palindromic-substrings/
 * 
 * @author 涛宝宝
 *
 */
public class _647_回文子串 {

	public int countSubstrings(String s) {

		if (s == null) {
			return 0;
		}
		if (s.length() <= 0) {
			return s.length();
		}

		char[] array = s.toCharArray();
		boolean[][] dp = new boolean[array.length][array.length];
		int count = 0;
		for (int i = array.length - 1; i >= 0; i--) {
			for (int j = array.length - 1; j >= i; j--) {
				if (i == j) {
					dp[i][j] = true;
				} else {
					if ((j - i + 1) <= 2) {
						dp[i][j] = array[i] == array[j];
					} else {
						dp[i][j] = dp[i + 1][j - 1] && array[i] == array[j];
					}
				}

				if (dp[i][j]) {
					count++;
				}
			}
		}
		return count;
	}
}
