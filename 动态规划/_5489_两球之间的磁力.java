package 动态规划;

import java.util.Arrays;

import javax.print.attribute.standard.PagesPerMinute;
import javax.xml.crypto.dsig.spec.DigestMethodParameterSpec;

/**
 * https://leetcode-cn.com/problems/magnetic-force-between-two-balls/comments/
 * 使用二分法间距进行求解；
 * @author 涛宝宝
 *
 */
public class _5489_两球之间的磁力 {
	public int maxDistance(int[] position, int m) {
		//第一步进行排序;
		Arrays.sort(position);
		//得出最大的两球之间的间距;
		int ri = (position[position.length - 1] - position[0]) / (m - 1);
		//表示两个小球之间最小的间距为1;
		int li = 1;
		//记录一下我们返回的间距，也就是最小磁力的最大值;
		int result = 1;
		while(li <= ri) {
			int mid = li + ((ri - li) >> 2);
			//通过判断，看是否可以满足小球的摆放;
			if (cheack(position, mid, m)) {
				//满足小球的摆放，记录位置;
				result = mid;
				li = mid + 1;
			}else {
				//不满足摆放的条件
				ri = mid - 1;
			}
		}
		return result;
	}

	private boolean cheack(int[] position, int mid, int m) {
		
		int i = 0;
		int count = 1;
		for (int j = 1; j < position.length; j++) {
			if (position[j] - position[i] >= mid) {
				i = j;
				count++;
				if (count >= m) {
					return true;
				}
			}
		}
		return false;
	}
}
