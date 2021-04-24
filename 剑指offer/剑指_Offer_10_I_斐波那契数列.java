package 剑指offer;

/**
 * https://leetcode-cn.com/problems/fei-bo-na-qi-shu-lie-lcof/
 * 
 * @author 涛宝宝
 *
 */
public class 剑指_Offer_10_I_斐波那契数列 {

	public int fib(int n) {
		int frist = 0;
		int second = 1;
		if (n == 0) {
			return frist;
		}
		if (n == 1) {
			return second;
		}

		for (int i = 2; i <= n; i++) {
			int temp = second;
			second = second + frist;
			frist = temp;
			if (second > 1000000007) {
				second = second % 1000000007;
			}
		}
		return second;
	}
}
