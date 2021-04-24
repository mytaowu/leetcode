package 链表

func kthToLast(head *ListNode, k int) int {
	firstNode := head
	secondNode := head

	for i := 0; firstNode != nil; i++ {
		firstNode = firstNode.Next
		if i >= k {
			secondNode = secondNode.Next
		}
	}

	return secondNode.Val
}
