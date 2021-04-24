package 并查集;

import java.util.TreeSet;

import org.omg.CORBA.UnionMember;

/**
 * https://leetcode-cn.com/problems/friend-circles/
 * 典型的使用并查集的题目。
 * @author 涛宝宝
 *
 */
public class _547_朋友圈 {
	
	int [] arr ;
	
	public int findCircleNum(int[][] M) {

		arr = new int [M.length];
		// 设置初始化，他们每个人都是自己一个组。
		for (int i = 0; i < M.length; i++) {
			arr[i] = i;
		}
		
		for (int i = 0; i < M.length; i++) {
			for (int j = 0; j < M[i].length; j++) {
				if (M[i][j] == 1) {
					// 进行合并的操作。
					union(i, j);
				}
			}
		}
		TreeSet<Integer> set = new TreeSet<Integer>();
		for (int i = 0; i < arr.length; i++) {
			set.add(arr[i]);
		}
		return set.size();
	}
	/**
	 * 把j合并到i里面。
	 */
	private void union(int i, int j) {
		int p1 = find(i);
		int p2 = find(j);
		for (int k = 0; k < arr.length; k++) {
			if (arr[k] == p1) {
				arr[k] = p2;
			}
		}
	}
	
	private int find(int v) {
		return arr[v];
	}
	

}
