package com.sourav.springbootfirstweb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.sourav.springbootfirstweb.dao.LoginDaoImpl;
import com.sourav.springbootfirstweb.model.LoginModel;
import com.sourav.springbootfirstweb.validator.Validator;

@Controller
public class LoginController {

	Validator validator = new Validator();
	LoginDaoImpl logindao = new LoginDaoImpl();

	@RequestMapping(value = "/login", method = RequestMethod.GET)

	public String loginMessage(ModelMap model) {
		// model.put("name", name);
		return "login";
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)

	public String welcomePage(ModelMap model, LoginModel loginModel, @RequestParam String name, @RequestParam String id,
			@RequestParam String password) {
		boolean isValidUser = validator.validate(password);
		boolean isExistingUser = logindao.validate(loginModel);
		if (!isValidUser && !isExistingUser) {
			model.put("errorMessage", "Invalid Credentials");
			return "login";

		} else {
			model.put("name", name);
			model.put("password", password);
			model.put("id", id);
			return "welcome";
		}

	}

}
