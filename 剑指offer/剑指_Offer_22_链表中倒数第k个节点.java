package 剑指offer;

import 链表.ListNode;

/**
 * @author TMingYi
 * @description https://leetcode-cn.com/problems/lian-biao-zhong-dao-shu-di-kge-jie-dian-lcof/
 * @date 2020年12月21日
 */
public class 剑指_Offer_22_链表中倒数第k个节点 {

	// 此题还可以用快慢指针进行一个解题，快指针先走k步，然后慢指针再走。
	public ListNode getKthFromEnd(ListNode head, int k) {
		
		int len = 0;
		ListNode tmpNode = head;
		while (tmpNode.next != null) {
			len++;
			tmpNode = tmpNode.next;
		}
		
		int count = 1;
		while (head.next != null) {
			if (count == len - k) {
				return head;
			}else {
				count++;
				head = head.next;
			}
		}
		return head;
	}

}
