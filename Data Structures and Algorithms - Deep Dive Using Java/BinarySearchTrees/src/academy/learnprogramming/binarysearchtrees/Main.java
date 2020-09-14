package academy.learnprogramming.binarysearchtrees;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
	    Tree intTree = new Tree();
	    intTree.insert(25);
	    intTree.insert(20);
	    intTree.insert(15);
	    intTree.insert(27);
	    intTree.insert(30);
	    intTree.insert(29);
	    intTree.insert(26);
	    intTree.insert(22);
	    intTree.insert(32);
	    intTree.insert(17);

	    intTree.traverseInOrder();

		System.out.println();
//		System.out.println(intTree.get(27));
//		System.out.println(intTree.get(17));
//		System.out.println(intTree.get(8888));
//
//		System.out.println(intTree.min());
//		System.out.println(intTree.max());

		intTree.delete(15);
		intTree.traverseInOrder();
		System.out.println();

		intTree.delete(27);
		intTree.traverseInOrder();
		System.out.println();

		intTree.delete(25);
		intTree.traverseInOrder();
		System.out.println();

		// CLRS 12.1-3 workspace
//		ArrayStack aux = new ArrayStack(10);
//		aux.push(intTree.getRoot());
//		ArrayList output = new ArrayList<>();
//		while (aux.peek().getLeftChild() != null) {
//			aux.push(aux.peek().getLeftChild());
//		}
//		while(!aux.isEmpty()) {
//			TreeNode node = aux.pop();
//			output.add(node.getData());
//			if (node.getRightChild() != null) {
//				aux.push(node.getRightChild());
//				while (aux.peek().getLeftChild() != null) {
//					aux.push(aux.peek().getLeftChild());
//				}
//			}
//		}
//		System.out.println(output);

    }

}
