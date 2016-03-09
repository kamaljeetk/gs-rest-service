package hello;

public class GreetingNotFoundException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private long greetingId;
	
	public GreetingNotFoundException(long id) { 
		this.greetingId = id; 
	}
	public long getgreetingId() { 
		return greetingId; }
}


