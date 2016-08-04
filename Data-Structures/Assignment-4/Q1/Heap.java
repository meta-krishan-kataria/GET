/**
 * Class to implement Heap
 * 
 * */
public class Heap {
	

	/**
	 * method to maintain the heap order
	 * 
	 * MAX-HEAPIFY.
		Its inputs are an array A and an index i into the array. When it is called, MAXHEAPIFY
		assumes that the binary trees rooted at LEFT(i) and RIGHT(i) are maxheaps,
		but that A[i] might be smaller than its children, thus violating the max-heap
		property. MAX-HEAPIFY lets the value at A[i] “float down” in the max-heap so
		that the subtree rooted at index i obeys the max-heap property.
	 * 
	 * a is the input array
	 * i is the index for the node
	 * */
	void maxHeapify(int[] a,int i){
		//l is the index for the left child
		int l= 2*i +1;
		//r is the index for the right child
		int r= 2*i +2;
		
		int largest;	//to store the index for the largest element
		
		if( l <= getHeapSize(a)-1 && a[l] > a[i]  ){
			largest=l;
		}else{
			largest=i;
		}
		
		if( r <= getHeapSize(a) && a[r] > a[largest]  ){
			largest=r;
		}
		
		if( largest != i ){
			swap( a, i, largest );
			maxHeapify(a, largest);
		}
	}	
	
	/**
	 * 	@return the size of the heap
	 * */	
	public int  getHeapSize(int[] a ){
		int count =0;
		for(int x:a){
			count++;
		}
		return count;
	}
	
	/**
	 * swaps two elements of the array
	 * */
	public void swap(int a[],int x,int y){
		int temp=a[x];
		a[x]=a[y];
		a[y]=temp;
	}	
		
			
	/**
	 * method to build heap
	 * 
	 *  the elements in the subarray A[(n/2)+1....n] are all leaves of the tree, and so each is
	 *  a 1-element heap to begin with. The procedure BUILD-MAX-HEAP goes through
	 *	the remaining nodes of the tree and runs MAX-HEAPIFY on each one.
	 * 
	 * */	
	public int[] buildHeap(int[] a){
		for( int i = a.length/2 ; i >= 0  ; i--){
			maxHeapify(a, i);
		}
		return a;
	}
		
	
	
}
	
	
	

