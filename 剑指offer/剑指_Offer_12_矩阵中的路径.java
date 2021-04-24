package 剑指offer;

import javax.swing.text.StyledEditorKit.BoldAction;

/**
 * https://leetcode-cn.com/problems/ju-zhen-zhong-de-lu-jing-lcof/
 * 
 * @author 涛宝宝
 *
 */
public class 剑指_Offer_12_矩阵中的路径 {

	public int[][] dirction = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };

	public boolean exist(char[][] board, String word) {
		char[] array = word.toCharArray();
		int len = array.length;

		int[][] flag = new int[board.length][board[0].length];
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				flag[i][j] = 1;
				if (board[i][j] == array[0] && hashPath(board, flag, array, i, j, 1)) {
					return true;
				}
				flag[i][j] = 0;

			}
		}
		return false;
	}

	private boolean hashPath(char[][] board, int[][] flag, char[] array, int i, int j, int k) {
		if (!range(board, i, j))
			return false;
		if (board[i][j] != array[k-1])
			return false;
		if (k == array.length)
			return true;

		for (int k2 = 0; k2 < dirction.length; k2++) {
			if (range(board, i + dirction[k2][0], j + dirction[k2][1])
					&& flag[i + dirction[k2][0]][j + dirction[k2][1]] == 0) {
				flag[i + dirction[k2][0]][j + dirction[k2][1]] = 1;
				if (!hashPath(board, flag, array, i + dirction[k2][0], j + dirction[k2][1], k + 1)) {
					flag[i + dirction[k2][0]][j + dirction[k2][1]] = 0;
				} else {
					return true;
				}
			}
		}
		return false;
	}

	private boolean range(char[][] board, int i, int j) {
		if (i < 0 || i >= board.length || j < 0 || j >= board[0].length)
			return false;
		return true;
	}
}
