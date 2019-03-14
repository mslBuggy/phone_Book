package com.acn.book.phone;

import java.util.HashMap;
import java.util.Map;

/**
 * Create a phonebook
 * A phonebook has many entries
 * An entry consists of
 * 		Name
 * 		Address
 * 		Phone no.
 * This phonebook has basic search functions using name as parameter
 * 	Search for address (for Developer 1)
 *  Search for phone number (for dev 2)
 *  Additional functions add-phonebook-entry & delete-phonebook-entry (for dev 3)
 * Combine the implementations in git
 * @author manuel.lara.bisch
 *
 */
public class PhoneBook {
	private Map<String, Person> bookMap;
	public Map<String, Person> getBookMap() {
		return bookMap;
	}
	public void setBookMap(Map<String, Person> bookMap) {
		this.bookMap = bookMap;
	}
	public void addEntry(Person p) {
		bookMap.put(p.getName(), p);
	}
	public void deleteEntry(String name) {
		if(bookMap.containsKey(name)) {
			Person p = bookMap.get(name);
			System.out.println("Deleting " + name + "with address " + p.getAddress() + " and number " + p.getPhoneNumber());
			bookMap.remove(name);
		}else {
			System.out.println("No person named " + name + " in phone book.");
		}
	}
	
}
