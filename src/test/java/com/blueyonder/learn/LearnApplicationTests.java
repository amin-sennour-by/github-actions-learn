package com.blueyonder.learn;

import com.blueyonder.learn.model.Person;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class LearnApplicationTests {

	@Test
	void contextLoads() {
	}

	@Test
	void model_initialization_test(){
		UUID testID = UUID.randomUUID();

		Person p = new Person(testID, "name");

		assertEquals("name", p.getName());
		assertEquals(testID, p.getId());
	}

}
