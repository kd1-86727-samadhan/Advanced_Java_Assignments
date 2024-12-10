package com.dao;

import static com.utils.HibernateUtils.getSessionFactory;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.entities.Players;
import com.entities.Team;

public class PlayerDaoImp implements PlayerDao {

	@Override
	public String addNewPlayer(Long teamId, Players player) {
		String msg = "Adding player failed !!!!";

		Session session = getSessionFactory().getCurrentSession();

		Transaction tx = session.beginTransaction();

		try {
			Team team = session.get(Team.class, teamId);
			if (team != null) {
				team.addPlayer(player);
				session.persist(player);
			}
			tx.commit();
			msg = "Added new player with id = " + player.getId();
		} catch (RuntimeException e) {
			if (tx != null)
				tx.rollback();

			throw e;
		}

		return msg;
	}

	@Override
	public String removePlayer(Long teamId, Long playerId) {
		String msg = "Removing player failed";

		Session session = getSessionFactory().getCurrentSession();

		Transaction tx = session.beginTransaction();

		try {
			Team team = session.get(Team.class, teamId);
			Players player = session.get(Players.class, playerId);

			if (team != null && player != null) {
				team.removePlayer(player);
				msg = "Player deleted";
			}
			tx.commit();
		} catch (Exception e) {
			if (tx != null)
				tx.rollback();

			throw e;
		}
		return msg;
	}
}
