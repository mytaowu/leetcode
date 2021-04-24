package 剑指offer;

/**
 * @author TMingYi
 * @description https://leetcode-cn.com/problems/ji-qi-ren-de-yun-dong-fan-wei-lcof/
 * @date 2020年12月21日
 */
public class 剑指_Offer_13_机器人的运动范围 {
	
	public int dir[][] = {{0,-1},{0,1},{1,0},{-1,0}}; 

	public int movingCount(int m, int n, int k) {

		boolean falg[][] = new boolean [m][n];
		dfs(falg,0,0,k);
		
		int count = 0;
		for (int i = 0; i < falg.length; i++) {
			for (int j = 0; j < falg[i].length; j++) {
				if (falg[i][j]) count++;
			}
		}
		return count;
	}

	private void dfs(boolean[][] falg, int i, int j, int k) {
		if (sum(i) + sum(j) > k) {
			return;
		}
		falg[i][j] = true;
		for (int k2 = 0; k2 < dir.length; k2++) {
			if (position(falg,i + dir[k2][0],j + dir[k2][1])) {
				dfs(falg, i + dir[k2][0],j + dir[k2][1], k);
			}
		}
	}

	private int sum(int j) {
		int sum = 0;
		while (j > 0) {
			sum += j % 10;
			j /= 10;
		}
		return sum;
	}

	private boolean position(boolean[][] falg, int i, int j) {
		if (i < 0 || i >= falg.length || j < 0 || j >= falg[0].length) {
			return false;
		}
		return !falg[i][j];
	}
	
}
