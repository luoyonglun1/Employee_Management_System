package istad.EMS;

import java.time.LocalDate;
import java.util.List;

public class EmployeeApplication {
    public static void main(String[] args) {

        EmployeeService employeeService = new EmployeeServiceImpl();
//            EmployeeDataBase employeeDataBase = new EmployeeDataBase();

        do {

            DisplayUtil.printNewLine(DisplayUtil.FirstDisplay);
            int Option = InputUtil.getInteger("Please Enter your option : " );

            switch (Option){
                case 1 -> {

                    DisplayUtil.printNewLine(DisplayUtil.LoginForm);
                    String nameLog = InputUtil.getText("Enter your Username : ");
                    String password = InputUtil.getText("Enter your password : ");
                    Admin adminLog = employeeService.adminLogin(nameLog , password);
                   if ( adminLog != null){
                       boolean backToMain = true;
                       do {

                           DisplayUtil.printNewLine(DisplayUtil.AdminMenu);
                           DisplayUtil.printNewLine("******** Welcome Admin " + adminLog.getName() + " ********");
                           int adminOpt =  InputUtil.getInteger("Please Enter your option : ");

                           switch (adminOpt){
                               // done
                               case 1 -> {
                                   DisplayUtil.printNewLine("---------------------------------------------------- EMPLOYEE LIST ----------------------------------------------------");
                                   DisplayUtil.table(employeeService.ViewAllEmployee());
                               }
                               // not yet done
                               case 2 -> {
//                                   DisplayUtil.printNewLine(DisplayUtil.SearchOpt);
                                   DisplayUtil.tableOneRow("1. Search by ID " , "2. Search by Name ");
                                   Integer searchOpt = InputUtil.getInteger("Enter your Option : ");
                                   switch (searchOpt){
                                       case 1 -> {
                                           DisplayUtil.printNewLine("""
                                                   |-----------------------|
                                                   |     Search By ID      |
                                                   |-----------------------|
                                                   """);
                                           Integer id = InputUtil.getInteger("Enter ID to search the Employee : ");
                                           Employee employee = employeeService.SearchEmployeeByID(id) ;
                                           DisplayUtil.tableForNonCount(employee);
                                       }
                                       case 2 -> {
                                           String name = InputUtil.getText("Enter the Employee name : ");
                                           List<Employee> foundEmployees = employeeService.SearchEmployeeByName(name);
                                           DisplayUtil.tableForList(foundEmployees);
                                       }
                                   }
                               }
                               // not yet
                               case 3 -> {
                                   DisplayUtil.printNewLine("""
                                                   |---------------------------------------|
                                                   |      Rating Employee Performance      |               
                                                   |---------------------------------------|
                                                   """);
                                   Integer id = InputUtil.getInteger("Enter Employee ID : ") ;
                                   DisplayUtil.tableForNonCount(employeeService.SearchEmployeeByID(id));
                                   Integer percentage = InputUtil.getInteger("Enter their performance 0 -> 100% : ");
                                   employeeService.ratingEmployee(id , percentage);
                               }
                               // done
                               case 4 -> {
                                   String name = InputUtil.getText("Enter your name : ");
                                   DisplayUtil.printNewLine("Enter your Birth Date! ");
                                   Integer year = InputUtil.getInteger("Enter your birth year : ");
                                   Integer month = InputUtil.getInteger("Enter your birth month : ");
                                   Integer day = InputUtil.getInteger("Enter your birth day : ");
                                   LocalDate age = LocalDate.of(year , month , day);
                                   String nationality = InputUtil.getText("Enter your nationality : ");
//                                   DisplayUtil.printNewLine(DisplayUtil.GenderOpt);
                                   DisplayUtil.tableOneRow("1. Male", "2. Female");
                                   Integer gd = InputUtil.getInteger("Enter your Gender : ");
                                   String gender ;
                                   switch (gd){
                                       case 1 -> {
                                           gender = "Male" ;
                                       }
                                       case 2 -> {
                                           gender = "Female" ;
                                       }
                                       default -> throw new IllegalStateException();
                                   }
                                   DisplayUtil.DepartmentList();
                                   Integer optDp = InputUtil.getInteger("Enter your departmnt : ");
                                   String department ;
                                   String position ;
                                   System.out.println(optDp);
                                   switch (optDp){
                                       case 1 -> {
                                           department = "Human Resources";
                                           DisplayUtil.PositionOfHR();
                                           Integer optPst = InputUtil.getInteger("Enter your position : ");
                                           switch (optPst){
                                               case 1 -> {
                                                   position = "HR Manager";
                                               }
                                               case 2 -> {
                                                   position = "Recruitment Officer";
                                               }
                                               case 3 -> {
                                                   position = "Payroll Specialist";
                                               }
                                               default -> throw new IllegalStateException();
                                           }

                                       }
                                       case 2 -> {
                                           department = "Infomation Technology";
                                           DisplayUtil.PositionOfIT();
                                           Integer optPst = InputUtil.getInteger("Enter your position : ");
                                           switch (optPst){
                                               case 1 -> {
                                                   position = "Software Developer";
                                               }
                                               case 2 -> {
                                                   position = "System Administator";
                                               }
                                               case 3 -> {
                                                   position = "DevOps engineering";
                                               }
                                               default -> throw new IllegalStateException();
                                           }

                                       }
                                       case 3 -> {
                                           department = "Finance";
                                           DisplayUtil.PositionOfFinance();
                                           Integer optPst = InputUtil.getInteger("Enter your position : ");
                                           switch (optPst){
                                               case 1 -> {
                                                   position = "Accountant";
                                               }
                                               case 2 -> {
                                                   position = "Finacial Analyst";
                                               }
                                               case 3 -> {
                                                   position = "Payroll officer";
                                               }
                                               default -> throw new IllegalStateException();
                                           }

                                       }
                                       case 4 -> {
                                           department = "Sale & Marketing";
                                           DisplayUtil.PositionOfSaleAndMarketing();
                                           Integer optPst = InputUtil.getInteger("Enter your position : ");
                                           switch (optPst){
                                               case 1 -> {
                                                   position = "Sales Executive";
                                               }
                                               case 2 -> {
                                                   position = "Marketing Coordinator";
                                               }
                                               case 3 -> {
                                                   position = "Customer Relationship Manager";
                                               }
                                               default -> throw new IllegalStateException();
                                           }

                                       }
                                       case 5 -> {
                                           department = "Operation";
                                           DisplayUtil.PositionOfOperation();
                                           Integer optPst = InputUtil.getInteger("Enter your position : ");
                                           switch (optPst){
                                               case 1 -> {
                                                   position = "Operations Manager";
                                               }
                                               case 2 -> {
                                                   position = "Inventory Controller";
                                               }
                                               case 3 -> {
                                                   position = "Admin";
                                               }
                                               default -> throw new IllegalStateException();
                                           }

                                       }
                                       default -> throw new IllegalStateException();

                                   }
                                   Double salary = InputUtil.getDouble("Enter the Employee salary : ");
                                   String userName = InputUtil.getText("Enter the Employee Login userName : ");
                                   String pw = InputUtil.getText("Enter the Emplopyee password : ");
                                   String attendance = "Not yet take attendance" ;
                                   Employee newEmployee = new Employee(name , age , nationality , gender , department , position , salary, attendance);
                                   employeeService.addEmployee(newEmployee);
                                   newEmployee.setUserName(userName);
                                   newEmployee.setPassword(pw);
                                   DisplayUtil.showSuccessMsg("Student added");

                               }
                               // not yet
                               case 5 -> {
                                   DisplayUtil.printNewLine("""
                                                   |--------------------------------------|
                                                   |     Update Employee Information      |
                                                   |--------------------------------------|
                                                   """);
                                   Integer id = InputUtil.getInteger("Please Enter Employee ID to update information :");
                                   DisplayUtil.tableForNonCount(employeeService.SearchEmployeeByID(id));
                                   String name = InputUtil.getText("Enter your name : ");
//                                   DisplayUtil.printNewLine("Enter your Birth Date! ");
//                                   Integer year = InputUtil.getInteger("Enter your birth year : ");
//                                   Integer month = InputUtil.getInteger("Enter your birth month : ");
//                                   Integer day = InputUtil.getInteger("Enter your birth day : ");
//                                   LocalDate age = LocalDate.of(year , month , day);
                                   String nationality = InputUtil.getText("Enter your nationality : ");
//                                   DisplayUtil.printNewLine(DisplayUtil.GenderOpt);
                                   DisplayUtil.tableOneRow("1. Male", "2. Female");
                                   Integer gd = InputUtil.getInteger("Enter your Gender : ");
                                   String gender ;
                                   switch (gd){
                                       case 1 -> {
                                           gender = "Male" ;
                                       }
                                       case 2 -> {
                                           gender = "Female" ;
                                       }
                                       default -> throw new IllegalStateException();
                                   }
                                   DisplayUtil.DepartmentList();
                                   Integer optDp = InputUtil.getInteger("Enter your departmnt : ");
                                   String department ;
                                   String position ;
                                   System.out.println(optDp);
                                   switch (optDp){
                                       case 1 -> {
                                           department = "Human Resources";
                                           DisplayUtil.PositionOfHR();
                                           Integer optPst = InputUtil.getInteger("Enter your position : ");
                                           switch (optPst){
                                               case 1 -> {
                                                   position = "HR Manager";
                                               }
                                               case 2 -> {
                                                   position = "Recruitment Officer";
                                               }
                                               case 3 -> {
                                                   position = "Payroll Specialist";
                                               }
                                               default -> throw new IllegalStateException();
                                           }

                                       }
                                       case 2 -> {
                                           department = "Infomation Technology";
                                           DisplayUtil.PositionOfIT();
                                           Integer optPst = InputUtil.getInteger("Enter your position : ");
                                           switch (optPst){
                                               case 1 -> {
                                                   position = "Software Developer";
                                               }
                                               case 2 -> {
                                                   position = "System Administator";
                                               }
                                               case 3 -> {
                                                   position = "DevOps engineering";
                                               }
                                               default -> throw new IllegalStateException();
                                           }

                                       }
                                       case 3 -> {
                                           department = "Finance";
                                           DisplayUtil.PositionOfFinance();
                                           Integer optPst = InputUtil.getInteger("Enter your position : ");
                                           switch (optPst){
                                               case 1 -> {
                                                   position = "Accountant";
                                               }
                                               case 2 -> {
                                                   position = "Finacial Analyst";
                                               }
                                               case 3 -> {
                                                   position = "Payroll officer";
                                               }
                                               default -> throw new IllegalStateException();
                                           }

                                       }
                                       case 4 -> {
                                           department = "Sale & Marketing";
                                           DisplayUtil.PositionOfSaleAndMarketing();
                                           Integer optPst = InputUtil.getInteger("Enter your position : ");
                                           switch (optPst){
                                               case 1 -> {
                                                   position = "Sales Executive";
                                               }
                                               case 2 -> {
                                                   position = "Marketing Coordinator";
                                               }
                                               case 3 -> {
                                                   position = "Customer Relationship Manager";
                                               }
                                               default -> throw new IllegalStateException();
                                           }

                                       }
                                       case 5 -> {
                                           department = "Operation";
                                           DisplayUtil.PositionOfOperation();
                                           Integer optPst = InputUtil.getInteger("Enter your position : ");
                                           switch (optPst){
                                               case 1 -> {
                                                   position = "Operations Manager";
                                               }
                                               case 2 -> {
                                                   position = "Inventory Controller";
                                               }
                                               case 3 -> {
                                                   position = "Admin";
                                               }
                                               default -> throw new IllegalStateException();
                                           }

                                       }
                                       default -> throw new IllegalStateException();

                                   }
                                   Double salary = InputUtil.getDouble("Enter the Employee salary : ");
                                   String userName = InputUtil.getText("Enter the Employee Login userName : ");
                                   String pw = InputUtil.getText("Enter the Emplopyee password : ");
                                   String attendance = "Not yet take attendance" ;
                                   Employee newEmployee = new Employee(name , nationality , gender , department , position , salary, attendance , userName , pw);
                                   employeeService.updateEmployeeByID(id , newEmployee);
                                   DisplayUtil.showSuccessMsg("Student updated");

                               }
                               // done
                               case 6 -> {
                                   Integer id = InputUtil.getInteger("Enter ID to delete : ");
                                   employeeService.deleteEmployee(id);
                                   DisplayUtil.showSuccessMsg("Employee deleted");
                               }
                               // not yet
                               case 7 -> {
                                   DisplayUtil.printNewLine("""
                                                   |-----------------------------------|
                                                   |      Filtering by department      |          
                                                   |-----------------------------------|
                                                   """);
                                   DisplayUtil.DepartmentList();
                                   Integer opt = InputUtil.getInteger("Enter your option : ");
                                   switch (opt){
                                       case 1 -> {
                                           DisplayUtil.printNewLine("This is Employee in department Human resources");
                                           DisplayUtil.table(employeeService.FilteringDepartment("Human resources"));
                                       }
                                       case 2 -> {
                                           DisplayUtil.printNewLine("This is Employee in department Information Technology");
                                           DisplayUtil.table(employeeService.FilteringDepartment("Information Technology"));
                                       }
                                       case 3 -> {
                                           DisplayUtil.printNewLine("This is Employee in department Finance");
                                           DisplayUtil.table(employeeService.FilteringDepartment("Finance"));
                                       }
                                       case 4 -> {
                                           DisplayUtil.printNewLine("This is Employee in department Sale & Marketing");
                                           DisplayUtil.table(employeeService.FilteringDepartment("Sale & Marketing"));
                                       }
                                       case 5 -> {
                                           DisplayUtil.printNewLine("This is Employee in department Operation");
                                           DisplayUtil.table(employeeService.FilteringDepartment("Operation"));
                                       }
                                   }

                               }
                               // not yet
                               case 8 -> {
                                   DisplayUtil.printNewLine("""
                                                   |---------------------------------|
                                                   |      Filtering by position      |          
                                                   |---------------------------------|
                                                   """);
                                   DisplayUtil.PositionList();
                                   Integer opt = InputUtil.getInteger("Enter your option : ");
                                   switch (opt){
                                       case 1 -> {
                                           DisplayUtil.printNewLine("This is Employee in position HR Manager");
                                           DisplayUtil.table(employeeService.FilteringPosition("HR Manager"));
                                       }
                                       case 2 -> {
                                           DisplayUtil.printNewLine("This is Employee in position Recruitment Officer");
                                           DisplayUtil.table(employeeService.FilteringPosition("Recruitment Officer"));
                                       }
                                       case 3 -> {
                                           DisplayUtil.printNewLine("This is Employee in position Payroll Specialist");
                                           DisplayUtil.table(employeeService.FilteringPosition("Payroll Specialist"));
                                       }
                                       case 4 -> {
                                           DisplayUtil.printNewLine("This is Employee in position Software Developer");
                                           DisplayUtil.table(employeeService.FilteringPosition("Software Developer"));
                                       }
                                       case 5 -> {
                                           DisplayUtil.printNewLine("This is Employee in position System Administator");
                                           DisplayUtil.table(employeeService.FilteringPosition("System Administator"));
                                       }
                                       case 6 -> {
                                           DisplayUtil.printNewLine("This is Employee in position DevOps engineering");
                                           DisplayUtil.table(employeeService.FilteringPosition("DevOps engineering"));
                                       }

                                       case 7 -> {
                                           DisplayUtil.printNewLine("This is Employee in position Accountant");
                                           DisplayUtil.table(employeeService.FilteringPosition("Accountant"));
                                       }
                                       case 8 -> {
                                           DisplayUtil.printNewLine("This is Employee in position Finacial Analyst");
                                           DisplayUtil.table(employeeService.FilteringPosition("Finacial Analyst"));
                                       }
                                       case 9 -> {
                                           DisplayUtil.printNewLine("This is Employee in position Payroll officer");
                                           DisplayUtil.table(employeeService.FilteringPosition("Payroll officer"));
                                       }
                                       case 10 -> {
                                           DisplayUtil.printNewLine("This is Employee in position Sales Executive");
                                           DisplayUtil.table(employeeService.FilteringPosition("Sales Executive"));
                                       }
                                       case 11 -> {
                                           DisplayUtil.printNewLine("This is Employee in position Marketing Coordinator");
                                           DisplayUtil.table(employeeService.FilteringPosition("Marketing Coordinator"));
                                       }
                                       case 12 -> {
                                           DisplayUtil.printNewLine("This is Employee in position Customer Relationship Manager");
                                           DisplayUtil.table(employeeService.FilteringPosition("Customer Relationship Manager "));
                                       }
                                       case 13 -> {
                                           DisplayUtil.printNewLine("This is Employee in position Operations Manager");
                                           DisplayUtil.table(employeeService.FilteringPosition("Operations Manager"));
                                       }
                                       case 14 -> {
                                           DisplayUtil.printNewLine("This is Employee in position Inventory Controller");
                                           DisplayUtil.table(employeeService.FilteringPosition("Inventory Controller"));
                                       }
                                       case 15 -> {
                                           DisplayUtil.printNewLine("This is Employee in position Admin");
                                           DisplayUtil.table(employeeService.FilteringPosition("Admin"));
                                       }
                                   }
                               }
                               // not yet
                               case 9 -> {
                                   DisplayUtil.printNewLine("""
                                                   |---------------------------|
                                                   |     SALARY FILTERING      |      
                                                   |---------------------------|
                                                   """);
                                   Double salary = InputUtil.getDouble("Enter Employee salary to search : ");
                                   DisplayUtil.tableOneRow("1. ASC " , "2. DESC");
                                   int opt = InputUtil.getInteger("Enter option: ");
                                   Boolean isOrder = null;
                                   if (opt == 1)
                                       isOrder = true;
                                   else if(opt == 2) {
                                       isOrder = false;
                                   } else {
                                       System.out.println("option is invalid..!");
                                   }
                                   List<Employee> employees = employeeService.findEmployeeBySalary( salary, isOrder);
                                   DisplayUtil.table(employees);
                               }
                               // not yet
                               case 10 -> {
                                   DisplayUtil.printNewLine("""
                                                   |---------------------------------------|
                                                   |     EMPLOYEE ATTENDANCE OF THE DAY    |
                                                   |---------------------------------------|
                                                   """);
                                   List<Employee> employees = employeeService.ViewAllEmployee();
                                   DisplayUtil.tableForAttendance(employees);
                               }
                               // not yet
                               case 11 -> {
                                   DisplayUtil.printNewLine("""
                                                   |---------------------------------------|
                                                   |     TAKE ATTENDANCE FOR EMPLOYEE      |
                                                   |---------------------------------------|
                                                   """);
                                   Integer id = InputUtil.getInteger("Enter Employee ID to take the attendance : ");
                                   Employee employee =  employeeService.SearchEmployeeByID(id);
                                   DisplayUtil.tableForAttendanceAdmin();
                                   Integer opt = InputUtil.getInteger("Enter your option : ");
                                   switch (opt){
                                       case 1 -> {
                                           employee.setAttendance("PM");
                                       }
                                       case 2 -> {
                                           employee.setAttendance("A");
                                       }
                                   }




                               }
                               case 0 -> backToMain = false;
                               default -> throw new IllegalStateException();
                           }
                       }while(backToMain);
                   }else {
                       System.out.println("Invalid admin credentials.");
                   }

                }
                case 2 -> {

                    DisplayUtil.printNewLine(DisplayUtil.LoginForm);
                    String nameLog = InputUtil.getText("Enter your Username : ");
                    String password = InputUtil.getText("Enter your password : ");
                    Employee empLog = employeeService.employeeLogin(nameLog , password);

                   if ( empLog != null){
                       boolean backToMain = true;
                       do {
                           DisplayUtil.printNewLine(DisplayUtil.EmployeeMenu);
                           DisplayUtil.printNewLine("Welcome " + empLog.getName());
                           int EmployeeOpt = InputUtil.getInteger("Please Enter your option : ");
                           switch (EmployeeOpt){
                               case 1 -> {
                                   DisplayUtil.printNewLine("""
                                                   |-----------------------------------|
                                                   |    YOUR ATTENDANCE FOR TODAY      |    
                                                   |-----------------------------------|
                                                   """);
                                   DisplayUtil.printNewLine("Your attendance status : " + empLog.getAttendance());
                               }
                               case 2 -> {
                                   String rating ;
                                   if (empLog.getPerformancerating() != null) {
                                       rating = empLog.getPerformancerating().toString() + "%";
                                   } else {
                                       rating = "not rating yet";
                                   }
                                   DisplayUtil.printNewLine("Dear " + empLog.getName() + " this is your rating : " + rating);
                               }
                               case 3 -> {
                                   DisplayUtil.printNewLine("""
                                                   |------------------------------|
                                                   |     TAKE YOUR ATTENDANCE     |
                                                   |------------------------------|
                                                   """);
                                   DisplayUtil.tableForAttendanceEmployee();
                                   Integer opt = InputUtil.getInteger("Enter your option : ");
                                   switch (opt){
                                       case 1 -> {
                                           empLog.setAttendance("P");
                                       }
                                       case 2 -> {
                                           empLog.setAttendance("PL");
                                       }
                                       case 3 -> {
                                           empLog.setAttendance("SL");
                                       }
                                       case 4 -> {
                                           empLog.setAttendance("H");
                                       }
                                   }
                               }
                               case 0 -> backToMain = false;
                               default -> throw new IllegalStateException();
                           }
                       }while(backToMain);
                   }else {
                       System.out.println("Invalid employee credentials.");
                   }


                }
                case 0 -> System.exit(0);
                default -> throw new IllegalStateException();
            }
        }while(true);






    }
  
}
