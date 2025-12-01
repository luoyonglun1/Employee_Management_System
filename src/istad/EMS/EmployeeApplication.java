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

                       DisplayUtil.printNewLine("******** Welcome Admin " + adminLog.getName() + " ********");
                       do {
                           DisplayUtil.printNewLine(DisplayUtil.AdminMenu);
                           int adminOpt =  InputUtil.getInteger("Please Enter your option : ");

                           switch (adminOpt){
                               // done
                               case 1 -> {
                                   DisplayUtil.printNewLine("------------------------------------------------------------ EMPLOYEE LIST -------------------------------------------------------------------");
                                   DisplayUtil.table(employeeService.ViewAllEmployee());
                               }
                               // not yet done
                               case 2 -> {
                                   Boolean isTrue = true ;
                                   Integer searchOpt ;
                                   DisplayUtil.printNewLine(DisplayUtil.SearchOpt);
                                   DisplayUtil.tableOneRow("1. Search by ID " , "2. Search by Name ");
                                   do {
                                       searchOpt = InputUtil.getInteger("Enter your Option : ");
                                       if (searchOpt == 1 ){
                                           searchOpt = 1;
                                           isTrue = false ;
                                       } else if (searchOpt == 2) {
                                           searchOpt = 2;
                                           isTrue = false;
                                       }else {
                                           DisplayUtil.printNewLine("Invalid Option!! Please choose option between 1 and 2");
                                       }
                                   }while (isTrue);
//
                                   switch (searchOpt){

                                       case 1 -> {
                                           DisplayUtil.printNewLine("""
                                                   |-----------------------|
                                                   |     Search By ID      |
                                                   |-----------------------|
                                                   """);
                                           List<Employee> employees = employeeService.ViewAllEmployee();
                                           Integer id;
                                           boolean valid = false;

                                           while (!valid) {
                                               id = InputUtil.getInteger("Enter Employee ID : ") ;
                                               final Integer finalId = id;
                                               valid = employees.stream().anyMatch(emp -> emp.getId().equals(finalId));
                                               if (!valid) {
                                                   System.out.println("Employee with ID " + id + " not found!!");
                                               } else {
                                                   Employee employee = employeeService.SearchEmployeeByID(id) ;
                                                   DisplayUtil.tableForNonCount(employee);
                                               }
                                           }
                                       }
                                       case 2 -> {
                                           List<Employee> employees = employeeService.ViewAllEmployee();
                                           String name ;
                                           boolean valid = false;

                                           while (!valid) {
                                               name = InputUtil.getTextOnly("Enter the Employee name : ");
                                               final String finalName = name;

//                                               valid = employees.stream().anyMatch(emp -> emp.getName().equals(employeeService.SearchEmployeeByName(finalName)));
                                               List<Employee> foundEmployees1 = employeeService.SearchEmployeeByName(finalName);
                                               valid = !foundEmployees1.isEmpty();

                                               if (!valid) {
                                                   System.out.println("Employee name " + name + " not found!!");
                                               } else {
                                                   List<Employee> foundEmployees = employeeService.SearchEmployeeByName(finalName);
                                                   DisplayUtil.tableForList(foundEmployees);
                                               }
                                           }
                                       }
                                     default -> DisplayUtil.printNewLine("Invalid Option!! Please Enter Option from 1 Or 2");
                                   }
                               }
                               // not yet
                               case 3 -> {
                                  DisplayUtil.printNewLine(DisplayUtil.Ratingmenu);
                                  DisplayUtil.tableOneRow("1. Rate Employee not get rating yet" , "2. Change Employee rating");
                                  Boolean isTrue = true ;
                                  Integer opt ;
                                  do {
                                      opt = InputUtil.getInteger("Enter your option : ");
                                      if (opt == 1){
                                          opt = 1;
                                          isTrue = false ;
                                      } else if (opt == 2) {
                                          opt = 2 ;
                                          isTrue = false;
                                      }else {
                                          DisplayUtil.printNewLine("Invalid Option!! Please choose option between 1 and 2.");
                                      }
                                  }while(isTrue);

                                   switch (opt){
                                       case 1 -> {
                                           DisplayUtil.table(employeeService.FilteringNotYetRating());
                                           List<Employee> employees = employeeService.FilteringNotYetRating();

                                           Integer id;
                                           boolean valid = false;

                                           while (!valid) {
                                               id = InputUtil.getInteger("Enter Employee ID : ") ;
                                               final Integer finalId = id;
                                               valid = employees.stream().anyMatch(emp -> emp.getId().equals(finalId));
                                               if (!valid) {
                                                   System.out.println(" Invalid ID. Please enter an ID from the list above.");
                                               } else {
                                                   DisplayUtil.tableForNonCount(employeeService.SearchEmployeeByID(id));
                                                   Integer percentage = InputUtil.getInteger("Enter their performance 0 -> 100% : ");
                                                   employeeService.ratingEmployee(id , percentage);
                                               }
                                           }

                                       }
                                       case 2 -> {
                                           DisplayUtil.table(employeeService.FilteringRatedEmployee());
                                           List<Employee> employees = employeeService.FilteringRatedEmployee();

                                           Integer id;
                                           boolean valid = false;

                                           while (!valid) {
                                               id = InputUtil.getInteger("Enter Employee ID : ") ;
                                               final Integer finalId = id;
                                               valid = employees.stream().anyMatch(emp -> emp.getId().equals(finalId));
                                               if (!valid) {
                                                   System.out.println(" Invalid ID. Please enter an ID from the list above.");
                                               } else {
                                                   DisplayUtil.tableForNonCount(employeeService.SearchEmployeeByID(id));
                                                   Integer percentage = InputUtil.getInteger("Enter their performance 0 -> 100% : ");
                                                   employeeService.ratingEmployee(id , percentage);
                                               }
                                           }
                                       }
                                   }

                               }
                               // done
                               case 4 -> {
                                   String name = InputUtil.getTextOnly("Enter your name : ");
                                   DisplayUtil.printNewLine("Enter your Birth Date! ");

//                                   int year;
//                                   do {
//                                       year = InputUtil.getInteger("Enter your birth year : ");
//                                       if (year >= 1950 && year <= 2025) {
//                                           System.out.println("Year must be less than 2025.");
//                                       }
//                                   } while (year >= 2025);

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

                                   LocalDate age = LocalDate.of(year, month, day);

                                   String nationality = InputUtil.getTextOnly("Enter your nationality : ");

                                   String gender = null;
                                   int gd;
                                   DisplayUtil.tableOneRow("1. Male", "2. Female");
                                   do {
                                       gd = InputUtil.getInteger("Enter your Gender : ");

                                       switch (gd) {
                                           case 1 -> gender = "Male";
                                           case 2 -> gender = "Female";
                                           default -> System.out.println("Invalid input. Please enter 1 for Male or 2 for Female.");
                                       }
                                   } while (gender == null);

                                   int optDp;
                                   String department = null;
                                   String position = null;


                                   DisplayUtil.DepartmentList();
                                   do {
                                       optDp = InputUtil.getInteger("Enter your department : ");

                                       if (optDp < 1 || optDp > 5) {
                                           System.out.println("Invalid option. Please enter a number between 1 and 5.");
                                       }
                                   } while (optDp < 1 || optDp > 5);

                                   switch (optDp) {
                                       case 1 -> {
                                           department = "Human Resources";
                                           DisplayUtil.PositionOfHR();
                                           Integer optPst;
                                           do {
                                               optPst = InputUtil.getInteger("Enter your position : ");
                                               if (optPst < 1 || optPst > 3) {
                                                   System.out.println("Invalid position. Please enter 1, 2, or 3.");
                                               }
                                           } while (optPst < 1 || optPst > 3);

                                           switch (optPst) {
                                               case 1 -> {
                                                   position = "HR Manager";
                                               }
                                               case 2 -> {
                                                   position = "Recruitment Officer";
                                               }
                                               case 3 -> {
                                                   position = "Payroll Specialist";;
                                               }
                                           }
                                       }
                                       case 2 -> {
                                           department = "Infomation Technology";
                                           DisplayUtil.PositionOfIT();
                                           Integer optPst;
                                           do {
                                               optPst = InputUtil.getInteger("Enter your position : ");
                                               if (optPst < 1 || optPst > 3) {
                                                   System.out.println("Invalid position. Please enter 1, 2, or 3.");
                                               }
                                           } while (optPst < 1 || optPst > 3);

                                           switch (optPst) {
                                               case 1 -> {
                                                   position = "Software Developer";
                                               }
                                               case 2 -> {
                                                   position = "System Administator";
                                               }
                                               case 3 -> {
                                                   position = "DevOps engineering";
                                               }
                                           }
                                       }
                                       case 3 -> {
                                           department = "Finance";
                                           DisplayUtil.PositionOfFinance();
                                           Integer optPst;
                                           do {
                                               optPst = InputUtil.getInteger("Enter your position : ");
                                               if (optPst < 1 || optPst > 3) {
                                                   System.out.println("Invalid position. Please enter 1, 2, or 3.");
                                               }
                                           } while (optPst < 1 || optPst > 3);

                                           switch (optPst) {
                                               case 1 -> {
                                                   position = "Accountant";
                                               }
                                               case 2 -> {
                                                   position = "Finacial Analyst";
                                               }
                                               case 3 -> {
                                                   position = "Payroll officer";
                                               }
                                           }
                                       }
                                       case 4 -> {
                                           department = "Sale & Marketing";
                                           DisplayUtil.PositionOfSaleAndMarketing();
                                           Integer optPst;
                                           do {
                                               optPst = InputUtil.getInteger("Enter your position : ");
                                               if (optPst < 1 || optPst > 3) {
                                                   System.out.println("Invalid position. Please enter 1, 2, or 3.");
                                               }
                                           } while (optPst < 1 || optPst > 3);

                                           switch (optPst) {
                                               case 1 -> {
                                                   position = "Sales Executive";
                                               }
                                               case 2 -> {
                                                   position = "Marketing Coordinator";
                                               }
                                               case 3 -> {
                                                   position = "Customer Relationship Manager";
                                               }
                                           }
                                       }
                                       case 5 -> {
                                           department = "Operation";
                                           DisplayUtil.PositionOfOperation();


                                           Integer optPst;
                                           do {
                                               optPst = InputUtil.getInteger("Enter your position : ");
                                               if (optPst < 1 || optPst > 3) {
                                                   System.out.println("Invalid position. Please enter 1, 2, or 3.");
                                               }
                                           } while (optPst < 1 || optPst > 3);

                                           switch (optPst) {
                                               case 1 -> {
                                                   position = "Operations Manager";
                                               }
                                               case 2 -> {
                                                   position = "Inventory Controller";
                                               }
                                               case 3 -> {
                                                   position = "Admin";
                                               }
                                           }
                                       }
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
                                   List<Employee> employees = employeeService.ViewAllEmployee();

                                   Integer id;
                                   boolean valid = false;

                                   while (!valid) {
                                       id = InputUtil.getInteger("Please Enter Employee ID to update information :");
                                       final Integer finalId = id;
                                       valid = employees.stream().anyMatch(emp -> emp.getId().equals(finalId));
                                       if (!valid) {
                                           System.out.println(" Invalid ID. Please enter ID again.");
                                       } else {
                                           DisplayUtil.tableForNonCount(employeeService.SearchEmployeeByID(id));
                                           String name = InputUtil.getTextOnly("Enter your name : ");
                                           String nationality = InputUtil.getTextOnly("Enter your nationality : ");

                                           String gender = null;
                                           int gd;
                                           DisplayUtil.tableOneRow("1. Male", "2. Female");
                                           do {
                                               gd = InputUtil.getInteger("Enter your Gender : ");

                                               switch (gd) {
                                                   case 1 -> gender = "Male";
                                                   case 2 -> gender = "Female";
                                                   default -> System.out.println("Invalid input. Please enter 1 for Male or 2 for Female.");
                                               }
                                           } while (gender == null);


                                           int optDp;
                                           String department = null;
                                           String position = null;


                                           DisplayUtil.DepartmentList();
                                           do {
                                               optDp = InputUtil.getInteger("Enter your department : ");

                                               if (optDp < 1 || optDp > 5) {
                                                   System.out.println("Invalid option. Please enter a number between 1 and 5.");
                                               }
                                           } while (optDp < 1 || optDp > 5);

                                           switch (optDp) {
                                               case 1 -> {
                                                   department = "Human Resources";
                                                   DisplayUtil.PositionOfHR();
                                                   Integer optPst;
                                                   do {
                                                       optPst = InputUtil.getInteger("Enter your position : ");
                                                       if (optPst < 1 || optPst > 3) {
                                                           System.out.println("Invalid position. Please enter 1, 2, or 3.");
                                                       }
                                                   } while (optPst < 1 || optPst > 3);

                                                   switch (optPst) {
                                                       case 1 -> {
                                                           position = "HR Manager";
                                                       }
                                                       case 2 -> {
                                                           position = "Recruitment Officer";
                                                       }
                                                       case 3 -> {
                                                           position = "Payroll Specialist";;
                                                       }
                                                   }
                                               }
                                               case 2 -> {
                                                   department = "Infomation Technology";
                                                   DisplayUtil.PositionOfIT();
                                                   Integer optPst;
                                                   do {
                                                       optPst = InputUtil.getInteger("Enter your position : ");
                                                       if (optPst < 1 || optPst > 3) {
                                                           System.out.println("Invalid position. Please enter 1, 2, or 3.");
                                                       }
                                                   } while (optPst < 1 || optPst > 3);

                                                   switch (optPst) {
                                                       case 1 -> {
                                                           position = "Software Developer";
                                                       }
                                                       case 2 -> {
                                                           position = "System Administator";
                                                       }
                                                       case 3 -> {
                                                           position = "DevOps engineering";
                                                       }
                                                   }
                                               }
                                               case 3 -> {
                                                   department = "Finance";
                                                   DisplayUtil.PositionOfFinance();
                                                   Integer optPst;
                                                   do {
                                                       optPst = InputUtil.getInteger("Enter your position : ");
                                                       if (optPst < 1 || optPst > 3) {
                                                           System.out.println("Invalid position. Please enter 1, 2, or 3.");
                                                       }
                                                   } while (optPst < 1 || optPst > 3);

                                                   switch (optPst) {
                                                       case 1 -> {
                                                           position = "Accountant";
                                                       }
                                                       case 2 -> {
                                                           position = "Finacial Analyst";
                                                       }
                                                       case 3 -> {
                                                           position = "Payroll officer";
                                                       }
                                                   }
                                               }
                                               case 4 -> {
                                                   department = "Sale & Marketing";
                                                   DisplayUtil.PositionOfSaleAndMarketing();
                                                   Integer optPst;
                                                   do {
                                                       optPst = InputUtil.getInteger("Enter your position : ");
                                                       if (optPst < 1 || optPst > 3) {
                                                           System.out.println("Invalid position. Please enter 1, 2, or 3.");
                                                       }
                                                   } while (optPst < 1 || optPst > 3);

                                                   switch (optPst) {
                                                       case 1 -> {
                                                           position = "Sales Executive";
                                                       }
                                                       case 2 -> {
                                                           position = "Marketing Coordinator";
                                                       }
                                                       case 3 -> {
                                                           position = "Customer Relationship Manager";
                                                       }
                                                   }
                                               }
                                               case 5 -> {
                                                   department = "Operation";
                                                   DisplayUtil.PositionOfOperation();


                                                   Integer optPst;
                                                   do {
                                                       optPst = InputUtil.getInteger("Enter your position : ");
                                                       if (optPst < 1 || optPst > 3) {
                                                           System.out.println("Invalid position. Please enter 1, 2, or 3.");
                                                       }
                                                   } while (optPst < 1 || optPst > 3);

                                                   switch (optPst) {
                                                       case 1 -> {
                                                           position = "Operations Manager";
                                                       }
                                                       case 2 -> {
                                                           position = "Inventory Controller";
                                                       }
                                                       case 3 -> {
                                                           position = "Admin";
                                                       }
                                                   }
                                               }
                                           }





//
                                           Double salary = InputUtil.getDouble("Enter the Employee salary : ");
                                           String userName = InputUtil.getText("Enter the Employee Login userName : ");
                                           String pw = InputUtil.getText("Enter the Emplopyee password : ");
                                           String attendance = "Not yet take attendance" ;
                                           Employee newEmployee = new Employee(name , nationality , gender , department , position , salary, attendance , userName , pw);
                                           employeeService.updateEmployeeByID(id , newEmployee);
                                           DisplayUtil.showSuccessMsg("Student updated");

                                       }
                                   }










                               }
                               // done
                               case 6 -> {



                                   List<Employee> employees = employeeService.ViewAllEmployee();

                                   Integer id;
                                   boolean valid = false;

                                   while (!valid) {
                                       id = InputUtil.getInteger("Enter ID to delete : ");
                                       final Integer finalId = id;
                                       valid = employees.stream().anyMatch(emp -> emp.getId().equals(finalId));
                                       if (!valid) {
                                           System.out.println(" Invalid ID. Please enter ID again.");
                                       } else {
                                           employeeService.deleteEmployee(id);
                                           DisplayUtil.showSuccessMsg("Employee deleted");
                                       }
                                   }
                               }
                               // not yet
                               case 7 -> {
                                   DisplayUtil.printNewLine("""
                                                   |-----------------------------------|
                                                   |      Filtering by department      |          
                                                   |-----------------------------------|
                                                   """);



                                   int opt;
                                   String department = null;



                                   DisplayUtil.DepartmentList();
                                   do {
                                     opt = InputUtil.getInteger("Enter your option : ");

                                       if (opt < 1 || opt > 5) {
                                           System.out.println("Invalid option. Please enter a number between 1 and 5.");
                                       }
                                   } while (opt < 1 || opt > 5);






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
                                       default -> DisplayUtil.printNewLine("Invalid Option!! Please Enter Option from 1 -> 5");
                                   }

                               }
                               // not yet
                               case 8 -> {
                                   DisplayUtil.printNewLine("""
                                                   |---------------------------------|
                                                   |      Filtering by position      |          
                                                   |---------------------------------|
                                                   """);



                                   int opt;
                                   String department = null;



                                   DisplayUtil.PositionList();
                                   do {
                                       opt = InputUtil.getInteger("Enter your option : ");

                                       if (opt < 1 || opt > 15) {
                                           System.out.println("Invalid option. Please enter a number between 1 and 15.");
                                       }
                                   } while (opt < 1 || opt > 15);

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
                                       default -> DisplayUtil.printNewLine("Invalid Option!! Please Enter Option from 1 -> 15");
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
                                   int opt;
                                   do {
                                       opt = InputUtil.getInteger("Enter your option : ");

                                       if (opt < 1 || opt > 2) {
                                           System.out.println("Invalid option. Please enter a number between 1 and 2.");
                                       }
                                   } while (opt < 1 || opt > 2);

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


                                   List<Employee> employees = employeeService.ViewAllEmployee();
                                   Integer id;
                                   boolean valid = false;

                                   while (!valid) {
                                       id = InputUtil.getInteger("Enter Employee ID to take the attendance : ");
                                       final Integer finalId = id;
                                       valid = employees.stream().anyMatch(emp -> emp.getId().equals(finalId));
                                       if (!valid) {
                                           System.out.println("Employee with ID " + id + " not found!!");
                                       } else {


                                           Boolean isTrue = true ;
                                           Integer opt ;
                                           Employee employee =  employeeService.SearchEmployeeByID(id);
                                           DisplayUtil.tableForNonCount(employee);
                                           DisplayUtil.tableForAttendanceAdmin();
                                           do {
                                               opt = InputUtil.getInteger("Enter your option : ");
                                               if (opt == 1 ){
                                                   employee.setAttendance("PM");
                                                   isTrue = false ;
                                               } else if (opt == 2) {
                                                   employee.setAttendance("A");
                                                   isTrue = false;
                                               } else if (opt == 3) {
                                                   employee.setAttendance("P");
                                                   isTrue = false;
                                               } else if (opt == 4) {
                                                   employee.setAttendance("PL");
                                                   isTrue = false;
                                               } else if (opt == 5) {
                                                   employee.setAttendance("SL");
                                                   isTrue = false;
                                               } else if (opt == 6    ) {
                                                   employee.setAttendance("H");
                                                   isTrue = false;
                                               }
                                               else {
                                                   DisplayUtil.printNewLine("Invalid Option!! Please choose option between 1 and 6");
                                               }
                                           }while (isTrue);

                                       }
                                       }
                                   }
                               case 12 -> {
                                   DisplayUtil.printNewLine("""
                                                   |------------------------------|
                                                   |     EMPLOYEES REQUSTION      |    
                                                   |------------------------------|
                                                   """);
                                   List<Employee> employees = employeeService.ViewAllEmployee();
                                   DisplayUtil.tableForGetRequest(employees);
                               }
                               case 0 -> backToMain = false;
                               default -> DisplayUtil.printNewLine("Invalid Option!! Please Enter option from 0 -> 12 ");
                           }
                       }while(backToMain);
                   }else {
                       System.out.println("Username or Password is incorrect");
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

                                   int opt;
                                   do {
                                       opt = InputUtil.getInteger("Enter your option : ");

                                       if (opt < 1 || opt > 5) {
                                           System.out.println("Invalid option. Please enter a number between 1 and 2.");
                                       }
                                   } while (opt < 1 || opt > 5);

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
                               case 4 -> {
                                   DisplayUtil.printNewLine("""
                                                   |---------------------------------|
                                                   |    YOUR PERSONAL INFORMATION    |    
                                                   |---------------------------------|
                                                   """);
                                   DisplayUtil.tableForNonCount(empLog);
                               }
                               case 5 -> {
                                   DisplayUtil.printNewLine("""
                                                   |-----------------------------|
                                                   |    SEND REQUEST TO ADMIN    |    
                                                   |-----------------------------|
                                                   """);
                                   String request = InputUtil.getText("Dear "+ empLog.getName() +" Pleas write your request : ");
                                   DisplayUtil.printNewLine("Message request send successfully");
                                   employeeService.sendRequestToAdmin(empLog , request);
                               }

                               case 0 -> backToMain = false;
                               default -> DisplayUtil.printNewLine("Invalid Option!! Please Enter option from 0 -> 5 ");
                           }
                       }while(backToMain);
                   }else {
                       System.out.println("Username or Password is incorrect");
                   }
                }
                case 0 -> System.exit(0);
                default -> DisplayUtil.printNewLine("Invalid Option!! Please Enter option from 0 -> 5 ");
            }
        }while(true);
    }
  
}
