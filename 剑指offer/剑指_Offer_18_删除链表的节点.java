package 剑指offer;

import 链表.ListNode;

/**
 * @author TMingYi
 * @description https://leetcode-cn.com/problems/shan-chu-lian-biao-de-jie-dian-lcof/
 * @date 2020年12月21日
 */
public class 剑指_Offer_18_删除链表的节点 {
	public ListNode deleteNode(ListNode head, int val) {
		while (head !=null && head.val == val) {
			head = head.next;
		}
		
		ListNode newHead = head;
		
		while (head.next != null) {
			if (head.next.val == val) {
				head.next = head.next.next;
			}else {
				head = head.next;
			}
		}
		return newHead;
		
	}
	
}
