package dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;

import bo.EmpBO;

public class DBOperationsDAO implements DBOperations {
	public static final String INSERT_EMP_DETAILS="INSERT INTO EMP(ID,NAME,DESG,SALARY) VALUES(?,?,?,?)";
	JdbcTemplate jt;
	public void setJt(JdbcTemplate jt) {
		this.jt = jt;
	}

	@Override
	public int[] insertEmpDetails(List<EmpBO> listbo) {
		int[] result=jt.batchUpdate(INSERT_EMP_DETAILS,new BatchPreparedStatementSetter() {
			
			List<EmpBO> listbo;
			
			@Override
			public void setValues(PreparedStatement ps, int index) throws SQLException {
				ps.setInt(1, listbo.get(index).getId());
				ps.setString(2, listbo.get(index).getName());
				ps.setString(3, listbo.get(index).getDesg());
				ps.setInt(4, listbo.get(4).getSalary());				
			}
			
			@Override
			public int getBatchSize() {
				return listbo.size();
			}
		});
		return result;
	}
}