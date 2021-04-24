package 剑指offer;

/**
 * https://leetcode-cn.com/problems/da-yin-cong-1dao-zui-da-de-nwei-shu-lcof/
 * 
 * @author 涛宝宝
 *
 */
public class 剑指_Offer_17_打印从1到最大的n位数 {

	public int[] printNumbers(int n) {
		int len = 1 * (int) Math.pow(10, n);
		int[] arr = new int[len - 1];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = i + 1;
		}

		return arr;
	}

}
