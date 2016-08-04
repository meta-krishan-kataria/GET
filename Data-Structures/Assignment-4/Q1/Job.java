/**
 * Class to represent a job
 * 
 * */
public class Job {
	
	private int id;				//job id
	private int priority;		//job priority. Higher value implies higher priority
	
	
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
