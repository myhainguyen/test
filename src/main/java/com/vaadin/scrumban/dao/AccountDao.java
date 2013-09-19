package com.vaadin.scrumban.dao;

import java.util.List;

import com.vaadin.scrumban.model.Account;

public interface AccountDao {
	public List<Account> getAllAccouts();
	public int insertAccount(Account acc);
}
