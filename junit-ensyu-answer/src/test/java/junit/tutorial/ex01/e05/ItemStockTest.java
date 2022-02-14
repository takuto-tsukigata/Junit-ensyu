package junit.tutorial.ex01.e05;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class ItemStockTest {

	@Nested
	@DisplayName("初期状態の場合")
	class test1 {
		ItemStock sut;
		Item book;
		
//		@BeforeAll
//		static void setUpBeforeClass() throws Exception {
//		}
//	
//		@AfterAll
//		static void tearDownAfterClass() throws Exception {
//		}

		@BeforeEach
		void setUp() throws Exception {
			book = new Item("book", 3800);
			sut = new ItemStock();
		}

		@AfterEach
		void tearDown() throws Exception {
		}

		@Test
		@DisplayName("初期状態でgetNum(book)で0")
		void test1_1() {
			assertEquals(0, sut.getNum(book));
		}
		
		@Test
		@DisplayName("add(book)後getNum(book)で1")
		void test1_2() {
			sut.add(book);
			assertEquals(1, sut.getNum(book));
		}
	}
	
	@Nested
	@DisplayName("bookが1回追加されている場合")
	class test2 {
		ItemStock sut;
		Item book;
		@BeforeEach
		void setUp() throws Exception {
			book = new Item("book", 3800);
			sut = new ItemStock();
			sut.add(book);
		}
		
		@Test
		@DisplayName("getNum(book)で1を返す")
		void test2_1() {
			assertEquals(1, sut.getNum(book));
		}
		
		@Test
		@DisplayName("add(book)後getNum(book)で2")
		void test2_2() {
			sut.add(book);
			assertEquals(2, sut.getNum(book));
		}
		
		@Test
		@DisplayName("add(bike)後getNum(bike)で1,getNum(book)も1")
		void test2_3() {
			Item bike = new Item("bike", 100000);
			sut.add(bike);
			assertEquals(1, sut.getNum(bike));
			assertEquals(1, sut.getNum(book));
		}
		
		
	}
	
}