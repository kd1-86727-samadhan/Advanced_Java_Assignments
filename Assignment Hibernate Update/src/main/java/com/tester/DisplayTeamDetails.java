package com.tester;

import static com.utils.HibernateUtils.getSessionFactory;
import org.hibernate.SessionFactory;

import com.dao.TeamDao;
import com.dao.TeamDaoImpl;

public class DisplayTeamDetails {
	public static void main(String[] args) {
		try (SessionFactory sf = getSessionFactory()){
			TeamDao teamDao = new TeamDaoImpl();
			
			teamDao.getAllTeam().forEach(System.out::println);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
