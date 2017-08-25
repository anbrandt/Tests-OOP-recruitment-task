import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by andrzej on 25.08.17.
 */
public class PersonServiceTest {

	private FileParser fileParser;
	private PersonService personService;

	@Before
	public void setUp() {
		fileParser = new FileParser();
		personService = new PersonService();
	}

	@Test
	public void getAllFemalesShouldReturnfemale() throws Exception {
		List<Person> stringFromFile = fileParser.getArrayListFromString("src/test/test-scenarios/address-book.csv");

		List<Person> allFemales = personService.getAllFemales(stringFromFile);

		for (Person allFemale : allFemales) {
			assertTrue(allFemale.getGender().equalsIgnoreCase("female"));
		}

	}

	@Test
	public void getAllMaleShouldReturnMale() throws Exception {

		List<Person> stringFromFile = fileParser.getArrayListFromString("src/test/test-scenarios/address-book.csv");

		List<Person> allMales = personService.getAllMales(stringFromFile);

		for (Person male : allMales) {
			assertTrue(male.getGender().equalsIgnoreCase("male"));

		}
	}

	@Test
	public void shouldReturnOldestPerson() throws Exception {
		List<Person> stringFromFile = fileParser.getArrayListFromString("src/test/test-scenarios/address-book.csv");

		List<Person> sorted = personService.sortByAge(stringFromFile);


		List<Person> personList = personService.sortByAge(initiateSampleTestList());

		personList.forEach(p -> System.out.println(p.toString()));



	}



	public List<Person> initiateSampleTestList() {
		List<Person> startingList = new ArrayList<>();

		Person personTest1 = new Person("Tom", "male", "1971-02-21");
		Person personTest2 = new Person("Jake", "male", "1973-02-20");

		startingList.add(personTest1);
		startingList.add(personTest2);

		return startingList;
	}
}