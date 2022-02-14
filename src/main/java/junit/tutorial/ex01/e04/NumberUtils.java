package junit.tutorial.ex01.e04;

import org.springframework.stereotype.Service;

@Service
public class NumberUtils {
	
	public static boolean isEven(int num) {
		return (num % 2 == 0);
	}

}
