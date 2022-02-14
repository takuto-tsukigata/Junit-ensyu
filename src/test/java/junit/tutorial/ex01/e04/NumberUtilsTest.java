package junit.tutorial.ex01.e04;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class NumberUtilsTest {

	@Test
	@DisplayName("10を入力したテスト")
	void test1() {
		NumberUtils numberUtils = new NumberUtils();
		assertTrue(numberUtils.isEven(10), "true");
	}

	@Test
	@DisplayName("7を入力したテスト")
	void test2() {
		NumberUtils numberUtils = new NumberUtils();
		assertFalse(numberUtils.isEven(7), "false");
	}

}