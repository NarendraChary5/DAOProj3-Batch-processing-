package dao;

import java.util.List;

import bo.EmpBO;

public interface DBOperations {
	public int[] insertEmpDetails(List<EmpBO> listbo);
}