package 串;

/**
 * https://leetcode-cn.com/problems/subtree-of-another-tree/
 * 	可以通过后续遍历，比较字符串的方式，吧我们的二叉树序列化成一个字符串，然后比较是否
 * 	包含字符即可。
 * @author 涛宝宝
 *
 */
public class _572_另一个树的子树 {

	
	public boolean isSubtree(TreeNode s, TreeNode t) {

		StringBuffer buffer = new StringBuffer();
		prevOrder(s,buffer);
		
		StringBuffer buffer2 = new StringBuffer();
		prevOrder(t,buffer2);
		
		return buffer.toString().contains(buffer2.toString());
	}

	private void prevOrder(TreeNode s, StringBuffer buffer) {
		//我们需要把空节点也进行一个处理，拼接返回。
		if (s == null) {
			buffer.append("#!");
			return;
		}
		prevOrder(s.left, buffer);
		prevOrder(s.right, buffer);
		buffer.append(s.val+"!");
	}

}
