package junit.tutorial.ex01.e03;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

class CounterTest {

	@Test
	public void test() {
		Counter counter = new Counter();

//		初期状態で、incrementメソッドを実行すると1が取得できる
//		System.out.println(counter.increment());

//		incrementメソッドを1回実行した状態で、incrementメソッドを実行すると2が取得できる
//		System.out.println(counter.increment());		

//		50回目の実行時に51が取得できる
		for (int i = 0; i <= 50; i++) {
			System.out.println(counter.increment());
		}

	}

}
