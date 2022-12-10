package com.tweetapp.api.modeltest;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.OutputStream;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import com.tweetapp.api.model.User;

@ExtendWith(MockitoExtension.class)
public class userTest {
	
	@InjectMocks
	User user;
	
	User user1 = new User("N101", "Neha08", "Neha08", "Neha@gmail.com", "Neha", "Patil", "9876543212");
	
	@Test
	public void getIdTest() {
		String expected = "N101";
		String actual = user1.getId();
		assertEquals(expected, actual);
	}
	
	@Test
	public void getUsernameTest() {
		String expected = "Neha08";
		String actual = user1.getUsername();
		assertEquals(expected, actual);
	}
	
	@Test
	public void getPasswordTest() {
		String expected = "Neha08";
		String actual = user1.getPassword();
		assertEquals(expected, actual);
	}
	
	@Test
	public void getEmailTest() {
		String expected = "Neha@gmail.com";
		String actual = user1.getEmail();
		assertEquals(expected, actual);
	}
	
	@Test
	public void getFirstNameTest() {
		String expected = "Neha";
		String actual = user1.getFirstName();
		assertEquals(expected, actual);
	}
	
	@Test
	public void getLastNameTest() {
		String expected = "Patil";
		String actual = user1.getLastName();
		assertEquals(expected, actual);
	}
	
	@Test
	public void getContactNumberTest() {
		String expected = "9876543212";
		String actual = user1.getContactNumber();
		assertEquals(expected, actual);
	}
	
}
