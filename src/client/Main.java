package client;

import api.BinaryTree;
import api.InorderIterator;

public class Main {

	public static void main(String[] args) {
		BinaryTree binaryTree = new BinaryTree();
		binaryTree.insertAll(new int[] { 100, 80, 109, 60, 86, 102, 112, 70, 82, 87, 107, 65, 71 });
		binaryTree.inOrder();
		System.out.println();
		InorderIterator inorderIterator = new InorderIterator(binaryTree);
		while (inorderIterator.hasNext()) {
			System.out.print(inorderIterator.next() + " ");
		}
	}

}
