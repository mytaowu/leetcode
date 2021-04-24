package 其他;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode-cn.com/problems/4sum-ii/
 * 
 * @author 涛宝宝
 *
 */
public class _454_四数相加II {
	// 我们尝试使用暴力法进行一个破解。
	public int fourSumCount1(int[] A, int[] B, int[] C, int[] D) {
		Arrays.parallelSort(A);
		Arrays.parallelSort(B);
		Arrays.parallelSort(C);
		Arrays.parallelSort(D);
		int count = 0;
		for (int i = 0; i < A.length; i++) {
			for (int j = 0; j < B.length; j++) {
				for (int k = 0; k < C.length; k++) {
					for (int l = 0; l < D.length; l++) {
						if (A[i] + B[j] + C[k] + D[l] > 0) break;
						if (A[i] + B[j] + C[k] + D[l] == 0) count++; 
					}
				}
			}
		}
		return count;
	}
	
	/**
	 * @return:要学会灵活的运用Map解决问题。
	 */
	public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
		int count = 0;
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 0; i < A.length; i++) {
			for (int j = 0; j < B.length; j++) {
				if (!map.containsKey(A[i] + B[j])) {
					map.put(A[i] + B[j], 1);
				}else {
					map.put(A[i] + B[j], map.get(A[i] + B[j]) + 1);
				}
			}
		}
		
		for (int i = 0; i < C.length; i++) {
			for (int j = 0; j < D.length; j++) {
				int temp = -( C[i] + D[j] );
				if (map.containsKey(temp)){
					count += map.get(temp);
				}
			}
		}
		return count;
	}
}
