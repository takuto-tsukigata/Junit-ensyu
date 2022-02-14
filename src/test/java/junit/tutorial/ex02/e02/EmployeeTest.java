package junit.tutorial.ex02.e02;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.junit.jupiter.api.Test;

class EmployeeTest {

	try{
		
		File file = new File("/src/main/java/junit.tutorial/ex02/e02/Employee.txt");
		FileReader fileReader = new FileReader(file);

		int ch = fileReader.read();
		while (ch != -1) {
			System.out.println((char) ch);
			
			ch = fileReader.read();
		}
	}catch(FileNotFoundException e){
		
		System.out.println(e);
		
	}catch(IOException ex){
		
		System.out.println(ex);
	}

	@Test
	void all(){
		Employee emp = new Employee();
		assertAll("emp", () -> assertEquals("Ichiro", emp.getFirstName(), "FirstName"),
				() -> assertEquals("Tanaka", emp.getLastName(), "LastName"),
				() -> assertEquals("ichiro@example.com", emp.getEmail(), "email"));
	}
}

