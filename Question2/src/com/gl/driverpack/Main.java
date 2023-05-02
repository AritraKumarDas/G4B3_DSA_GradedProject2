package com.gl.driverpack;

/* class imports */
import com.gl.treenode.Node;
import com.gl.binarytree.BinarySearchTree;
import com.gl.binarytree.RightSkewedTree;

/* Driver Class Main() */
public class Main {

	public static void main(String[] args) {

		int[] arr = { 50, 30, 60, 10, 55 }; /* Array Node data inputs taken in an Array */

		Node root = null; /* root node initialized with null */

		BinarySearchTree bst = new BinarySearchTree(); /* Instance of BST created */

		for (int i = 0; i < arr.length; i++) {
			root = bst.insert(root, arr[i]); /* insert() method called to insert the nodes in BST */
		}

		System.out.println("----- Before Coversion of Binary Search Tree ----- ");
		System.out.println("Root Node = " + root.data); /* printing root node of BST before conversion */
		bst.printLevelByLevel(root); /* printing the BST in level order before conversion */

		RightSkewedTree rst = new RightSkewedTree(); /* instance of RightSkewedTree created to invoke covert method */
		root = rst.convertToRightSkewed(root); /* convert method of RightSkewedTree invoked passing in root of BST */

		System.out.println("\n\n----- After conversion to Right Skewed Tree ----- ");
		System.out.println("Root Node = " + root.data); /* printing root node of BST after conversion */
		bst.printLevelByLevel(root); /* printing the same BST in level order after conversion */

	}
}
