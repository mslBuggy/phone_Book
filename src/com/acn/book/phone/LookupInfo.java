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
		
		System.out.println("Was moechtest du machen");
		System.out.println("Gebe 1 ein fuer Suche nach Name");
		System.out.println("Gebe 2 ein fuer Suche nach Nummer");
		System.out.println("Gebe 3 ein add Entry");
		System.out.println("Gebe 4 ein delete Entry");
		System.out.println("Gebe 5 ein fuer Exit");
		
		String sIn = in.readLine();
		
		while (true) {
			
			if(sIn.equals("1")) {//nach Name suchen
				
			}
			else if(sIn.equals("2")) { // nach Nummer suchen
				
			}
			else if(sIn.equals("3")) { // add Entry
				
			}
			else if(sIn.equals("4")) { // delete Entry
				
			}
			else if(sIn.equals("5")) { // exit
				
			}
			else {
				System.out.println("close");
				break;
			}

		}
		in.close();
		System.out.println("Goodbye");
		System.exit(0);

	}

}
