
//Class to demonstrate Heap class methods
public class HeapDemo {

	public static void main(String[] args) {
		
		int a[]={1,10,8,4,68,29,67};
		
		Heap heap=new Heap(a);
	

		heap.buildHeap(a);
		for(int x : a){
			System.out.print(x+"  ");
		}
		System.out.println();
		
		
		heap.heapSort(a);
		
		for(int x : a){
			System.out.print(x+"  ");
		}
		 
	}

}
