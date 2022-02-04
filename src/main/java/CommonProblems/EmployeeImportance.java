package CommonProblems;

import java.util.*;

/*
* https://leetcode.com/problems/employee-importance/
*
*You have a data structure of employee information, including the employee's unique ID, importance value, and direct subordinates' IDs.
You are given an array of employees employees where:
employees[i].id is the ID of the ith employee.
employees[i].importance is the importance value of the ith employee.
employees[i].subordinates is a list of the IDs of the direct subordinates of the ith employee.
Given an integer id that represents an employee's ID, return the total importance value of this employee and all their direct and indirect subordinates.
* Example 1:
* Input: employees = [[1,5,[2,3]],[2,3,[]],[3,3,[]]], id = 1
Output: 11
Explanation: Employee 1 has an importance value of 5 and has two direct subordinates: employee 2 and employee 3.
They both have an importance value of 3.
Thus, the total importance value of employee 1 is 5 + 3 + 3 = 11.
*
* */
public class EmployeeImportance {
    public static void main(String[] args) {
        EmployeeSolution employeeSolution = new EmployeeSolution();
        List<Employee> employees = new ArrayList<>();
        Employee employee = new Employee();
        employee.id = 1;
        employee.importance = 2;
        employee.subordinates = new ArrayList<Integer>(Arrays.asList(5));
        employees.add(employee);
        employee = new Employee();
        employee.id = 5;
        employee.importance = -3;
        employee.subordinates = new ArrayList<Integer>();
        employees.add(employee);
        System.out.println(employeeSolution.getImportance(employees, 5));

        employees = new ArrayList<>();
        employee.id = 1;
        employee.importance = 5;
        employee.subordinates = new ArrayList<Integer>(Arrays.asList(2,3));
        employees.add(employee);
        employee = new Employee();
        employee.id = 2;
        employee.importance = 3;
        employee.subordinates = new ArrayList<Integer>();
        employees.add(employee);
        employee = new Employee();
        employee.id = 3;
        employee.importance = 3;
        employee.subordinates = new ArrayList<Integer>();
        employees.add(employee);
        System.out.println(employeeSolution.getImportance(employees, 1));
    }
}
class EmployeeSolution{
    /*
    * Complexity Analysis:
        Time Complexity: O(N), where NN is the number of employees. We might query each employee in dfs.
        Space Complexity: O(N), the size of the implicit call stack when evaluating dfs.
    * */
    Map<Integer, Employee> employeeMap;
    public int getImportance(List<Employee> employees, int id){
        employeeMap = new HashMap<>();
        for(Employee employee : employees){
            employeeMap.put(employee.id, employee);
        }
        return dfs(id);
    }
    private int dfs(int eid){
        Employee employee = employeeMap.get(eid);
        int result = employee.importance;
        for(Integer subId: employee.subordinates){
            result += dfs(subId);
        }
        return result;
    }
}
class Employee{
    public int id;
    public int importance;
    public List<Integer> subordinates;
}