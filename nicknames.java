import java.io.*;
import java.util.*;

class Node {
	public String name;
	public int height;
	public Node left, right, parent;
	public int size;

	Node (String n) {
		name = n;
		parent = left = right = null;
		height = 1;
	}
}

class AVL {
	public Node root;
	public AVL() {root = null; }

	public void insert(String n) { root = insert(root, n); }

	public Node insert(Node T, String n) {
		if (T == null) {
			return new Node(n);
		}//insertion point is found

		if (T.name.compareTo(n) < 0) { //search to right
			T.right = insert(T.right, n);
			T.right.parent = T;
		} 
		else { //search to left
			T.left = insert(T.left, n);
			T.left.parent = T;
		}
		T.height = Math.max(getHeight(T.left), getHeight(T.right)) + 1; //update height
		T = rotation(T);
		return T; //return updated AVL
	}

	public int getHeight(Node T) {
		if (T == null) {
			return 0;
		}
		return T.height;
	}

	public int nodeHeight(Node T) {
		return T != null ? T.height : 0;
	}

	public int printHeight() {
		return getHeight(root);
	}

	public void inorder() {
		inorder(root);
		System.out.println();
	}

	public void inorder(Node T) {
		if (T == null) return;
		inorder(T.left); //recursively go left
		System.out.printf(" %s", T.name);
		inorder(T.right); //recursively go right
	}

	public int bf(Node T) {
		return T != null ? getHeight(T.left) - getHeight(T.right) : 0;
	}

	public Node rotation(Node T) {
		int balance = bf(T);
		if (balance > 1) {
			if (bf(T.left) > 0) {
				T=rotateRight(T);
			}
			else {
				T.left=rotateLeft(T.left);
				T=rotateRight(T);
			}
		}
		if (balance < -1) {
			if (bf(T.right) < 0) {
				T=rotateLeft(T);
			}
			else {
				T.right =rotateRight(T.right);
				T = rotateLeft(T);
			}
		}
		return T;
	}

	public Node rotateLeft(Node T) { //pre-req: T.right !=null
		Node W = T.right;
		if (W.left != null) {
			T.right = W.left;
			W.left.parent = T;
		} else {
			T.right = null;
		}
		if (T.parent == null) {
			root = W;
		}
		W.parent = T.parent;	
		W.left = T;
		T.parent = W;
		T.height = Math.max(getHeight(T.left), getHeight(T.right))+1;
		W.height = Math.max(getHeight(W.left), getHeight(W.right))+1;
		return W;
	}

	public Node rotateRight(Node T) { //pre-req: T.right !=null
		Node W = T.left;
		if (W.right != null) {
			T.left = W.right;
			W.right.parent = T;
		} else {
			T.left = null;
		}
		if (T.parent == null) {
			root = W;
		}
		W.parent = T.parent;	
		W.right = T;
		T.parent = W;
		T.height = Math.max(getHeight(T.left), getHeight(T.right))+1;
		W.height = Math.max(getHeight(W.left), getHeight(W.right))+1;
		return W;
	}

	public int getOccurences(String s) {
		return countOccurences(root, s);
	}

	public int countOccurences(Node T, String s) {
		if (T == null) return 0;
		else if (T.name.compareTo(s) < 0 ) return countOccurences(T.right, s);
		else if (T.name.indexOf(s) == 0) {
			return 1 + countOccurences(T.right, s) + countOccurences(T.left, s);
		}
		else {
			return countOccurences(T.left, s);
		}
	}
}



public class nicknames {
	public static void main (String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
		AVL tree = new AVL();
		int numName = Integer.parseInt(br.readLine());
		for (int x=0; x<numName; x++) {
			String curWord = br.readLine();
			tree.insert(curWord);
		}
		int nicks = Integer.parseInt(br.readLine());
		HashMap<String, Integer> seen= new HashMap<String, Integer>(nicks);
		for (int n=0; n<nicks; n++) {
			String curNick = br.readLine();
			if (seen.get(curNick) == null) {
				int count = tree.getOccurences(curNick);
				pw.println(count);
				seen.put(curNick, count);
			} else {
				pw.println(seen.get(curNick));
			}
		}
		pw.close();
	}
}