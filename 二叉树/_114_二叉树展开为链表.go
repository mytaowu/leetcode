package 二叉树

func flatten(root *TreeNode)  {
	if root == nil {
		return
	}

	var list = make([]*TreeNode, 0)

	order(root, &list)
	for i := 0 ; i < len(list) - 1 ; i++ {
		list[i].Left = nil
		list[i].Right = list[i + 1]
	}

	list[len(list) - 1].Left = nil
	list[len(list) - 1].Right = nil
}

func order(node *TreeNode, list *[]*TreeNode) {
	*list = append(*list, node)
	if node.Left != nil {
		order(node.Left, list)
	}
	if node.Right != nil {
		order(node.Right, list)
	}
}
