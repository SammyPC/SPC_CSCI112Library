/**
 * Subclass example
 *
 * Describe subclass functions
 *
 * includes a set of constructors and default handlers
 */

public class subclass extends Superclass{
    private int employeeID;
    private String email;
    private String phoneNumber;

    /**
     * This method generates an empty Employee object
     */
    public Employee()
    {
    } // end no-Arg Constructor

    /**
     * This method generates an empty Person object and accpets arguments for the
     * employee's ID, email address, and phone number
     * @param id The integer value for the Employee ID
     * @param emailAddress The email address of the employee
     * @param phone The phone number of the employee
     */
    public Employee( int id, String emailAddress, String phone )
    {
        setEmployeeID( id );
        setEmail( emailAddress );
        setPhoneNumber( phone );
    } //end three arg Employee constructor

    /**
     * This method sets the value for the hours flown by the pilot
     * @param id The integer value for the Employee's ID number
     */
    public void setEmployeeID( int id )
    {
        employeeID = id;
    } // end method setEmployeeID

    /**
     * This method gets the double value stored for the number of hours flown
     * @return The current value for the Employee's ID number
     */
    public int getEmployeeID()
    {
        return employeeID;
    } // end method get employee ID

    /**
     * This method sets the value for the hours flown by the pilot
     * @param emailAddress The current employee's email address
     */
    public void setEmail( String emailAddress )
    {
        email = emailAddress;
    } // end method setEmail

    /**
     * This method gets the double value stored for the number of hours flown
     * @return The current value for the employee's email address
     */
    public String getEmail()
    {
        return email;
    } // end method getEmail

    /**
     * This method sets the value for the hours flown by the pilot
     * @param phone The current value for the employee's phone number
     */
    public void setPhoneNumber( String phone )
    {
        phoneNumber = phone;
    } // end method setPhoneNumber

}
