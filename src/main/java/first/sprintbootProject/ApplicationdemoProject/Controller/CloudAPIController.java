package first.sprintbootProject.ApplicationdemoProject.Controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import first.sprintbootProject.ApplicationdemoProject.Model.CloudVender;
import first.sprintbootProject.ApplicationdemoProject.response.ResponseHandler;
import first.sprintbootProject.ApplicationdemoProject.service.CloudVenderService;

@RestController
@RequestMapping("/cloudVender")

public class CloudAPIController {

	CloudVenderService cloudVenderService;

	CloudAPIController(CloudVenderService cloudVenderService) {
		this.cloudVenderService = cloudVenderService;

	}

	@GetMapping("{venderId}")
	public ResponseEntity<Object> getCloudVenderDetails(@PathVariable("venderId") String venderId) {

		return ResponseHandler.responseBuilder("Requested Vender Details are give here!!", HttpStatus.OK, cloudVenderService.getCloudVender(venderId));
		

		// return new CloudVender("C1","Vender1","Address One",2343);
	}

	// Read all cloud vender
	@GetMapping()
	public List<CloudVender> getALLCloudVenderDetails() {

		return cloudVenderService.getAllCloudVender();

	}

	@PostMapping
	public String createCloudVenderDetails(@RequestBody CloudVender cloudVender) {
		return cloudVenderService.createCloudVender(cloudVender);
		//return "Cloud vender created successfully";

	}

	@PutMapping
	public String updateCloudVenderDetails(@RequestBody CloudVender cloudVender) {
		cloudVenderService.updateCloudVender(cloudVender);
		return "Cloud vender updated successfully";

	}

	@DeleteMapping("{venderId}")
	public String deleteCloudVender(@PathVariable("venderId") String venderID) {
		cloudVenderService.deleteCloudVender(venderID);
		return "Cloud vender deleted successfully";

	}

}
