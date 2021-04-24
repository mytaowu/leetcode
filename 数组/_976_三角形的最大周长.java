package 数组;

import java.util.Arrays;



/**
 * https://leetcode-cn.com/problems/largest-perimeter-triangle/ 此题为变了项的三数之和。
 * 
 * @author 涛宝宝
 *
 */
public class _976_三角形的最大周长 {

	public static int largestPerimeter(int[] A) {
		
		int left = 0;
		int right = A.length;
		int cur = 1;
		
		Arrays.sort(A);
		int max = 0;
		
		for (int i = 0; i < A.length; i++) {
			left = i;
			right = A.length - 1;
			cur = i + 1;
			while(cur < right) {
				int flag = isAriangle(A[left], A[cur], A[right]);
				if (flag == 0) {
					max = max > (A[left] + A[cur] + A[right]) ? max : (A[left] + A[cur] + A[right]);
					cur++;
					right--;
				}
				if (flag == -1) {
					cur++;
				}else {
					right--;
				}
			}
		}
		return max;
	}

	private static int isAriangle(int i, int j, int k) {
		if (i + j <= k) return 1;
		if (i + k <= j) return 1;
		if (j + k <= i) return 1;
		
		if (i - j >= k) return -1;
		if (i - k >= j) return -1;
		if (j - k >= i) return -1;
		if (j - i >= k) return -1;
		if (k - i >= j) return -1;
		if (k - j >= i) return -1;
		return 0;
	}
	
	/**
	 *经典的降序写法。 
	 */
	public int largestPerimeter2(int[] A) {
        Arrays.sort(A);
        for (int i = A.length - 1; i >= 2; --i) {
            if (A[i - 2] + A[i - 1] > A[i]) {
                return A[i - 2] + A[i - 1] + A[i];
            }
        }
        return 0;
    }

	
	public static void main(String[] args) {
		int [] arr = new int[]{3,6,2,3};
		largestPerimeter(arr);
	}
}
