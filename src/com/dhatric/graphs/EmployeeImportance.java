package com.dhatric.graphs;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class EmployeeImportance {
	public int getImportance(List<Employee> employees, int id) {
        int importance=0;
        if(employees ==null){
          throw new IllegalArgumentException("Invalid list");
        }

     HashMap<Integer,Employee> empMap = new HashMap<>();
     employees.forEach(emp -> empMap.put(emp.id,emp));    

     Employee headEmployee= empMap.get(id);
     if(headEmployee == null){
         throw new IllegalArgumentException("Id not found");
     }
     
     LinkedList<Employee> queue = new LinkedList<>();
     queue.add(headEmployee);

     while(!queue.isEmpty()){
       Employee emp = queue.pop();
       importance+=emp.importance;
       for(Integer subOrd: emp.subordinates){
         queue.add(empMap.get(subOrd));
       }
     }
        return importance;
    }
	
	
	class Employee {
	    public int id;
	    public int importance;
	    public List<Integer> subordinates;
	};
}
