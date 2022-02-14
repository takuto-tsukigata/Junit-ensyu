package junit.tutorial.ex03.e03;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.doReturn;

import java.io.ByteArrayInputStream;

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
class NetworkResourcesTest extends NetworkResources {

	@Mock
	private NetworkLoader mockedNetworkLoader;
	
	@InjectMocks
	private NetworkResources networkResources = new NetworkResources();

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
	@DisplayName("ネットワークから取得した文字列を返す")
	void test() throws Exception {
		String expected = "Hello World";
		ByteArrayInputStream input = new ByteArrayInputStream(expected.getBytes());
		doReturn(input).when(mockedNetworkLoader).getInput();
		assertEquals(expected, networkResources.load());
	}
}
