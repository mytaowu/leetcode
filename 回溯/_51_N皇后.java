package 回溯;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/n-queens/
 * 
 * @author 涛宝宝
 *
 */
public class _51_N皇后 {
	
	//记录该列有没有皇后；
	public int[] cols;
	
	//记录有多少条路径；
	public int ways;
	
	//List记录路径；
	public List<List<String>> pathInfo = new ArrayList<>();
	
	
	public List<List<String>> solveNQueens(int n) {
		queue(n);
		return pathInfo;
	}
	
	private void queue(int n) {
		//初始化数组；
		cols = new int[n];
		place(0);
	}


	//表示在row行摆放皇后；
	private void place(int row) {
		//设置回溯的最终条件；
		if (row == cols.length) {
			ways++;
			show();
			return;
		}
		for(int col = 0 ; col < cols.length ; col++) {
			if (isValid(row,col)) {
				cols[row] = col;
				place(row + 1);
			}
		}
		
	}


	private void show() {
		//这时候cols数组就包含了皇后摆放的信息；
		ArrayList<String> list = new ArrayList<>();
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < cols.length; i++) {
			for (int j = 0; j < cols.length; j++) {
				if (cols[i] == j) {
					sb.append("Q");
				}
				else {
					sb.append(".");
				}
			}
			list.add(sb.toString());
			sb.delete(0,sb.length());
		}
		pathInfo.add(list);
	}


	private boolean isValid(int row, int col) {
		//判断row和col是否可以摆放皇后;
		for (int i = 0; i < row; i++) {
			if (cols[i] == col) return false;
			if (row - i == Math.abs(col - cols[i])) return false;
		}
		return true;
	}
	
	public static void main(String[] args) {
		List<List<String>> list = new _51_N皇后().solveNQueens(1);
		System.out.println(list);
	}

}
