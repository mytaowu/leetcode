package 剑指offer;

import java.util.Scanner;

/**
 * https://leetcode-cn.com/problems/qing-wa-tiao-tai-jie-wen-ti-lcof/
 * 
 * @author 涛宝宝
 *
 */
public class 剑指Offer_10_II_青蛙跳台阶问题 {

//	public int numWays(int n) {
//		if (n == 0) {
//			return 1;
//		}
//		return jmp(n);
//	}
//
//	private int jmp(int n) {
//		if (n <= 2) {
//			return n;
//		}
//		return ((jmp(n - 2) % 1000000007) + (jmp(n - 1) % 1000000007)) % 1000000007;
//	}

	public int numWays(int n) {
		
		if (n == 0) {
			return 1;
		}
		if (n < 2) {
			return n;
		}
		int frist = 1;
		int second = 2;
		for (int i = 3; i <= n; i++) {
			second = second % 1000000007;
			int temp = second;
			second = frist + second;
			frist = temp;
			second = second % 1000000007;
		}
		return second;
	}

}
