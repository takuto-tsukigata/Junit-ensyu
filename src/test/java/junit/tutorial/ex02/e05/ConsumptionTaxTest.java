package junit.tutorial.ex02.e05;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class ConsumptionTaxTest {

	ConsumptionTax sut;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@Nested
	@DisplayName("消費税5%の場合")
	class 消費税5 {
		@BeforeEach
		void setUp() throws Exception {
			sut = new ConsumptionTax(5);
		}

		@AfterEach
		void tearDown() throws Exception {
		}

		@ParameterizedTest
		@CsvSource({ "100, 105", "3000, 3150", "50, 52" })
		void test1(int input, int expected) {
			assertEquals(expected, sut.apply(input));
		}

	}

	@Nested
	@DisplayName("消費税10%の場合")
	class 消費税10 {
		@BeforeEach
		void setUp() throws Exception {
			sut = new ConsumptionTax(10);
		}

		@AfterEach
		void tearDown() throws Exception {
		}

		@ParameterizedTest
		@CsvSource({ "50, 55" })
		void test1(int input, int expected) {
			assertEquals(expected, sut.apply(input));
		}

	}

	@Nested
	@DisplayName("消費税3%の場合")
	class 消費税3 {
		@BeforeEach
		void setUp() throws Exception {
			sut = new ConsumptionTax(3);
		}

		@AfterEach
		void tearDown() throws Exception {
		}

		@ParameterizedTest
		@CsvSource({ "50, 51" })
		void test1(int input, int expected) {
			assertEquals(expected, sut.apply(input));
		}

	}

}
