package 排序搜索;

import java.util.HashSet;
import java.util.TreeSet;

/**
 * https://leetcode-cn.com/contest/biweekly-contest-33/problems/detect-cycles-in-2d-grid/
 * 
 * @author 涛宝宝
 *
 */
public class _5482_二维网格图中探测环 {
	private int row;
	private int col;
	private int[][] directions;
	private boolean[][] used;

	public boolean containsCycle(char[][] grid) {
		row = grid.length;
		col = grid[0].length;
		used = new boolean[row][col];
		directions = new int[][] { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				if (used[i][j]) {
					continue;
				} else {
					if (dfs(grid, i, j, -1, -1, grid[i][j])) {
						return true;
					}
				}
			}
		}
		return false;
	}

	// dfs
	private boolean dfs(char[][] grid, int i, int j, int p, int q, char charT) {
		if (verify(i, j) && grid[i][j] == charT) {
			if (used[i][j])
				return true;
			used[i][j] = true;
			for (int[] direction : directions) {
				int x = direction[0] + i;
				int y = direction[1] + j;
				if (x == p && y == q) {
					continue;
				}
				if (dfs(grid, x, y, i, j, charT)) {
					return true;
				}
			}
		}
		return false;
	}

	private boolean verify(int i, int j) {
		return i >= 0 && i < row && j >= 0 && j < col;
	}
}
