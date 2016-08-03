
public class Job {
	private int id;
	private int priority;
	
	public Job(int id, int priority) {
		super();
		this.id = id;
		this.priority = priority;
	}

	public int getId() {
		return id;
	}

	public int getPriority() {
		return priority;
	}

	@Override
	public String toString() {
		return "Job [id=" + id + ", priority=" + priority + "]";
	}
	
	
}
