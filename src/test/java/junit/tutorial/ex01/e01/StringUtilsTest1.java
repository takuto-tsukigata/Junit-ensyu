package junit.tutorial.ex01.e01;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

class StringUtilsTest1 {

	@Test
	public void 呼び出し() {
		StringUtils string = new StringUtils();
		System.out.println(string.toSnakeCase("aaa"));
		System.out.println(string.toSnakeCase("HelloWorld"));
		System.out.println(string.toSnakeCase("practiceJunit"));
	}

}
