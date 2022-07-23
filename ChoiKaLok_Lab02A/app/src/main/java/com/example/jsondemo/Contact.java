package com.example.jsondemo;

import java.io.Serializable;

public class Contact implements Serializable {
	public String id;
	public String name;
	public String email;
	public String address;
	public String gender;
	public String phoneMobile;
	public String phoneHome;
	public String phoneOffice;
	
	public Contact() {
	}
	
	public String toDetailString() {
		return "id=" + id + "\nname=" + name + "\nemail=" + email
				+ "\naddress=" + address + "\ngender=" + gender
				+ "\nphoneMobile=" + phoneMobile + "\nphoneHome=" + phoneHome
				+ "\nphoneOffice=" + phoneOffice;
	}
	public String toString(){
		return this.name;
	}
}
