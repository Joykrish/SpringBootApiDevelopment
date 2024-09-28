package first.sprintbootProject.ApplicationdemoProject.Service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doAnswer;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Optional;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Answers;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import first.sprintbootProject.ApplicationdemoProject.Model.CloudVender;
import first.sprintbootProject.ApplicationdemoProject.Repository.CloudVenderRepository;
import first.sprintbootProject.ApplicationdemoProject.service.CloudVenderService;
import first.sprintbootProject.ApplicationdemoProject.service.CloudVenderserviceImplement.CVServiceImplement;

public class CloudVenderServiceImplementationTest {

	@Mock
	private CloudVenderRepository cloudVenderRepository;
	private CloudVenderService cloudVenderService;
	AutoCloseable autoCloseable;
	CloudVender cloudVender;

	
	@BeforeEach
	void setUp() {
		autoCloseable = MockitoAnnotations.openMocks(this);
		cloudVenderService = new CVServiceImplement(cloudVenderRepository);
		cloudVender = new CloudVender("C2", "Govardhan", "Goloka", 2343);
	}

	@AfterEach
	void tearUp() throws Exception {
		autoCloseable.close();
	}

	@Test()
	void testCreateCloudVender() {
		mock(CloudVender.class);
		mock(CloudVenderRepository.class);

		when(cloudVenderRepository.save(cloudVender)).thenReturn(cloudVender);
		assertThat(cloudVenderService.createCloudVender(cloudVender)).isEqualTo("Successs!!Data saves successfully");

	}

	

	@Test
	void testUpdateCloudVender() {
		mock(CloudVender.class);
		mock(CloudVenderRepository.class);

		when(cloudVenderRepository.save(cloudVender)).thenReturn(cloudVender);
		assertThat(cloudVenderService.updateCloudVender(cloudVender)).isEqualTo("Success!!Updated Successfully");

	}

	@Test
	void testGetCloudVenderById() {
		mock(CloudVender.class);
		mock(CloudVenderRepository.class);
		System.out.println(cloudVenderRepository.findById("1").toString());
		when(cloudVenderRepository.findById("1")).thenReturn(Optional.ofNullable(cloudVender));
		assertThat(cloudVenderService.getCloudVender("1").getVenderName()).isEqualTo(cloudVender.getVenderName());
	}

	@Test
	void testGetByVenderName() {
		mock(CloudVender.class);
		mock(CloudVenderRepository.class);
		when(cloudVenderRepository.findByVenderName("Govardhan"))
				.thenReturn(new ArrayList<CloudVender>(Collections.singleton(cloudVender)));
		assertThat(cloudVenderService.getByVendorName("Govardhan").get(0).getVenderId())
				.isEqualTo(cloudVender.getVenderId());

	}

	@Test
	void testGetAllCloudVender() {
		mock(CloudVender.class);
		mock(CloudVenderRepository.class);
		when(cloudVenderRepository.findAll())
				.thenReturn(new ArrayList<CloudVender>(Collections.singleton(cloudVender)));
		assertThat(cloudVenderService.getAllCloudVender().get(0).getVenderPhoneNumber())
				.isEqualTo(cloudVender.getVenderPhoneNumber());
	}

	@Test
	void testDeleteCloudVender() {
		mock(CloudVender.class);
		mock(CloudVenderRepository.class, Mockito.CALLS_REAL_METHODS);
		doAnswer(Answers.CALLS_REAL_METHODS).when(cloudVenderRepository).deleteById(any());
		assertThat(cloudVenderService.deleteCloudVender("C1")).isEqualTo("Success!!Deleted Successfully");
	}

}
