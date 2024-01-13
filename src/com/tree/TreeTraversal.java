package com.tree;

public class TreeTraversal {
	public static void main(String[] args)
    {
        NormalTree tree = new NormalTree();
        tree.root = new TreeNode(1);
        tree.root.left = new TreeNode(2);
        tree.root.right = new TreeNode(3);
        tree.root.left.left = new TreeNode(4);
        tree.root.left.right = new TreeNode(5);
        tree.root.right.left = new TreeNode(6);
        tree.root.right.right = new TreeNode(7);
        tree.root.right.left.left = new TreeNode(8);
        tree.root.right.left.right = new TreeNode(9);
        // Function call
        System.out.println("Inorder traversal :");
        tree.printInorder(tree.root);
        System.out.println();
        System.out.println("PreOrder traversal :");
        tree.printPreOrder(tree.root);
        System.out.println();
        System.out.println("PostOrder traversal :");
        tree.printPostOrder(tree.root);
        System.out.println();
        System.out.println("height : " +  tree.height(tree.root));
        System.out.println("Level Order traversal :");
        tree.printLevelOrder(tree.root);
        System.out.println("Boundary traversal :");
        
        System.out.println("Daigonal Order traversal :");
    }
	
}
