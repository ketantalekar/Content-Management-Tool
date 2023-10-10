package com.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.model.User;
import com.util.MyHibernate;

public class UserDao {
	private SessionFactory sf = MyHibernate.mySessionFactory();
	
	public int insertUser(User u) {
		int check = 0;
		Session session = sf.getCurrentSession();
		Transaction tx = session.beginTransaction();
		check = (int) session.save(u);
		tx.commit();
		session.close();
		return check;
	}
}
