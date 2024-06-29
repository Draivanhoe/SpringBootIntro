package com.esercizio12.esercizio12;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest
@ActiveProfiles(value = "test")
class StudentServiceTest {

	private Long id = 1L;
	private String name = "Ivan";
	private String surname = "Frangipani";
	private boolean workingStatus = false;

	@Autowired
	private StudentService studentService;

	@Autowired
	private StudentRepository studentRepository;

	@Test
	void loads() {
		assert studentService != null;
	}

	@Test
	public void updateWorkingStatus() {
		Student student = new Student();
		student.setId(id);
		student.setName(name);
		student.setSurname(surname);
		student.setWorking(workingStatus);

		studentService.create(student);
		studentService.updateWorkingStatus(student.getId(), !student.getWorking());

		assert studentRepository.findById(id).get().getWorking() == !workingStatus;
	}

}