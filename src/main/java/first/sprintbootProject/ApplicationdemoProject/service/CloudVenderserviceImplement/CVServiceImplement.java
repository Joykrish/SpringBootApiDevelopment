package first.sprintbootProject.ApplicationdemoProject.service.CloudVenderserviceImplement;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import first.sprintbootProject.ApplicationdemoProject.Exception.CloudVenderNotFoundException;
import first.sprintbootProject.ApplicationdemoProject.Model.CloudVender;
import first.sprintbootProject.ApplicationdemoProject.Repository.CloudVenderRepository;
import first.sprintbootProject.ApplicationdemoProject.service.CloudVenderService;

@Service
public class CVServiceImplement implements CloudVenderService{
	
	CloudVenderRepository cloudVenderRepository;
	public CVServiceImplement( CloudVenderRepository cloudVenderRepository){
		this.cloudVenderRepository=cloudVenderRepository;
		
	}
	

	@Override
	public String createCloudVender(CloudVender cloudVender) {
		cloudVenderRepository.save(cloudVender);
		return "Successs!!Data saves successfully";
	}

	@Override
	public String updateCloudVender(CloudVender cloudVender) {
		cloudVenderRepository.save(cloudVender);
		return "Success!!Updated Successfully";
	}

	@Override
	public String deleteCloudVender(String cloudVenderID) {
		cloudVenderRepository.deleteById(cloudVenderID);
		return "Success!!Deleted Successfully";
	
		 
	}

	@Override
	public CloudVender getCloudVender(String cloudVenderID) {
		if(cloudVenderRepository.findById(cloudVenderID).isEmpty())
				throw new CloudVenderNotFoundException("Cloud Vender you are trying is not exist");
		return cloudVenderRepository.findById(cloudVenderID).get();
		}

	@Override
	public List<CloudVender> getAllCloudVender() {
		
		return cloudVenderRepository.findAll();
	}

}
