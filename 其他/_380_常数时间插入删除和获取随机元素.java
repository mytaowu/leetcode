package 其他;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * https://leetcode-cn.com/problems/insert-delete-getrandom-o1/
 * @author 涛宝宝
 *
 */
public class _380_常数时间插入删除和获取随机元素 {
	
	List<Integer> list = new ArrayList<Integer>();
	
	Map<Integer, Integer> map = new HashMap<Integer, Integer>();
	
    
	// 进行插入的操作;
    public boolean insert(int val) {
    	if (map.containsKey(val)) {
    		return false;
    	}
    	list.add(val);
    	map.put(val, list.size() - 1);
    	return true;
    }
    
    public boolean remove(int val) {
    	if (!map.containsKey(val)) {
    		return false;
    	}
    	Integer oldIndex = map.get(val);
    	Integer oldValue = list.get(list.size() - 1);
    	list.set(oldIndex, oldValue);
    	list.remove(list.size() - 1);
    	map.put(oldValue, oldIndex);
    	map.remove(val);
    	return true;
    }
    
    public int getRandom() {
    	return list.get((int)(Math.random() * list.size()));
    }
	
}
