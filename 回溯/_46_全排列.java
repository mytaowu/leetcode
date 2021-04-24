package 回溯;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.swing.text.html.HTMLDocument.HTMLReader.PreAction;

/**
 * https://leetcode-cn.com/problems/permutations/
 * 
 * @author 涛宝宝
 *
 */
public class _46_全排列 {

//	private List<List<Integer>> total = new ArrayList<>();
//
//	public List<List<Integer>> permute(int[] nums) {
//		for (int i = 0; i < nums.length; i++) {
//			List<Integer> list = new ArrayList<Integer>();
//			list.add(nums[i]);
//			per(nums[i], list, nums);
//		}
//		return total;
//	}
//
//	private void per(int n, List<Integer> list, int[] nums) {
//		if (list.size() == nums.length) {
//			total.add(arrayCopy(list));
//			return;
//		}
//
//		for (int i = 0; i < nums.length; i++) {
//			if (n != nums[i] && !list.contains(nums[i])) {
//				list.add(nums[i]);
//				per(nums[i], list, nums);
//				list.remove(list.indexOf(nums[i]));
//			}
//		}
//
//	}
//
	private List<Integer> arrayCopy(List<Integer> list) {
		List<Integer> temp = new ArrayList<>();
		for (int i = 0; i < list.size(); i++) {
			temp.add(list.get(i));
		}
		return temp;
	}

	List<List<Integer>> resultList =  new ArrayList<List<Integer>>();
	
	public List<List<Integer>> permute(int[] nums) {
		
		for (int i = 0; i < nums.length; i++) {
			List<Integer> list = new ArrayList<Integer>();
			list.add(nums[i]);
			// 我们定义从num[0]开始的;
			pre(nums[i], list, nums);
		}
		return resultList;
	}

	private void pre(int num, List<Integer> list, int[] nums) {
		if (list.size() == nums.length) {
			ArrayList<Integer> temp = new ArrayList<Integer>();
			resultList.add(arrayCopy(list));
			return;
		}
		
		for (int i = 0; i < nums.length; i++) {
			if (num != nums[i] && !list.contains(nums[i])) {
				list.add(nums[i]);
				pre(nums[i], list, nums);
				list.remove(list.indexOf(nums[i]));
			}
		}
		
	}

	public static void main(String[] args) {
		int num[] = { 1, 2, 3 };
		List<List<Integer>> permute = new _46_全排列().permute(num);
		System.out.println(permute);
	}

}
