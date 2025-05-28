/**
 * employee class repsrents any person with a salary and it extedns from person so it inherits methods,etc
 * 
 */
public class Employee extends Person {
    private double salary; // salary

    /**
     * constructs employee object with name, id and salary 
     *
     * @param name   name of employee 
     * @param id     id of employee 
     * @param salary salary of employee 
     */
    public Employee(String name, String id, double salary) {
        super(name, id); // call constructor of super class
        this.salary = salary;
    }

    /**
     * 
     * 
     * @return The salary of the given employee 
     */
    public double getSalary() {
        return salary;
    }

    /**
     * setter 
     *
     * @param salary sets the parameter salary for the given employee 
     */
    public void setSalary(double salary) {
        this.salary = salary;
    }

    /**
     * 
     *
     * @return the role of the employee
     */
    @Override
    public String getRole() {
        return "Employee";
    }

    /**
     * 
     *
     * @return a toString method that represents the employee visually 
     */
    @Override
    public String toString() {
        return "Employee{" +
                "salary=" + salary +
                "} " + super.toString(); // calls the toString of the super class 
    }
}
