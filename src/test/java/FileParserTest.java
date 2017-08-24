import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;
import java.util.logging.FileHandler;

import static org.junit.Assert.*;

/**
 * Created by andrzej on 24.08.17.
 */
public class FileParserTest {


	private FileParser fileParser;

	@Before
	public void setUp() {
		fileParser = new FileParser();
	}

	@Test(expected = NoSuchElementException.class)
	public void shouldReturnMessageIfFileIsEmpty() throws Exception {
		String requestAsJson = fileParser.readAsString("src/test/test-scenarios/address-book-null.csv");
		Assert.assertNull(requestAsJson);

	}

	@Test(expected = RuntimeException.class)
	public void shouldReturnErrorWhenFieldIsMissing() throws Exception {

		String requestAsJson = fileParser.readAsString("src/test/test-scenarios/address-book-field-nulls.csv");

		List<Person> personList = mapStringToPersonObject(requestAsJson);

		for (Person person : personList) {
			if(person.getDateOfBirth().isEmpty())

		}


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