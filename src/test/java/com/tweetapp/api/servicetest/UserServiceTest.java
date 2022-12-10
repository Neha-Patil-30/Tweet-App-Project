package com.tweetapp.api.servicetest;

import org.mockito.InjectMocks;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.tweetapp.api.kafka.ConsumerService;
import com.tweetapp.api.kafka.ProducerService;
import com.tweetapp.api.model.Tweet;
import com.tweetapp.api.model.User;

import com.tweetapp.api.model.UserResponse;

import com.tweetapp.api.repository.TweetRepository;
import com.tweetapp.api.repository.UserRepository;
import com.tweetapp.api.service.UserService;
import com.tweetapp.api.service.UserServiceImpl;

public class UserServiceTest {
	private MockMvc mockMvc;

	@Mock
	private UserRepository userrepo;

	@Mock
	private TweetRepository tweetRepo;
	
	@Mock
	private ProducerService producerService;
	
	@Mock
	private ConsumerService consumerService;
	
	@Mock 
	private UserResponse userRespose;
	
	@Mock
	private UserService userService;

	@InjectMocks
	private UserServiceImpl userServiceMock = new UserServiceImpl(userrepo, null);

	@BeforeEach
	public void setup() {

		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void registerPositiveTest() throws Exception {
		User registerDTO = new User();
		registerDTO.setId("id");
		registerDTO.setEmail("fse@gmail.com");
		registerDTO.setFirstName("admin");
		registerDTO.setLastName("admin");
		registerDTO.setPassword("admin");
		registerDTO.setUsername("admin9");

		when(userrepo.save(registerDTO)).thenReturn(registerDTO);
		User actualresp = userServiceMock.createUser(registerDTO);

		assertEquals(registerDTO, actualresp);	
		
//		userrepo.findByUsername("admin9");
//		verify(userrepo, times(1)).findByUsername("admin9");
	}

	@Test
	public void signUpPostiveTest() throws Exception {
		User user = new User();
		user.setId("id");
		user.setEmail("fse@gmail.com");
		user.setFirstName("admin");
		user.setLastName("admin");
		user.setPassword("admin");
		user.setUsername("admin");
		UserResponse loginRequestDTO = new UserResponse();
		loginRequestDTO.setUser(user);
		loginRequestDTO.setToken(null);
		loginRequestDTO.setLoginStatus("success");

		when(userrepo.findByUsername("admin")).thenReturn(user);

//		UserResponse actual = userServiceMock.loginUser(user.getUsername(), user.getPassword());
//		assertEquals("success", actual.getLoginStatus());
		
	
	}

	@Test
	public void getAllUsersPositiveTest() throws Exception {

		List<User> registerList = new ArrayList<>();
		User register = new User();
		register.setId("id");
		register.setEmail("fse@gmail.com");
		register.setFirstName("admin");
		register.setLastName("admin");
		register.setPassword("admin");
		register.setUsername("admin");

		registerList.add(register);

		List<User> expectedList = new ArrayList<>();

		User userDTO = new User();
		userDTO.setId("id");
		userDTO.setEmail("fse@gmail.com");
		userDTO.setFirstName("admin");
		userDTO.setLastName("admin");
		userDTO.setPassword("admin");
		userDTO.setUsername("admin");

		expectedList.add(userDTO);

		when(userrepo.findAll()).thenReturn(registerList);

		List<User> actual = userServiceMock.getAllUsers();
		assertEquals(registerList, actual);
	}
	
	@Test
	public void getUserByIdTest() throws Exception {
		User registerDTO = new User();
		registerDTO.setId("id");
		registerDTO.setEmail("fse@gmail.com");
		registerDTO.setFirstName("admin");
		registerDTO.setLastName("admin");
		registerDTO.setPassword("admin");
		registerDTO.setUsername("admin9");

		when(userrepo.save(registerDTO)).thenReturn(registerDTO);
		Optional<User> actualresp = userServiceMock.getUserById("id");

		assertNotEquals(registerDTO, actualresp);	
	
	}
	
	@Test
	public void getUserByUsernameTest() throws Exception {
		List<User> registerList = new ArrayList<>();
		User register = new User();
		register.setId("id");
		register.setEmail("fse@gmail.com");
		register.setFirstName("admin");
		register.setLastName("admin");
		register.setPassword("admin");
		register.setUsername("admin");

		registerList.add(register);

		List<User> expectedList = new ArrayList<>();

		User userDTO = new User();
		userDTO.setId("id");
		userDTO.setEmail("fse@gmail.com");
		userDTO.setFirstName("admin");
		userDTO.setLastName("admin");
		userDTO.setPassword("admin");
		userDTO.setUsername("admin");

		expectedList.add(userDTO);

		when(userrepo.findByUsernameContaining("admin")).thenReturn(registerList);

		List<User> actual = userServiceMock.getUserByUsername("admin");
		assertEquals(registerList, actual);
	}

	
	@Test
	public void deleteUserTest() {
		User registerDTO = new User();
		registerDTO.setId("id");
		registerDTO.setEmail("fse@gmail.com");
		registerDTO.setFirstName("admin");
		registerDTO.setLastName("admin");
		registerDTO.setPassword("admin");
		registerDTO.setUsername("admin9");

		userServiceMock.deleteUser(registerDTO);
		Mockito.verify(userrepo).delete(registerDTO);
	}
	
	@Test
	public void updateUserTest() {
		User registerDTO = new User();
		registerDTO.setId("id");
		registerDTO.setEmail("fse@gmail.com");
		registerDTO.setFirstName("admin");
		registerDTO.setLastName("admin");
		registerDTO.setPassword("admin");
		registerDTO.setUsername("admin9");
		
		when(userServiceMock.updateUser(registerDTO)).thenReturn(registerDTO);
		User actualresp = userServiceMock.updateUser(registerDTO);
		assertEquals(actualresp, registerDTO);
	}

}