package 动态规划;

/**
 * https://leetcode-cn.com/problems/longest-common-subsequence/
 * 
 * @author 涛宝宝
 *
 */
public class _1143_最长公共子序列 {
	
	
	//方法1;使用简单的动规划来进行解题(并尝试进行优化)；
	public static int longestCommonSubsequence(String text1, String text2) {
		if (text1 == null || text2 == null) return 0;
		if (text1.length() == 0 || text2.length() == 0) return 0;
		char[] rowChars = text1.toCharArray();
		char[] colChars = text2.toCharArray();
		if (rowChars.length < colChars.length) {
			rowChars = text2.toCharArray();
			colChars = text1.toCharArray();
		}
		
		//初始化dp数组；
		int dp[] = new int[colChars.length + 1];
		for (int row = 1; row <= rowChars.length; row++) {
			int cur = 0;
			for (int col = 1; col <= colChars.length; col++) {
				int leftTop = cur;
				cur = dp[col];
				//进行dp数组中的数据处理；
				if (rowChars[row - 1] == colChars[col - 1]) {
					dp[col] = leftTop + 1;
				}else {
					dp[col] = Math.max(dp[col], dp[col - 1]);
				}
			}
		}
		return dp[colChars.length];
	}
//
//	//方法1;使用简单的动规划来进行解题；
//	public static int longestCommonSubsequence(String text1, String text2) {
//		if (text1 == null || text2 == null) return 0;
//		if (text1.length() == 0 || text2.length() == 0) return 0;
//		char[] array1 = text1.toCharArray();
//		char[] array2 = text2.toCharArray();
//		
//		//初始化dp数组；
//		int dp[][] = new int[array1.length + 1][array2.length + 1];
//		for (int row = 1; row <= array1.length; row++) {
//			for (int col = 1; col <= array2.length; col++) {
//				//进行dp数组中的数据处理；
//				if (array1[row - 1] == array2[col - 1]) {
//					dp[row][col] = dp[row - 1][col - 1] + 1;
//				}else {
//					dp[row][col] = Math.max(dp[row - 1][col], dp[row][col - 1]);
//				}
//			}
//		}
//		return dp[array1.length][array2.length];
//	}
	
	public static void main(String[] args) {
		System.out.println(longestCommonSubsequence(new String("abcde"),new String("ace")));
		
	}

}
