package com.tester;

import java.util.Scanner;

import org.hibernate.SessionFactory;

import com.dao.TeamDao;
import com.dao.TeamDaoImpl;
import com.utils.HibernateUtils;

public class DeleteTeamById {
	public static void main(String[] args) {
		try (SessionFactory sf = HibernateUtils.getSessionFactory();
				Scanner sc = new Scanner(System.in)){
			
			TeamDao teamDao = new TeamDaoImpl();
			System.out.println("Enter the id you want to delete: ");
			long id = sc.nextLong();
			
			System.out.println(teamDao.deleteById(id));
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
