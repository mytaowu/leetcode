package 剑指offer;

/**
 * https://leetcode-cn.com/problems/jian-sheng-zi-lcof/
 * 
 * @author 涛宝宝
 *
 */
public class _剑指_Offer_14I剪绳子 {

//	// 我们尝试使用三数之和。来解决问题。
//	public int cuttingRope(int n) {
//
//		int [] arr = new int [n];
//		for (int i = 0; i < arr.length; i++) {
//			arr[i] = i+1;
//		}
//		int frist = 0;
//		int cur = 1;
//		int end = arr.length;
//		int maxSum = n;
//		for (frist = 0; frist < arr.length; frist++) {
//			cur = frist + 1;
//			end = arr.length - 1;
//			while (cur < end) {
//				if (arr[frist] + arr[cur] + arr[end] > n) {
//					end--;
//				}else if (arr[frist] + arr[cur] + arr[end] < n) {
//					cur++;
//				}else {
//					maxSum = Math.max(maxSum, arr[frist] * arr[cur] * arr[end]);
//					cur++;
//					end--;
//				}
//			}
//		}
//		return maxSum;
//	}
	// 不断的剪绳子，以3为单位。
	public int cuttingRope(int n) {
		if (n == 1 || n == 2) {
			return 1;
		}
		if (n == 3) {
			return 2;
		}
		int sum = 1;
		while (n > 4) {
			sum *= 3;
			n-=3;
		}
		return sum * n;
	}
}
