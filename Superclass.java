/** Superclass name
 * Here we put a description of what the superclass does
 *
 *
 * This Example uses a "Person" and tracks their name
 * includes a set of constructors and default handlers
 */




public class Superclass {
    private String firstName; // Def String field for "first name"
    private String lastName; // Def String for "last name"

    /**
     * This method generates an empty Person object
     */
    public Person()
    {
    }// End default constructor

    /**
     * This method generates an empty Employee object and accepts
     * parameters for the first and last name
     * @param first The first name of the person
     * @param last The last name of the person
     */
    public Person( String first, String last )
    {
        setFirstName( first );
        setLastName( last );

    } // end two- argument constructor

    /**
     * This method Sets the first name value of the Person object.
     * @param first The first name of the person.
     */
    public void setFirstName( String first )
    {
        firstName = first;
    } // end method setFirstName

    /**
     * This method returns the first name of the person as a String.
     * @return The current first name value of the person object.
     */
    public String getFirstName()
    {
        return firstName;
    } // end method getFirstName

    /**
     * This method Sets the last name value of the Person object.
     * @param last The last name of the person.
     */
    public void setLastName( String last )
    {
        lastName = last;
    }// end method setLastName

    /**
     * This method gets the last name value of the Person object.
     * @return The current last name value of the person object.
     */
    public String getLastName()
    {
        return lastName;
    }// end method getLastName

    /**
     * This method returns the current state of the Person object
     * @return a String containing current values of the Person object
     */
    public String toString()
    {
        String item = "";
        item = item + "First Name: " + firstName + '\n';
        item = item + "Last Name: " + lastName + '\n';
        return item;
    }// End method toString

    /**
     * This method can compare names to see if they are the same between two people
     * @param p The name of the person you would like to compare to!
     * @return TRUE or FALSE bases on a name match
     */
    public boolean equals(Person p)
    {
        return (firstName.equals(p.firstName) && lastName.equals(p.lastName));
    }

    /**
     * Can compare two instances of employee ids and will return a ranking based on the name
     * @param  p The name of the person you would like to compare to
     * @return This returns a 1 if the employeeID is greater than, a -1 if it is less than,
     * and a 0 otherwise
     */
    public int compareTo(Person p)
    {
        String item1 = lastName+firstName;
        String item2 = p.lastName + p.firstName;
        return item1.compareTo(item2);
    }
}//end class person
