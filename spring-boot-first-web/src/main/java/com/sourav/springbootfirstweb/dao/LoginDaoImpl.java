package com.sourav.springbootfirstweb.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.sourav.springbootfirstweb.model.LoginModel;

@Repository
public class LoginDaoImpl implements LoginDao {
	@Autowired(required = true)
	private JdbcTemplate jdbcTemplate;

	@Bean
	public JdbcTemplate jdbcTemplate(DataSource dataSource) {
		return new JdbcTemplate(dataSource);
	}

	public boolean validate(LoginModel model) {
		String sql = "SELECT * FROM user WHERE username = ? and password= ?";

		try {
			@SuppressWarnings("unused")
			LoginModel loginModel = jdbcTemplate.queryForObject(sql, new Object[] { model.getUserName(), model.getPassword() },
					(rs, rowNum) -> new LoginModel(rs.getInt(1), rs.getString(2), rs.getString(3)));
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public int insert(LoginModel model) {

		String sql = "insert into Log values(?,?,?)";
		int r = jdbcTemplate.update(sql, model.getId(), model.getUserName(), model.getPassword());

		return r;

	}

	@Override
	public List<LoginModel> showAll() {
		String query = "select * from Log";
		return jdbcTemplate.query(query,
				(rs, rowNum) -> new LoginModel(rs.getInt(1), rs.getString(2), rs.getString(3)));

	}

}
