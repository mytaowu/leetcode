package 回溯;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/permutations-ii/
 * 
 * @author 涛宝宝
 *
 */
public class _47_全排列II {


	private List<List<Integer>> total = new ArrayList<>();

	// 调用此方法，进行获得不重复的全排列。
	public List<List<Integer>> permuteUnique(int[] nums) {
		List<Node> numNodes = new ArrayList<>();
		// 因为元素可以重复，我们使用Node（下标和元素值唯一确定一个元素。）
		for (int i = 0; i < nums.length; i++) {
			numNodes.add(new Node(nums[i], i));
		}
		for (int i = 0; i < numNodes.size(); i++) {
			List<Node> list = new ArrayList<>();
			list.add(numNodes.get(i));
			per(numNodes.get(i), list, numNodes);
		}
		
		// 我们去重的操作。
		Iterator<List<Integer>> iterator = total.iterator();
		while (iterator.hasNext()) {
			List<Integer> next = iterator.next();
			if (isnnn(next)) {
				iterator.remove();
			}
			
		}
		return total;
	}

	private boolean isnnn(List<Integer> next) {
		Iterator<List<Integer>> iterator = total.iterator();
		while (iterator.hasNext()) {
			List<Integer> list = iterator.next();
			if (list == next) continue;
			if (isyyy(list,next)) return true;
		}
		return false;
	}


	
	private boolean isyyy(List<Integer> list, List<Integer> next) {
		int size = list.size();
		if (next.size() != size) return false;
		for(int i = 0 ; i < size ; i++) {
			if (list.get(i) != next.get(i)) {
				return false;
			}
		}
		return true;
	}

	// 递归函数。
	private void per(Node node, List<Node> list, List<Node> numNodes) {
		if (list.size() == numNodes.size()) {
			total.add(arrayCopy(list));
			return;
		}

		for (int i = 0; i < numNodes.size(); i++) {
			// 如果下标和元素值都为一个元素，则认为是同一个元素。
			if (!node.equals(numNodes.get(i)) && !list.contains(numNodes.get(i))) {
				list.add(numNodes.get(i));
				per(numNodes.get(i), list, numNodes);
				list.remove(list.indexOf(numNodes.get(i)));
			}
		}
	}

	// 进行集合的copy的元素。
	private List<Integer> arrayCopy(List<Node> list) {
		List<Integer> temp = new ArrayList<>();
		for (int i = 0; i < list.size(); i++) {
			temp.add(list.get(i).value);
		}
		return temp;
	}
	
	class Node {
		int value;
		int index;

		public Node(int value, int index) {
			super();
			this.value = value;
			this.index = index;
		}

		@Override
		public boolean equals(Object obj) {
			Node node = (Node) obj;
			return value == node.value && index == node.index;
		}
	}


	public static void main(String[] args) {
		int num[] = { 1, 1, 2 };
		List<List<Integer>> permute = new _47_全排列II().permuteUnique(num);
		System.out.println(permute);
	}

}
