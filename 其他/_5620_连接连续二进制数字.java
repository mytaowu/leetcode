package 其他;

import java.math.BigInteger;

/**
 * https://leetcode-cn.com/problems/concatenation-of-consecutive-binary-numbers/submissions/
 * 
 * @author 涛宝宝
 *
 */
public class _5620_连接连续二进制数字 {
//	public static int concatenatedBinary(int n) {
//		
//		StringBuffer sbBuffer  = new StringBuffer(); 
//		BigInteger modBigInteger = new BigInteger("1000000007");
//		Map<BigInteger, String> map = new HashMap();
//		for (int i = 1; i <= n; i++) {
//			BigInteger temp = new BigInteger(Integer.toBinaryString(i), 2);
////			if (temp.compareTo(modBigInteger) > 0) {
////				temp = temp.mod(modBigInteger);
////			}
//			if (map.get(temp) != null) {
//				String string = map.get(temp);
//				sbBuffer.append(string);
//			}else {
//				map.put(temp, temp.toString(2));
//				sbBuffer.append(Integer.toBinaryString(i));
//				BigInteger bigInteger = new BigInteger(sbBuffer.toString(),2);
//				if (bigInteger.compareTo(modBigInteger) > 0) {
//					bigInteger = bigInteger.mod(modBigInteger);
//					sbBuffer.delete(0,sbBuffer.length());
//					sbBuffer.append(bigInteger.toString(2));
//				}
//			}
//		}
//		return Integer.valueOf(sbBuffer.toString(), 2);
//	}
//	

	public int concatenatedBinary(int n) {
		long res = 0;
		int M = 1_000_000_007;
		int shift = 0;
		for (int i = 1; i <= n; i++) {
			if ((i & (i - 1)) == 0) {
				shift++;
			}
			res = ((res << shift) % M + i) % M;
		}
		return (int) res;
	}

	public static void main(String[] args) {
		System.out.println(new _5620_连接连续二进制数字().concatenatedBinary(3));
	}
}
