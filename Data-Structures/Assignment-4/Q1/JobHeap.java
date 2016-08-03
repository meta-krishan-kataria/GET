import java.util.List;


public class JobHeap {
	
	void maxHeapify(List<Job> a,int i){
		//l is the index for the left child
		int l= 2*i +1;
		//r is the index for the right child
		int r= 2*i +2;
		
		int largest;
		
		if( l <= a.size()-1 && a.get(l).getPriority() > a.get(i).getPriority()  ){
			largest=l;
		}else{
			largest=i;
		}
		
		if( r <= a.size()-1 && a.get(r).getPriority() > a.get(largest).getPriority()  ){
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
	
	
	/**
	 * 
	 * */
	public void swap(List<Job> a ,int x,int y){
		Job temp=a.get(x);
		a.set(x, a.get(y));
		a.set(y, temp);
		
	}	
		
			
	/**
	 * build heap
	 * 
	 * */	
	public List<Job> buildHeap(List<Job> a){
		for( int i = a.size()/2 ; i >= 0  ; i--){
			maxHeapify(a, i);
		}
		return a;
	}
}
