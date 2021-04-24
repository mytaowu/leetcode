package 串;

/**
 * https://leetcode-cn.com/problems/zigzag-conversion/
 * 
 * @author 涛宝宝
 *
 */
public class _6_Z_字形变换 {

	public String convert(String s, int numRows) {

		// 做我们的条件判断;
		if (s == null || s.length() < 2) {
			return s;
		}
		int n = numRows -1;
		char[] array = s.toCharArray();
		StringBuffer [] buffers = new StringBuffer[numRows];
		for (int i = 0; i < buffers.length; i++) {
			buffers[i] = new StringBuffer();
			
		}
		for (int i = 1; i <= array.length; i++) {
			int mode = i % n;
			buffers[mode-1].append(array[i-1]);
		}
		
		for (StringBuffer stringBuffer : buffers) {
			System.out.print(stringBuffer.toString());
		}
		
		return null;
		
		
	}

}
