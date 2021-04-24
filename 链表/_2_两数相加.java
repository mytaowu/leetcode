package 链表;

/**
 * https://leetcode-cn.com/problems/add-two-numbers/
 * 
 * @author 涛宝宝
 *
 */
public class _2_两数相加 {

//	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
//		l1 = reverse(l1);
//		l2 = reverse(l2);
//		String result1 = "";
//		while (l1 != null) {
//			result1 += l1.val;
//		}
//		
//		String result2 = "";
//		while (l2 != null) {
//			result2 += l2.val;
//		}
//		
//		String sum = String.valueOf(Integer.parseInt(result1) + Integer.parseInt(result2));
//		ListNode newNead = new ListNode(sum.charAt(0));
//		ListNode temp = newNead;
//		for (int i = 1; i < sum.length(); i++) {
//			ListNode node = new ListNode(sum.charAt(i));
//			temp.next = node;
//			temp = temp.next;
//		}
//		return newNead;
//	}
//
//	private ListNode reverse(ListNode node) {
//		ListNode newNead = null;
//		while (node != null) {
//			ListNode temp = node.next;
//			node.next = newNead;
//			newNead = node;
//			node = temp;
//		}
//		return newNead;
//	}
	
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        ListNode result = new ListNode((l1.val + l2.val) % 10);
        int jinwei = (l1.val + l2.val) / 10;
        l1 = l1.next;
        l2 = l2.next;
        while (l1 != null && l2 != null) {
            int current = l1.val + l2.val + jinwei;
            ListNode temp = result;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = new ListNode(current % 10);
            jinwei = current / 10;
            l1 = l1.next;
            l2 = l2.next;
        }
        while (l1 != null) {
            int current = l1.val + jinwei;
            ListNode temp = result;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = new ListNode(current % 10);
            jinwei = current / 10;
            l1 = l1.next;
        }
        while (l2 != null) {
            int current = l2.val + jinwei;
            ListNode temp = result;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = new ListNode(current % 10);
            jinwei = current / 10;
            l2 = l2.next;
        }
        if (jinwei == 1) {
            ListNode temp = result;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = new ListNode(1);
        }
        return result;
    }

}
