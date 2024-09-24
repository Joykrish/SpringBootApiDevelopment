package first.sprintbootProject.ApplicationdemoProject.Exception;

public class CloudVenderNotFoundException extends RuntimeException{
	
	
	public CloudVenderNotFoundException(String message) {
		super(message);
		
	}
	
	public CloudVenderNotFoundException(String message,Throwable cause) {
		super(message,cause);
	}
	

}
