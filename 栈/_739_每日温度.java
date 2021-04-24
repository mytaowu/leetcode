package 栈;

import java.util.Arrays;
import java.util.Stack;

/**
 * https://leetcode-cn.com/problems/daily-temperatures/
 * @author 涛宝宝
 * 中等题
 */
public class _739_每日温度 {
	
	public int[] dailyTemperatures(int[] T) {

		//左边最大的数组;
		int [] rm = new int[T.length];
		
		//单调递减栈,放置我们的索引;
		Stack<Integer> stack = new Stack<Integer>();
		
		for (int i = 0; i < T.length; i++) {
			while (!stack.isEmpty() && T[i] > T[stack.peek()]) {
				Integer index = stack.pop();
				//设置右边最大,注意，这里的是索引的值;
				rm[index] = i - index;
			}
			stack.add(i);
		}
		
		return rm;
    }
}
