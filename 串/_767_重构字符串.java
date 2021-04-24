package 串;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * https://leetcode-cn.com/problems/reorganize-string/
 * 
 * @author 涛宝宝
 *
 */
public class _767_重构字符串 {

	// 基于贪心 + 最大堆的解法。
	public String reorganizeString(String S) {

		if (S.length() < 2)
			return "";
		char[] array = S.toCharArray();
		int[] count = new int[26];
		

		System.out.println(Arrays.toString(array));
		for (int i = 0; i < array.length; i++) {
			count[array[i] - 'a']++;
		}
		
		PriorityQueue<Character> queue = new PriorityQueue<Character>((c1, c2) -> {
			return count[(c2 - 'a')] - count[(c1 - 'a')];
		});

		int maxCount = -1;
		for (int i = 0; i < count.length; i++) {
			maxCount = maxCount > count[i] ? maxCount : count[i];
		}
		
		 for (char c = 'a'; c <= 'z'; c++) {
	            if (count[c - 'a'] > 0) {
	                queue.offer(c);
	            }
	        }

		if (maxCount > ((S.length() + 1) >> 1)) {
			return "";
		}

		StringBuffer buffer = new StringBuffer();
		while (queue.size() > 1) {
			Character poll1 = queue.poll();
			Character poll2 = queue.poll();
			buffer.append(poll1);
			buffer.append(poll2);
			count[poll1 - 'a']--;
			count[poll2 - 'a']--;
			if (count[poll1 - 'a'] > 0) {
				queue.offer(poll1);
			}
			if (count[poll2 - 'a'] > 0) {
				queue.offer(poll2);
			}
		}

		if (queue.size() > 0) {
			buffer.append(queue.poll());
		}
		return buffer.toString();
	}

//  尝试的错误解法。
//	public String reorganizeString(String S) {
//		
//		char[] array = S.toCharArray();
//		Arrays.sort(array);
//
//		for (int i = 0; i < array.length-1; i++) {
//			int frist = i;
//			int second = i + 1;
//			
//			int index = -1;
//			for (int j = second; j < array.length; j++) {
//				if (array[frist] != array[j]) {
//					
//					index = j;
//					break;
//				}
//			}
//			
//			if (index == -1) return "";
//			char temp = array[second];
//			array[second] = array[index];
//			array[index] = temp;
//		}
//		
//		return new String(array);
//
//	}

}
