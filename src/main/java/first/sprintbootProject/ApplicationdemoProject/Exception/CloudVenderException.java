package first.sprintbootProject.ApplicationdemoProject.Exception;

import org.springframework.http.HttpStatus;

public class CloudVenderException {
	

	private final String message;
	private final Throwable throwable;
	private final HttpStatus httpStatus;
	
	public CloudVenderException(String message, Throwable throwable, HttpStatus httpStatus) {
		this.message = message;
		this.throwable = throwable;
		this.httpStatus = httpStatus;
	}
	
	public String getMessage() {
		return message;
	}

	public Throwable getThrowable() {
		return throwable;
	}

	public HttpStatus getHttpStatus() {
		return httpStatus;
	}

}
