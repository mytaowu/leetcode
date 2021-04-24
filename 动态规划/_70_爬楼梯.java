package 动态规划;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode-cn.com/problems/climbing-stairs/
 * 
 * @author 涛宝宝
 *
 */
public class _70_爬楼梯 {
	
	HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();

	public int climbStairs(int n) {
		if (n <= 2)
			return n;
		if (map.containsKey(n)) {
			return map.get(n);
		}
		int result = climbStairs(n - 1) + climbStairs(n - 2);
		map.put(n, result);
		return result;
	}
	
	public static void main(String[] args) {
		
	}

}
