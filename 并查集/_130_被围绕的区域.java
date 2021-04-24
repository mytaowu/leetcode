package 并查集;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.swing.text.StyledEditorKit.BoldAction;

/**
 * https://leetcode-cn.com/problems/surrounded-regions/
 * @author 涛宝宝
 *
 */
public class _130_被围绕的区域 {
	
	class Spot{
		int x;
		int y;
		public Spot(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
		@Override
			public boolean equals(Object obj) {
			Spot spot = (Spot) obj;
				return this.x == spot.x && this.y == spot.y;
			}

	}
	List<Spot> OArray = new ArrayList();
	
	public void solve(char[][] board) {
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				if (i == 0 || j == 0 || i == board.length - 1 || j == board[i].length - 1) {
					if (board[i][j] == 'O') {
						OArray.add(new Spot(i, j));
					}
				}else {
					if (rangeCheack(i, j)) {
						OArray.add(new Spot(i, j));
					}
				}
			}
		}
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				if (board[i][j] == 'O' && !OArray.contains(new Spot(i, j))) {
					board[i][j] = 'X';
				}
			}
		}
    }
	
	boolean rangeCheack(int i,int j){
		if (OArray.contains(new Spot(i, j+1))){
			return true;
		}
		if (OArray.contains(new Spot(i, j-1))){
			return true;
		}
		if (OArray.contains(new Spot(i-1, j))){
			return true;
		}
		if (OArray.contains(new Spot(i+1, j))){
			return true;
		}
		return false;
	}
}
