package 堆;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

import org.omg.PortableInterceptor.ServerRequestInfo;

import 堆._451_根据字符出现频率排序.Inner;

/**
 * https://leetcode-cn.com/problems/sort-characters-by-frequency/
 * @author 涛宝宝
 *
 */
public class _451_根据字符出现频率排序 {
	
	private Map<Character, Inner> map = new HashMap<>();
	
	static class Inner implements Comparable<Inner>{
		String str;
		char s;
		int count;
		public Inner(char s, int count) {
			this.s = s;
			this.count = count;
			str = String.valueOf(s);
		}
		public void countPuls() {
			count++;
			str += String.valueOf(s);
		}
		@Override
		public int compareTo(Inner o) {
//			if (o.count == this.count) {
//				return 1;
//			}
			return o.count - this.count;
		}
	}
	
	public String frequencySort(String s) {
		for (int i = 0; i < s.length(); i++) {
			char a = s.charAt(i);
			if (map.containsKey(a)) {
				map.get(a).countPuls();
			}else {
				map.put(a, new Inner(a, 1));
			}
		}
		PriorityQueue<Inner> queue = new PriorityQueue<Inner>();
		map.values().forEach((Inner i)->{
			queue.add(i);
		});
		int queueSize = queue.size();
		StringBuilder sBuilder = new StringBuilder();
		for (int i = 0; i < queueSize; i++) {
			sBuilder.append(queue.poll().str);
		}
		return sBuilder.toString().intern();
    }
	
	public static void main(String[] args) {
		new _451_根据字符出现频率排序().frequencySort("eert");
	}
}
