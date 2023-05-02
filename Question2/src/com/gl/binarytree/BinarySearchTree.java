package com.gl.binarytree;

import java.util.LinkedList;
import java.util.Queue;
import com.gl.treenode.Node;

/* Binary Search Tree class defined */
public class BinarySearchTree {

	/* insert method to add new node into the binary search tree */
	public Node insert(Node root, int k) {
		Node newNode = new Node(k);
		if (root == null) {
			root = newNode;

			return root;
		}

		Node parent = null;
		Node temp = root;
		while (temp != null) {
			parent = temp;
			if (temp.data == k) {
				System.out.println("Node " + k + " already exists");
				return root;
			} else if (k < temp.data) {
				temp = temp.left;
			} else {
				temp = temp.right;
			}
		}

		if (k < parent.data) {
			parent.left = newNode;
		} else if (k > parent.data) {
			parent.right = newNode;
		}

		return root;
	}

	/* method for printing the BST in level by level order */
	public void printLevelByLevel(Node root) {

		if (root == null) {
			System.out.println("Tree is empty");
			return;
		}
		Queue<Node> queue = new LinkedList<Node>();
		queue.add(root);
		System.out.print("Printing in Level Order: ");
		while (!queue.isEmpty()) {
			Node temp = queue.poll();
			System.out.print(temp.data + " ");
			if (temp.left != null) {
				queue.add(temp.left);
			}
			if (temp.right != null) {
				queue.add(temp.right);
			}

		}
	}

	/* method for printing the BST in-order traversal */
	public void inorder(Node root) {

		if (root == null) {
			return;
		}
		inorder(root.left);
		System.out.print(root.data + " ");
		inorder(root.right);
	}
}
