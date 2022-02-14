package junit.tutorial.ex01.e02;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CalculatorTest {

	private static Calculator target;

	@BeforeAll
	public static void getTestClass() {
		target = new Calculator();
	}

	@Test
	@DisplayName("例外処理テスト")
	void test1() {
		Calculator calc = new Calculator();

		Throwable exeption = assertThrows(IllegalArgumentException.class, () -> target.divide(1, 0));

		assertEquals(exeption.getMessage(), "divide by zero.");
	}
}
