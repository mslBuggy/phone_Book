package com.acn.book.phone;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class LookupInfo {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		// TODO initialize map
		Map<String, Person> pBook = new HashMap<>();
		String name1 = "Manuel", name2 = "Thuong", name3 = "Ali";
		pBook.put(name1, new Person(name1, "Adickesallee 65, Frankfurt", "0172-45533877"));
		pBook.put(name2, new Person(name2, null, "0176-2134799"));
		pBook.put(name3, new Person(name3, "Adickesallee 43, Frankfurt", null));
		// TODO start app in console with "Name:" prompt, wait for input
		while (true) {

			System.out.print("Name: ");
			String sIn = in.readLine();

			// TODO after input with Enter:
			
			// TODO if input: "closeapp", end app
			if (sIn.equalsIgnoreCase("closeapp")){
				break;
			}
			/* TODO
			 * 1. if contact not existent, print error message
			 */
			if (!pBook.containsKey(sIn)) {
				System.out.println("No such person found in phone book.");
			} else {
				/* TODO
				 * 2. search Address:
				 * if found, print contact address
				 * else "no address saved for Person"
				 */
				
				
				System.out.println("Hallo " + sIn);
				/* TODO
				 * 3. search phone#: if found, print phone#
				 * else, printout "no phone number saved for Person"
				 */
				System.out.println("Nummer " + sIn);

			// TODO 4. print prompt again, wait for input
			}

		}
		in.close();
		System.out.println("Goodbye");
		System.exit(0);

	}

}
