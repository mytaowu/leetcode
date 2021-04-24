package 串;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/group-anagrams/
 * 
 * @author 涛宝宝
 *
 */
public class _49_字母异位词分组 {
	public List<List<String>> groupAnagrams(String[] strs) {
		
		
		int [] falg = new int[strs.length];
		
		ArrayList<List<String>> tList = new ArrayList<List<String>>();
		
		for (int i = 0; i < falg.length; i++) {
			if (falg[i] == 1) {
				continue;
			}
			List<String> list = new ArrayList<>();
			list.add(strs[i]);
			falg[i] = 1;
			for (int j = i + 1; j < falg.length; j++) {
				//已经在别的地方判断过了;
				if (falg[j] == 1) {
					continue;
				}
				
				if (isAnagram(strs[i],strs[j])) {
					list.add(strs[j]);
					falg[j] = 1;
				}
			}
			tList.add(list);
		}

		return tList;
	}
	

	public boolean isAnagram(String s, String t) {
		if (s == null || t == null) {
			return false;
		}
    	if (s.length() != t.length()) {
    		return false;
    	}
    	
    	//我们假设只有小写字母;
    	int [] array = new int [26];
    	
    	 char[] sChar = s.toCharArray();
    	 char[] tChar = t.toCharArray();
    	 
    	 for (int i = 0; i < tChar.length; i++) {
    		 array[sChar[i] - 'a']++;
    		 array[tChar[i] - 'a']--;
		}
    	 
    	 for (int i = 0; i < array.length; i++) {
			if (array[i] != 0) {
				return false;
			}
		}
    	 return true;
    	 
	}
}
