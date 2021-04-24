package 其他;
/**
 * https://leetcode-cn.com/problems/plus-one/
 * @author 涛宝宝
 *
 */
public class _66_加一 {
	
	public int[] plusOne(int[] digits) {
		if (digits[digits.length - 1] < 9) {
			digits[digits.length - 1] += 1;
			return digits;
		}else {
			for (int i = digits.length - 1; i >= 0 ; i--) {
				if (digits[i] < 9) {
					digits[i] += 1;
					for (int j = i + 1; j < digits.length ; j++) {
						digits[j] = 0;
					}
					return digits;
				}
			}
		}
		
		int [] arr = new int[digits.length + 1];
		arr[0] = 1;
		return arr;
    }

}
