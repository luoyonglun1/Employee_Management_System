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
        List<Employee> employees = employeeDataBase.getAllEmployeesDesc()
                .stream()
                .filter(employee -> !employee.getId().equals(id))
                .collect(Collectors.toList());
        employeeDataBase.setEmployee(employees);
    }

    @Override
    public Employee SearchEmployeeByID(Integer id) {
        Optional<Employee> foundEmployee = employeeDataBase
                .getAllEmployeesDesc()
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

//    public List<Employee> FilteringNotYetRating(String rating) {
//
//        return employeeDataBase
//                .getAllEmployeesDesc()
//                .stream()
//                .filter(
//
//                        employee -> employee.getPerformancerating().toString()
//                        .contains(rating.toLowerCase()))
//                .toList();
//    }
public List<Employee> FilteringNotYetRating() {
    return employeeDataBase
            .getAllEmployeesDesc()
            .stream()
            .filter(employee -> employee.getPerformancerating() == null)
            .toList();
}

    @Override
    public List<Employee> FilteringRatedEmployee() {
        return employeeDataBase
                .getAllEmployeesDesc()
                .stream()
                .filter(employee -> employee.getPerformancerating() != null)
                .toList();
    }

    @Override
    public Employee employeeLogin(String userName, String password) {
        return employeeDataBase.employeeLogin(userName ,  password);
    }


public void updateEmployeeByID(Integer id, Employee newEmployee) {
    DisplayUtil.printNewLine("Enter your Birth Date! ");

//    int year;
//    do {
//        year = InputUtil.getInteger("Enter your birth year : ");
//        if (year >= 1950 && year <= 2025) {
//            System.out.println("Year must be less than 2025.");
//        }
//    } while (year >= 1950 && year <= 2025);

    int year;
    do {
        year = InputUtil.getInteger("Enter your birth year : ");
        if (year < 1950 || year > 2025) {
            System.out.println(" Year must be between 1950 and 2025.");
        }
    } while (year < 1950 || year > 2025);


    int month;
    do {
        month = InputUtil.getInteger("Enter your birth month : ");
        if (month > 12 || month < 1) {
            System.out.println("Month must be between 1 and 12.");
        }
    } while (month > 12 || month < 1);

    int day;
    do {
        day = InputUtil.getInteger("Enter your birth day : ");
        if (day > 31 || day < 1) {
            System.out.println("Day must be between 1 and 31.");
        }
    } while (day > 31 || day < 1);
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
                    employee.setAttendance("Not yet take attendance");
                    employee.setUserName(newEmployee.getUserName());
                    employee.setPassword(newEmployee.getPassword());
                }
                return employee;
            })
            .collect(Collectors.toList());

    // Save updated list back to database
    employeeDataBase.setEmployee(updatedEmployees);
}

    public Employee ratingEmployee(Integer id, Integer percentage) {
        Optional<Employee> foundEmployee = employeeDataBase
                .getEmployeesDesc()
                .stream()
                .filter(employee -> employee.getId().equals(id))
                .findFirst();

        if (foundEmployee.isPresent()) {
            Employee employee = foundEmployee.get();
            while (true) {
                if (percentage <= 100) {
                    employee.setPerformancerating(percentage);
                    return employee;
                } else {
                    System.out.println("The rating must be from 0 -> 100%");
                    percentage = InputUtil.getInteger("Enter rating again (0 -> 100%) : ");
                }
        }

        }else{
            return null;
        }

    }

    @Override
    public List<Employee> findEmployeeBySalary(Double salary, Boolean order) {
        return employeeDataBase
                .getAllEmployeesDesc()
                .stream()
                .filter(Employee -> {
                    if (order) { // Bigger or Equal
                        return Employee.getSalary() >= salary;
                    } else { // Smaller or Equal
                        return Employee.getSalary() <= salary;
                    }
                })
                .toList();
    }

    @Override
    public void sendRequestToAdmin(Employee employee , String request) {
        employee.setRequestToAdmin(request);
    }



}
