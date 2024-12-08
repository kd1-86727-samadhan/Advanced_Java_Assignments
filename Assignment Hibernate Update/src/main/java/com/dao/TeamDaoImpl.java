package com.dao;

import static com.utils.HibernateUtils.getSessionFactory;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.entities.Team;

public class TeamDaoImpl implements TeamDao {

	public String insertTeam(Team team) {

		String msg = "Insertion failed";
		// System.out.println(team);

		Session session = getSessionFactory().getCurrentSession();

		Transaction tx = session.beginTransaction();

		try {
			Serializable teamId = session.save(team);
			tx.commit();
			msg = "Inserted successfully ! ID" + teamId;
		} catch (RuntimeException e) {
			if (tx != null) {
				tx.rollback();
			}
			throw e;
		}
		return msg;
	}

	@Override
	public List<Team> getAllTeam() {
		List<Team> teams = null;

		String jpql = "select t from Team t";

		Session session = getSessionFactory().getCurrentSession();

		Transaction tx = session.beginTransaction();

		try {
			teams = session.createQuery(jpql, Team.class).getResultList();
			tx.commit();
		} catch (Exception e) {
			if (tx != null)
				tx.rollback();

			throw e;
		}
		return teams;
	}

	@Override
	public List<Team> displayAgeAndBattingAvg(int age, double avg) {

		List<Team> teams;
		String jpql = "select t from Team t where t.maxPlayerAge<:age and battingAverage>:average";

		Session session = getSessionFactory().getCurrentSession();

		Transaction tx = session.beginTransaction();

		try {
			teams = session.createQuery(jpql, Team.class).setParameter("age", age).setParameter("average", avg)
					.getResultList();
			tx.commit();
		} catch (Exception e) {
			if (tx != null)
				tx.rollback();

			throw e;
		}

		return teams;
	}

	@Override
	public List<Team> displayOwnNameAndAbbreviation(int age, double avg) {
		List<Team> teams = null;

		String jpql = "select new com.entities.Team(owner, abbreviation) from Team t where t.maxPlayerAge <:age and t.battingAverage >:average";

		Session session = getSessionFactory().getCurrentSession();

		Transaction tx = session.beginTransaction();
		try {
			teams = session.createQuery(jpql, Team.class).setParameter("age", age).setParameter("average", avg)
					.getResultList();
			tx.commit();
		} catch (RuntimeException e) {
			if (tx != null)
				tx.rollback();

			throw e;
		}
		return teams;
	}

	@Override
	public String updateAge(String name, int age) {
		Team teams = null;
		String msg = "Age updation failed";

		String jpql = "select t from Team t where t.name=:nm";

		Session session = getSessionFactory().getCurrentSession();
		Transaction tx = session.beginTransaction();

		try {
			teams = session.createQuery(jpql, Team.class).setParameter("nm", name).getSingleResult();

			teams.setMaxPlayerAge(age);
			msg = "Age changed !!!!";
			tx.commit();
		} catch (RuntimeException e) {
			if (tx != null)
				tx.rollback();
		}
		return msg;
	}

	@Override
	public String deleteById(Long teamId) {
		String msg = "Deletion Failed";

		Team teams = null;

		Session session = getSessionFactory().getCurrentSession();

		Transaction tx = session.beginTransaction();

		try {

			teams = session.get(Team.class, teamId);
			if (teams != null) {
				session.delete(teams);
				msg = "Deleted successfully";
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
