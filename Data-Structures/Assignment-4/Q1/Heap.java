
public class Heap {
	
	/**
	 * 
		* MAX-HEAPIFY.A; i /
		1 l D LEFT.i /
		2 r D RIGHT.i /
		3 if l <= A:heap-size and AOEl > AOEi
		4 largest D l
		5 else largest D i
		6 if r <= A:heap-size and AOEr > AOElargest
		7 largest D r
		8 if largest != i
		9 exchange AOEi with AOElargest
		10 MAX-HEAPIFY.A; largest/
	 * 
	 * 
	 * */

	/**
	 * a is the input array
	 * i is the index for the node
	 * */
	void maxHeapify(int[] a,int i){
		//l is the index for the left child
		int l= 2*i +1;
		//r is the index for the right child
		int r= 2*i +2;
		int largest;
		
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
	 * 
	 * */	
	public int  getHeapSize(int[] a ){
		int count =0;
		for(int x:a){
			count++;
		}
		return count;
	}
	
	/**
	 * 
	 * */
	public void swap(int a[],int x,int y){
		int temp=a[x];
		a[x]=a[y];
		a[y]=temp;
	}	
		
			
	/**
	 * build heap
	 * 
	 * */	
	public int[] buildHeap(int[] a){
		for( int i = a.length/2 ; i >= 0  ; i--){
			maxHeapify(a, i);
		}
		return a;
	}
		
	
	
}
	
	
	

