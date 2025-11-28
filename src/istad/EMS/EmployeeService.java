package istad.EMS;

import java.util.List;

public interface EmployeeService {
    /*
     * 1. View all employee
     * 2. Search employee -> show information
     * 3. Add employee
     * 4. Update employee
     * 5. Delete employee
     * 6. Department filterring -> show all employee in the department
     * 7. Position filtering -> show all employee in that position
     * 8. View employee attendance -> can filter view by all employee , department , position , ID or name
     *  */

    List<Employee> ViewAllEmployee();
    List<Employee> ViewOnlyEmployeeWithoutAdmin();
    List<Admin> ViewAdmin();
    void addEmployee(Employee employee);
    void deleteEmployee(Integer id);
    Employee SearchEmployeeByID(Integer id);
    Admin adminLogin(String userName , String password);
    Employee employeeLogin(String userName , String password);
    List<Employee> SearchEmployeeByName(String name);
    void updateEmployeeByID(Integer id, Employee newEmployee);
    List<Employee> FilteringDepartment(String department);
    List<Employee> FilteringPosition(String position);



}
