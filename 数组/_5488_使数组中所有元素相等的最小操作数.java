package 数组;
/**
 * https://leetcode-cn.com/contest/weekly-contest-202/problems/minimum-operations-to-make-array-equal/
 * https://leetcode-cn.com/problems/minimum-operations-to-make-array-equal/comments/
 * @author 涛宝宝
 *
 */
public class _5488_使数组中所有元素相等的最小操作数 {
	
	public int minOperations(int n) {

		int [] array = new int [n];
		int sum = 0;
		int avg = 0;
		for (int i = 0; i < array.length; i++) {
			array[i] = (2 * i) + 1;
			sum += array[i];
		}
		avg = sum / n;
		int i = 0;
		int count = 0;
		while (array[i] < avg) {
			count += avg - array[i];
			i++;
		}
		return count;
    }

}
