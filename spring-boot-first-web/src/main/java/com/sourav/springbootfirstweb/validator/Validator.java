package com.sourav.springbootfirstweb.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Validator {

	 private Pattern pattern;
	    private Matcher matcher;
	 
	    private static final String PASSWORD_PATTERN = "((?=.*[a-z])(?=.*\\d)(?=.*[A-Z])(?=.*[@#$%!]).{10})";
	 
	    
	 
	    public boolean validate(final String password) {
	 
	    	pattern = Pattern.compile(PASSWORD_PATTERN);
	        matcher = pattern.matcher(password);
	        return matcher.matches();
	 
	    }

	}


