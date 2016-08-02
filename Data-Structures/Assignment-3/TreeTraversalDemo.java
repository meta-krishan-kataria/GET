
public class TreeTraversalDemo {

	public static void main(String[] args) {

		//creating a tree
		Node<String> tree=new Node("A");	//root node
		
		tree.left=new Node<String>("B");
		tree.right=new Node<String>("C");
		
		tree.left.left=new Node<String>("D");
		tree.left.right=new Node<String>("E");
		
		tree.right.left=new Node<String>("F");
		tree.right.right=new Node<String>("G");
		
		
		//Traversing 
		
		TreeMethods<String> travrese=new TreeMethods<String>();
		
		System.out.println("Pre Order Traversal");
		travrese.preOrder(tree);
		System.out.println();
		
		System.out.println("Post Order Treaversal");
		travrese.postOrder(tree);
		System.out.println();
		


		System.out.println("In Order Treaversal");
		travrese.inOrder(tree);
		System.out.println();
		

		//creating another tree 
		Node<String> tree2=new Node("A");	//root node

		tree2.left=new Node<String>("C");
		tree2.right=new Node<String>("B");

		tree2.left.left=new Node<String>("G");
		tree2.left.right=new Node<String>("F");

		tree2.right.left=new Node<String>("E");
		tree2.right.right=new Node<String>("D");

		//Traversing 
		System.out.println();

		TreeMethods<String> travrese2=new TreeMethods<String>();

		System.out.println("Pre Order Traversal");
		travrese2.preOrder(tree2);
		System.out.println();


		System.out.println("Post Order Treaversal");
		travrese2.postOrder(tree2);
		System.out.println();



		System.out.println("In Order Treaversal");
		travrese2.inOrder(tree2);	
		System.out.println();


		//checking mirror image
		System.out.println( travrese.isMirror(tree, tree2)  );
				
	}

}
