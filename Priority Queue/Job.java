package PriorityQueue;

/* This is a component class. This class 
 * @author Bhupendra
 *
 */
public class Job {
	
	// Instance variables.
	private int priority;
	private String jobName;
	
	// Constructor.
	public Job(int priority, String jobName) {
		this.priority = priority;
		this.jobName = jobName;
	}
	
	/* This method return the job name.
	 * @return job name
	 */
	public String getJobName() {
		return this.jobName;
	}
	
	/* This method returns the priority of the job.
	 * @return priority.
	 */
	public int getPriority() {
		return this.priority;
	}
}
