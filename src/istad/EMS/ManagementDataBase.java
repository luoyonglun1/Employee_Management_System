package istad.EMS;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ManagementDataBase {
    private List<Employee> ManagementList;

    public ManagementDataBase(){
        ManagementList = new ArrayList<>();

        LocalDate emp1 = LocalDate.of(2006,3,10);

        Employee employee1 = new Employee(emp1);
        employee1.setId(2);
        employee1.setName("Lor Vengroth");
        employee1.setGender("Male");
        employee1.setNationality("Khmer");
        employee1.setPosition("Software Developer");
        employee1.setDepartment("Information Technology");
        employee1.setAttendance("P");
        employee1.setSalary(1500.00);
        employee1.setUserName("emp1");
        employee1.setPassword("emp123");
        employee1.setPerformancerating(null);


        LocalDate emp2 = LocalDate.of(2004,5,20);

        Employee employee2 = new Employee(emp2);
        employee2.setId(3);
        employee2.setName("Thouern Chanthat");
        employee2.setGender("Male");
        employee2.setNationality("Khmer");
        employee2.setPosition("System Administator");
        employee2.setDepartment("Information Technology");
        employee2.setAttendance("P");
        employee2.setSalary(1700.00);
        employee2.setUserName("emp2");
        employee2.setPassword("emp234");
        employee2.setPerformancerating(70);

        LocalDate emp3 = LocalDate.of(2007,1,16);
        Employee employee3 = new Employee(emp3);
        employee3.setId(4);
        employee3.setName("Path Minea");
        employee3.setGender("Male");
        employee3.setNationality("Khmer");
        employee3.setPosition("DevOps Engineering");
        employee3.setDepartment("Information Technology");
        employee3.setAttendance("P");
        employee3.setSalary(1200.00);
        employee3.setUserName("emp3");
        employee3.setPassword("emp345");
        employee3.setPerformancerating(null);


        LocalDate emp4 = LocalDate.of(2002,6,4);
        Employee employee4 = new Employee(emp4);
        employee4.setId(5);
        employee4.setName("Lor Kimsorng");
        employee4.setGender("Female");
        employee4.setNationality("Chinese");
        employee4.setPosition("HR Manager");
        employee4.setDepartment("Human resources");
        employee4.setAttendance("P");
        employee4.setSalary(1200.00);
        employee4.setUserName("emp4");
        employee4.setPassword("emp456");
        employee4.setPerformancerating(70);


        LocalDate emp5 = LocalDate.of(2002,6,4);
        Employee employee5 = new Employee(emp5);
        employee5.setId(6);
        employee5.setName("Rim Bonna");
        employee5.setGender("Female");
        employee5.setNationality("Khmer");
        employee5.setPosition("Recruitment Officer");
        employee5.setDepartment("Human resources");
        employee5.setAttendance("P");
        employee5.setSalary(1200.00);
        employee5.setUserName("emp5");
        employee5.setPassword("emp567");
        employee5.setPerformancerating(70);

        LocalDate emp6 = LocalDate.of(2002,6,4);
        Employee employee6 = new Employee(emp6);
        employee6.setId(7);
        employee6.setName("Kim Sovanreach");
        employee6.setGender("Female");
        employee6.setNationality("Khmer");
        employee6.setPosition("Payroll Specialist");
        employee6.setDepartment("Human resources");
        employee6.setAttendance("P");
        employee6.setSalary(1200.00);
        employee6.setUserName("emp6");
        employee6.setPassword("emp678");
        employee6.setPerformancerating(null);


        LocalDate emp7 = LocalDate.of(2002,6,4);
        Employee employee7 = new Employee(emp7);
        employee7.setId(8);
        employee7.setName("Him Kimhour");
        employee7.setGender("Male");
        employee7.setNationality("Chinese");
        employee7.setPosition("accountant");
        employee7.setDepartment("Finance");
        employee7.setAttendance("P");
        employee7.setSalary(1200.00);
        employee7.setUserName("emp7");
        employee7.setPassword("emp789");
        employee7.setPerformancerating(70);

        LocalDate emp8 = LocalDate.of(2002,6,4);
        Employee employee8 = new Employee(emp8);
        employee8.setId(9);
        employee8.setName("Lor Kimhor");
        employee8.setGender("Female");
        employee8.setNationality("Chinese");
        employee8.setPosition("Finacial Analyst");
        employee8.setDepartment("Finance");
        employee8.setAttendance("P");
        employee8.setSalary(1200.00);
        employee8.setUserName("Employee3");
        employee8.setPassword("emp345");
        employee8.setPerformancerating(70);

        LocalDate emp9 = LocalDate.of(2002,6,4);
        Employee employee9 = new Employee(emp9);
        employee9.setId(10);
        employee9.setName("Kong Kimsong");
        employee9.setGender("Male");
        employee9.setNationality("Chinese");
        employee9.setPosition("Payroll officer");
        employee9.setDepartment("Finance");
        employee9.setAttendance("P");
        employee9.setSalary(1200.00);
        employee9.setUserName("Employee3");
        employee9.setPassword("emp345");
        employee9.setPerformancerating(70);

        LocalDate emp10 = LocalDate.of(2002,6,4);
        Employee employee10 = new Employee(emp10);
        employee10.setId(11);
        employee10.setName("Tang Lyheng");
        employee10.setGender("Female");
        employee10.setNationality("Chinese");
        employee10.setPosition("Sales Executive");
        employee10.setDepartment("Sale & Marketing");
        employee10.setAttendance("P");
        employee10.setSalary(1200.00);
        employee10.setUserName("Employee3");
        employee10.setPassword("emp345");
        employee10.setPerformancerating(70);

        LocalDate emp11 = LocalDate.of(2002,6,4);
        Employee employee11 = new Employee(emp11);
        employee11.setId(12);
        employee11.setName("Luo Yonglun");
        employee11.setGender("Male");
        employee11.setNationality("Chinese");
        employee11.setPosition("Marketing Coordinator");
        employee11.setDepartment("Sale & Marketing");
        employee11.setAttendance("P");
        employee11.setSalary(1900.00);
        employee11.setUserName("Employee3");
        employee11.setPassword("emp345");
        employee11.setPerformancerating(70);

        LocalDate emp12 = LocalDate.of(2002,6,4);
        Employee employee12 = new Employee(emp12);
        employee12.setId(13);
        employee12.setName("Luo Jinghua");
        employee12.setGender("Female");
        employee12.setNationality("Chinese");
        employee12.setPosition("Customer Relationship Manager");
        employee12.setDepartment("Sale & Marketing");
        employee12.setAttendance("P");
        employee12.setSalary(1500.00);
        employee12.setUserName("Employee3");
        employee12.setPassword("emp345");
        employee12.setPerformancerating(70);


        LocalDate emp13 = LocalDate.of(2002,6,4);
        Employee employee13 = new Employee(emp13);
        employee13.setId(14);
        employee13.setName("Chen Lixing");
        employee13.setGender("Female");
        employee13.setNationality("Chinese");
        employee13.setPosition("Inventory Controller");
        employee13.setDepartment("Operation");
        employee13.setAttendance("P");
        employee13.setSalary(1500.00);
        employee13.setUserName("Employee3");
        employee13.setPassword("emp345");
        employee13.setPerformancerating(70);


        LocalDate emp14 = LocalDate.of(2002,6,4);
        Employee employee14 = new Employee(emp14);
        employee14.setId(15);
        employee14.setName("Chen Liping");
        employee14.setGender("Male");
        employee14.setNationality("Chinese");
        employee14.setPosition("Operations Manager");
        employee14.setDepartment("Operation");
        employee14.setAttendance("P");
        employee14.setSalary(1500.00);
        employee14.setUserName("Employee3");
        employee14.setPassword("emp345");
        employee14.setPerformancerating(70);

        LocalDate adm1 = LocalDate.of(2000,10,3);
        Admin admin1 = new Admin(adm1);
        admin1.setId(1);
        admin1.setName("Heng Vengkhang");
        admin1.setGender("female");
        admin1.setNationality("Chinese");
        admin1.setPosition("Admin");
        admin1.setDepartment("Operation");
        admin1.setAttendance("P");
        admin1.setSalary(1700.00);
        admin1.setUserName("Admin");
        admin1.setPassword("AdminKhang");
        admin1.setPerformancerating(90);

        ManagementList.add(admin1);
        ManagementList.add(employee1);
        ManagementList.add(employee2);
        ManagementList.add(employee3);
        ManagementList.add(employee4);
        ManagementList.add(employee5);
        ManagementList.add(employee6);
        ManagementList.add(employee7);
        ManagementList.add(employee8);
        ManagementList.add(employee9);
        ManagementList.add(employee10);
        ManagementList.add(employee11);
        ManagementList.add(employee12);
        ManagementList.add(employee13);
        ManagementList.add(employee14);




    }




    public List<Employee> getAllEmployeesDesc() {
        return ManagementList.reversed();
    }

    public List<Employee> getEmployeesDesc(){
        List<Employee> employees = new ArrayList<>();
        for (Employee e : ManagementList) {
            if (!(e instanceof Admin)) {
                employees.add(e);
            }
        }
        return employees.reversed();

    }

    public List<Admin> getOnlyAdmins() {
        List<Admin> admins = new ArrayList<>();
        for (Employee e : ManagementList) {
            if (e instanceof Admin) {
                admins.add((Admin) e); // safe cast
            }
        }
        return admins.reversed();
    }



    public Admin adminLogin(String username, String password) {
        return ManagementList.stream()
                .filter(user -> user instanceof Admin)
                .map(user -> (Admin) user)
                .filter(admin -> admin.getUserName().equals(username) && admin.getPassword().equals(password))
                .findFirst()
                .orElse(null);
    }

    public Employee employeeLogin(String username, String password) {
        return ManagementList.stream()
                .filter(user -> !(user instanceof Admin)) // exclude Admins
                .map(user -> (Employee) user)             // safe cast
                .filter(emp -> emp.getUserName().equals(username) &&
                        emp.getPassword().equals(password))
                .findFirst()
                .orElse(null);
    }


    private Integer autoId() {
        return ManagementList.getLast().getId() + 1;
    }

    public void addEmployee(Employee employee) {
        employee.setId(autoId());
        ManagementList.add(employee);
    }

    public void setEmployee(List<Employee> employeeList){
        this.ManagementList = employeeList.reversed() ;
    }


}
