package 动态规划;

import java.util.Arrays;
import java.util.Scanner;

/**
 * https://leetcode-cn.com/problems/coin-change/
 * 
 * @author 涛宝宝
 */
public class _322_零钱兑换 {
	
	/**
	 * @param moneys 我们可以使用的金额。
	 * @param count 我们需要凑的金额。
	 */
	public int coin(int moneys[], int count) {
		
		// 使用动态规划进行一个解题;
		// dp[i]表示凑齐i元需要的最少硬币数。
		int dp[] = new int [count + 1];
		
		// 初始化dp[0] = 0, 凑齐0元的硬币数为0;
		for (int i = 1; i <= count; i++) {
			// 记录是否找到最小值，可能会找不到。
			int min = Integer.MAX_VALUE;
			for (int j = 0; j < moneys.length; j++) {
				// 如果当前的需要凑的钱少于当前硬币面值，直接略过。
				if (i < moneys[j]) continue;
				if (dp[i-moneys[j]] < 0 && dp[i-moneys[j]] >= min) continue;
				min = dp[i-moneys[j]];
			}
			if (min == Integer.MAX_VALUE) {
				dp[i] = -1;
			}else {
				dp[i] = min + 1;
			}
		}
		
		return dp[count];
		
	}

	

}
