package 其他;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/contest/weekly-contest-175/problems/check-if-n-and-its-double-exist/
 * 
 * @author 涛宝宝
 *
 */
public class _5332_检查整数及其两倍数是否存在 {

	public boolean checkIfExist(int[] arr) {
		Arrays.sort(arr);
		for(int i = 0 ; i < arr.length ; i++) {
			if (arr[i] == 0 )
			for(int j = 0 ; j < arr.length ; j++) {
				
				if ((arr[i] * 2) == arr[j]) return true;
			}
		}
		return false;
	}

}
