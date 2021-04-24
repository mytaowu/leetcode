package 其他;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/contest/weekly-contest-218/problems/max-number-of-k-sum-pairs/
 * @author 涛宝宝
 *
 */
public class _5618_K_和数对的最大数目 {
	public static int maxOperations(int[] nums, int k) {
		Arrays.sort(nums);
		int first = 0;
		int end = nums.length - 1;
		int count = 0;
		while (first < end) {
			if (nums[first] + nums[end] == k) {
				System.out.println("相等");
				count++;
				first++;
				end--;
			}else if (nums[first] + nums[end] < k) {
				first++;
			}else {
				end--;
			}
		}
		return count;
    }
	
	public static void main(String[] args) {
		int arr [] = new int [] {4,4,1,3,1,3,2,2,5,5,1,5,2,1,2,3,5,4};
		maxOperations(arr, 2);
	}
}
