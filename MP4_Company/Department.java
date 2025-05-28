import java.util.ArrayList;
import java.util.List;

/**
 * the deparement class represents the give deparement of a business 
 */
public class Department {
    private String name; // deparment name 
    private List<Employee> employees; // list of employees

    /**
     * constructs the deparment object 
     *
     * @param name parameter that sets the name of the department 
     */
    public Department(String name) {
        this.name = name;
        this.employees = new ArrayList<>(); // intilaize the list of employees in a given department 
    }

    /**
     * getter 
     *
     * @return the name of a gvien department 
     */
    public String getName() {
        return name;
    }

    /**
     * setter
     *
     * @param name parameter that sets the name of the department 
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 
     *
     * @return returns of the list of employees 
     */
    public List<Employee> getEmployees() {
        return employees;
    }

    /**
     * adds an employee 
     *
     * @param employee 
     */
    public void addEmployee(Employee employee) {
        employees.add(employee);
    }

    /**
     * 
     *
     * @return A toString that represents the department itself visually with the deparment itself and the employees 
     */
    @Override
    public String toString() {
        return "Department{" +
                "name='" + name + '\'' +
                ", employees=" + employees +
                '}';
    }
}
