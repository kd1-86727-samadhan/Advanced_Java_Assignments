package com.tester;

import java.util.List;
import java.util.Scanner;

import org.hibernate.SessionFactory;

import com.dao.TeamDao;
import com.dao.TeamDaoImpl;
import com.entities.Team;
import com.utils.HibernateUtils;

public class DisplayAgeAndBatAvg {

	public static void main(String[] args) {

		try (SessionFactory sf = HibernateUtils.getSessionFactory(); Scanner sc = new Scanner(System.in)) {
			TeamDao teamDao = new TeamDaoImpl();

			System.out.println("Enter the maximum age: ");
			int age = sc.nextInt();

			System.out.println("Enter the batting average: ");
			double avg = sc.nextDouble();

			List<Team> teams = teamDao.displayAgeAndBattingAvg(age, avg);

			for (Team team : teams) {
				System.out.println(team);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
