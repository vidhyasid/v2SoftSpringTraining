package com.v2soft.training.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.v2soft.training.model.*;

public class EmployeeService {
	 private Map<Integer,Employee> employees;

	    public EmployeeService(){
	        try {
				loadEmployees();
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    }

	    public List<Employee> listAllEmployees() {
	        return new ArrayList<>(employees.values());
	    }

	    private void loadEmployees() throws ParseException{
	        employees = new HashMap<>();
         
	        Employee employee1 = new Employee();
	        employee1.setEmployeeId("1");
	        employee1.setFirstName("Sam");
	        employee1.setLastName("Miller");
	        employee1.setMiddleName("Ted");
	        employee1.setDateOfBirth(new SimpleDateFormat("dd/MM/yyyy").parse("22/07/1982"));
	        employee1.setPassportNumber("L123456");
	        employee1.setSsn("111-452-4545");
	        employees.put(1,employee1);
	        
	        Employee employee2 = new Employee();
	        employee2.setEmployeeId("2");
	        employee2.setFirstName("Polly");
	        employee2.setLastName("Fisher");
	        employee2.setMiddleName("Mary");
	        employee2.setDateOfBirth(new SimpleDateFormat("dd/MM/yyyy").parse("12/11/1972"));
	        employee2.setPassportNumber("M452456");
	        employee2.setSsn("222-452-4545");
	        employees.put(2,employee2);
	        
	        Employee employee3 = new Employee();
	        employee3.setEmployeeId("3");
	        employee3.setFirstName("Michel");
	        employee3.setLastName("Vaghun");
	        employee3.setMiddleName("Patrick");
	        employee3.setDateOfBirth(new SimpleDateFormat("dd/MM/yyyy").parse("28/02/1990"));
	        employee3.setPassportNumber("L323456");
	        employee3.setSsn("333-452-4545");
	        employees.put(3,employee3);
	    }
	}

