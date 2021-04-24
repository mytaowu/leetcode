package 串;

import java.util.PrimitiveIterator.OfDouble;

import javax.lang.model.element.VariableElement;

/**
 * https://leetcode-cn.com/contest/weekly-contest-201/problems/find-kth-bit-in-nth-binary-string/
 * 
 * @author 涛宝宝
 *
 */
public class _1545_找出第N个二进制字符串中的第K位 {

	public char findKthBit(int n, int k) {
		
		//创建一个StringBuffer或者Buliter，然后进行循环遍历；
		String result = "0";
		for (int i = 1; i < n; i++) {
			result = result + "1" + reverse(result);
			if (result.length() >= k) {
				break;
			}
		}
		return result.charAt(k-1);
	}

	private String reverse(String buffer) {
		
		char[] array = buffer.toCharArray();
		for (int i = 0; i < array.length >> 1; i++) {
			char temp = array[i];
			array[i] = array[array.length - 1 -i];
			array[array.length - 1 -i] = temp;
		}
		for (int i = 0; i < array.length; i++) {
			if (array[i] == '1') {
				array[i] = '0';
			}else {
				array[i] = '1';
			}
		}
		return new String(array);
	}
	
	public static void main(String[] args) {
		new _1545_找出第N个二进制字符串中的第K位().findKthBit(4,1);
	}

}
