package 链表



func findTheWinner(n int, k int) int {
	if k == 1 {
		return n
	}

	newHead := &ListNode{}
	curNode := newHead
	for i := 1 ; i <= n ; i++ {
		tempNode := &ListNode{i, nil}

		curNode.Next = tempNode
		curNode = curNode.Next
	}

	curNode.Next = newHead.Next
	newHead = newHead.Next


	for newHead.Next != newHead {
		for i := 1 ; i < k - 1 ; i++ {
			newHead = newHead.Next
		}
		newHead.Next = newHead.Next.Next
		newHead = newHead.Next
	}

	return newHead.Val
}
