package com.fizzbuzz.controller;

import static org.junit.Assert.assertEquals;

import java.io.IOException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fizzbuzz.model.FizzBuzz;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT) 
public class FizzbuzzControllerTest {

	@LocalServerPort
    private int port;
 
    @Autowired
    private TestRestTemplate restTemplate;
    
    @Autowired
    private ObjectMapper objectMapper;
 
    @Test
    public void testFizzbuzzSize() throws JsonParseException, JsonMappingException, IOException {
    	ResponseEntity<String> responseEntity =  this.restTemplate.getForEntity("http://localhost:" + port + "/fizzbuzz/"+100, String.class);
    	assertEquals(200, responseEntity.getStatusCodeValue());
    	final FizzBuzz fizzBuzzList = objectMapper.readValue(responseEntity.getBody(), FizzBuzz.class);
    	assertEquals(14, fizzBuzzList.getBuzz().size());
    	assertEquals(27, fizzBuzzList.getFizz().size());
    	assertEquals(6, fizzBuzzList.getFizzBuzz().size());
    	assertEquals(100, fizzBuzzList.getFizzBuzzNumberSeries().size());
    	assertEquals("Fizz", fizzBuzzList.getFizzBuzzNumberSeries().get(26));
    	assertEquals("Buzz", fizzBuzzList.getFizzBuzzNumberSeries().get(54));
    	assertEquals("FizzBuzz", fizzBuzzList.getFizzBuzzNumberSeries().get(44));
    }
    
    @Test
    public void testWhenUpperLimitIsInvalid() throws Exception {
    	ResponseEntity<String> responseEntity =  this.restTemplate.getForEntity("http://localhost:" + port + "/fizzbuzz/"+-1, String.class);
    	assertEquals(500, responseEntity.getStatusCodeValue());
    }
}
