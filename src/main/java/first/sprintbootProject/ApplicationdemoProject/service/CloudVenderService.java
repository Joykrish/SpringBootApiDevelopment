package first.sprintbootProject.ApplicationdemoProject.service;

import java.util.List;

import first.sprintbootProject.ApplicationdemoProject.Model.CloudVender;

public interface CloudVenderService {
	
	public String createCloudVender(CloudVender cloudVender);
	public String updateCloudVender(CloudVender cloudVender);
	public String deleteCloudVender(String cloudVenderID);
	public CloudVender getCloudVender(String cloudVenderID);
	public List<CloudVender> getByVendorName(String couldVenderName);
	public List<CloudVender> getAllCloudVender();

}
