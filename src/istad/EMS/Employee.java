package istad.EMS;
import java.time.LocalDate;
import java.time.Period;


public class Employee {
    private Integer id ;
    private String name ;
//    insert Birtday date and print out the age
    private LocalDate birthday;
    private String nationality ;
    private String gender ;
    private String department ;
    private String position ;
    private Double salary ;
    private String attendance ;
    private String userName ;
    private String password ;
    private Integer performancerating ;



    public Employee() {

    }

    public Employee(LocalDate birthday) {

        this.birthday = birthday;
    }

//    public Employee(String userName, String password) {
//        this.userName = userName;
//        this.password = password;
//    }

    public Employee(String name, LocalDate birthday, String nationality, String gender, String department, String position, Double salary, String attendance) {

        this.name = name;
        this.birthday = birthday;
        this.nationality = nationality;
        this.gender = gender;
        this.department = department;
        this.position = position;
        this.salary = salary;
        this.attendance = attendance;
    }
    public Employee(String name,  String nationality, String gender, String department, String position, Double salary, String attendance , String userName , String password ) {

        this.name = name;
        this.nationality = nationality;
        this.gender = gender;
        this.department = department;
        this.position = position;
        this.salary = salary;
        this.attendance = attendance;
        this.userName = userName ;
        this.password = password ;
    }

    public Integer getPerformancerating() {
        return performancerating;
    }

    public void setPerformancerating(Integer performancerating) {
        this.performancerating = performancerating;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public Integer getAge() {
        if (birthday == null) return -1; // Handle missing DOB
        LocalDate today = LocalDate.now();
        return Period.between(birthday, today).getYears();
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public String getAttendance() {
        return attendance;
    }

    public void setAttendance(String attendance) {
        this.attendance = attendance;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age =" + getAge() +
                ", nationality='" + nationality + '\'' +
                ", gender='" + gender + '\'' +
                ", department='" + department + '\'' +
                ", position='" + position + '\'' +
                ", salary=" + salary +
                ", attendance=" + attendance +
                '}';
    }
}
