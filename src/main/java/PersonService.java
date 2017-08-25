import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * Created by andrzej on 24.08.17.
 */
public class PersonService {

	private final String FEMALE = "female";
	private final String MALE = "male";


	public List<Person> getAllFemales(List<Person> allPerson) {
		List<Person> allFemales = new ArrayList<>();
		for (Person person : allPerson) {
			if (person.getGender().equalsIgnoreCase(FEMALE)) {
				allFemales.add(person);
			}
		}
		return allFemales;
	}

	public List<Person> getAllMales(List<Person> allPerson) {
		List<Person> allMales = new ArrayList<>();
		for (Person person : allPerson) {
			if (person.getGender().equalsIgnoreCase(MALE)) {
				allMales.add(person);
			}
		}
		return allMales;
	}

	public List<Person> sortByAge(List<Person> allPerson) {
		allPerson.sort(Comparator.comparing(Person::getDateOfBirth));

		return allPerson;
	}


	public Person getOldestPerson(List<Person> allPerson) {
		allPerson.sort(Comparator.comparing(Person::getDateOfBirth));

		return allPerson.get(0);
	}

	public long getDifferenceInDaysOfAgeBetweenJonAndPaul(List<Person> allPerson) {
		Person jon = null;
		Person paul = null;

		for (Person person : allPerson) {
			if (person.getName().equalsIgnoreCase("jon")) {
				jon = new Person(person.getName(), person.getGender(), person.getDateOfBirth());
			} else if (person.getName().equalsIgnoreCase("paul")) {
				paul = new Person(person.getName(), person.getGender(), person.getDateOfBirth());
			}
		}

		//Math.abs
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		LocalDate parseJon = LocalDate.parse(jon.getDateOfBirth(), formatter);
		LocalDate parsePaul = LocalDate.parse(paul.getDateOfBirth(), formatter);
		return ChronoUnit.DAYS.between(parseJon, parsePaul);

	}


}
