package 动态规划;

import javax.management.openmbean.OpenDataException;

/**
 * https://leetcode-cn.com/problems/longest-palindromic-substring/ 动态规划中等题；
 * 
 * @author 涛宝宝
 *
 */
public class _5_最长回文子串 {

	// 方法3： 使用中心扩展法进行优化;
	public String longestPalindrome(String s) {
		if (s == null) {
			return "";
		}
		if (s.length() <= 1) {
			return s;
		}
		char[] array = s.toCharArray();
		int maxLen = 1;
		int start = 0;
		int i = 0;

		while (i < array.length) {
			int r = i;
			//找到右边第一个不等于array[i]的元素;
			while(++r < array.length && array[i] == array[r]);
			
			int l = i - 1;
			i = r;
			// 进行中心的扩展;
			while (l >= 0 && r < array.length && array[l] == array[r]) {
				l--;
				r++;
			}
			int len = r - ++l;
			if (len > maxLen) {
				maxLen = len;
				start = l;
			}
		}

		return new String(array, start, maxLen);
	}

	// 方法2： 使用中心扩展法进行解题;
	public String longestPalindrome2(String s) {
		if (s == null) {
			return "";
		}
		if (s.length() <= 1) {
			return s;
		}
		char[] array = s.toCharArray();
		int len = 1;
		int start = 0;

		// 边界条件我们自行判断;
		for (int i = array.length - 2; i >= 1; i--) {
			int centerLen = extention(i - 1, i + 1, array);
			int obliqueLen = extention(i, i + 1, array);
			obliqueLen = Math.max(centerLen, obliqueLen);
			if (obliqueLen > len) {
				len = obliqueLen;
				start = i - ((len - 1) >> 1);
			}
		}

		if (array[0] == array[1] && len < 2) {
			start = 0;
			len = 2;
		}
		return new String(array, start, len);
	}

	private int extention(int l, int r, char[] array) {
		while (l >= 0 && r < array.length && array[l] == array[r]) {
			l--;
			r++;
		}
		return r - l - 1;
	}

	// 方法1 ，使用动态规划的解法解题;
	public String longestPalindrome1(String s) {
		if (s == null) {
			return "";
		}
		if (s.length() == 0) {
			return "";
		}

		char[] array = s.toCharArray();
		boolean[][] dp = new boolean[array.length][array.length];
		int max = Integer.MIN_VALUE;
		String maxStr = "";
		for (int i = array.length - 1; i >= 0; i--) {
			for (int j = array.length - 1; j >= i; j--) {
				if (i == j) {
					dp[i][j] = true;
				} else {
					if ((j - i + 1) <= 2) {
						dp[i][j] = array[i] == array[j];
					} else {
						dp[i][j] = dp[i + 1][j - 1] && array[i] == array[j];
					}
				}

				if (dp[i][j]) {
					if ((j - i) > max) {
						max = j - i;
						maxStr = new String(array, i, j - i + 1);
					}
				}
			}
		}
		return maxStr;
	}

}
