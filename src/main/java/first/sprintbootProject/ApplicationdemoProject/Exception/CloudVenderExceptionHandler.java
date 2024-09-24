package first.sprintbootProject.ApplicationdemoProject.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
@ControllerAdvice
public class CloudVenderExceptionHandler {
	@ExceptionHandler(value = { CloudVenderNotFoundException.class })
	public ResponseEntity<Object> handleCloudVendorNotFoundException(
			CloudVenderNotFoundException cloudVenderNotFoundExcep) {
		System.out.println("Into the response entity");
		CloudVenderException cloudVenderException = new CloudVenderException(cloudVenderNotFoundExcep.getMessage(),
				cloudVenderNotFoundExcep.getCause(), HttpStatus.NOT_FOUND);
		
		return new ResponseEntity<>(cloudVenderException, HttpStatus.NOT_FOUND);

	}

}
