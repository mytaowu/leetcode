package 剑指offer;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/li-wu-de-zui-da-jie-zhi-lcof/ 中等题，
 * 经典的动态规划题目;,看能不能进行进一步的压缩；
 * 
 * @author 涛宝宝
 *
 */
public class 剑指_Offer_47_礼物的最大价值 {
	public int maxValue(int[][] grid) {
		
		//横
		int row = grid.length;
		//列
		int col = grid[0].length;
		//创建dp数组；,进行数组的压缩;
		int [][] dp = new int [2][col];
		dp[0][0] = grid[0][0];
		for (int i = 1; i < col; i++) {
			dp[0][i] = dp[0][i - 1] + grid[0][i]; 
		}
		
		for (int i = 1; i < row; i++) {
			for (int j = 0; j < col; j++) {
				if (j == 0) {
					dp[0][0] = dp[1][0] = dp[0][0] + grid[i][j];
				}else {
					dp[0][j] = dp[1][j] = Math.max(dp[0][j], dp[1][j-1]) + grid[i][j];
				}
			}
		}
		return dp[0][col -1];
	}

	public int maxValue2(int[][] grid) {

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
				dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
			}
		}
		return dp[row - 1][col - 1];

	}
}
