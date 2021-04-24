package 数组;

import java.util.Scanner;

/**
 * https://leetcode-cn.com/problems/score-after-flipping-matrix/
 * 
 * @author 涛宝宝
 *
 */
public class _861_翻转矩阵后的得分 {
	
	public int matrixScore(int[][] A) {
		int m = A.length;
		int n = A[0].length;
		int ant = m * (1 << (n - 1));
		for (int j = 1; j < n; j++) {
			int frist = 0;
			int second = 0;
			for (int i = 0; i < m; i++) {
				if (A[i][0] == 1) {
					if (A[i][j] == 1) {
						frist++;
					}else {
						second++;
					}
				}else {
					if (A[i][j] == 1) {
						second++;
					}else {
						frist++;
					}
				}
			}
			ant += Math.max(frist, second) * (1 << (n - j - 1)); 
		}
		return ant;
	}
}
