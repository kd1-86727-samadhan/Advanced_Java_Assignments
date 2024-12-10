package com.tester;

import java.util.Scanner;

import org.hibernate.SessionFactory;

import com.dao.TeamDao;
import com.dao.TeamDaoImpl;
import com.utils.HibernateUtils;

public class DisplayOwnerNameAndAbbrivation {

	public static void main(String[] args) {

		try(SessionFactory sf= HibernateUtils.getSessionFactory();
				Scanner sc = new Scanner(System.in)) {
			TeamDao teamDao = new TeamDaoImpl();
			
			System.out.println("Enter the maximum age: ");
			int age = sc.nextInt();
			
			System.out.println("Enter the batting average: ");
			double avg = sc.nextDouble();
			
			teamDao.displayOwnNameAndAbbreviation(age, avg)
			.forEach(t->System.out.println(t.getOwner() + "\t" + t.getAbbreviation()));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
