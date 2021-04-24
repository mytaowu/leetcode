package 动态规划;

import java.util.Arrays;
import java.util.PrimitiveIterator.OfDouble;

import javax.xml.crypto.dsig.spec.DigestMethodParameterSpec;
import javax.xml.stream.events.EndDocument;

/**
 * https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/
 * 
 * @author 涛宝宝
 *
 */
public class _3_无重复字符的最长子串 {
	
	int start = 0;
	
	public int lengthOfLongestSubstring(String s) {
		if (s == null || s.length() == 0) {
			return 0;
		}
		char[] array = s.toCharArray();
		int[] dp = new int[array.length];
		dp[0] = 1;
		for (int i = 1; i < array.length; i++) {
			if (hasCommonChar(array, i)) {
				dp[i] = i - start;
			} else {
				dp[i] = dp[i - 1] + 1;
			}
		}

		int result = dp[0];
		for (int i = 1; i < dp.length; i++) {
			System.out.println(dp[i]);
			if (result < dp[i]) {
				result = dp[i];
			}
		}
		return result;

	}

	private boolean hasCommonChar(char[] array, int i) {

		boolean flag = false;
		
		for (int j = start; j < i; j++) {
			if (array[j] == array[i]) {
				flag = true;
				start = j;
			}
		}
		return flag;
	}
	
	public static void main(String[] args) {
		System.out.println("最后结果："+new _3_无重复字符的最长子串().lengthOfLongestSubstring("pwwkew"));
	}
}
