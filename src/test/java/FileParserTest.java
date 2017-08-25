import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.*;

/**
 * Created by andrzej on 24.08.17.
 */
public class FileParserTest {


	private FileParser fileParser;

	@Before
	public void setUp() {
		fileParser = new FileParser();
	}


	@Test
	public void shouldReturnTheSameObject() throws Exception {
		Person person = new Person("Jon", "male", "1985-03-09");

//		String stringFromFile = fileParser.getStringFromFile("src/test/test-scenarios/address-book-null.csv");

//		fileParser.getArrayListFromString();
	}

	@Test(expected = NoSuchElementException.class)
	public void shouldReturnMessageIfFileIsEmpty() throws Exception {
//		String requestAsJson = fileParser.getStringFromFile("src/test/test-scenarios/address-book-null.csv");
//		Assert.assertNull(requestAsJson);

	}

	@Test(expected = RuntimeException.class)
	public void shouldReturnErrorWhenFieldIsMissing() throws Exception {

//		String requestAsJson = fileParser.getStringFromFile("src/test/test-scenarios/address-book.csv");

//		List<Person> personList = fileParser.mapStringsFromFileToObjects(requestAsJson);
//		personList.forEach(p -> System.out.println(p.toString()));

	}

	public List<Person> mapStringToPersonObject(String requestAsJson) {
		String[] split = requestAsJson.split("\n");
		List<Person> personList = new ArrayList<Person>();

		Person person;

		for (String s : split) {
			person = new Person();
			String[] split1 = s.split(", ");
			person.setName(split1[0]);
			person.setGender(split1[1]);
			person.setDateOfBirth(split1[2]);
			personList.add(person);

		}

		return personList;

	}
}