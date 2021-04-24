package 并查集;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.TreeSet;

/**
 * https://leetcode-cn.com/contest/biweekly-contest-33/problems/minimum-number-of-vertices-to-reach-all-nodes/
 * 
 * @author 涛宝宝
 *
 */
public class _5480_可以到达所有点的最少点数目 {
	public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
		List<Integer> result = new ArrayList<Integer>();
		TreeSet<Integer> set = new TreeSet<Integer>();
		int[] array = new int[n];
		for (int i = 0; i < edges.size(); i++) {
			List<Integer> list = edges.get(i);
			array[list.get(1)]++;
		}


		for (int i = 0; i < array.length; i++) {
			if (array[i] == 0) {
				result.add(i);
			}
		}
		

		for (int i = 0; i < edges.size(); i++) {
			List<Integer> list = edges.get(i);
			set.add(list.get(1));
			if (set.size() == n) {
				return result;
			}
		}
		return result;
	}
}
