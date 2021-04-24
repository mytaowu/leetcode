package 动态规划;

/**
 * https://leetcode-cn.com/problems/minimum-path-sum/
 * 
 * @author 涛宝宝
 *
 */
public class _64_最小路径和 {

	public int minPathSum(int[][] grid) {
		// 横
		int row = grid.length;
		// 列
		int col = grid[0].length;
		// 创建dp数组；
		int[][] dp = new int[row][col];
		dp[0][0] = grid[0][0];
		for (int i = 1; i < col; i++) {
			dp[0][i] = dp[0][i - 1] + grid[0][i];
		}
		for (int i = 1; i < row; i++) {
			dp[i][0] = dp[i - 1][0] + grid[i][0];
		}

		for (int i = 1; i < row; i++) {
			for (int j = 1; j < col; j++) {
				dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
			}
		}
		return dp[row - 1][col - 1];

	}

}
