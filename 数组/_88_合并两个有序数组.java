package 数组;

/**
 * https://leetcode-cn.com/problems/merge-sorted-array/
 * 
 * @author 涛宝宝
 *
 */
public class _88_合并两个有序数组 {

	public void merge(int[] nums1, int m, int[] nums2, int n) {

		int index1 = m -1;
		int index2 = n - 1;
		int teil = nums1.length -1;
		while (index2 >= 0) {
			if (index1 >= 0 && nums1[index1] > nums2[index2]) {
				nums1[teil--] = nums1[index1--];
			}else {
				nums1[teil--] = nums2[index2--];
			}
		}
		
	}
}
