package 其他;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Stack;

/**
 * https://leetcode-cn.com/contest/weekly-contest-217/problems/find-the-most-competitive-subsequence/
 * 
 * @author 涛宝宝
 *
 */
public class _5614_找出最具竞争力的子序列 {
	
	
	
	public static int[] mostCompetitive(int[] nums, int k) {
		// 使用单调栈的方式。
		Stack<Integer> stack = new Stack<Integer>();

		for ( int i = 0; i < nums.length; i++) {
			while (!stack.isEmpty() && stack.peek() > nums[i]  && stack.size() > ( k- nums.length + i)) {
				stack.pop();
			}
			stack.push(nums[i]);
			
		}
		while(stack.size() > k) {
			stack.pop();
		}
		
		int [] res = new int [k];
		while(k != 0) {
			res[--k] = stack.pop();
		}
		return res;
	}
	
	public static void main(String[] args) {
		int arr[] = new int []{3,5,2,6};
		mostCompetitive(arr,2);
	}
	
////	
//	List<List<Integer>> list = new ArrayList<List<Integer>>();
//	
//	public int[] mostCompetitive(int[] nums, int k) {
//		
//		dfs(nums, k, 0,new ArrayList<Integer>());
//
//		list.sort((e1, e2) ->{
//			for (int i = 0; i < k; i++) {
//				if (e2.get(i) == e1.get(i)) continue;
//				if (e2.get(i) - e1.get(i) > 0) {
//					return -1;
//				}else {
//					return 1;
//				}
//			}
//			return 1;
//		}) ;
//		
//		
//		return list.get(0).stream().mapToInt(e -> e).toArray();
//		
//	}
//	
//	
//
//	private void dfs(int[] nums, int k,int currnIndex, ArrayList<Integer> aList) {
//		if (aList.size() == k) {
//			List<Integer> temp = new ArrayList<Integer>();
//			for (int i = 0; i < k; i++) {
//				temp.add(aList.get(i));
//			}
//			list.add(temp);
//		}else {
//			for (int i = currnIndex ; i < nums.length; i++) {
//				aList.add(nums[i]);
//				dfs(nums, k,++currnIndex, aList);
//				aList.remove(aList.size() - 1);
//			}
//		}
//	}
//	public int[] mostCompetitive2(int[] nums, int k) {
//
//		PriorityQueue<Integer> queue = new PriorityQueue<Integer>();
//		for (int i = 0; i < nums.length; i++) {
//			queue.add(nums[i]);
//		}
//
//		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
//		for (int i = 0; i < nums.length; i++) {
//			if (map.get(nums[i]) != null) {
//				map.put(nums[i], map.get(nums[i]) + 1);
//			} else {
//				map.put(nums[i], 1);
//			}
//		}
//
//		int[] result = new int[k];
//
//		for (int i = 0; i < k; i++) {
//			while(!queue.isEmpty()) {
//				
//				
//				Integer poll = queue.poll();
//				System.out.println("poll:  " + poll);
//				int index = 0;
//				for (int j = 0; j < nums.length; j++) {
//					if (nums[j] == poll) {
//						index = j;
//						break;
//					}
//				}
//
//				if (nums.length - index >= k - i) {
//					for (int j = 0; j < index; j++) {
//						queue.remove(nums[j]);
//						int count = map.get(nums[j]);
//						if (count != 1) {
//							while (count > 1) {
//								queue.add(nums[j]);
//								count--;
//							}
//							map.put(nums[j], 1);
//						}
//					}
//					System.out.println("i = " + i);
//					System.out.println("size = " + queue.size());
//					result[i] = poll;
//					break;
//				}
//			}
//		}
//		return result;
//	}
}
