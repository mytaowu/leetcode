package 动态规划;

import java.util.HashMap;

/**
 * https://leetcode-cn.com/problems/coin-lcci/
 * 
 * @author 涛宝宝
 *
 */
public class 面试题08_11_硬币 {
	
	HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();

	public int waysToChange(int n) {
		map.put(1, 1);
		map.put(5, 1);
		map.put(10, 1);
		map.put(25, 1);
		return dfs(n);
	}

	// 进行一个深度优先遍历;
	private int dfs(int n) {
		return 0;
	}

	public static void main(String[] args) {
		System.out.println(1);
	}
}
