package com.tester;

import static com.utils.HibernateUtils.getSessionFactory;

import java.util.Scanner;

import org.hibernate.SessionFactory;

import com.dao.PlayerDao;
import com.dao.PlayerDaoImp;

public class RemovePlayerFromTeam {

	public static void main(String[] args) {
		try (SessionFactory sf = getSessionFactory();
				Scanner sc = new Scanner(System.in)) {
			PlayerDao playerDao = new PlayerDaoImp();
			System.out.println("Enter the team id: ");
			Long teamId = sc.nextLong();

			System.out.println("Enter the player id: ");
			Long playerId = sc.nextLong();
			
			System.out.println(playerDao.removePlayer(teamId, playerId));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
