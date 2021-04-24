package 串;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/group-anagrams-lcci/
 * @author 涛宝宝
 *
 */
public class 面试题_10_02_变位词组 {
    public List<List<String>> groupAnagrams(String[] strs) {
    	
    	//这里我们使用hashmap来进行处理；
    	HashMap<String, List<String>> map = new HashMap<String, List<String>>();
    	
    	for (String str : strs) {
			char[] array = str.toCharArray();
			Arrays.sort(array);
			String curStr = new String(array);
			if (map.get(curStr) == null) {
				List<String> list = new ArrayList<>();
				list.add(str);
				map.put(curStr, list);
			}else {
				List<String> list = map.get(curStr);
				list.add(str);
				map.put(curStr, list);
			}
		}
    	
    	return new ArrayList<List<String>>(map.values());
    }
}
