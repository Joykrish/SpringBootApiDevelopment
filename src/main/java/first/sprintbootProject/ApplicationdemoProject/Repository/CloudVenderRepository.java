package first.sprintbootProject.ApplicationdemoProject.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import first.sprintbootProject.ApplicationdemoProject.Model.CloudVender;

public interface CloudVenderRepository extends JpaRepository<CloudVender,String>{
	
	public List<CloudVender> findByVenderName(String vendorName);

	
	
	
	

}
