package 数组;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class _0_数组找出重复的元素 {
	
	public static int [] findCommonArrayItem(int [] arr) {
		
		HashMap<Integer,Integer> map = new HashMap<Integer, Integer>();
		List<Integer> list = new ArrayList<Integer>();
		for (int i = 0; i < arr.length; i++) {
			Integer temp =  map.get(arr[i]);
			if (temp == null) {
				map.put(arr[i], 1);
			}
			if (temp != null && temp >= 1 && !list.contains(arr[i])) {
				list.add(arr[i]);
			}
		}
		return list.stream().mapToInt(e -> e).toArray();
	}
	
	public static void main(String[] args) {
		int [] arr = new int [] {1,2,2,2,3,5,5,8,9,9,9};
		System.out.println(Arrays.toString(findCommonArrayItem(arr)));
	}
	

}
