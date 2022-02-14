package junit.tutorial.ex01.e05;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ItemStockTest {

	Item item = new Item(null, 0);
	ItemStock stock = new ItemStock();

	@Test
	@DisplayName("初期状態でgetNum()実行")
	void test1() {
		int result1 = stock.getNum(item);
		assertEquals(0, result1, "初期状態でgetNum()");
	}

	@Test
	@DisplayName("初期状態でaddでitem追加後getNum()")
	void test2() {
		stock.add(item);
		int result2 = stock.getNum(item);
		assertEquals(1, result2, "初期状態でaddでitem追加後getNum()");
	}

	@BeforeEach
	@DisplayName("初期状態からitemを1つ追加")
	void instanse() {
		item = new Item("CD", 1000);
		ItemStock stock = new ItemStock();
		stock.add(item);
	}

	@Test
	@DisplayName("itemが1つ追加されている状態で、getNum()")
	void test3() {
		stock.add(item);
		int result3 = stock.getNum(item);
		assertEquals(1, result3, "itemが1つ追加されている状態で、getNum()");
	}

	@Test
	@DisplayName("itemが1つ追加されている状態で、addで同じitemオブジェクトを追加してgetNum()")
	void test4() {
		stock.add(item);
		stock.add(item);
		int result4 = stock.getNum(item);
		assertEquals(2, result4, "itemが1つ追加されている状態で、addで同じitemオブジェクトを追加してgetNum()");
	}

	@Test
	@DisplayName("itemが1っ追加されている状態で、addで異なるitemオブジェクトを追加してgetNum()")
	void test5() {
		Item item2 = new Item("PC", 100000);
		stock.add(item2);
		int result5 = stock.getNum(item2);
		assertEquals(1, result5, "itemが1っ追加されている状態で、addで異なるitemオブジェクトを追加してgetNum()");
	}
}
