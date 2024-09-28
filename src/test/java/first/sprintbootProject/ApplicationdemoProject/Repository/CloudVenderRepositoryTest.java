package first.sprintbootProject.ApplicationdemoProject.Repository;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Configuration;

import first.sprintbootProject.ApplicationdemoProject.Model.CloudVender;
import first.sprintbootProject.ApplicationdemoProject.Repository.CloudVenderRepository;

@DataJpaTest

public class CloudVenderRepositoryTest {

	@Autowired
	private CloudVenderRepository cloudVenderRepository;
	CloudVender cloudVender;

	@BeforeEach
	void setUp() {
		cloudVender = new CloudVender("C1", "Krishna", "Gokula", 108);
		cloudVenderRepository.save(cloudVender);

	}
	// success scenario
	@Test
	void testFindByVendorName_Found() {
		List<CloudVender> cloudVenderList = cloudVenderRepository.findByVenderName("Krishna");
		System.out.println("Retrieved Cloud vender is:"+cloudVenderList);
		assertThat(cloudVenderList.get(0).getVenderId().equals(cloudVender.getVenderId()));
		assertThat(cloudVenderList.get(0).getVenderName().equals(cloudVender.getVenderName()));
	}

	// failure scenario
	@Test
	void testFindByVendorName_notFound() {
		List<CloudVender> cloudVenderList = cloudVenderRepository.findByVenderName("Govinda");
		System.out.println("Retrieved Cloud vender is:"+cloudVenderList);
		assertThat(cloudVenderList.isEmpty()).isTrue();
		
	}
	
	@AfterEach
	void tearDown() {
		cloudVender = null;
		cloudVenderRepository.deleteAll();
	}

}
