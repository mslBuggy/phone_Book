package com.acn.book.phone;

public class Person {
	private String name;
	private String address;
	private String phoneNumber;
	
	public Person(String name, String address, String phoneNumber) {
		super();
		this.name = name;
		this.address = address;
		this.phoneNumber = phoneNumber;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder("Name: ");
		sb.append(name);
		sb.append("\nAddress: ");
		sb.append(address);
		sb.append("\nPhone no.: ");
		sb.append(phoneNumber);
		return sb.toString();
	}
}
