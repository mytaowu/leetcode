package 排序搜索;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode-cn.com/contest/weekly-contest-203/problems/most-visited-sector-in-a-circular-track/
 * 
 * @author 涛宝宝
 *
 */
public class _5495_圆形赛道上经过次数最多的扇区 {

	public List<Integer> mostVisited(int n, int[] rounds) {
		int count[] = new int[n];
		for (int i = 0; i < rounds.length - 1; i++) {
			int curIndex = i;
			int curValue = rounds[curIndex];
			curValue++;
			while (curValue != rounds[i+1]) {
				curValue++;
				if (curValue > n) curValue = curValue % n ;
				count[curValue - 1]++;
			}
		}
		System.out.println(Arrays.toString(count));

		for (int i = 0; i < rounds.length; i++) {
			count[rounds[i] - 1]++;
		}
		
		int max = 0;
		for (int i = 0; i < count.length; i++) {
			max = max < count[i] ? count[i] : max;
		}
		
		List<Integer> list = new ArrayList<Integer>();
		for (int i = 0; i < count.length; i++) {
			if (count[i] == max) list.add(i + 1);
		}
		return list;
	}

	public static void main(String[] args) {
		System.out.println(Math.ceil(5 >> 1));
		System.out.println(Math.ceil(5 / 0x2));
	}
	
}
