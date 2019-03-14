package com.acn.book.phone;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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
		PROMPT: while (true) {
			System.out.println(
					"Welcome to the phone book application.\nType a name to search for an entry, or type \"closeapp\" to exit.");
			System.out.print("Name: ");
			String sIn = in.readLine();

			// TODO after input with Enter:

			// TODO if input: "closeapp", end app
			if (sIn.equalsIgnoreCase("closeapp")) {
				break;
			}
			/*
			 * TODO 1. if contact not existent, print error message
			 */
			if (sIn.equals("xyzzy")) {
				System.out.println("A hollow voice says \"PLUGH\".");
				PhoneBook pb = new PhoneBook(pBook);
				while (true) {
					System.out.println("Enter 1 to add an entry, 2 to remove. PLUGH exits.");
					sIn = in.readLine();
					if (sIn.equals("PLUGH")) {
						System.out.println("Normal function restored.");
						continue PROMPT;
					}
					if (sIn.equals("2")) {
						System.out.println("Enter name of the entry to delete");
						sIn = in.readLine();
						pb.deleteEntry(sIn);
						pBook.remove(sIn);
					} else if (sIn.equals("1")) {
						System.out.println("Enter name of new entry");
						sIn = in.readLine();
						if (pBook.containsKey(sIn)) {
							// Key already exists
							System.out.println("Person with this name already exists. New entry cannot be added");
						} else if (sIn.equals("")) {
							System.out.println("Name field cannot be empty.");
						} else {
							Person p = new Person(sIn, null, null);
							System.out.println("Enter address of new entry, or press enter to skip.");
							sIn = in.readLine();
							if (!sIn.equals(""))
								p.setAddress(sIn);
							System.out.println("Enter phone number of new entry, or press enter to skip.");
							sIn = in.readLine();
							if (!sIn.equals(""))
								p.setPhoneNumber(sIn);
							pb.addEntry(p);
							pBook.put(p.getName(), p);
							System.out.println(pBook);
						}
					}
				}
			}
			if (!pBook.containsKey(sIn)) {
				System.out.println("No such person found in phone book.");
			} else {
				/*
				 * TODO 2. search Address: if found, print contact address else
				 * "no address saved for Person"
				 */
//				List<String> addresses = new ArrayList<String>();
//				
//				System.out.println("Seeking address: ");
//				
//				BufferedReader in1 = new BufferedReader(new InputStreamReader(System.in));
//				
//				String searchedAd = in1.readLine();

				System.out.println(pBook.get(sIn).getAddress());
			}

			System.out.println("Hallo " + sIn);
			/*
			 * TODO 3. search phone#: if found, print phone# else, printout
			 * "no phone number saved for Person"
			 */
			System.out.println("Nummer " + sIn);

			// TODO 4. print prompt again, wait for input
		}

		in.close();
		System.out.println("Goodbye.");
		System.exit(0);

	}
}
