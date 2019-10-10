package com.v2soft.training.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.springframework.http.CacheControl;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.http.MediaType;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.v2soft.training.model.Employee;
import com.v2soft.training.service.*;

@Controller
public class EmployeeController {
	
	private EmployeeService employeeService = new EmployeeService();
	List<Employee> employeeList = employeeService.listAllEmployees() ;
	
	
	  @RequestMapping(value="/getEmployeeById/{employeeId}", method=RequestMethod.GET)
	  @ResponseBody 
	  public String printEmployeeGet(@PathVariable("employeeId")
	  String employeeId) throws JsonProcessingException { 
	  Employee employee = new Employee(); 
	  employee.setEmployeeId(employeeId); 
	  ObjectMapper objectMapper = new ObjectMapper(); 
	  String json = objectMapper.writeValueAsString(employee);
	  return json;
	  }
	 
	
    @RequestMapping(value="/getEmployeeList", method=RequestMethod.GET)
    @ResponseBody
    public  String  ListEmployees()
    		throws JsonProcessingException {
    	
    	ObjectMapper objectMapper = new ObjectMapper();
        String json = "";
        
        for(Employee employee: employeeList) {
        	json = json.concat(objectMapper.writeValueAsString(employee)) + "\n";
        }
    	 return json;
    }
    
	/*
	 * @GetMapping("/getEmployeeIDByGetMapping/{employeeId}")
	 * 
	 * @ResponseBody public String
	 * printEmployeeGetMapping(@PathVariable("employeeId") String employeeId) throws
	 * JsonProcessingException { Employee employee = new Employee();
	 * employee.setEmployeeId(employeeId); ObjectMapper objectMapper =new
	 * ObjectMapper(); String json = objectMapper.writeValueAsString(employee);
	 * return json; }
	 */
	 
	
	/*
	 * @PostMapping("/getEmployeeById")
	 * 
	 * @ResponseBody public String printEmployeePost(@RequestParam("employeeId")
	 * String employeeId) throws JsonProcessingException { Employee employee = new
	 * Employee(); employee.setEmployeeId(employeeId); ObjectMapper objectMapper =
	 * new ObjectMapper(); String json = objectMapper.writeValueAsString(employee);
	 * 
	 * return json; }
	 */
    
     @RequestMapping(value ="/addEmployeeObject", method=RequestMethod.POST)
     @ResponseBody
     public String addEmployee(@RequestParam(value="Id",required=false) String Id,
    		 				   @RequestParam(value="Fname",required=false) String Fname,
    		 				   @RequestParam(value="Lname",required=false) String Lname,
    		 				   @RequestParam(value="Mname",required=false) String Mname,
    		 				   @RequestParam(value="DOB",required=false) String DOB,
    		 				   @RequestParam(value="Passport",required=false) String Passport,
    		 				   @RequestParam(value="SSN",required=false) String SSN)   		                    
    		 throws JsonProcessingException, ParseException {
    	 
    	 Employee employee = new Employee();
    	 employee.setEmployeeId(Id);
    	 employee.setFirstName(Fname);
    	 employee.setLastName(Lname);
    	 employee.setMiddleName(Mname);
    	 if(DOB != null) {
    	 employee.setDateOfBirth(new SimpleDateFormat("dd/MM/yyyy").parse(DOB));
    	 }
    	 employee.setPassportNumber(Passport);
    	 employee.setSsn(SSN);
    	 
    	 employeeList.add(employee);
    	 return "Employee List";
   	 
     }
     
     @RequestMapping(value ="/SearchEmployee", method=RequestMethod.POST)
     @ResponseBody
     public String SearchEmployee(@RequestParam(value="Id",required=false) String Id,
    		                      @RequestParam(value="Fname",required=false) String Fname,
    		                      @RequestParam(value="Lname",required=false) String Lname,
    		                      @RequestParam(value="Mname",required=false) String Mname,
    		                      @RequestParam(value="DOB",required=false) String DOB,
    		                      @RequestParam(value="Passport",required=false) String Passport,
    		                      @RequestParam(value="SSN",required=false) String SSN)    		                    
    		 throws JsonProcessingException, ParseException {
    	 
    	
    	 ObjectMapper objectMapper = new ObjectMapper();
         String json = "";
    	 for(Employee employee: employeeList) {
    		 if(Id !=null && Id.equals(employee.getEmployeeId())){
    			 json = json.concat(objectMapper.writeValueAsString(employee)) + "\n";
    		 }
    		 else if(Fname !=null && Fname.equals(employee.getFirstName())){
    			 json = json.concat(objectMapper.writeValueAsString(employee)) + "\n";
    		 }
    		 else if(Lname !=null && Lname.equals(employee.getLastName())){
    			 json = json.concat(objectMapper.writeValueAsString(employee)) + "\n";
    		 }
    		 else if(Mname !=null && Mname.equals(employee.getMiddleName())){
    			 json = json.concat(objectMapper.writeValueAsString(employee)) + "\n";
    		 }
    		 else if(DOB !=null && DOB.equals(objectMapper.writeValueAsString(employee.getDateOfBirth()))){
    			 json = json.concat(objectMapper.writeValueAsString(employee)) + "\n";
    		 }
    		 else if(Passport !=null && Passport.equals(employee.getPassportNumber())){
    			 json = json.concat(objectMapper.writeValueAsString(employee)) + "\n";
    		 }
    		 else if(SSN !=null && SSN.equals(employee.getSsn())){
    			 json = json.concat(objectMapper.writeValueAsString(employee)) + "\n";
    		 }
         }  
    	 if(json.equals(""))
    	 {
    		 json = "No Such Employee";
    	 }
    	 return json;
     }

}
