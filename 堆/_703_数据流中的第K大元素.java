package 堆;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/kth-largest-element-in-a-stream/
 * 构建以K为长度的小定锥；
 * @author 涛宝宝
 *
 */
public class _703_数据流中的第K大元素 {
	
	
	
//	private int k;
//
//	private int nums[];
//
//	private int size;
//
//	public _703_数据流中的第K大元素(int k, int[] nums) {
//		this.k = k;
//		this.nums = nums;
//		size = nums.length;
//		Heaptify(this.nums);
//
//	}
//
//	private void Heaptify(int[] nums) {
//		// 我们使用自下而上的下溢进行原地建堆；
//		for (int i = (size >> 1) - 1; i >= 0; i--) {
//			down(nums, i);
//		}
//	}
//
//	// 下溢的过程。
//	private void down(int[] nums, int index) {
//		int element = nums[index];
//		int heaf = size >> 1;
//		while (index < heaf) {
//			int leftChilenIndex = (index << 1) + 1;
//			// 证明有右孩子;
//			if (leftChilenIndex + 1 < size) {
//				leftChilenIndex = nums[leftChilenIndex] > nums[leftChilenIndex + 1] ? leftChilenIndex
//						: leftChilenIndex + 1;
//			}
//			if (element < nums[leftChilenIndex]) {
//				nums[index] = nums[leftChilenIndex];
//			} else {
//				break;
//			}
//			index = leftChilenIndex;
//		}
//		nums[index] = element;
//	}
//
//	public int add(int val) {
//		ensureCapacity(size + 1);
//		nums[size] = val;
//		up(size);
//		List<Integer> list = new ArrayList();
//		for (int i = 0; i < k - 1; i++) {
//			list.add(poll());
//		}
//		int oldValue = poll();
//		list.add(oldValue);
//		for (int i = 0; i < list.size(); i++) {
//			addInner(list.get(i));
//		}
//		return oldValue;
//	}
//	
//	private void addInner(int val) {
//		ensureCapacity(size + 1);
//		nums[size++] = val;
//		up(size - 1);
//	}
//
//	private int poll() {
//		int oldMax = nums[0];
//		nums[0] = nums[--size];
//		down(nums, 0);
//		return oldMax;
//	}
//
//	private void up(int index) {
//		int element = nums[index];
//		while (index > 0) {
//			int parentIndex = (index - 1) >> 1;
//			int parent = nums[parentIndex];
//			if (element <= parent)
//				break;
//			// 将父元素存储在index位置
//			nums[index] = parent;
//			// 重新赋值index
//			index = parentIndex;
//		}
//		nums[index] = element;
//	}
//
//	private void ensureCapacity(int capacity) {
//		int oldCapacity = nums.length;
//		if (oldCapacity >= capacity)
//			return;
//
//		// 新容量为旧容量的1.5倍
//		int newCapacity = oldCapacity + (oldCapacity >> 1);
//		int[] newElements = new int[newCapacity];
//		for (int i = 0; i < size; i++) {
//			newElements[i] = nums[i];
//		}
//		nums = newElements;
//	}
//
//	private void emptyCheck() {
//		if (size == 0) {
//			throw new IndexOutOfBoundsException("Heap is empty");
//		}
//	}

}
