package api;

import java.util.ArrayDeque;
import java.util.Iterator;

import api.BinaryTree.Node;

public class InorderIterator implements Iterator<Integer> {

	private ArrayDeque<Node> stack = new ArrayDeque<>();

	public InorderIterator(BinaryTree binaryTree) {
		Node root = binaryTree.getRoot();
		if (root != null) {
			binaryTree.resetVisited();
			stack.push(root);
		}
	}

	@Override
	public boolean hasNext() {
		return !stack.isEmpty();
	}

	@Override
	public Integer next() {
		Node last = stack.getFirst();
		Node left = last.getLeft();
		if (left != null && !left.isVisited()) {
			while (left != null) {
				stack.push(left);
				left = left.getLeft();
			}
		}
		Node res = stack.remove();
		res.setVisited(true);
		if (res.getRight() != null) {
			stack.push(res.getRight());
		}
		return res.getKey();
	}

}
