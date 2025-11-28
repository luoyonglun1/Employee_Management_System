package istad.EMS;

import org.nocrala.tools.texttablefmt.BorderStyle;
import org.nocrala.tools.texttablefmt.Table;

import java.util.List;

public class DisplayUtil {
    public final static String FirstDisplay = """
            |---------------------------------------------------|
            |        [+] EMPLOYEE MANAGEMENT SYSTEM [+]         |
            |---------------------------------------------------|
            1. Admin
            2. Employee
            0. Exit the system
            """;
    public final static String AdminMenu = """
            |----------------------------------|
            |        [+] ADMIN APP [+]         |
            |----------------------------------|
            1. View all Employee
            2. Search Employee
            3. Rating Employee performance
            4. Add Employee
            5. Update Employee information 
            6. Delete Employee
            7. Department filtering Employee
            8. Position filtering Employee
            9. Salary filtering 
            10. View Employee attendance  
            11. Set Permission Or Absent 
            0. Back to the Login
            """;
    public final static  String SearchOpt = """
            |--------------------------------------------|
            |        [+] Enter Search Option [+]         |
            |--------------------------------------------|
            1. Search by ID 
            2. Search by Name 
            3. Search by gender
            """;

    public final static String EmployeeMenu = """
            |-----------------------------------|
            |       [+] EMPLOYEE APP [+]        |
            |-----------------------------------|
            1. View attendance 
            2. View performance rating
            3. Take attendance
            0. Back to the Login
            """;

    public final static String GenderOpt = """
            --------------------------------
            |   1. Male   |   2. Female    |
            --------------------------------
            """;

    public static void DepartmentList(){
        Table table = new Table(5, BorderStyle.UNICODE_ROUND_BOX_WIDE);
        table.addCell("1. Human resources");
        table.addCell("2. IT");
        table.addCell("3. Finance");
        table.addCell("4. Sale & Marketing");
        table.addCell("5. Operation");
        DisplayUtil.printNewLine(table.render());
    }

    public static void PositionList(){
        Table table = new Table(5,  BorderStyle.UNICODE_ROUND_BOX_WIDE);
        table.addCell(" Department Of HR");
        table.addCell(" Department of IT");
        table.addCell(" Department of Finance");
        table.addCell(" Department of Sale & Marketing");
        table.addCell(" Department of Operation");
        table.addCell("1. HR Manager");
        table.addCell("4. Software Developer");
        table.addCell("7. Accountant");
        table.addCell("10. Sale Executive");
        table.addCell("13. Operation Manager");
        table.addCell("2. Recruitment Officer");
        table.addCell("5. System Administator");
        table.addCell("8. Finacial Analyst");
        table.addCell("11. Marketing Coordinator");
        table.addCell("14. Inventory Controller");
        table.addCell("3. Payroll Specialist");
        table.addCell("6. DevOps engineering");
        table.addCell("9. Payroll Officer");
        table.addCell("12. Customer Relationship Manager");
        table.addCell("15. Admin");

        DisplayUtil.printNewLine(table.render());
    }

    public static void PositionOfHR(){
        Table table = new Table(3, BorderStyle.UNICODE_ROUND_BOX_WIDE);
        table.addCell("1. HR Manager");
        table.addCell("2. Recruitment Officer");
        table.addCell("3. Payroll Specialist");
        DisplayUtil.printNewLine(table.render());
    }

    public static void PositionOfIT(){
        Table table = new Table(3, BorderStyle.UNICODE_ROUND_BOX_WIDE);
        table.addCell("1. Software Developer");
        table.addCell("2. System Administator");
        table.addCell("3. DevOps engineering");
        DisplayUtil.printNewLine(table.render());
    }

    public static void PositionOfFinance(){
        Table table = new Table(3, BorderStyle.UNICODE_ROUND_BOX_WIDE);
        table.addCell("1. Accountant");
        table.addCell("2. Finacial Analyst");
        table.addCell("3. Payroll officer");
        DisplayUtil.printNewLine(table.render());
    }

