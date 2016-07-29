
public class TryMyQueue {

	public static void main(String[] args) {
		
		MyQueue<String> q=new MyQueue<String>();
		
		q.enqueue("a");
		q.enqueue("b");
		
		System.out.println( q.dequeue() );
		System.out.println( q.dequeue() );
		
		System.out.println( q.dequeue() );
		
		

	}

}
