package com.tester;
import static com.utils.HibernateUtils.getSessionFactory;

import java.util.Scanner;

import org.hibernate.SessionFactory;

import com.dao.TeamDao;
import com.dao.TeamDaoImpl;
import com.entities.Team;


public class TeamRegistration {
	public static void main(String[] args) {
		try (SessionFactory sf = getSessionFactory(); Scanner sc = new Scanner(System.in)){
			TeamDao teamDao = new TeamDaoImpl();
			System.out.println("Enter the player details: String name + String abbreviation + String owner + int maxPlayerAge + double battingAverage + int wickets ");
			
			Team newPlayer = new Team(sc.next(), sc.next(), sc.next(), sc.nextInt(), sc.nextDouble(), sc.nextInt());
			System.out.println(teamDao.insertTeam(newPlayer));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
