package 串;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;
import java.util.TreeSet;

/**
 * @author TMingYi
 * @description
 * @date 2020年12月20日
 * https://leetcode-cn.com/problems/remove-duplicate-letters/
 */
public class _316_去除重复字母 {
	// 使用单调栈进行一个求解。
	// 思路就是 遇到一个新字符 如果比栈顶小 并且在新字符后面还有和栈顶一样的 就把栈顶的字符抛弃了
	public String removeDuplicateLetters(String s) {
		char[] chars = s.toCharArray();
		// 单调栈
		Stack<Character> stack = new Stack<Character>();
		for (int i = 0; i < chars.length; i++) {
			if (stack.contains(chars[i])) continue;
			while (!stack.isEmpty() && stack.peek() > chars[i] && s.indexOf(stack.peek(),i) != -1) {
				stack.pop();
			}
			stack.push(chars[i]);
		} 
		char[] res = new char [stack.size()];
		
		for (int i = 0; i < stack.size(); i++) {
			res[i]=stack.get(i);
        }

		return new String(res);
		
	}
}
