package 数组;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * https://leetcode-cn.com/contest/weekly-contest-201/problems/maximum-number-of-non-overlapping-subarrays-with-sum-equals-target/
 * https://leetcode-cn.com/problems/maximum-number-of-non-overlapping-subarrays-with-sum-equals-target/
 * @author 涛宝宝
 *
 */
public class _1546_和为目标值的最大数目不重叠非空子数组数目 {

	public int maxNonOverlapping(int[] nums, int target) {

		HashSet<Node> set = new HashSet<>();
//		for (int i = 0; i < nums.length; i++) {
//			for (int j = i + 1; j <= nums.length; j++) {
//				// 我们还是使用左闭右开的区间进行操作；
//				if (target == sum(nums, i, j)) {
//					list.add(new Node(i, j));
//				}
//			}
//		}
//		Collections.sort(list, new Comparator<Node>() {
//			@Override
//			public int compare(Node o1, Node o2) {
//				return o2.begin - o1.begin;
//			}
//		});
//		list.forEach((Node node) -> {
//			System.out.println(node);
//			set.add(node);
//		});
//		return set.size();
		
		for (int i = nums.length - 1; i >= 0; i--) {
			for (int j = i + 1; j <= nums.length ; j++) {
				if (target == sum(nums, i, j)) {
					set.add(new Node(i, j));
				}
			}
		}
		return set.size();
	}

	class Node {
		int begin;
		int end;

		public Node(int begin, int end) {
			super();
			this.begin = begin;
			this.end = end;
		}

		@Override
		public boolean equals(Object obj) {
			Node newNode = (Node) obj;
			if (newNode.begin >= this.end) {
				return false;
			}
			if (newNode.end <= this.begin) {
				return false;
			}
			return true;
		}

		@Override
		public int hashCode() {
			return 0;
		}
		
		@Override
		public String toString() {
			return "this.begin = " + this.begin + " this.end = " + this.end;
		}
	}

	/**
	 * 求和的函数
	 */
	private int sum(int[] nums, int bagin, int end) {
		int sum = 0;
		for (int i = bagin; i < end; i++) {
			sum += nums[i];
		}
		return sum;
	}
	
	
	/**
	 * 正确答案；;
	 * @param nums
	 * @param target
	 * @return
	 */
	public int maxNonOverlapping2(int[] nums, int target) {
        // 对每一段总和都用set保存下来，判断之前是否有某段+target=当前段
        Set<Integer> set = new HashSet();
        int curSum = 0;
        int res = 0;
        set.add(0);
        for (int num : nums) {
            curSum += num;
            if (set.contains(curSum - target)) {
                // 如果当前段和减去之前某一段和为target，则符合条件，即当前curSum=上次curSum+target
                set.clear();
                set.add(0);
                curSum = 0;
                res++;
            } else {
                // 还未满足条件，保留当前段的和
                set.add(curSum);
            }
        }
        return res;
    }


	public static void main(String[] args) {
		int ar[] = {0,0,0};
		new _1546_和为目标值的最大数目不重叠非空子数组数目().maxNonOverlapping(ar, 0);
	}
}
