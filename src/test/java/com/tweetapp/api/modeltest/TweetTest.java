package com.tweetapp.api.modeltest;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import com.tweetapp.api.model.Tweet;

@ExtendWith(MockitoExtension.class)
public class TweetTest {

	@InjectMocks
	Tweet tweet;
	
	Tweet tweet1 = new Tweet("630c8d9537c0db3115f0f815","Welcome to India..!!",2, null, null, "FirstTweet");
	
	@Test
	public void getIdTest() {
		String expected = "630c8d9537c0db3115f0f815";
		String actual = tweet1.getId();
		assertEquals(expected, actual);
	}
	
	@Test
	public void getTweetNameTest() {
		String expected = "Welcome to India..!!";
		String actual = tweet1.getTweetName();
		assertEquals(expected, actual);
	}
	
	@Test
	public void getLikesTest() {
		long expected = 2;
		long actual = tweet1.getLikes();
		assertEquals(expected, actual);
	}
	
	@Test
	public void getTweetTagTest() {
		String expected = "FirstTweet";
		String actual = tweet1.getTweetTag();
		assertEquals(expected, actual);
	}	
	
}
