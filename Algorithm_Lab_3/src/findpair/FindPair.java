package findpair;

import java.util.*;

public class FindPair {
	class Node {
		private Node left;
		private Node right;
		private int data;

		Node(int key){
		left=right=null;
		data=key;
		}
	}

		public Node insert(Node root, int key) {
			if(root==null)
				return new Node(key);
			if(key<root.data) {

				root.left= insert(root.left, key);
			}
			else {
				root.right=insert(root.right, key);
			}
			return root;
		}

		public static boolean findPair(Node current, int sum,Set set) {
			if(current==null) {
			return false;
			}
			else {
				boolean isPresent = findPair(current.left,sum,set);
				if(isPresent) {
					return isPresent;
				}
				if(set.contains(sum - current.data)) {
					System.out.println("The pair exists with values of "+ (sum-current.data)+ ","+current.data);
					return true;
				}
				else {
					set.add(current.data);
				}
				return findPair(current.right,sum,set);
			}
		}
			public static void findPairWithGivenSum(Node root, int sum) {
			HashSet<Integer> set = new HashSet<Integer>();
			boolean isPresent = findPair(root,sum,set);
			if(!isPresent) {
				System.out.println("Pair does not exist");
			}
}
			public static void main(String[] args) {
				Node root = null;
				FindPair findPair = new FindPair();
				root = findPair.insert(root, 10);
				root = findPair.insert(root, 20);
				root = findPair.insert(root, 30);
				root = findPair.insert(root, 40);
				root = findPair.insert(root, 55);
				root = findPair.insert(root, 60);
				root = findPair.insert(root, 70);
				findPairWithGivenSum(root,65);
				}
}