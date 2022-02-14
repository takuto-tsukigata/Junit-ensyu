package junit.tutorial.ex01.e04;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

class NumberUtilsTest {

	@Autowired
	private NumberUtils numberUtils;

	@Test
	public void test() {
//		trueのケース
		assertTrue(numberUtils.isEven(10), "true");
//		falseのケース
		assertFalse(numberUtils.isEven(7), "false");
	}

}