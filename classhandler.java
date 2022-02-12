package com.company;

        import java.io.File;
        import java.io.PrintWriter;
        import java.util.Scanner;

/**
 * Class Handler
 *
 * This is a program with diffrent examplles of handler functions for classes
 *
 * includes a set of constructors and default handlers
 */

public class classhandler
{
    protected int length; //store the size of the list
    protected int maxSize; //store the max size of the list
    protected Employee [] list; //Array to hold list objects

    // place the definitions of the instance methods here

    // main Constructor for handler
    public EmployeeManager()
    {
        length = 0;
        maxSize = 10;
        list = new Employee[maxSize];
    }
    public EmployeeManager(int size)
    {
        if (size <= 0)
        {
            System.err.println("The array size must be positive "
                    + "Creating an array of size 100. ");
            maxSize = 100;
        }else
            maxSize = size;
        length = 0;
        list = new Employee[maxSize];
    }

    // append method
    public void append(Employee newEmployee)
    {

        if (length == maxSize)
        {
            System.err.println("Cannot insert in a full list");
        }
        else
        {
            //list is empty
            list[length] = newEmployee; //insert insert item
            length++;                   //increment length
        } //end append
    }
    // ************************************************************************** Loads data from file
    public void loadEmployees()
    {
        //load employee begins
        //First item is first name
        //Second item is last name
        //Third item is email
        //Fourth item is Employee ID
        //Fifth item is Phone Number

        Employee temp = new Employee();
        try
        {
            File file = new File("testdata.txt");
            Scanner empData = new Scanner(file);

            while (empData.hasNext())
            {
                //start While
                String record = empData.nextLine();
                String[] fields = record.split(",");
                temp.setFirstName(fields[0]);
                temp.setLastName(fields[1]);
                temp.setEmail(fields[2]);
                temp.setEmployeeID(Integer.parseInt(fields[3]));
                temp.setPhoneNumber(fields[4]);
                append(temp);
                //end While
            }
            print();
        } //end try
        catch(Exception e)
        {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }
    //************************************************************************************Prints array data to screen
    public void print()
    {
        int count = 0;
        while (count < length)
        {
            System.out.println(list[count].toString());
            count++;
        }
    }
    //**********************************************************************Saves data to an object after confirmation
    public Employee getAnEmployee()
    {
        Scanner kb = new Scanner(System.in);
        String first;              //first name of an employee
        String last;               //last name of an employee
        String email;              //Email of an employee
        String phone;              //phone number of an employee
        int empnum;                //employee number
        Employee emp;              //Employee Object to Return
        String informationCorrect; //User response for correctness

        emp = new Employee();
        System.out.println("Get an Employee Record \n");
        System.out.println("This Module adds an employee record to the system.");

        System.out.println("Enter Employee ID: \n");
        empnum = kb.nextInt();

        System.out.println("Enter Employee First Name: \n");
        first = kb.next();

        System.out.println("Enter Employee Last Name: \n");
        last = kb.next();

        System.out.println("Enter Employee email: \n");
        email = kb.next();

        System.out.println("Enter Employee phone: \n");
        phone = kb.next();

        //Display Data User Entered for Verification
        System.out.println("The following information was entered \n\n ");

        System.out.println("Enter Employee ID: " + empnum );
        System.out.println("Enter Employee FirstName: " + first );
        System.out.println("Enter Employee Last Name: " + last );
        System.out.println("Enter Employee email: " + email );
        System.out.println("Enter Employee phone: " + phone );

        System.out.println("\n Is the information entered correct \n");
        informationCorrect = kb.next();

        informationCorrect = informationCorrect;

        //If info is correct Load Employee Class Object with confirmed Information
        if (informationCorrect.equals("Y"))
        {
            emp.setEmployeeID(empnum);
            emp.setLastName(first);
            emp.setLastName(last);
            emp.setEmail(email);
            emp.setPhoneNumber(phone);
            System.out.println("\n The Employee was added successfully.");
        } //end if

        return emp;
    } // end getAnEmployee
//************************************************************************************Saves loaded data to a text file
    public void saveEmployees()
    {
        //load employee begins
        //First item is first name
        //Second item is last name
        //Third item is email
        //Fourth item is Employee ID
        //Fifth item is Phone Number

        try
        {
            File file = new File("employeeData.txt");
            PrintWriter pw = new PrintWriter(file);
            int count = 0;
            //Employee temp;1

            String printline = "";

            while (count < length)
            {
                Employee temp = null;
                printline = "";
                temp = new Employee();
                temp = list[count];
                printline = printline + temp.getFirstName() + ",";
                printline = printline + temp.getLastName() + ",";
                printline = printline + temp.getEmail() + ",";
                printline = printline + temp.getEmployeeID() + ",";
                printline = printline + temp.getPhoneNumber();

                pw.println(printline);
                System.out.println(printline);
                count = count + 1;

            }// end WHILE (count < length)
            pw.close();
        } // end TRY
        catch (Exception e)
        { // Begin Catch
            System.out.println(e.getMessage());
            e.printStackTrace();
        } // end Catch
    } // end saveEmployees()
    //*****************************************************************************************Seq Search module
    // The purpose of this method is to receive data representing an employee object
    // the method will then search the array attempting to locate a match
    // if a match is found, the index of the element is returned by the method
    // if a match is not found then a negative number is returned
    // to Java an index position cannot be negative
    // a negative value indicates the element was not located in the array
    // this method will also become a utility method for the Retrieve operation
    // ths method will also become a utility method for delete operations

    public int seqSearch(Employee searchItem)
    {
        int loc;
        boolean found = false;
        for (loc = 0; loc < length; loc++)
            if (list[loc].equals(searchItem))
            {
                found = true;
                break;
            }
        if (found)
            return loc;
        else
            return -1;
    } //end seq search
    //********************************************************************************Removes an object from the array
    // This method receives the location of an Employee to remove
    // This location will determine the starting point of the elements
    // that need to be advanced one position within the array
    // This advancement will overwrite the element that should be deleted
    // This is a foundational Algorithm for element removal in an array
    // In short: Won't just delete and leave wasted elements in space and memory.

    public void removeAt(int location)
    {
        // If location passed in is invalid this will display an error message
        if (location < 0 || location >= length)
        {
            System.err.println("The location of the item to be removed is " +
                    "out of range.");
        } // end IF (location < 0 || location >= length)

        // If the location passed is a valid int within the range of
        // possible index positions, the items below it are shifted up on position
        // in the array. This will overwrite the item to be removed.
        else
        {
            for (int i = location; i < length -1; i++)
                list[i] = list[i + i];
            list[length - 1] = null;
            length--;

        } // end ELSE
    } // end removeAt

} // end Employee manager
