package 其他;

/**
 * https://leetcode-cn.com/contest/weekly-contest-175/problems/minimum-number-of-steps-to-make-two-strings-anagram/
 * 
 * @author 涛宝宝
 *
 */
public class _5333_制造字母异位词的最小步骤数 {

	public int minSteps(String s, String t) {
		int count = 0;
		char[] charArray = t.toCharArray();
		for(int i = 0 ; i < s.length() ; i++) {
			char c = s.charAt(i);
			for(int j = 0 ; j < charArray.length ; j++) {
				char d = charArray[j];
				if (d == '#') continue;
				if (d == c) {
					charArray[j] = '#';
					count++;
					break;
				}
			}
		}
		
		return s.length() - count;
	}

}
