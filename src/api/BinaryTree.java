package api;

public class BinaryTree {

	private Node root;
	private int size;

	public void insertAll(int[] keys) {
		for (int key : keys) {
			insert(key);
		}
	}

	public void insert(int key) {
		if (root == null) {
			root = new Node(key);
		} else {
			Node parent = null;
			Node current = root;
			while (current != null) {
				parent = current;
				current = (key < current.key) ? current.left : current.right;
			}
			if (key < parent.key) {
				parent.left = new Node(key);
			} else {
				parent.right = new Node(key);
			}
		}
		size++;
	}

	public int getSize() {
		return size;
	}

	void resetVisited() {
		resetVisited(root);
	}

	private void inOrder(Node node) {
		if (node != null) {
			inOrder(node.left);
			
			inOrder(node.right);
		}
	}

	public void inOrder() {
		inOrder(root);
	}

	private void resetVisited(Node node) {
		if (node != null) {
			resetVisited(node.left);
			resetVisited(node.right);
			node.setVisited(false);
		}
	}

	Node getRoot() {
		return root;
	}

	static class Node {

		private int key;
		private Node left;
		private Node right;
		private boolean visited;

		public Node(int key) {
			this.key = key;
		}

		boolean isVisited() {
			return visited;
		}

		void setVisited(boolean visited) {
			this.visited = visited;
		}

		Node getRight() {
			return right;
		}

		Node getLeft() {
			return left;
		}

		int getKey() {
			return key;
		}
	}
}
