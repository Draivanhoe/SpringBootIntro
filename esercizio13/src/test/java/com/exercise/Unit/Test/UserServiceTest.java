package com.exercise.Unit.Test;

import com.exercise.Unit.Test.dtos.UserDTO;
import com.exercise.Unit.Test.entities.UserEntity;
import com.exercise.Unit.Test.mapper.UserMapper;
import com.exercise.Unit.Test.repositories.UserRepository;
import com.exercise.Unit.Test.services.UserService;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringBootTest
public class UserServiceTest {

    @Autowired
    private UserService userService;

    @MockBean
    private UserRepository userRepository;

    @Mock
    private UserMapper userMapper;

    private Long testId = 1L;
    private String testName = "Ivan";
    private String testSurname = "Frangipani";

    @Test
    public void testCreateUser() {
        UserDTO userDTO = new UserDTO();
        userDTO.setId(this.testId);
        userDTO.setFirstName(this.testName);
        userDTO.setLastname(this.testSurname);

        UserEntity user = new UserEntity();
        user.setId(this.testId);
        user.setFirstName(this.testName);
        user.setLastname(this.testSurname);

        UserEntity userSaved = new UserEntity();
        userSaved.setId(this.testId);
        userSaved.setFirstName(this.testName);
        userSaved.setLastname(this.testSurname);

        when(userMapper.asEntity(userDTO)).thenReturn(user);
        when(userRepository.saveAndFlush(any(UserEntity.class))).thenReturn(userSaved);
        when(userMapper.asDTO(userSaved)).thenReturn(userDTO);

        UserDTO newUser = userService.createUser(userDTO);
        assertEquals(testName, newUser.getFirstName());
        assertEquals(testSurname, newUser.getLastname());
    }

    @Test
    public void testGetUserById() {
        UserEntity user = new UserEntity();
        user.setId(this.testId);
        user.setFirstName(this.testName);
        user.setLastname(this.testSurname);

        when(userRepository.findById(this.testId)).thenReturn(Optional.of(user));

        UserDTO userFound = userService.getUserById(this.testId);
        assertEquals(this.testId, userFound.getId());
        assertEquals(this.testName, userFound.getFirstName());
        assertEquals(this.testSurname, userFound.getLastname());
    }

    @Test
    public void testUpdateUser() {
        UserEntity user = new UserEntity();
        user.setId(this.testId);
        user.setFirstName(this.testName);
        user.setLastname(this.testSurname);

        UserDTO userDTO = new UserDTO();
        userDTO.setId(this.testId);
        userDTO.setFirstName(this.testName);
        userDTO.setLastname(this.testSurname);

        when(userRepository.findById(this.testId)).thenReturn(Optional.of(user));
        when(userRepository.saveAndFlush(any(UserEntity.class))).thenReturn(user);

        UserDTO userUpdated = userService.updateUser(this.testId, userDTO);
        assertEquals(this.testId, userUpdated.getId());
        assertEquals(this.testName, userUpdated.getFirstName());
        assertEquals(this.testSurname, userUpdated.getLastname());
    }
}
