package 数组;

/**
 * https://leetcode-cn.com/problems/check-if-it-is-a-straight-line/
 * 
 * @author 涛宝宝
 *
 */
public class _1232_缀点成线 {
//	
//	static boolean isCol;
//	
//	static boolean isRow;
//	
//	static double factor;
//	
//	public static void name() {
//	
//	}
//	
//	public static boolean checkStraightLine(int[][] coordinates) {
//		if (coordinates == null || coordinates.length < 2) {
//			return false;
//		}
//		
//		int e1 = coordinates[0][0];
//		int e2 = coordinates[0][1];
//		
//		int o1 = coordinates[1][0];
//		int o2 = coordinates[1][1];
//		if (e1 == o1) {
//			isCol = true;
//		}else if (o2 == e2) {
//			isRow = true;
//		}else {
//			factor = (Math.abs(o2 - e2))*1.0/(Math.abs(o1 - e1));
//		}
//		
//		for (int i = 2; i < coordinates.length; i++) {
//			if (isCol) {
//				if (coordinates[i][0] != e1) return false;
//			}else if (isRow) {
//				if (coordinates[i][1] != o2) return false;
//			}else {
//				if (Math.abs(coordinates[i][1] - e2)*1.0/(Math.abs(coordinates[i][0] - e1)) != factor) {
//					return false;
//				}
//			}
//		}
//		return true;
//		
//    }

	//这里可以做一个除法过度到乘法的优化；
	public static boolean checkStraightLine(int[][] coordinates) {
		if (coordinates == null || coordinates.length < 3)
			return true;
		int x = coordinates[1][0] - coordinates[0][0], y = coordinates[1][1] - coordinates[0][1], dx, dy;
		for (int i = 2; i < coordinates.length; i++) {
			dx = coordinates[i][0] - coordinates[0][0];
			dy = coordinates[i][1] - coordinates[0][1];
			if (x * dy != y * dx)
				return false;
		}
		return true;

	}

	public static void main(String[] args) {
		System.out.println(checkStraightLine(new int[][] { { 0, 1 }, { 1, 3 }, { -4, -7 }, { 5, 11 } }));
	}

}
