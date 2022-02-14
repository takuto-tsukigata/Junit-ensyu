package junit.tutorial.ex03.e02;

//import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.doThrow;

import java.io.IOException;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class) 
class LogAnalyzerTest {

	@Mock
	private LogLoader mockedLogLoader;
	
	@InjectMocks
	private LogAnalyzer logAnalyzer = new LogAnalyzer();
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
		// こちらでインスタンスを生成するとテスト失敗する
//		logAnalyzer = new LogAnalyzer();
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	@DisplayName("例外ハンドリング")
	void test() throws Exception {
//		when(mockedLogLoader.load("test")).thenThrow(new IOException("error by stub"));
		doThrow(new IOException("error by stub")).when(mockedLogLoader).load("test");
		AnalyzeException e = assertThrows(AnalyzeException.class,
				() -> logAnalyzer.analyze("test"));

		Throwable throwable = e.getCause();
		assertTrue(throwable instanceof IOException);
		assertEquals("error by stub", throwable.getMessage());
		
	}

}
