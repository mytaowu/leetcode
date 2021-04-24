package 回溯;

import java.awt.datatransfer.StringSelection;
import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/palindrome-partitioning/
 * 经典的回溯应用；
 * @author 涛宝宝
 *
 */
public class _131_分割回文串 {
	
	private List<List<String>> total = new ArrayList<>();

	
	public List<List<String>> partition(String s) {
		if (s == null) return null;
		dfs(s,0,new ArrayList<String>());
		return total;
	}


	//经典的回溯调用方式;
	private void dfs(String s, int begin, ArrayList<String> list) {
		//结束条件；
		if (s.length() == begin) {
			total.add(new ArrayList<String>(list));
			return;
		}
		
		//进行循环回溯；
		for (int i = begin ; i < s.length(); i++) {
			String spil = s.substring(begin, i+1);
			//不是回文子串;
			if (!isHuiWen(spil)) {
				continue;
			}
			//是回文子串;
			list.add(spil);
			dfs(s, i+1, list);
			list.remove(list.size() - 1);
		}
	}

	//判断是否为回文子串；
	private static boolean isHuiWen(String spil) {
		if (spil == null || spil.length() <= 1) {
			return true;
		}
		for (int i = 0; i < spil.length() >> 1; i++) {
			if (spil.charAt(i) != spil.charAt(spil.length() - 1 -i)) {
				return false;
			}
		}
		return true;
	}


	public static void main(String[] args) {
		new _131_分割回文串().partition("aab");
	}
}
