package MyUtil;

public class EmptyMyQueueException extends RuntimeException {

	public EmptyMyQueueException() {
		super();
		
	}

	public EmptyMyQueueException(String msg) {
		super(msg);
		
	}

}
