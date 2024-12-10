package com.tester;

import java.time.LocalDate;
import java.util.Scanner;

import org.hibernate.SessionFactory;

import com.dao.PlayerDao;
import com.dao.PlayerDaoImp;
import com.entities.Players;
import com.utils.HibernateUtils;

public class AddNewPlayer {

	public static void main(String[] args) {
		try (SessionFactory sf = HibernateUtils.getSessionFactory(); Scanner sc = new Scanner(System.in)) {

			PlayerDao playerDao = new PlayerDaoImp();

			System.out.println("Enter the team id: ");
			Long teamId = sc.nextLong();

			System.out.println("Enter the first name of player: ");
			String fName = sc.next();

			System.out.println("Enter the last name of player: ");
			String lName = sc.next();

			System.out.println("Enter the date of the birth: ");
			LocalDate ldt = LocalDate.parse(sc.next());

			System.out.println("Enter the batting average: ");
			double bAvg = sc.nextDouble();

			System.out.println("Enter the wicket: ");
			int wkt = sc.nextInt();

			Players player = new Players(fName, lName, ldt, bAvg, wkt);

			System.out.println(playerDao.addNewPlayer(teamId, player));

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
