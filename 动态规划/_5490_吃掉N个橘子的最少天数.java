package 动态规划;

import java.util.HashMap;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane.IconifyAction;

import org.omg.PortableServer.ID_ASSIGNMENT_POLICY_ID;

/***
 * https://leetcode-cn.com/contest/weekly-contest-202/problems/minimum-number-of-days-to-eat-n-oranges/
 * https://leetcode-cn.com/problems/minimum-number-of-days-to-eat-n-oranges/
 * 吸取的教训，顺着推不行，我们反着来。时间超了，就想办法删掉一些情况，使用递归，把不要的情况剔除掉。
 * @author 涛宝宝
 *
 */
public class _5490_吃掉N个橘子的最少天数 {

//	public int minDays(int n) {
//		
//		int dp[] = new int [n + 1];
//		dp[0] = 0;
//		for (int i = 1; i <= n; i++) {
//			int min1 = dp[i - 1] + 1;
//			int min2 = 0, min3 = 0;
//			if (i % 2 == 0) {
//				min2 = dp[i / 2] + 1;
//			}else {
//				min2 = Integer.MAX_VALUE;
//			}
//			
//			if (i % 3 == 0) {
//				min3 = dp[i - (2 * (i / 3))] + 1;
//			}else {
//				min3 = Integer.MAX_VALUE;
//			}
//			dp[i] = Math.min(min1, Math.min(min2, min3));
//		}
//		
//	
//		
//		return dp[n];
//	}
//	
	HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();

	public int minDays(int n) {
		return dfs(n);
	}

	private int dfs(int n) {
		if (n <= 1) {
			return 1;
		}
		if (map.containsKey(n)) {
			return map.get(n);
		}
		int min = Math.min(n % 2 + 1 + dfs(n/2), n % 3 + 1 + dfs(n/3));
		map.put(n, min);
		return min;
	}

	public static void main(String[] args) {
		System.out.println(new _5490_吃掉N个橘子的最少天数().minDays(689599));
	}

}
