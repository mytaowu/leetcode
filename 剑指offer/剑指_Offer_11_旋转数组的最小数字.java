package 剑指offer;

/**
 * https://leetcode-cn.com/problems/xuan-zhuan-shu-zu-de-zui-xiao-shu-zi-lcof/
 * 
 * @author 涛宝宝
 *
 */
public class 剑指_Offer_11_旋转数组的最小数字 {
	public int minArray(int[] numbers) {
		
		if (numbers.length < 1) return 0;
		
		int min = numbers[0];
		for (int i = 0; i < numbers.length - 1 ; i++) {
			if (numbers[i] > numbers[i + 1]) {
				min = numbers[i + 1];
			}
		}
		
		return min;
	}
}
