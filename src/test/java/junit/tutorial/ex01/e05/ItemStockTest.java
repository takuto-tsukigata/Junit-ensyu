package junit.tutorial.ex01.e05;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.Test;

class ItemStockTest {
	private Map<String, Integer> itemMap = new HashMap<>();
	Integer num = itemMap.get(item.getName());

	@Test
	public void test() {
		ItemStock itemStock = new ItemStock();
//		初期状態で、getNumで0が取得できる
		itemStock.getNum(null);
	}

}
