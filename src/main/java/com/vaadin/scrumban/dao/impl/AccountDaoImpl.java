package com.vaadin.scrumban.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.vaadin.scrumban.dao.AccountDao;
import com.vaadin.scrumban.model.Account;

@Repository("accountDao")
public class AccountDaoImpl implements AccountDao {
	@Autowired
	private SessionFactory sessionFactory;
	
	private Session getSession() {
		Session session;
		try {
			session = sessionFactory.getCurrentSession();

		} catch (Exception e) {
			session = sessionFactory.openSession();
		}
	
	return session;
	}
	@SuppressWarnings("unchecked")
	public List<Account> getAllAccouts() {
		// TODO Auto-generated method stub
		return getSession().createQuery("from Account").list();
	}
	public int insertAccount(Account acc) {
		this.getSession().save(acc);		
		return acc.getId();
	}

}
