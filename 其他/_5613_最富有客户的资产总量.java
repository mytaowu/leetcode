package 其他;

import java.util.stream.IntStream;

import javax.xml.crypto.dsig.keyinfo.RetrievalMethod;

/**
 * https://leetcode-cn.com/contest/weekly-contest-217/problems/richest-customer-wealth/
 * 
 * @author 涛宝宝
 *
 */
public class _5613_最富有客户的资产总量 {
	public int maximumWealth(int[][] accounts) {

		int max = Integer.MIN_VALUE;
		for (int i = 0; i < accounts.length; i++) {
			int sum = 0;
			for (int j = 0; j < accounts[i].length; j++) {
				sum += accounts[i][j];
			}
			if (sum > max) {
				max = sum;
			}
		}
		return max;
		
	}
}
