package 串;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/*
 * https://leetcode-cn.com/contest/biweekly-contest-33/problems/thousand-separator/
 */
public class _5479_千位分隔数 {

	public String thousandSeparator(int n) {
		String result = n + "";
		if (result.length() <= 3) {
			return result;
		}
		Stack<String> stack = new Stack();
		int len = result.length();
		while (len >= 3) {
			stack.push(result.substring(len - 3, len));
			len -= 3;
		}
		
		if (len > 0) {
			stack.push(result.substring(0, len));
		}
		
		StringBuffer sb = new StringBuffer(stack.pop());
		while (!stack.isEmpty()) {
			sb.append(".");
			sb.append(stack.pop());
		}
		return sb.toString();
	}

}
