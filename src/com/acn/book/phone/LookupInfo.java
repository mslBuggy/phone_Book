
package com.acn.book.phone;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class LookupInfo {

	private String addressFromName(String input, Map<String, Person> personMap) {
		if (personMap.get(input).getAddress() == null)
			return "No address found for this person";
		return "Address: " + personMap.get(input).getAddress();
	}

	private String phoneFromName(String input, Map<String, Person> personMap) {
		Person p = personMap.get(input);
		if (p.getPhoneNumber() == null) {
			return "No phone number found for this person";
		}
		return "Phone: " + p.getPhoneNumber();
	}

	private Map<String, Person> interact(Map<String, Person> personMap, BufferedReader br, boolean xyzzy) throws IOException {
		System.out.println("Interactive mode enabled.");
		PhoneBook pb = new PhoneBook(personMap);
		String exit; // differs depending on whether the mode was entered normally or via cheat code
		while (true) {
			if (xyzzy) {
				System.out.println("Enter 1 to add an entry, 2 to remove. PLUGH exits.");
				exit = "PLUGH";
			} else {
				System.out.println("Enter 1 to add an entry, 2 to remove.\nEnter 9 to return to the standard name search.");
				exit = "9";
			}
			String sIn = br.readLine();
			if (sIn.equals(exit)) {
				System.out.println("Quick name search mode restored.");
				break; // back to businessLogic method
			}
			if (sIn.equals("2")) {
				System.out.println("Enter name of the entry to delete");
				sIn = br.readLine();
				pb.deleteEntry(sIn);
				personMap.remove(sIn);
			} else if (sIn.equals("1")) {
				// add new entry
				System.out.println("Enter name of new entry");
				sIn = br.readLine();
				if (personMap.containsKey(sIn)) {
					// Key already exists
					System.out.println("Person with this name already exists. New entry cannot be added");
				} else if (sIn.equals("")) {
					System.out.println("Name field cannot be empty.");
				} else {
					Person p = new Person(sIn, null, null);
					System.out.println("Enter address of new entry, or press enter to skip.");
					sIn = br.readLine();
					if (!sIn.equals("")) { // empty input results in no modification
						p.setAddress(sIn);
					}
					System.out.println("Enter phone number of new entry, or press enter to skip.");
					sIn = br.readLine();
					if (!sIn.equals("")) { // empty input results in no modification
						p.setPhoneNumber(sIn);
					}
					pb.addEntry(p);
					personMap.put(p.getName(), p);
//					System.out.println(personMap);
				}
			}
		}
		return personMap;

	}

	private void businessLogic(Map<String, Person> book) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		// TODO start app in console with "Name:" prompt, wait for input
		PROMPT: while (true) {
			System.out.println("\nWelcome to the phone book application.\n"
					+ "Type a name to search for an entry, or type \"closeapp\" to exit.\n"
					+ "Or type \"interact\" to open interactive mode for adding or removing entries.");
			System.out.print("Name: ");
			String sIn = in.readLine();

			// TODO after input with Enter:

			// DONE if input: "closeapp", end app
			if (sIn.equalsIgnoreCase("closeapp")) {
				break;
			}
			
			if (sIn.equals("xyzzy")) { // cheat code entered
				System.out.println("A hollow voice says \"PLUGH\".");
				book = interact(book, in, true);
				continue PROMPT;
			}else if (sIn.equals("interact")) { // interactive mode entered normally
				book = interact(book, in, false);
				continue PROMPT;
			}
			/*
			 * DONE 1. if contact not existent, print error message
			 */
			if (!book.containsKey(sIn)) {
				System.out.println("No such person found in phone book.");
			} else {
				/*
				 * DONE 2. search Address: if found, print contact address else
				 * "no address saved for Person"
				 */
				System.out.println(addressFromName(sIn, book));
				/*
				 * DONE 3. search phone#: if found, print phone# else, printout
				 * "no phone number saved for Person"
				 */
				System.out.println(phoneFromName(sIn, book));
			}
			// DONE 4. print prompt again, wait for input
		}
		in.close();
	}

	public static void main(String[] args) throws IOException {
		// initialize map
		Map<String, Person> pBook = new HashMap<>();
		// fill with values
		String name1 = "Manuel", name2 = "Thuong", name3 = "Ali";
		pBook.put(name1, new Person(name1, "Adickesallee 65, Frankfurt", "0172-45533877"));
		pBook.put(name2, new Person(name2, null, "0176-2134799"));
		pBook.put(name3, new Person(name3, "Adickesallee 43, Frankfurt", null));
		LookupInfo li = new LookupInfo();
		li.businessLogic(pBook);
		// end program
		System.out.println("Goodbye.");
		System.exit(0);
	}
}