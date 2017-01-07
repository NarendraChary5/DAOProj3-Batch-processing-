package test;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import dto.EmpDTO;
import service.DBOperationsService;

public class ClientApp {

	public static void main(String[] args) throws Exception {
		ApplicationContext context=new FileSystemXmlApplicationContext("src/cfg/applicationContext.xml");
		DBOperationsService service=context.getBean("empService",DBOperationsService.class);
		EmpDTO dto = new EmpDTO(5,"abc","test5",10000);
		EmpDTO dto1 = new EmpDTO(6,"mnp","test6",10001);
		EmpDTO dto2 = new EmpDTO(7,"xyz","test7",10002);
		List<EmpDTO> listdto=new ArrayList<EmpDTO>();
		listdto.add(dto);
		listdto.add(dto1);
		listdto.add(dto2);
		String result=service.registerEmp(listdto);
		System.out.println("result : "+result);
	}
}