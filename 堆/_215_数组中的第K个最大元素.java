package 堆;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * https://leetcode-cn.com/problems/kth-largest-element-in-an-array/
 * @author 涛宝宝
 *
 */
public class _215_数组中的第K个最大元素 {
	
	
	//我们使用优先级队列来完成。
	public int findKthLargest(int[] nums, int k) {
		if (nums == null) return -1;
		if (nums.length == 0) return -1;
		if (k < 1) return -1;
		PriorityQueue<Integer> queue = new PriorityQueue<Integer>((Integer o1, Integer o2) -> {
			return o2 - o1;
		});
		for (int i = 0; i < nums.length; i++) {
			queue.offer(nums[i]);
		}
		for (int i = 0; i < k-1; i++) {
			//删除一个元素;
			queue.poll();
		}
		return queue.poll();
    }

//	int size;
//
//		
//	//这里就需要使用我们的二叉堆了；
//	public int findKthLargest(int[] nums, int k) {
//		//原地建堆的式子；
//		size = nums.length;
//		Heaptify(nums);
//		System.out.println(Arrays.toString(nums));
//		for (int i = 0; i < k-1; i++) {
//			//删除一个元素;
//			remove(nums);
//		}
//		return remove(nums);
//    }
//	
//	private int remove(int[] nums) {
//		int oldMax = nums[0];
//		nums[0] = nums[--size];
//		down(nums, 0);
//		return oldMax;
//	}
//
//	private void Heaptify(int[] nums) {
//		//我们使用自下而上的下溢进行原地建堆；
//		for (int i = (size >> 1) - 1; i >= 0; i--) {
//			down(nums,i);
//		}		
//	}
//
//	//下溢的过程。
//	private void down(int[] nums, int index) {
//		int element = nums[index];
//		int heaf = size >> 1;
//		while (index < heaf) {
//			int leftChilenIndex = (index << 1) + 1;
//			//证明有右孩子;
//			if (leftChilenIndex + 1 < size) {
//				leftChilenIndex = nums[leftChilenIndex] > nums[leftChilenIndex + 1] ? leftChilenIndex : leftChilenIndex + 1;
//			}
//			if (element < nums[leftChilenIndex]) {
//				nums[index] = nums[leftChilenIndex];
//			}else {
//				break;
//			}
//			index = leftChilenIndex;
//		}
//		nums[index] = element;
//	}
//	
//	private void siftDown(int num[], int index) {
//		int element = num[index];
//		int half = size >> 1;
//		// 第一个叶子节点的索引 == 非叶子节点的数量
//		// index < 第一个叶子节点的索引
//		// 必须保证index位置是非叶子节点
//		while (index < half) { 
//			// index的节点有2种情况
//			// 1.只有左子节点
//			// 2.同时有左右子节点
//			
//			// 默认为左子节点跟它进行比较
//			int childIndex = (index << 1) + 1;
//			int child = num[childIndex];
//			
//			// 右子节点
//			int rightIndex = childIndex + 1;
//			
//			// 选出左右子节点最大的那个
//			if (rightIndex < size && num[rightIndex]> child) {
//				child = num[childIndex = rightIndex];
//			}
//			
//			if (element>=child) break;
//
//			// 将子节点存放到index位置
//			num[index] = child;
//			// 重新设置index
//			index = childIndex;
//		}
//		num[index] = element;
//	}

	public static void main(String[] args) {
		new _215_数组中的第K个最大元素().findKthLargest(new int[]{2,1,3,5,6,4}, 2);
	}

}
