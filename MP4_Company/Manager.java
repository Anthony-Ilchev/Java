
public class Manager extends Employee {
    private String department; // The department managed by the manager

    /**
     * construts manager object with a name id salary and department 
     *
     * @param name       name of manager 
     * @param id         id of manager 
     * @param salary     salary of manager 
     * @param department deparement of manager 
     */
    public Manager(String name, String id, double salary, String department) {
        super(name, id, salary); // call constructor of superclass employee 
        this.department = department;
    }

    /**
     * 
     *
     * @return department of manger 
     */
    public String getDepartment() {
        return department;
    }

    /**
     * 
     *
     * @param department the new department the manager manages 
     */
    public void setDepartment(String department) {
        this.department = department;
    }

    /**
     * 
     * // beginning of stack overflow code that we changed up 
     * @return the manager of the role 
     */
    @Override
    public String getRole() {
        return "Manager";
    }

    /**
     * 
     *
     * @return a string representation of the manager object
     */
    @Override
    public String toString() {
        return "Manager{" +
                "department='" + department + '\'' +
                "} " + super.toString(); // call toSring of super class
    }
}
/** end of stack overlfow we changed up a bit. */