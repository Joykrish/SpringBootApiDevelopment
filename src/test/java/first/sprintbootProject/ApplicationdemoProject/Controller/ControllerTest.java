package first.sprintbootProject.ApplicationdemoProject.Controller;

import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Disabled;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;

import first.sprintbootProject.ApplicationdemoProject.Model.CloudVender;
import first.sprintbootProject.ApplicationdemoProject.service.CloudVenderService;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(CloudAPIController.class)
public class ControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private CloudVenderService cloudVenderService;

	CloudVender cloudVender1;
	CloudVender cloudVender2;

	List<CloudVender> cloudVenderList = new ArrayList<>();

	@BeforeEach
	void setUp() {
		cloudVender1 = new CloudVender("C1", "Ram", "Ayodya", 108);
		cloudVender2 = new CloudVender("C2", "Krishna", "Vrindavana", 216);
		cloudVenderList.add(cloudVender1);
		cloudVenderList.add(cloudVender2);

	}

	@AfterEach
	void tearUp() throws Exception {

	}

	@Test
	public void TestgetCloudVenderDetails() throws Exception {
		when(cloudVenderService.getCloudVender("C5")).thenReturn(cloudVender1);

		this.mockMvc.perform(get("/cloudVender/C5")).andDo(print()).andExpect(status().isOk());

	}
	@Disabled("This test is ignored for now")
	@Test
	public void testGetALLCloudVenderDetails() throws Exception {
		when(cloudVenderService.getAllCloudVender()).thenReturn(cloudVenderList);

		this.mockMvc.perform(get("/cloudVender")).andDo(print()).andExpect(status().isOk());
	}
	@Disabled("This test is ignored for now")
	@Test
	public void testDeleteCloudVender() throws Exception {
		when(cloudVenderService.deleteCloudVender("C1")).thenReturn("Cloud vender deleted successfully");
		this.mockMvc.perform(delete("/cloudVender/C1")).andDo(print()).andExpect(status().isOk());
	}
	@Disabled("This test is ignored for now")
	@Test
	public void testCreateCloudVenderDetails() throws Exception {
		ObjectMapper mapper = new ObjectMapper();
		mapper.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
		ObjectWriter ow = mapper.writer().withDefaultPrettyPrinter();
		String requestJson = ow.writeValueAsString(cloudVender1);

		when(cloudVenderService.createCloudVender(cloudVender1)).thenReturn("Successs!!Data saves successfully");
		this.mockMvc.perform(post("/cloudVender").contentType(MediaType.APPLICATION_JSON).content(requestJson))
				.andDo(print()).andExpect(status().isOk());

	}
	@Disabled("This test is ignored for now")
	@Test
	public void updateCloudVenderDetails() throws Exception {
		ObjectMapper mapper = new ObjectMapper();
		mapper.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
		ObjectWriter ow = mapper.writer().withDefaultPrettyPrinter();
		String requestJson = ow.writeValueAsString(cloudVender1);

		when(cloudVenderService.updateCloudVender(cloudVender1)).thenReturn("Cloud vender updated");
		this.mockMvc.perform(put("/cloudVender").contentType(MediaType.APPLICATION_JSON).content(requestJson))
				.andDo(print()).andExpect(status().isOk());

	}
}
