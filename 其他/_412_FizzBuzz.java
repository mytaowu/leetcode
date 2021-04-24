package 其他;

import java.util.ArrayList;
import java.util.List;
import java.util.zip.CRC32;

/**
 * https://leetcode-cn.com/problems/fizz-buzz/
 * 
 * @author 涛宝宝
 *
 */
public class _412_FizzBuzz {
	public static List<String> fizzBuzz(int n) {
		int is3 = 3;
		int is5 = 5;
		int is3And5 = 15;
		ArrayList<String> list = new ArrayList<String>();
		for (int i = 1 ; i <= n ; i++) {
			String cur = String.valueOf(i);
			if ((i - is3And5) % 15 == 0) {
				is3And5 = i;
				cur = "FizzBuzz";
			}else {
				if (((i - is3) % 3 )== 0) {
					is3 = i;
					cur = "Fizz";
				}else if (((i - is5) % 5 )== 0) {
					is5 = i;
					cur = "Buzz";
				}
			}
			list.add(cur);
		}
		return list;
	}
	
	
	public static void main(String[] args) {
		System.out.println(fizzBuzz(100));
	}
}
