package 串;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/find-all-anagrams-in-a-string/
 * @author 涛宝宝
 *
 */
public class _438_找到字符串中所有字母异位词 {
	
    public List<Integer> findAnagrams(String s, String p) {
    	int len = p.length();
    	ArrayList<Integer> list = new ArrayList<Integer>();
    	for (int i = 0; i <= s.length() - len; i++) {
    		if (isAnagram(s.substring(i, i + len), p)){
    			list.add(i);
    		}
		}
    	return list;
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
