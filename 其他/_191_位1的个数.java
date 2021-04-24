package 其他;

/**
 * https://leetcode-cn.com/problems/number-of-1-bits/
 * 
 * @author 涛宝宝
 *
 */
public class _191_位1的个数 {

    public static int hammingWeight(int n) {
     int count = 0;
     while (n != 0) {
    	 count += n & 1;
    	 n = n >>> 1;
     }
     return count;
    }

//	public int hammingWeight(int n) {
//		if (n < 2) {
//			return n;
//		}
//		int count = 0;
//		String string = Integer.toBinaryString(n);
//		for (int i = 0; i < string.length(); i++) {
//			if (string.charAt(i) == '1') {
//				count++;
//			}
//		}
//		return count;
//	}

	public static void main(String[] args) {
		
		
	}
}
