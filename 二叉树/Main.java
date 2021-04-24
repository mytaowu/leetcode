package 二叉树;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * 纯JAVA实现的图片处理工具类
 * @author wutaotao
 * time：2020/1/5 17.58
 */
public class Main {
	
	public static void main(String[] args) throws IOException {
//		String str = "123";
//		String str2 = new String("123");
//		System.out.println(str.hashCode());
//		System.out.println(str2.hashCode());
//		System.out.println(str == str2);
		TreeNode treeNode = new TreeNode(1);
		TreeNode treeNode2 = treeNode;
		treeNode2 = null;
		System.out.println(treeNode);
		System.out.println(treeNode2);
	}
}
