package 数组;
/**
 * https://leetcode-cn.com/contest/weekly-contest-202/problems/three-consecutive-odds/
 * @author 涛宝宝
 *
 */
public class _5185_存在连续三个奇数的数组 {

	public boolean threeConsecutiveOdds(int[] arr) {
		int count = 0;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] % 2 == 1) {
				count = count + 1;
			}else {
				count = 0;
			}
			if (count == 3) {
				return true;
			}
		}
		return false;
    }
}
