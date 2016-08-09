import java.util.LinkedList;
import java.util.List;



/* Node structure for tree */
class Node <E> {
	E data;
	Node<E> left, right;

	public Node(E item) 
	{
		data = item;
		left = right = null;
	}
}


class BinarySearchTreeGeneric<E> 
{

	// Root Node
	Node<E> root;

	// Constructor
	BinarySearchTreeGeneric() 
	{ 
		root = null; 
	}

	// method to insert data in BST, starts a recursion
	@SuppressWarnings("unchecked")
	void insert(E data) 
	{
		root = insertRec(root, data);
	}
	
	
	/**
	 * @return reference for the root node of the tree
	 * 
	 * */
	public Node<E> getTree()
	{
		return root;
	}

	
	/**
	 *  recursive method to insert a new data in BST 
	 *  */
	private Node insertRec(Node<E> root, E data) 
	{

		/* If the root is empty, returns a new node */
		if (root == null) {
			root = new Node<E>(data);
			return root;
		}

		/* Otherwise, recur down the tree according to BST order */
		if(  ((Comparable)data).compareTo( root.data ) < 0 ){

			root.left = insertRec(root.left, data);

		} else if ( ((Comparable)data).compareTo( root.data ) > 0 ){

			root.right = insertRec(root.right, data);
		}   


		return root;
	}

	
	/**
	 * In order traversal of a tree
	 * */
	private void inOrder(Node<E> tree, List<E> traversal)
	{
		if(tree==null){
			return;
		}

		// Recurring with left sub tree
		inOrder(tree.left , traversal);

		//dealing with node
		traversal.add(tree.data);

		// Recurring with right sub tree
		inOrder(tree.right, traversal);			

	}


	
	/**
	 * @return list of inorder traversal
	 * */
	public List<E> getInOrderTraversal(Node<E> tree)
	{
		List<E>	traversal=new LinkedList<E>();

		inOrder(root, traversal);

		return traversal;
	}



}