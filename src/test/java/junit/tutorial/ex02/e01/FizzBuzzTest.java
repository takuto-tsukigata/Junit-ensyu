package junit.tutorial.ex02.e01;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;

class FizzBuzzTest extends FizzBuzz {

	@Test
	void testAssert() {
		FizzBuzz fizzBuzz = new FizzBuzz();
		List<String> result1 = fizzBuzz.createFizzBuzzList(16);
		assertEquals("[1,2,Fizz,4,Buzz,Fizz,7,8,Fizz,Buzz,11,Fizz,13,14,FizzBuzz,16]", result1,
				"fizzBuzz.createFizzBuzzListの引数が16の場合");

	}

}
