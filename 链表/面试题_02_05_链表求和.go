package 链表

/**
https://leetcode-cn.com/problems/sum-lists-lcci/
*/

func addTwoNumbers(l1 *ListNode, l2 *ListNode) *ListNode {
	newHead := &ListNode{}
	tempHead := newHead
	falg := false

	for l1 != nil && l2 != nil {
		temp := l1.Val + l2.Val
		if falg {
			// 表示上一位有进位
			temp += 1
		}

		if temp >= 10 {
			falg = true
			temp %= 10
		} else {
			falg = false
		}

		head := &ListNode{temp, nil}
		tempHead.Next = head
		tempHead = tempHead.Next

		l1 = l1.Next
		l2 = l2.Next
	}

	for l1 != nil {
		temp := l1.Val
		if falg {
			temp += 1
			falg = false
		}
		if temp >= 10 {
			falg = true
			temp %= 10
		} else {
			falg = false
		}
		head := &ListNode{temp, nil}
		tempHead.Next = head
		tempHead = tempHead.Next
		l1 = l1.Next
	}

	for l2 != nil {
		temp := l2.Val
		if falg {
			temp += 1
			falg = false
		}
		if temp >= 10 {
			falg = true
			temp %= 10
		} else {
			falg = false
		}
		head := &ListNode{temp, nil}
		tempHead.Next = head
		tempHead = tempHead.Next
		l2 = l2.Next
	}

	if falg {
		head := &ListNode{1, nil}
		tempHead.Next = head
		tempHead = tempHead.Next
	}
	return newHead.Next
}
