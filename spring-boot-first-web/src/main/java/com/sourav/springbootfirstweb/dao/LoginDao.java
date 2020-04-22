package com.sourav.springbootfirstweb.dao;

import java.util.List;

import com.sourav.springbootfirstweb.model.LoginModel;

public interface LoginDao {
	public int insert(LoginModel model);

	public List<LoginModel> showAll();

	public boolean validate(LoginModel model);
}
