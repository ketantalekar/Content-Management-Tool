package com.dao;

import java.util.*;

import org.hibernate.*;
import org.hibernate.query.Query;

import com.model.Content;
import com.model.User;
import com.util.MyHibernate;

public class ContentDao {
	private SessionFactory sf = MyHibernate.mySessionFactory();

	List<Content> contents = null;
	Query<Content> query = null;
	Session session = null;
	Transaction tx = null;

	public int insertContent(Content c) {
		session = sf.getCurrentSession();
		tx = session.beginTransaction();
		int check = 0;
		try {
			check = (int) session.save(c);
			tx.commit();
			session.close();

		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return check;
	}

//	public void deleteContent(int id, Content c) {
//		int check = 0;
//		Session session = sf.getCurrentSession();
//    	Query query = session.createQuery("FROM Content WHERE cid:= id");
//		Transaction tx = session.beginTransaction();
//		check = session.save(c);
//	}

	public List<Content> displayAll(){
		session = sf.getCurrentSession();
		tx = session.beginTransaction();

		try {
			String hql = "FROM Content";
			// Create the query
			query = session.createQuery(hql, Content.class);
			contents = query.getResultList();
			System.out.println(contents);
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}
		
		return contents;
	}
}
