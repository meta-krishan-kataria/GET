import java.util.List;

/**
 * Class to create heap for the type JOB
 * 
 * */
public class JobHeap {
	
	private int heapSize;
	
	public JobHeap(List<Job> a){
		heapSize=a.size();
	}
	
	
	/**
	 * 	@return the size of the heap
	 * */	
	public int  getHeapSize(List<Job> a ){
		return heapSize;
	}
	
	/**
	 * method to maintain the heap order
	 * 
	 * MAX-HEAPIFY	
	 * (ref: Intro. to algorithm by Cormen)
	 *	Its inputs are an array A and an index i into the array. When it is called, MAXHEAPIFY
	 *	assumes that the binary trees rooted at LEFT(i) and RIGHT(i) are maxheaps,
	 *		but that A[i] might be smaller than its children, thus violating the max-heap
	 *	property. MAX-HEAPIFY lets the value at A[i] “float down” in the max-heap so
	 *	that the subtree rooted at index i obeys the max-heap property.
	 * 
	 * a is the input arraylist
	 * i is the index for the node
	 * */
	void maxHeapify(List<Job> a,int i){
		//l is the index for the left child
		int l= 2*i +1;
		//r is the index for the right child
		int r= 2*i +2;
		
		int largest;
		
		if( l <= getHeapSize(a)-1 && a.get(l).getPriority() > a.get(i).getPriority()  ){
			largest=l;
		}else{
			largest=i;
		}
		
		if( r <= getHeapSize(a)-1 && a.get(r).getPriority() > a.get(largest).getPriority()  ){
			largest=r;
		}
		
		if( largest != i ){
			swap( a, i, largest );
			maxHeapify(a, largest);
		}
	}	
	

	
	/**
	 * swaps the two elements x,y in the arraylist
	 * */
	public void swap(List<Job> a ,int x,int y){
		Job temp=a.get(x);
		a.set(x, a.get(y));
		a.set(y, temp);
		
	}	
		
			
	/**
	 * builds heap from the input arraylist
	 * @return created heap
	 * */	
	public void buildHeap(List<Job> a){
		heapSize=a.size();
		for( int i = a.size()/2 ; i >= 0  ; i--){
			maxHeapify(a, i);
		}

	}
	
	/**
	 * 
	 *Heap Sort 
	 * 
	 */
	public void heapSort(List<Job> a){
		buildHeap(a);
		for(int i=a.size()-1;  i>=1; i--){
			swap(a, 0, i);
			heapSize--;
			maxHeapify(a, 0);
		}
	}
	
}