    public static void PositionOfSaleAndMarketing(){
        Table table = new Table(3, BorderStyle.UNICODE_ROUND_BOX_WIDE);
        table.addCell("1. Sales Executive");
        table.addCell("2. Marketing Coordinator");
        table.addCell("3. Customer Relationship Manager");
        DisplayUtil.printNewLine(table.render());
    }

    public static void PositionOfOperation(){
        Table table = new Table(3, BorderStyle.UNICODE_ROUND_BOX_WIDE);
        table.addCell("1. Operations Manager");
        table.addCell("2. Inventory Controller");
        table.addCell("3. Admin");
        DisplayUtil.printNewLine(table.render());
    }

    public static String LoginForm = """
            |---------------------------------------------|
            |     [+] PLEASE LOGIN INTO YOUR APP [+]      |
            |---------------------------------------------|
            """;


    public static void printNewLine(String text){
        System.out.println(text);
    }

    public static void showSuccessMsg(String prefix) {
        System.out.println(prefix + " successfully");
    }

    public static void printSameLine(String text){
        System.out.print(text);
    }

    public static void printList(List<Employee> employees){
        System.out.println(employees);
    }

    public static void table(List<Employee> employees) {
        Table table = new Table(8, BorderStyle.UNICODE_ROUND_BOX_WIDE);
        table.addCell("ID");
        table.addCell("NAME");
        table.addCell("GENDER");
        table.addCell("AGE");
        table.addCell("NATIONALITY");
        table.addCell("DEPARTMENT");
        table.addCell("POSITION");
        table.addCell("SALARY");
        for (Employee employee : employees) {
            table.addCell(employee.getId().toString());
            table.addCell(employee.getName());
            table.addCell(employee.getGender());
            table.addCell(employee.getAge().toString());
            table.addCell(employee.getNationality());
            table.addCell(employee.getDepartment());
            table.addCell(employee.getPosition());
            table.addCell(employee.getSalary().toString());
        }
        DisplayUtil.printNewLine(table.render());
    }

    public static void tableOneRow(String inputOne , String inputTwo) {
        Table table = new Table(2, BorderStyle.UNICODE_ROUND_BOX_WIDE);
        table.addCell(inputOne);
        table.addCell(inputTwo);
        DisplayUtil.printNewLine(table.render());
    }

    public static void tableForNonCount(Employee employee) {
        Table table = new Table(8, BorderStyle.UNICODE_ROUND_BOX_WIDE);
        table.addCell("ID");
        table.addCell("NAME");
        table.addCell("GENDER");
        table.addCell("AGE");
        table.addCell("NATIONALITY");
        table.addCell("DEPARTMENT");
        table.addCell("POSITION");
        table.addCell("SALARY");

            table.addCell(employee.getId().toString());
            table.addCell(employee.getName());
            table.addCell(employee.getGender());
            table.addCell(employee.getAge().toString());
            table.addCell(employee.getNationality());
            table.addCell(employee.getDepartment());
            table.addCell(employee.getPosition());
            table.addCell(employee.getSalary().toString());

        DisplayUtil.printNewLine(table.render());
    }

    public static void tableForList(List<Employee> employees) {
        Table table = new Table(8, BorderStyle.UNICODE_ROUND_BOX_WIDE);
        table.addCell("ID");
        table.addCell("NAME");
        table.addCell("GENDER");
        table.addCell("AGE");
        table.addCell("NATIONALITY");
        table.addCell("DEPARTMENT");
        table.addCell("POSITION");
        table.addCell("SALARY");
        for (Employee employee : employees) {
            table.addCell(employee.getId().toString());
            table.addCell(employee.getName());
            table.addCell(employee.getGender());
            table.addCell(employee.getAge().toString());
            table.addCell(employee.getNationality());
            table.addCell(employee.getDepartment());
            table.addCell(employee.getPosition());
            table.addCell(employee.getSalary().toString());
        }
        DisplayUtil.printNewLine(table.render());
    }


}
