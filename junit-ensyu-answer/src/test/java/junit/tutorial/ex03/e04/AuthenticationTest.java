package junit.tutorial.ex03.e04;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.doReturn;

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
class AuthenticationTest extends Authentication {

	@Mock
	private AccountDao accountDao;
	
	@InjectMocks
	private Authentication authentication = new Authentication();

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
	@DisplayName("AccountDaoがnullを返す場合はauthenticateメソッドもnullを返す")
	void test1() {
		doReturn(null).when(accountDao).findOrNull("user001");
		assertNull(authentication.authenticate("user001", "aaa"));
	}
	
	@Test
	@DisplayName("AccountDaoがaccountを返すが、パスワードが一致しない場合authenticateメソッドはnullを返す")
	void test2() {
		Account account = new Account("user001", "aaa");
		doReturn(account).when(accountDao).findOrNull("user001");
		assertNull(authentication.authenticate("user001", "bbb"));
	}
	
	@Test
	@DisplayName("AccountDaoがaccountを返し、パスワードも一致する場合authenticateメソッドはaccountを返す")
	void test3() {
		Account account = new Account("user001", "bbb");
		doReturn(account).when(accountDao).findOrNull("user001");
		Account dbAccount = authentication.authenticate("user001", "bbb");
		assertEquals(account.getName(), dbAccount.getName());
		assertEquals(account.getPassword(), dbAccount.getPassword());
	}

}
