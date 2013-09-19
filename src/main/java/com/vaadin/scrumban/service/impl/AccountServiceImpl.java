package com.vaadin.scrumban.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.vaadin.scrumban.dao.AccountDao;
import com.vaadin.scrumban.model.Account;
import com.vaadin.scrumban.service.AccountService;

@Service( "accountService" )
public class AccountServiceImpl implements AccountService{
	@Autowired
	private AccountDao accountDao;

	@Transactional
	public List<Account> getAllAccouts() {
		// TODO Auto-generated method stub
		return accountDao.getAllAccouts();
	}

}
