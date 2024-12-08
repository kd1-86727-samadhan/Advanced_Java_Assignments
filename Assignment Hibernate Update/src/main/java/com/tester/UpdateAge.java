package com.tester;

import java.util.Scanner;

import org.hibernate.SessionFactory;

import com.dao.TeamDao;
import com.dao.TeamDaoImpl;
import com.utils.HibernateUtils;

public class UpdateAge {
	public static void main(String[] args) {
		try (SessionFactory sf = HibernateUtils.getSessionFactory(); Scanner sc = new Scanner(System.in)) {

			TeamDao teamDao = new TeamDaoImpl();
			System.out.println("Enter the team name: ");
			String teamName = sc.next();

			System.out.println("Enter the new age: ");
			int age = sc.nextInt();

			System.out.println(teamDao.updateAge(teamName, age));

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
