import java.util.List;

/**
 * Created by andrzej on 24.08.17.
 */
public class Main {

	public static void main(String[] args) throws Exception {

	FileParser file = new FileParser();
		PersonService personService = new PersonService();
		List<Person> stringFromFile = file.getArrayListFromString("/home/andrzej/dev/recruitmenttest2/src/main/resources/address-book.csv");

		System.out.println("How many females are in the file?");
		System.out.println("Answer is " + personService.getAllFemales(stringFromFile).size());

		System.out.println("Who is the oldest person in the file?");
		System.out.println("Answer is " + personService.getOldestPerson(stringFromFile).toString());

		System.out.println("What is the age difference in days between Jon and Paul?");
		System.out.println("Answer is " + personService.getDifferenceInDaysOfAgeBetweenJonAndPaul(stringFromFile) + " days");
		

	}
}
