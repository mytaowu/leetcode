package Trie;

import java.util.HashMap;

/**
 * https://leetcode-cn.com/problems/implement-trie-prefix-tree/
 * 
 * @author 涛宝宝 实现一颗前缀树；
 */
@SuppressWarnings("unused")
public class _208_实现Trie {
	
	//定义根节点；
	private Node root;
	
	private int size;

    //往字典树中进行插入
	public void insert(String word) {
		if (word == null || word.length() == 0) {
    		return;
    	}
		
		//初始化根节点;
		if (root == null) {
			root = new Node(null);
		}
		//用于进行循环的node节点;
		Node node = root;
		for (int i = 0; i < word.length(); i++) {
			Character c = word.charAt(i);
			//表示childen节点为空；
			if (node.childen == null) {
				node.childen = new HashMap<>();
			}
			Node temp = null;
			if ((temp = node.childen.get(c)) == null) {
				temp = new Node(node);
				temp.c = c;
				node.childen.put(c, temp);
			}
			node = temp;
		}
		node.isWord = true;
		size++;
	}


	//检查字典树中有没有word;
	public boolean search(String word) {
		if (word == null || word.length() == 0 || root == null) {
    		return false;
    	}
		//用于进行循环的node节点;
		Node node = root;
		for (int i = 0; i < word.length(); i++) {
			Character c = word.charAt(i);
			//表示childen节点为空；
			if (node.childen == null) {
	    		return false;
			}
			Node temp = null;
			if ((temp = node.childen.get(c)) == null) {
	    		return false;
			}
			node = temp;
		}
		if (node.isWord) {
			return true;
		}else {
			return false;
		}
	}
	
    //检查字典树是否以prefix开头。
	public boolean startsWith(String prefix) {
		if (prefix == null || prefix.length() == 0 || root == null) {
    		return false;
    	}
		//用于进行循环的node节点;
		Node node = root;
		for (int i = 0; i < prefix.length(); i++) {
			Character c = prefix.charAt(i);
			//表示childen节点为空；
			if (node.childen == null) {
	    		return false;
			}
			Node temp = null;
			if ((temp = node.childen.get(c)) == null) {
	    		return false;
			}
			node = temp;
		}
		return true;
	}
	
	
	private static class Node{
		Node parent;
		//指向其子节点：
		HashMap<Character, Node> childen;
		//保存的字符
		Character c;
		//是否为一个完成的单词；
		boolean isWord;
		public Node(Node parent) {
			super();
			this.parent = parent;
		}
	}
	
	public static void main(String[] args) {
		_208_实现Trie trie = new _208_实现Trie();
		trie.insert("apple");
		System.out.println(trie.startsWith("app"));
		trie.insert("app");
		System.out.println(trie.search("app"));
	}
}
