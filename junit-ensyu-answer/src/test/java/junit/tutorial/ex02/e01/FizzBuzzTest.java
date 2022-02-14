package junit.tutorial.ex02.e01;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


class FizzBuzzTest {
	
	FizzBuzz fizzBuzz;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
		fizzBuzz = new FizzBuzz();
	}

	@AfterEach
	void tearDown() throws Exception {
	}


	@Test
	@DisplayName("16までチェック")
	void test() {
		List<String> expected = Arrays.asList("1", "2", "Fizz", "4", "Buzz", "Fizz", "7", "8", "Fizz", "Buzz", "11",
				"Fizz", "13", "14", "FizzBuzz", "16");
		List<String> actual = fizzBuzz.createFizzBuzzList(16);
		assertAll("createFizzBuzz",
				() -> assertEquals(expected, actual),
				() -> assertIterableEquals(expected, actual)
			);
	}

}
