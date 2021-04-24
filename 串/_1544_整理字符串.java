package 串;

import javax.imageio.event.IIOReadWarningListener;


/**
 * https://leetcode-cn.com/problems/make-the-string-great/comments/
 * @author 涛宝宝
 *
 */
public class _1544_整理字符串 {
    public String makeGood(String s) {
    	
    	char[] array = s.toCharArray();
    	int len = array.length;
    	for (int i = 0; i < len - 1; i++) {
    		//处理字母为大写字母的情况；
			if (array[i] >= 'A' && array[i] <= 'Z') {
				if (array[i + 1] == array[i] + 32) {
					//这里进行移位的操作;
					for (int j = i + 2; j < len; j++) {
						array[j - 2] = array[j];
					}
					len = len - 2;
					if (i > 0) {
						i = i - 2;
					}
					if (i == 0) {
						i = i-1;
					}
					continue;
				}
			}
			
			//处理字母为小写字母的情况；
			if (array[i] >= 'a' && array[i] <= 'z') {
				if (array[i + 1] == array[i] - 32) {
					//这里进行移位的操作;
					for (int j = i + 2; j < len; j++) {
						array[j - 2] = array[j];
					}
					len = len - 2;
					if (i > 0) {
						i -= 2;
					}
					if (i == 0) {
						i = i-1;
					}
					continue;
				}
			}
		}
    	
    	return new String(array,0,len);
    }

}
