package istad.EMS;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class EmployeeServiceImpl implements EmployeeService {

    private final ManagementDataBase employeeDataBase;

    public EmployeeServiceImpl() {
        employeeDataBase = new ManagementDataBase();
    }

    @Override
    public List<Employee> ViewAllEmployee() {
        return employeeDataBase.getAllEmployeesDesc();
    }

    @Override
    public List<Employee> ViewOnlyEmployeeWithoutAdmin() {
        return employeeDataBase.getEmployeesDesc();
    }

    @Override
    public List<Admin> ViewAdmin() {
        return employeeDataBase.getOnlyAdmins();
    }

    @Override
    public void addEmployee(Employee employee) {
        employeeDataBase.addEmployee(employee);
    }

    @Override
    public void deleteEmployee(Integer id) {
        // TODO
        List<Employee> employees = employeeDataBase.getEmployeesDesc()
                .stream()
                .filter(employee -> !employee.getId().equals(id))
                .collect(Collectors.toList());
        employeeDataBase.setEmployee(employees);
    }

    @Override
    public Employee SearchEmployeeByID(Integer id) {
        Optional<Employee> foundEmployee = employeeDataBase
                .getEmployeesDesc()
                .stream()
                .filter(employee -> {
                    return employee.getId().equals(id);
                })
                .findFirst();

        if (foundEmployee.isPresent())
            return foundEmployee.get();
        else {
            DisplayUtil.printNewLine("Employee" + id + "not found");
            return null;
        }
    }

    @Override
    public Admin adminLogin(String userName, String password) {
        return employeeDataBase.adminLogin(userName , password);
    }

    @Override
    public List<Employee> SearchEmployeeByName(String name) {
        return employeeDataBase
                .getAllEmployeesDesc()
                .stream()
                .filter(employee -> employee.getName().toLowerCase()
                        .contains(name.toLowerCase()))
                .toList();
    }

    public List<Employee> FilteringDepartment(String department) {
        return employeeDataBase
                .getAllEmployeesDesc()
                .stream()
                .filter(employee -> employee.getDepartment().toLowerCase()
                        .contains(department.toLowerCase()))
                .toList();
    }

    public List<Employee> FilteringPosition(String position) {
        return employeeDataBase
                .getAllEmployeesDesc()
                .stream()
                .filter(employee -> employee.getPosition().toLowerCase()
                        .contains(position.toLowerCase()))
                .toList();
    }

    @Override
    public Employee employeeLogin(String userName, String password) {
        return employeeDataBase.employeeLogin(userName ,  password);
    }


public void updateEmployeeByID(Integer id, Employee newEmployee) {
    Integer year = InputUtil.getInteger("Enter your birth year : ");
    Integer month = InputUtil.getInteger("Enter your birth month : ");
    Integer day = InputUtil.getInteger("Enter your birth day : ");
    LocalDate dateOfBirth = LocalDate.of(year, month, day);

    // Update employee list using map (not peek)
    List<Employee> updatedEmployees = employeeDataBase.getAllEmployeesDesc()
            .stream()
            .map(employee -> {
                if (employee.getId().equals(id)) {
                    employee.setBirthday(dateOfBirth);
                    employee.setName(newEmployee.getName());
                    employee.setGender(newEmployee.getGender());
                    employee.setNationality(newEmployee.getNationality());
                    employee.setDepartment(newEmployee.getDepartment());
                    employee.setPosition(newEmployee.getPosition());
                    employee.setSalary(newEmployee.getSalary());
                    employee.setAttendance(true);
                    employee.setUserName(newEmployee.getUserName());
                    employee.setPassword(newEmployee.getPassword());
                }
                return employee;
            })
            .collect(Collectors.toList());

    // Save updated list back to database
    employeeDataBase.setEmployee(updatedEmployees);
}
}
