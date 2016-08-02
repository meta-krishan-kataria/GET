import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * methods to work on trees
 * */


public class TreeMethods <E> {
	
	//Common list to store traversal result
	List<E> list=new ArrayList<E>();
	
	/**
	 * cleans the list, remove all elements of the list
	 * */
	void clean(){
		list.clear();
	}
	
	/**
	 * return the list
	 * */
	public List<E> getResult(){
		return list;
	}
	
	/**
	 * preorder traversal of a tree
	 * */
	void preOrder(Node<E> tree){
		if(tree==null){
			return;
		}
		
		//dealing with node
		list.add(tree.data);
		System.out.print( tree.data + " ");
		
		// Recurring with left sub tree
		preOrder(tree.left);
		
		// Recurring with right sub tree
		preOrder(tree.right);
			
		
	}
	
	/**
	 * postorder traversal of a tree
	 * */
	void postOrder(Node<E> tree){
		if(tree==null){
			return;
		}

		// Recurring with left sub tree
		postOrder(tree.left);
		
		// Recurring with right sub tree
		postOrder(tree.right);
		
		
		//dealing with node
		list.add(tree.data);
		System.out.print( tree.data + " ");
			
		
	}
	
	
	/**
	 * postorder traversal of a tree
	 * */
	void inOrder(Node<E> tree){
		if(tree==null){
			return;
		}

		// Recurring with left sub tree
		inOrder(tree.left);
		
		//dealing with node
		list.add(tree.data);
		System.out.print( tree.data + " ");
		
		// Recurring with right sub tree
		inOrder(tree.right);			
		
	}
	
	
	/**
	 * checks whether to trees are mirror image of each other
	 * 
	 */
	 /*
	  *  using Krishan's Theorem 
	  *  
	  *  "two trees are mirror image of each other
	 *  if the preorder traversal of one is equal to the reversed post order traversal
	 *  of the other" 
	 *  
	 * 
	 * */
	public boolean isMirror(Node<E> t1,Node<E> t2){
		//cleaning list
		clean();
		//pre order traversal for t1
		preOrder(t1);
		//geting list
		List list1=new ArrayList( getResult() );
		
		//cleaning list
		clean();
		//post order traversal for t2
		postOrder(t2);
		//geting list
		List list2=new ArrayList( getResult() );
		
		//reversing list2
		Collections.reverse(list2);
		
		//comparing lists
		for( int i=0  ;      i < list1.size() ;       i++ ){
			if(  ! list1.get(i).equals(  list2.get(i) )  ){
				return false;
			}
		}
		return true;
		
		
		
	}
	
	
	
}
