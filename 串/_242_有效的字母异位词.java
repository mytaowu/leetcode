package 串;

/**
 * https://leetcode-cn.com/problems/valid-anagram/
 * 
 * @author 涛宝宝
 *
 */
public class _242_有效的字母异位词 {

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
