package 分治;

/**
 * https://leetcode-cn.com/problems/maximum-subarray/
 * 
 * @author 涛宝宝
 *
 */
public class _53_最大子序和 {

	// 方法2，我们使用分治法来求解；
	public static int maxSubArray(int[] nums) {
		if (nums == null || nums.length == 0) {
			return 0;
		}
		return maxSubArray(nums, 0, nums.length);
	}

	//注意区间。左闭右开[begin,end)
	private static int maxSubArray(int[] nums, int begin, int end) {
		if (end - begin < 2) return nums[begin];
		int mid = (begin + end) >> 1;
		
		int leftSum = nums[mid - 1];
		int leftMax = nums[mid - 1];
		for (int i = mid - 2; i >= begin; i--) {
			leftSum += nums[i];
			leftMax = Math.max(leftMax, leftSum);
		}
		
		int rightSum = nums[mid];
		int rightMax = nums[mid];
		for (int i = mid + 1; i < end; i++) {
			rightSum += nums[i];
			rightMax = Math.max(rightMax,rightSum);
		}
		
		return Math.max(rightMax + leftMax, 
				Math.max(maxSubArray(nums, begin, mid),
						maxSubArray(nums, mid, end)));
	}

//	//方法1，我们使用暴力法来求解；
//	public int maxSubArray(int[] nums) {
//		if (nums == null || nums.length == 0) return 0;
//		int max = Integer.MIN_VALUE;
//		//使用暴力破解；
//		for (int begin = 0; begin < nums.length; begin++) {
//			int sum = 0;
//			for (int end = begin; end < nums.length; end++) {
//				sum += nums[end];
//				max = Math.max(sum, max);
//			}
//		}
//		return max;
//    }

	public static void main(String[] args) {
		int[] sums = { 2,0,3,-2};
		System.out.println(maxSubArray(sums));
	}

}
