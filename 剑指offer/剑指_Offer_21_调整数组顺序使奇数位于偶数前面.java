package 剑指offer;

import java.util.LinkedList;

/**
 * @author TMingYi
 * @description https://leetcode-cn.com/problems/diao-zheng-shu-zu-shun-xu-shi-qi-shu-wei-yu-ou-shu-qian-mian-lcof/
 * @date 2020年12月21日
 */
public class 剑指_Offer_21_调整数组顺序使奇数位于偶数前面 {
	
	
	public int[] exchange(int[] nums) {
		// 使用双端队列。
		LinkedList<Integer> list = new LinkedList<Integer>();
		
		for (int i = 0; i < nums.length; i++) {
			if ((nums[i] & 1) == 0) {
				list.offerLast(nums[i]);
			}else {
				list.offerFirst(nums[i]);
			}
		}
		return list.stream().mapToInt(e -> e).toArray();

	}
}
