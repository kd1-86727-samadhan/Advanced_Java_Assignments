package com.tester;

import static com.utils.HibernateUtils.getSessionFactory;

import org.hibernate.SessionFactory;

public class TestHibernate {

	public static void main(String[] args) {
		try (SessionFactory sf = getSessionFactory()) {
			System.out.println("Hibernate up n running");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
