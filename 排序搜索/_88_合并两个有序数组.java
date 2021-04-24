package 排序搜索;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/merge-sorted-array/
 * 
 * @author 涛宝宝
 *
 */
public class _88_合并两个有序数组 {
	public static void merge(int[] nums1, int m, int[] nums2, int n) {
		if (n == 0) return;
		if (m == 0) {
			for(int i = 0 ; i < n ; i++) {
				nums1[i] = nums2[i];
			}
			return;
		}
		for(int i = m - 1 ; i >= 0 ; i--) {
			nums1[i+n] = nums1[i];
		}
		int index = 0;
		int li = 0;
		int le = n;
		int ri = n;
		int re = m + n;
		while(li < le) {
			if (ri < re && nums1[ri] < nums2[li]) {
				nums1[index++] = nums1[ri++];
			}else {
				nums1[index++] = nums2[li++];
			}
		}
	}
	
	public static void main(String[] args) {
		int [] arr1 = {4,0,0,0,0,0};
		int [] arr2 = {1,2,3,5,6};
		merge(arr1, 1, arr2, 5);
		System.out.println(Arrays.toString(arr1));
		
	}
}
