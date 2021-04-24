package 动态规划;

import java.util.Arrays;
import java.util.Scanner;

public class _0_硬币找零问题 {
	
	public static void coinChange(int[] coins, int amount) {
		// 我们进行适当的条件判断;
		if (coins == null || coins.length == 0) {
			System.out.println("Impossible");
		}
		// 定义dp[i];dp[i]就是凑齐i需要的最少的硬币数量；这里为了方便，就使用amount+1个元素；
		int[] dp = new int[amount + 1];
		// 设置dp的初始状态；设置
		for (int i = 1; i < dp.length; i++) {
			int min = Integer.MAX_VALUE;
			for (int j = 0; j < coins.length; j++) {
				if (i < coins[j])
					continue;
				if (dp[i - coins[j]] < 0 || dp[i - coins[j]] >= min)
					continue;
				min = dp[i - coins[j]];
			}
			if (min == Integer.MAX_VALUE) {
				dp[i] = -1;
			} else {
				dp[i] = min + 1;
			}
		}
		if (dp[amount] == -1) {
			System.out.println("Impossible");
		} else {
			System.out.println(dp[amount]);
		}
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		while (scanner.hasNextLine()) {
			int n = Integer.parseInt(scanner.nextLine());
			String line = scanner.nextLine();
			int coins[] = Arrays.stream(line.split(" ")).mapToInt(Integer::parseInt).toArray();
			int amount = Integer.parseInt(scanner.nextLine());
			coinChange(coins, amount);
		}
	}
}
