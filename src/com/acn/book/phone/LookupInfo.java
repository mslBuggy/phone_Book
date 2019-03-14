package com.acn.book.phone;

import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

public class LookupInfo {

	public static void main(String[] args) {
		// TODO initialize map
		Map<String, Person> pBook = new HashMap<>();
		String name1 = "Manuel", name2 = "Thuong", name3 = "Ali";
		pBook.put(name1, new Person(name1, "Adickesallee 65, Frankfurt", "0172-45533877"));
		pBook.put(name2, new Person(name2, null, "0176-2134799"));
		pBook.put(name1, new Person(name3, "Adickesallee 43, Frankfurt", null));
		// TODO start app in console with "Name:" prompt, wait for input
		System.out.print("Name: ");
		// TODO after input with Enter:
		/*
		 * 1. if contact not existent, print error message
		 */
		
		/* TODO
		 * 2. search Address:
		 * if found, print contact address
		 * else "no address saved for Person"
		 */
		
		/* TODO
		 * 3. search phone#: if found, print phone#
		 * else, printout "no phone number saved for Person"
		 */
		
		// TODO 4. print prompt again, wit for input
		
		// TODO if input: "closeapp", end app

	}

}
