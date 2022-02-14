package junit.tutorial.ex01.e01;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class StringUtilsTest {

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	@DisplayName("「aaa」を入力すると「aaa」が取得できる")
	void test1() {
		assertEquals("aaa", StringUtils.toSnakeCase("aaa"));
	}

	@Test
	@DisplayName("「HelloWorld」を入力すると「hello_world」が取得できる")
	void test2() {
		assertEquals("hello_world", StringUtils.toSnakeCase("HelloWorld"));
	}

	@Test
	@DisplayName("「practiceJunit」を入力すると「practice_junit」が取得できる")
	void test3() {
		assertEquals("practice_junit", StringUtils.toSnakeCase("practiceJunit"));
	}
	
}
