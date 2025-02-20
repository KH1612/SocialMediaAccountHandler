public class BinaryTree{

	Node root;

	public boolean addNode(User user) {

		Node newNode = new Node(user);

		if (root == null) {

			root = newNode;

		} else {

			Node focusNode = root;
			Node parent;

			while (true) {

				parent = focusNode;

				if (user.account.equals(parent.user.account)){
					return true;
				}
				else if (user.account.compareTo(parent.user.account)<0 ) {

					focusNode = focusNode.leftChild;

					// If the left child has no children

					if (focusNode == null) {

						// then place the new node on the left of it

						parent.leftChild = newNode;
						return false; // All Done

					}

				} else { // If we get here put the node on the right

					focusNode = focusNode.rightChild;

					// If the right child has no children

					if (focusNode == null) {

						// then place the new node on the right of it

						parent.rightChild = newNode;
						return false; // All Done

					}

				}
				
			}
			
		}
		return true;
	}

	// All nodes are visited in ascending order
	// Recursion is used to go to one node and
	// then go to its child nodes and so forth

	public void inOrderTraverseTree(Node focusNode) {

		if (focusNode != null) {

			// Traverse the left node

			inOrderTraverseTree(focusNode.leftChild);

			// Visit the currently focused on node

			System.out.println(focusNode);

			// Traverse the right node

			inOrderTraverseTree(focusNode.rightChild);

		}

	}

	public void preorderTraverseTree(Node focusNode) {

		if (focusNode != null) {

			System.out.println(focusNode);

			preorderTraverseTree(focusNode.leftChild);
			preorderTraverseTree(focusNode.rightChild);

		}

	}

	public void postOrderTraverseTree(Node focusNode) {

		if (focusNode != null) {

			postOrderTraverseTree(focusNode.leftChild);
			postOrderTraverseTree(focusNode.rightChild);

			System.out.println(focusNode);

		}

	}

	public Node findNode(String account) {

		// Start at the top of the tree

		Node focusNode = root;

		// While we haven't found the Node
		// keep looking

		while (!focusNode.user.account.equals(account)) {

			// If we should search to the left

			if (account.compareTo(focusNode.user.account) < 0) {

				// Shift the focus Node to the left child

				focusNode = focusNode.leftChild;

			} else {

				// Shift the focus Node to the right child

				focusNode = focusNode.rightChild;

			}

			// The node wasn't found

			if (focusNode == null)
				return null;

		}

		return focusNode;

	}
	public boolean remove(String account) {

		Node focusNode = root;
		Node parent = root;

		boolean isItALeftChild = true;

		while  (!focusNode.user.account.equals(account)) {

			parent = focusNode;

			if (account.compareTo(focusNode.user.account)<0) {

				isItALeftChild = true;

				focusNode = focusNode.leftChild;

			} else {

				isItALeftChild = false;

				focusNode = focusNode.rightChild;

			}

			if (focusNode == null)
				return false;

		}

		if (focusNode.leftChild == null && focusNode.rightChild == null) {

			if (focusNode == root)
				root = null;

			else if (isItALeftChild)
				parent.leftChild = null;

			else
				parent.rightChild = null;

		}

		else if (focusNode.rightChild == null) {

			if (focusNode == root)
				root = focusNode.leftChild;

			else if (isItALeftChild)
				parent.leftChild = focusNode.leftChild;

			else
				parent.rightChild = focusNode.leftChild;

		}

		else if (focusNode.leftChild == null) {

			if (focusNode == root)
				root = focusNode.rightChild;
			else if (isItALeftChild)
				parent.leftChild = focusNode.rightChild;
			else
				parent.rightChild = focusNode.rightChild;

		}
		else {

			Node replacement = getReplacementNode(focusNode);
			if (focusNode == root)
				root = replacement;
			else if (isItALeftChild)
				parent.leftChild = replacement;
			else
				parent.rightChild = replacement;
			replacement.leftChild = focusNode.leftChild;
		}
		return true;
	}

	public Node getReplacementNode(Node replacedNode) {

		Node replacementParent = replacedNode;
		Node replacement = replacedNode;

		Node focusNode = replacedNode.rightChild;

		// While there are no more left children

		while (focusNode != null) {

			replacementParent = replacement;

			replacement = focusNode;

			focusNode = focusNode.leftChild;

		}

		// If the replacement isn't the right child
		// move the replacement into the parents
		// leftChild slot and move the replaced nodes
		// right child into the replacements rightChild

		if (replacement != replacedNode.rightChild) {

			replacementParent.leftChild = replacement.rightChild;
			replacement.rightChild = replacedNode.rightChild;

		}

		return replacement;


}
}

  

