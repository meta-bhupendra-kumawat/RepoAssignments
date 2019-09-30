package com.metacube.SpringMVCParkingSystem.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.metacube.SpringMVCParkingSystem.model.Pass;

public class PriceMapper implements RowMapper<Pass> {

	@Override
	public Pass mapRow(ResultSet rs, int rowNum) throws SQLException {
		Pass pass = new Pass();
//		pass.setId(rs.getInt("id"));
		pass.setType(rs.getString("type"));
		pass.setDaily(rs.getDouble("daily"));
		pass.setMonthly(rs.getDouble("monthly"));
		pass.setYearly(rs.getDouble("yearly"));
		return pass;
	}

}
