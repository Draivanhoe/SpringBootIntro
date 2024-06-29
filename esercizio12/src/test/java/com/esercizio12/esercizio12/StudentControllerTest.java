package com.esercizio12.esercizio12;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@ActiveProfiles(value = "test")
@AutoConfigureMockMvc
class StudentControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@Autowired
	private ObjectMapper objectMapper;

	@LocalServerPort
	private int port;

	@Autowired
	private StudentController studentController;

	@Test
	@Order(1)
	void studentControllerLoads() {
		assert studentController != null;
	}

	@Test
	@Order(2)
	public void createStudent() throws Exception {
		Student student = new Student();
		student.setId(1L);
		student.setName("Ivan");
		student.setSurname("Frangipani");
		student.setWorking(false);

		String studentJson = objectMapper.writeValueAsString(student);

		this.mockMvc.perform(post("/students")
						.contentType(MediaType.APPLICATION_JSON)
						.content(studentJson)).andDo(print())
				.andExpect(status().isOk());
	}

	@Test
	@Order(3)
	public void getAll() throws Exception {
		MvcResult result = this.mockMvc.perform(get("/students"))
				.andDo(print())
				.andExpect(status().isOk())
				.andReturn();
		List<Student> studentsResponse = objectMapper.readValue(result.getResponse().getContentAsString(), List.class);
		assert (!studentsResponse.isEmpty());
	}

	@Test
	@Order(4)
	public void getById() throws Exception {
		MvcResult result = this.mockMvc.perform(get("/students/" + 1))
				.andDo(print())
				.andExpect(status().isOk())
				.andReturn();
		Student studentFound = objectMapper.readValue(result.getResponse().getContentAsString(), Student.class);
		assert studentFound != null;
		assert studentFound.getName().equals("Ivan");
		assert studentFound.getSurname().equals("Frangipani");
		assert studentFound.getWorking() == false;
	}

	@Test
	@Order(5)
	public void update() throws Exception {
		Long studentId = 1L;
		String nuovoNome = "Giovanni";
		String nuovoCognome = "Bianchi";

		Student updatedStudent = new Student();
		updatedStudent.setName(nuovoNome);
		updatedStudent.setSurname(nuovoCognome);
		String studentJson = objectMapper.writeValueAsString(updatedStudent);

		this.mockMvc.perform(put("/students/update/" + studentId)
						.contentType(MediaType.APPLICATION_JSON)
						.content(studentJson))
				.andDo(print())
				.andExpect(status().isOk())
				.andReturn();

		MvcResult response = this.mockMvc.perform(get("/students/" + studentId))
				.andDo(print())
				.andExpect(status().isOk())
				.andReturn();
		updatedStudent = objectMapper.readValue(response.getResponse().getContentAsString(), Student.class);

		assert updatedStudent.getName().equals(nuovoNome);
		assert updatedStudent.getSurname().equals(nuovoCognome);
	}

	@Test
	@Order(6)
	public void updateWorkingStatus() throws Exception {
		Long studentId = 1L;
		boolean newWorkingStatus = true;

		this.mockMvc.perform(patch("/students/" + studentId)
						.param("working", String.valueOf(newWorkingStatus)))
				.andDo(print())
				.andExpect(status().isOk())
				.andReturn();

		MvcResult response = this.mockMvc.perform(get("/students/" + studentId))
				.andDo(print())
				.andExpect(status().isOk())
				.andReturn();
		Student updatedStudent = objectMapper.readValue(response.getResponse().getContentAsString(), Student.class);

		assert updatedStudent.getWorking() == newWorkingStatus;
	}

	@Test
	@Order(7)
	public void deleteById() throws Exception {
		Long studentId = 1L;

		this.mockMvc.perform(delete("/students/" + studentId))
				.andDo(print())
				.andExpect(status().isOk());
	}

}