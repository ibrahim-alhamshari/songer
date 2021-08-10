package com.example.songr;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class SongrApplicationTests {

	@Test
	void contextLoads() {
	}

	@Test
	void albumTesting(){
		Album album = new Album("Thriller" , "Michael Jackson", 70 , 200 , "https://image.jpg");
		assertEquals("Michael Jackson",album.getArtist() );
		assertEquals("Thriller" , album.getTitle());
		assertEquals(70 , album.getSongCount());
		assertEquals(200 , album.getLength());
		assertEquals("https://image.jpg" , album.getImageUrl());
	}

	@Test
	void setterTest(){
		Album album = new Album("Thriller" , "Michael Jackson", 42 , 50 , "https://image.jpg");
		assertEquals("Mohammad",album.setArtist("Mohammad") );

	}

}
