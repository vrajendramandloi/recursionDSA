package com.tree;

public class NormalTree {
	TreeNode root;
	public NormalTree() {
		root = null;
	}
	
	void printInorder(TreeNode node) {
        if (node == null)
            return;
        printInorder(node.left);
        System.out.print(node.key + " ");
        printInorder(node.right);
    }
	
	void printPreOrder(TreeNode node) {
        if (node == null)
            return;
        System.out.print(node.key + " ");
        printPreOrder(node.left);
        printPreOrder(node.right);
    }
	
	void printPostOrder(TreeNode node) {
        if (node == null)
            return;
        printPostOrder(node.left);
        printPostOrder(node.right);
        System.out.print(node.key + " ");
    }
	
	int height(TreeNode node) {
		if(node == null)
			return 0;
		int leftHeight = height(node.left);
		int rightHeight = height(node.right);
		
		if(leftHeight > rightHeight) {
			return leftHeight + 1;
		} else 
			return rightHeight + 1;
	}
	
	void printLevelOrder(TreeNode node) {
		for(int i=1; i<=height(node); i++) {
			printOrderByLevel(node, i);
			System.out.println();
		}
	}
	void printOrderByLevel(TreeNode node, int level) {
		if(level == 0) {
			return;
		}
		if(level == 1 && node!=null) {
			System.out.print(node.key);
		} else if(level > 1) {
			printOrderByLevel(node.left, level -1);
			printOrderByLevel(node.right, level -1);
		}
	}
	
	
}
