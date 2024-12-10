package com.tester;

import static com.utils.HibernateUtils.getSessionFactory;

import java.util.Scanner;

import org.hibernate.SessionFactory;

import com.dao.TeamDao;
import com.dao.TeamDaoImpl;
import com.entities.Team;;

public class DisplayTeamAndPlayerDetails {

	public static void main(String[] args) {
		try (SessionFactory sf = getSessionFactory(); Scanner sc = new Scanner(System.in)) {
			TeamDao teamDao = new TeamDaoImpl();
			System.out.println("Enter the team id: ");
			Long teamId = sc.nextLong();

			Team tm = teamDao.displayTeamAndPlayerDetails(teamId);
			System.out.println(tm);
			System.out.println("Player");
			tm.getPlayer()
			.forEach(System.out::println);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
