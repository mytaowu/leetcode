package 数组;

/**
 * https://leetcode-cn.com/problems/sort-colors/
 * 
 * @author 涛宝宝
 *
 */
public class _75_颜色分类 {
	public void sortColors(int[] nums) {
		if (nums.length == 0 || nums.length == 1) {
			return;
		}
		int cur = 0;
		int r = nums.length - 1;
		int i = 0;
		while(i <= r) {
			if (nums[i] == 2) {
				swap(nums, i, r);
				r--;
			}else if (nums[i] == 1){
                i++;
            } else  {
				swap(nums, cur, i);
				i++;
				cur++;
			}
		}

	}
	
	void swap(int [] a,int l, int r) {
		int temp = a[l];
		a[l] = a[r];
		a[r] = temp;
	}
}
