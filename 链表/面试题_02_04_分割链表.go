package 链表

/**
https://leetcode-cn.com/problems/partition-list-lcci/comments/
*/
func partition(head *ListNode, x int) *ListNode {
	list := make([]int, 0)

	newHead := &ListNode{}
	tempHead := newHead

	for head != nil {
		if head.Val < x {
			tempHead.Next = &ListNode{head.Val, nil}
			tempHead = tempHead.Next
		} else {
			list = append(list, head.Val)
		}
		head = head.Next
	}

	for _, value := range list {
		tempHead.Next = &ListNode{value, nil}
		tempHead = tempHead.Next
	}

	return newHead.Next
}
