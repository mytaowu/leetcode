package 动态规划;
/**
 * https://blog.csdn.net/huangkangying/article/details/45421875
 * @author 涛宝宝
 *
 */
public class 摔杯子 {
	
	public static void main(String[] args) {
		//经典的动态规划问题;
		int [][] dp = new int [100 + 1][2 + 1];
		int [][] route = new int [100 + 1][2 + 1];
		//dp[i][j]表示剩余i层，j个杯子最少的试摔次数；
		for (int i = 1; i < dp.length; i++) {
			dp[i][1] = i;
		}
		for (int i = 1; i < dp[0].length; i++) {
			dp[1][i] = 1;
		}
		for (int i = 2; i < 3; i++) {
			for (int j = 2; j < 101; j++) {
				dp[j][i] = j;
				route[j][i] = 0;
				for (int k = 1 ; k < j ; k++) {
					int min = Math.max(dp[k - 1][i - 1] + 1, dp[j-k][i] + 1);
					route[j][i] = (min <= dp[j][i] ? k : route[j][i]);
				    dp[j][i] = Math.min(min, dp[j][i]);
				}
			}
		}
		System.out.println(dp[100][2]);
		
	}

}
