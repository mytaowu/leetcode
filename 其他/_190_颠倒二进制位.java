package 其他;
/**
 * https://leetcode-cn.com/problems/reverse-bits/
 * @author 涛宝宝
 *
 */
public class _190_颠倒二进制位 {
	
	  // you need treat n as an unsigned value
    public static int reverseBits(int n) {
    	 int res = 0;
    	 // 这里可以进行一个异或的操作。
         for (int i = 0; i < 32; i++) {
             int bit = n & 1;
             n = n >> 1;
             res = (res << 1) ^ bit;
         }
         return res;
    }
    
    public static void main(String[] args) {
    	System.out.println(reverseBits(43261596));
	}
}
