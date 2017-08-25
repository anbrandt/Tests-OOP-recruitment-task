import java.util.List;

/**
 * Created by andrzej on 24.08.17.
 */
public class Main {

	public static void main(String[] args) throws Exception {

	FileParser file = new FileParser();
		List<Person> stringFromFile = file.getArrayListFromString("/home/andrzej/dev/recruitmenttest2/src/main/resources/address-book.csv");
		stringFromFile.forEach(per -> System.out.println(per.toString()));



		PersonService personService = new PersonService();

		List<Person> allFemales = personService.getAllFemales(stringFromFile);
		List<Person> personList = personService.sortByAge(stringFromFile);
		personList.forEach(p -> System.out.println(p.getDateOfBirth()));

		Person oldestPerson = personService.getOldestPerson(stringFromFile);
		System.out.println(oldestPerson.toString());

		long differenceInDaysOfAgeBetweenJonAndPaul = personService.getDifferenceInDaysOfAgeBetweenJonAndPaul(stringFromFile);
		System.out.println(differenceInDaysOfAgeBetweenJonAndPaul);

	}
}
