package com.gl.binarytree;

import com.gl.treenode.Node;

/* Right Skewed Tree Class defined */
public class RightSkewedTree {

	Node headNode;
	Node prevNode;

	/* class constructor method */
	public RightSkewedTree() {
		headNode = null;
		prevNode = null;
	}

	/* method defined to convert any binary tree to right skewed */
	public Node convertToRightSkewed(Node root) {

		if (root == null) {
			return null;
		}

		convertToRightSkewed(root.left); /* recursive call to the left subtree */

		if (headNode == null) {  /* realigning the root node of the right skewed tree */
			headNode = root;
			root.left = null;
			prevNode = root;
		} else {                /* realigning subsequent nodes of the right skewed tree */
			prevNode.right = root;
			root.left = null;
			prevNode = root;
		}

		convertToRightSkewed(root.right); /* recursive call to the right subtree */

		/* returning the headNode that acts as the new root node */
		return headNode;
	}

}
