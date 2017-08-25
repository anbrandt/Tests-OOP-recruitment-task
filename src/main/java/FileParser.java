import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 * Created by andrzej on 24.08.17.
 */
public class FileParser {

	//TODO przekazać ścieżke do pliku w parametrze metody

	public List<Person> getArrayListFromString(String path) throws Exception {

		List<Person> personList = new ArrayList<>();

		try {
			String next = new Scanner(new File(path)).useDelimiter("\\Z").next();

			if (next.isEmpty())
				throw new NoSuchElementException("File is empty!");

			String[] split = next.split("\n");


			Person person;
			for (String s : split) {
				person = new Person();
				String[] split1 = s.split(", ");
				person.setName(split1[0]);
				person.setGender(split1[1]);
				person.setDateOfBirth(split1[2]);
				personList.add(person);

			}


		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		return personList;

	}

	public String getStringFromFile(String path) throws Exception {

		String next = new Scanner(new File(path)).useDelimiter("\\Z").next();

		if (next.isEmpty()) {
			throw new NoSuchElementException("File is empty!");
		} else
			return next;
	}

}
