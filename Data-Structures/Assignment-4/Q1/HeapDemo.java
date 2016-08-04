
//Class to demonstrate Heap class methods
public class HeapDemo {

	public static void main(String[] args) {
		
		int a[]={1,2,3,4,5,6,7};
		
		Heap heap=new Heap();
	

		int b[]=heap.buildHeap(a);
		
		for(int x : b){
			System.out.print(x+"  ");
		}
		 
	}

}
