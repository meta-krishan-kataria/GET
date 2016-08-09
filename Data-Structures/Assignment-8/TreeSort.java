import java.util.List;


public class TreeSort<E> {
	
	public List<E> sort( List<E> input ){
		//creating BST object
		BinarySearchTreeGeneric<E> bst=new BinarySearchTreeGeneric<E>();
		
		//inserting elements of input list(unsorted) into BST
		for( E e : input ){
			bst.insert(e);
		}
		
		//traversing BST inorder and returning traversed list
		return bst.getInOrderTraversal( bst.getTree() );
		
	}
}
