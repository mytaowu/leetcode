package 数组;

import java.util.Queue;

/**
 * https://leetcode-cn.com/problems/sub-sort-lcci/
 * 
 * @author 涛宝宝
 *
 */
public class _16_部分排序 {
	public int[] subSort(int[] array) {
		if (array.length == 0) {
			return new int[] { -1, -1 };
		}
		int r = -1;
		int l = -1;
		int max = array[0];
		int min = array[array.length - 1];
		for (int i = 1; i < array.length; i++) {
			if (array[i] >= max) {
				max = array[i];
			} else {
				r = i;
			}
		}

		for (int i = array.length - 2; i >= 0; i--) {
			if (array[i] <= min) {
				min = array[i];
			} else {
				l = i;
			}
		}
		return new int[] { l, r };

	}

}
