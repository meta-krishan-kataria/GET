package MyUtil;

public class Node<E> implements Comparable{
	E data;				//data for the node
	Node<E> next;		//pointer to the next node	
	
	public E getData(){
		return data;
	}

	@Override
	public int compareTo(	Object arg0) {
		//line 1
		//boolean a= getData() > arg0.getData() ;	//****Error "The operator > is undefined for the argument type(s) E, E"
		
		//line 2
		return ((Comparable)getData()).compareTo( (Comparable)( (Node<E>)arg0 ).getData() );	//****Error "The method compareTo(E) is undefined for the type E"
	}

	/*@Override
	public int compareTo(Object o) {
		// TODO Auto-generated method stub
		return 0;
	}*/
	
	
}


/*public class Node < T extends Comparable<T> > implements Comparable< Node >  {
	T data;				//data for the node
	Node<T> next;		//pointer to the next node	
	
	public T getData(){
		return data;
	}
	
	@Override
    public int compareTo(Node n) {
        return getData().compareTo(n.getData());
    }
}*/

/*
 * 
 * public class Item<T extends Comparable<T>> implements Comparable<Item> {

    private int s;
    private T t;

    public T getT() {
        return t;
    }

    @Override
    public int compareTo(Item o) {
        return getT().compareTo(o.getT());
    }

 * */
/*public class Node < E  > implements Comparable< Node<E> >  {
	E data;				//data for the node
	Node<E> next;		//pointer to the next node	
	
	public E getData(){
		return data;
	}
	
	@Override
    public int compareTo(Node<E> n) {
        return ( (Comparable<Node<E>>) getData()).compareTo((Node<E>) n.getData() );
    }
}*/


 