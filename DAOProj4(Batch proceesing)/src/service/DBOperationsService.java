package service;

import java.util.ArrayList;
import java.util.List;

import bo.EmpBO;
import dao.DBOperationsDAO;
import dto.EmpDTO;

public class DBOperationsService {
	DBOperationsDAO dao;

	public void setDao(DBOperationsDAO dao) {
		this.dao = dao;
	}
	public String registerEmp(List<EmpDTO> listdto)
	{
		List<EmpBO> listbo=new ArrayList<EmpBO>();
	//convert dto to bo
		for (EmpDTO dto : listdto) {
			EmpBO bo = new EmpBO();
			bo.setId(dto.getId());
			bo.setName(dto.getName());
			bo.setDesg(dto.getDesg());
			bo.setSalary(dto.getSalary());
			listbo.add(bo);
		}
		int[] result=dao.insertEmpDetails(listbo);
		if(result!=null)
		{
			return "Employees are registered";
		}
		else
		{
			return "Employees not are registered";
		}
	}
}