package 串;

import java.awt.CardLayout;

import javax.lang.model.element.VariableElement;

/**
 * https://leetcode-cn.com/problems/reverse-words-in-a-string/
 * @author 涛宝宝
 *
 */
public class _151_翻转字符串里的单词 {
    public String reverseWords(String s) {
    	
    	char[] array = s.toCharArray();
    	
    	//第一步：去除多余的空格；
    	//标志上一个位置是否为空格；
    	boolean flag = true;
    	//去除空格之后，剩下的元素的实际长度；
    	int len = 0;
    	for (int i = 0; i < array.length; i++) {
			if (array[i] == ' ') {
				//前面是空格的情况，什么都不做。
				if (flag) {
					continue;
				}else {
					array[len++] = ' ';
					flag = true;
				}
			}else {
				array[len++] = array[i];
				flag =  false;
			}
		}
    	
    	//去除最后一个空格
    	System.out.println(new String(array,0,len));

    	if (len == 0) {
    		return "";
    	}
    	if (array[len - 1] == ' ') {
    		len--;
		}
    	
    	//进行整体的翻转；
    	reverse(array,0,len);
    	
    	//进行局部的翻转；
    	int cur = 0;
    	for (int i = 0; i < len; i++) {
			if (array[i] == ' ') {
		    	reverse(array,cur,i);
		    	cur = i + 1;
			}
		}
    	
    	reverse(array,cur,len);
    	return new String(array,0,len);
    }
    
    private void reverse(char[] array, int start, int end) {
    	
    	end--;
    	while (start < end) {
    		char temp = array[start];
    		array[start] = array[end];
    		array[end] = temp;
			start++;
			end--;
		}
    	
	}

	public static void main(String[] args) {
		new _151_翻转字符串里的单词().reverseWords("        ");
	}
}
