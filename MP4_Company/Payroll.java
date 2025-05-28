import java.util.*;

/**
 * This class represents payroll entries for employees
 */
public class Payroll implements Comparable<Payroll> {
    private Employee employee; // employee associated
    private double amount; // payment amount

    /**
     * constructs a Payroll object with a specifeid employee.
     *
     * @param employee the payroll of the employee 
     */
    public Payroll(Employee employee) {
        this.employee = employee;
        this.amount = employee.getSalary(); //initial amount set for the employee
    }

    /**
     *      
     * @return the employee that matches the entry 
     */
    public Employee getEmployee() {
        return employee;
    }

    /**
     * 
     *
     * @return the payment amount for the assiocated employee
     */
    public double getAmount() {
        return amount;
    }

    /**
     * compares payroll entrees
     *
     * @param o deals with comparing multiple entries 
     * @return the payroll amount
     */
    @Override
    public int compareTo(Payroll o) {
        return Double.compare(this.amount, o.amount); // Compare based on payment amount
    }

    /**
     * 
     *
     * @return a the payroll entry as a string with the toString method. 
     */
    @Override
    public String toString() {
        return "Payroll{" +
                "employee=" + employee +
                ", amount=" + amount +
                '}';
    }
}
