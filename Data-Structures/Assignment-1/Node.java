package MyUtil;

public class Node < E extends Comparable<E> > implements Comparable<Node<E>>  {
	E data;				//data for the node
	Node<E> next;		//pointer to the next node	
	
	public E getData(){
		return data;
	}
	
	@Override
    public int compareTo(Node<E> n) {
        return getData().compareTo(n.getData());
    }
}


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
 */
