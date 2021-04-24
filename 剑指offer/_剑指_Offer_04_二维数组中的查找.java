package 剑指offer;

/**
 * https://leetcode-cn.com/problems/er-wei-shu-zu-zhong-de-cha-zhao-lcof/
 * 
 * @author 涛宝宝
 *
 */
public class _剑指_Offer_04_二维数组中的查找 {
	public boolean findNumberIn2DArray1(int[][] matrix, int target) {
		
		for (int i = 0; i < matrix.length; i++) {
			if (matrix[i].length == 0) continue;
			if (target >= matrix[i][0] && target <= matrix[i][matrix[i].length - 1]) {
				for (int j = 0; j < matrix[i].length; j++) {
					if (target == matrix[i][j]) {
						return true;
					} 
				}
			}
		}
		return false;
	}
	
//	public boolean findNumberIn2DArray(int[][] matrix, int target) {
//		
//		return dfs(matrix, 0, 0, target);
//	}
//
//	private boolean dfs(int[][] matrix, int x, int y, int target) {
//		
//		if (x > matrix.length || y > matrix[x].length) {
//			return false;
//		}
//		
//		if (matrix[x][y] == target) {
//			return true;
//		}
//		
//		if (target > matrix[x][y]) {
//			return false;
//		}
//		
//		return dfs(matrix, x, y + 1, target) || dfs(matrix, x + 1, y, target);
//		
//	}
	
}
