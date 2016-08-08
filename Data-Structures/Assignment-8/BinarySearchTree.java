/* Node structure for tree */
class Node {
        int data;
        Node left, right;
 
        public Node(int item) {
            data = item;
            left = right = null;
        }
    }


class BinarySearchTree {

    // Root Node
    Node root;
 
    // Constructor
    BinarySearchTree() { 
        root = null; 
    }
 
    // method to insert data in BST, starts a recursion
    void insert(int data) {
       root = insertRec(root, data);
    }
     
    /**
     *  recursive method to insert a new data in BST 
     *  */
    Node insertRec(Node root, int data) {
 
        /* If the root is empty, returns a new node */
        if (root == null) {
            root = new Node(data);
            return root;
        }
 
        /* Otherwise, recur down the tree according to BST order */
        if (data < root.data){
        	
            root.left = insertRec(root.left, data);
            
        } else if (data > root.data){
        	
            root.right = insertRec(root.right, data);
        }   
 
       
        return root;
    }
 
    /**
	 * In order traversal of a tree
	 * */
	public void inOrder(Node tree){
		if(tree==null){
			return;
		}

		// Recurring with left sub tree
		inOrder(tree.left);
		
		//dealing with node
		System.out.print( tree.data + " ");
		
		// Recurring with right sub tree
		inOrder(tree.right);			
		
	}
 
   
    // Driver Program 
    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree();
 
        tree.insert(50);
        tree.insert(30);
        tree.insert(20);
        tree.insert(40);
        tree.insert(70);
        tree.insert(60);
        tree.insert(80);
 
        // print inorder traversal of the BST
        tree.inOrder(tree.root);
    }
}
