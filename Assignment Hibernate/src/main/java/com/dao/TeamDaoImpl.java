package com.dao;

import static com.utils.HibernateUtils.getSessionFactory;

import java.io.Serializable;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.entities.Team;

public class TeamDaoImpl implements TeamDao {

	public String insertTeam(Team team) {

		String msg = "Insertion failed";
		//System.out.println(team);

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

}
