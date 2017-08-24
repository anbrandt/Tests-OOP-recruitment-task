import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 * Created by andrzej on 24.08.17.
 */
public class FileParser {



	public List<Person> getStringFromFile() throws Exception {

		String requestAsJson = readAsString("src/main/resources/address-book.csv");


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

	public String readAsString(String path) throws Exception {

		String next = new Scanner(new File(path)).useDelimiter("\\Z").next();

		if(next.isEmpty()) {
			throw new NoSuchElementException("File is empty!");
		} else
			return next;
	}

}
