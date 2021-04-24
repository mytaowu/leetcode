package 数组;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * 使用hash表和最小堆进行一个求解。
 * 
 * @author 涛宝宝
 *
 */
public class _659_分割数组为连续子序列 {
	
	public boolean isPossible(int[] nums) {

		Map<Integer, PriorityQueue<Integer>> map = new HashMap<Integer, PriorityQueue<Integer>>();
		
		for (int num : nums) {
			if (!map.containsKey(num)) {
				map.put(num, new PriorityQueue<Integer>());
			}
			
			if (map.containsKey(num - 1)) {
				int path = map.get(num - 1).poll();
				if (map.get(num - 1).isEmpty()) {
					map.remove(num - 1);
				}
				map.get(num).offer(path + 1);				
			}else {
				map.get(num).offer(1);
			}
		}
		
		Set<Entry<Integer,PriorityQueue<Integer>>> entrySet = map.entrySet();
		
		Iterator<Entry<Integer, PriorityQueue<Integer>>> iterator = entrySet.iterator();
		while (iterator.hasNext()) {
			if (iterator.next().getValue().peek() < 3) {
				return false;
			}
		}
		return true;
	}
}
