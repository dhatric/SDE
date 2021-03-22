package com.dhatric.graphs;

import java.util.HashMap;
import java.util.List;

public class EmployeeImportanceDFS {
	public int getImportance(List<Employee> employees, int id) {
        if(employees ==null){
          throw new IllegalArgumentException("Invalid list");
        }
        
      
     HashMap<Integer,Employee> empMap = new HashMap<>();
     employees.forEach(emp -> empMap.put(emp.id,emp));    
     Employee headEmployee= empMap.get(id);
     if(headEmployee == null){
         throw new IllegalArgumentException("Id not found");
     }
        return dfs(headEmployee,empMap);
    }
	

	private int dfs(Employee headEmployee, HashMap<Integer,Employee> empMap) {
		int importance=0;
		if(headEmployee.subordinates == null) {
			importance = headEmployee.importance;
		}else {
			importance=headEmployee.importance;
			for(Integer subOrd: headEmployee.subordinates) {
				importance += dfs(empMap.get(subOrd),empMap);
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
