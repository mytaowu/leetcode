package 回溯;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/n-queens-ii/
 * 
 * @author 涛宝宝
 *
 */
public class _52_N皇后II {
	// 记录该列有没有皇后；
	public int[] cols;

	// 记录有多少条路径；
	public int ways;

	public int totalNQueens(int n) {
		queue(n);
		return ways;
	}

	private void queue(int n) {
		// 初始化数组；
		cols = new int[n];
		place(0);
	}

	// 表示在row行摆放皇后；
	private void place(int row) {
		// 设置回溯的最终条件；
		if (row == cols.length) {
			ways++;
			return;
		}
		for (int col = 0; col < cols.length; col++) {
			if (isValid(row, col)) {
				cols[row] = col;
				place(row + 1);
			}
		}

	}


	private boolean isValid(int row, int col) {
		// 判断row和col是否可以摆放皇后;
		for (int i = 0; i < row; i++) {
			if (cols[i] == col)
				return false;
			if (row - i == Math.abs(col - cols[i]))
				return false;
		}
		return true;
	}
}
