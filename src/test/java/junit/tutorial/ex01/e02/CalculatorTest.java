package junit.tutorial.ex01.e02;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CalculatorTest {

	@Test
	public void test() {
		Calculator calculator = new Calculator();
		calculator.divide(1, 0);

	}

}
