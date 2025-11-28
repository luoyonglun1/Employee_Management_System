package istad.EMS;

import java.time.LocalDate;

public class Admin extends Employee{
    public Admin() {
        super();
    }

    public Admin(LocalDate birthday) {
        super(birthday);
    }

    public Admin(String name, LocalDate birthday, String nationality, String gender, String department, String position, Double salary, Boolean attendance) {
        super(name, birthday, nationality, gender, department, position, salary, attendance);
    }

    @Override
    public Integer getId() {
        return super.getId();
    }

    @Override
    public void setId(Integer id) {
        super.setId(id);
    }

    @Override
    public String getName() {
        return super.getName();
    }

    @Override
    public Integer getAge() {
        return super.getAge();
    }

    @Override
    public void setName(String name) {
        super.setName(name);
    }

    @Override
    public String getNationality() {
        return super.getNationality();
    }

    @Override
    public void setNationality(String nationality) {
        super.setNationality(nationality);
    }

    @Override
    public String getGender() {
        return super.getGender();
    }

    @Override
    public void setGender(String gender) {
        super.setGender(gender);
    }

    @Override
    public String getDepartment() {
        return super.getDepartment();
    }

    @Override
    public void setDepartment(String department) {
        super.setDepartment(department);
    }

    @Override
    public String getPosition() {
        return super.getPosition();
    }

    @Override
    public void setPosition(String position) {
        super.setPosition(position);
    }

    @Override
    public Double getSalary() {
        return super.getSalary();
    }

    @Override
    public void setSalary(Double salary) {
        super.setSalary(salary);
    }

    @Override
    public Boolean getAttendance() {
        return super.getAttendance();
    }

    @Override
    public void setAttendance(Boolean attendance) {
        super.setAttendance(attendance);
    }

    @Override
    public String getUserName() {
        return super.getUserName();
    }

    @Override
    public void setUserName(String userName) {
        super.setUserName(userName);
    }

    @Override
    public String getPassword() {
        return super.getPassword();
    }

    @Override
    public void setPassword(String password) {
        super.setPassword(password);
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
