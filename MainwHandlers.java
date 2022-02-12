public class MainwHandlers {
    /**
     * Main example w handlers
     */

import java.util.Scanner;

    public class Main {
        // Begin Main

        //Instantiates a class level instance of the array manager
        public static EmployeeManager em = new EmployeeManager();

        public static void main(String[] args)
        { //begin main
            // EmployeeManager em = new EmployeeManager();
            em.loadEmployees();
            menu();

        } //end main

        public static void menu()
        {
            int selection = 0;
            Scanner kb = new Scanner(System.in);

            while (selection != 7)
            {
                System.out.println("\t\tEmployee Array API\n");
                System.out.println("1 ===> To List Employees");
                System.out.println("2 ===> To Add an Employee");
                System.out.println("3 ===> To Save Employees");
                System.out.println("4 ===> To Load Employees");
                System.out.println("5 ===> To Search for Employee");
                System.out.println("6 ===> To Delete an Employee");
                System.out.println("7 ===> To Exit System");

                selection = kb.nextInt();
                if (selection == 1)
                {
                    System.out.println("You selected to list all Employees \n\n");
                    em.print();
                } // end IF (Selection = 1)

                else if (selection == 2)
                {
                    System.out.println("You selected to Add Employees \n\n");
                    Employee newEmployee;
                    newEmployee = em.getAnEmployee();
                    em.append(newEmployee);

                } // end IF (Selection = 2)

                else if (selection == 3)
                {
                    System.out.println("You selected to Save all Employees \n\n");
                    em.saveEmployees();
                } // end IF (Selection = 3)

                else if (selection == 4)
                {
                    System.out.println("You selected to Load All Current Employees \n\n");
                    em.loadEmployees();
                } // end IF (Selection = 4)

                else if (selection == 5)
                {
                    System.out.println("You selected to Search for an Employee in the Array \n\n");
                    System.out.println("\n\n");
                    Employee emp;
                    emp = getEmployeeIDObject(); // return the ID we want to find
                    int status; // holds search status, returns 0 if found

                    if (emp == null)
                    {
                        System.out.println("Problem with employee record");
                    }
                    else
                    {
                        status = em.seqSearch(emp);
                        System.out.println("The status of the search is: " + status);
                    }

                } // end IF (Selection = 5)

                else if (selection == 6)
                {
                    System.out.println("You selected to delete an Employee \n\n");
                    deleteEmployee(em);
                } // end IF (Selection = 6)

                else if (selection == 7)
                {
                    System.out.println("You selected to Exit the System \n\n");
                } // end IF (Selection = 7)

            } // end WHILE (selection != 7)
            kb.close();

        } // end menu

        // This method gets Employee Criteria for Employee Object Array Search
        // The main criteria is Employee ID

        public static Employee getEmployeeIDObject()
        {
            Employee temp = null;
            int empID;
            Scanner kb = new Scanner(System.in);
            String response;

            //obtains employee ID
            System.out.println("Please enter the ID for the employee you like to locate:  \n");
            empID = kb.nextInt();

            //Echoes the users input and confirms validity
            System.out.println("Is this the Employee Number you would like to find: " + empID);
            response = kb.next();

            //Evaluate the user response
            if (response.toUpperCase().equals("Y"))
            {
                temp = new Employee();
                temp.setEmployeeID(empID);
            } // end IF (response.toUpperCase().equals("Y"))
            return temp; //return Employee object state

        } // end getEmployeeIDObject

        // this method obtains the search key to locate an Employee in the array.
        // It then locates the employee in the array. If the Employee is in the Array it
        // will remove the element from the array. Prior to removing the element
        // the method will obtain final user approval and invoke
        // another method that will receive and remove the element by shifting all
        // elements below it up by one location.

        public static void deleteEmployee(EmployeeManager em)
        {
            System.out.println("Application to Remove an Employee");
            Scanner kb; // Keyboard Input Tool
            kb = new Scanner(System.in);

            Employee emp; // Temp Employee Object
            int empID;    // Employee ID
            int position; // Location found in the array
            String confirmation; // Confirm to Delete

            // Get Employee ID to delete
            System.out.println("What is the Employee ID that you would like to remove?");
            empID = kb.nextInt();

            // Instantiate an Employee object for the search that has the ID of
            // the employee ID you need to match for deletion
            emp = new Employee();
            emp.setEmployeeID(empID);
            position = em.seqSearch((emp));

            // If the value is not negative the object is located
            if (position >= 0)
            {
                System.out.println("Employee has been located\n");
                System.out.println("Are you sure you want to delete this employee" +
                        "from the system?\n");
                confirmation = kb.next();

                // Sends the position to the removeAt method to remove the item
                if (confirmation.toUpperCase().equals("Y"))
                {
                    em.removeAt(position);
                } // end IF (confirmation.toUpperCase().equals("Y"))
            } // end IF (position >= 0)

        } // end deleteEmployee


    }

}
