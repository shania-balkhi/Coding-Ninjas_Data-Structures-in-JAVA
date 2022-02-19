class BinarySearchTree {
	private BinaryTreeNode<Integer> root; // to pass in all the public methods as arguments so that all static Helper()
											// can use this root to carry out recursion
											// all Helper() are static since they operate being independent of the
											// current BST class (they can work on any node passed as argument to it!)
	private int size;

	// 1st method - insert()
	private static BinaryTreeNode<Integer> insertHelper(BinaryTreeNode<Integer> node, int data) {
		if (node == null) {
			BinaryTreeNode<Integer> newNode = new BinaryTreeNode<>(data);
			return newNode;
		}

		if (data > node.data) {             // acc. to question, if element is equal to the data of the node, we have to insert it in the left subtree
			node.right = insertHelper(node.right, data);
		} else {
			node.left = insertHelper(node.left, data);
		}

		return node;

	}

	public void insert(int data) {
		root = insertHelper(root, data);
		++size;
	}

	/*-----------------------------------------------------------------------------------------*/

	// 2nd method - remove()
	class BSTRemoveReturn {
		BinaryTreeNode<Integer> removedNode;
		boolean isRemoved;

		BSTRemoveReturn(BinaryTreeNode<Integer> removeNode, boolean isRemoved) {
			this.removedNode = removeNode;
			this.isRemoved = isRemoved;
		}
	}

	private BSTRemoveReturn removeHelper(BinaryTreeNode<Integer> node, int data) {
		if (node == null) {
			return new BSTRemoveReturn(null, false);
		}

		if (data > node.data) {
			BSTRemoveReturn outputRight = removeHelper(node.right, data);
			node.right = outputRight.removedNode;
			outputRight.removedNode = node; // to reduce the number of objects & return the only object that was
											// created. see @6:03 of lecture video 'Delete In BST - Code' for further
											// explanantion
			return outputRight;
		}

		if (data < node.data) {
			BSTRemoveReturn outputLeft = removeHelper(node.left, data);
			node.left = outputLeft.removedNode;
			outputLeft.removedNode = node; // to reduce the number of objects & return the only object that was created.
											// see @6:03 of lecture video 'Delete In BST - Code' for further
											// explanantion
			return outputLeft;
		}

		// data wasn't > & < than root node's data. that means if it is present in the
		// BST, it must be equal to the root node's data

		// if root node has 0 children
		if (node.left == null && node.right == null) {
			return new BSTRemoveReturn(null, true);
		}

		// if root node has just 1 child : left Child
		if (node.left != null && node.right == null) {
			return new BSTRemoveReturn(node.left, true);
		}

		// if root node has just 1 child : right child
		if (node.left == null && node.right != null){
			return new BSTRemoveReturn(node.right, true);
		}

		// if root node has both left and right children
		
		int rightMin = NodeWithMinimumValue(node.right);
		node.data = rightMin;
		BSTRemoveReturn rightOutput = removeHelper(node.right, rightMin);
		node.right = rightOutput.removedNode;
		return new BSTRemoveReturn(node, true);
		

	}

	private static int NodeWithMinimumValue(BinaryTreeNode<Integer> node) {
		if (node == null) {
			return Integer.MAX_VALUE;
		}

		int outputLeft = NodeWithMinimumValue(node.left);
		int outputRight = NodeWithMinimumValue(node.right);

		return Math.min(node.data, Math.min(outputLeft, outputRight));

	}

	public void remove(int data) {
		BSTRemoveReturn ans = removeHelper(root, data);
		root = ans.removedNode;
		if (ans.isRemoved == true) {
			--size;
		}
	}

	/*-----------------------------------------------------------------------------------------*/

	// 3rd method - print()
	private static void printTreeHelper(BinaryTreeNode<Integer> node) {
		if (node == null) {
			return;
		}

		System.out.print(node.data + ":");
		if (node.left != null) {
			System.out.print("L:" + node.left.data + ",");
		}
		if (node.right != null) {
			System.out.print("R:" + node.right.data);
		}
		System.out.println();

		printTreeHelper(node.left);
		printTreeHelper(node.right);

	}

	public void printTree() {
		printTreeHelper(root);
	}

	/*-----------------------------------------------------------------------------------------*/

	// 4th method - search()
	private static boolean searchHelper(BinaryTreeNode<Integer> node, int data) {
		if (node == null) {
			return false;
		}

		if (node.data == data) {
			return true;
		}

		if (data > node.data) {
			return searchHelper(node.left, data);
		}

		else {
			return searchHelper(node.right, data);
		}
	}

	public boolean search(int data) {
		return searchHelper(root, data);
	}

	/*-----------------------------------------------------------------------------------------*/

	// additional method - size()
	private int getSize() {
		return size;
	}

}
