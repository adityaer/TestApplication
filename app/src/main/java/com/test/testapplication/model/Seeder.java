package com.test.testapplication.model;

import java.util.ArrayList;

public class Seeder {

	public Seeder(){
		seed();
	}

	static public ArrayList<Contact> arrayContacts = new ArrayList<Contact>();

	public ArrayList<Contact> getContacts(){
		return arrayContacts;
	}

	public void seed(){
		Contact a = new Contact();
		a.setName("Contact 1");
		a.setEmail("contact1@gmail.com");
		a.setPhone("11111");

		Contact b = new Contact();
		b.setName("Contact 2");
		b.setEmail("contact2@gmail.com");
		b.setPhone("22222");

		Contact c = new Contact();
		c.setName("Contact 3");
		c.setEmail("contact3@gmail.com");
		c.setPhone("33333");

		Contact d = new Contact();
		d.setName("Contact 4");
		d.setEmail("contact4@gmail.com");
		d.setPhone("44444");

		Contact e = new Contact();
		e.setName("Contact 5");
		e.setEmail("contact5@gmail.com");
		e.setPhone("55555");

		Contact f = new Contact();
		f.setName("Contact 6");
		f.setEmail("contact6@gmail.com");
		f.setPhone("66666");

		arrayContacts.add(a);
		arrayContacts.add(b);
		arrayContacts.add(c);
		arrayContacts.add(d);
		arrayContacts.add(e);
		arrayContacts.add(f);
	}
}
