import java.io.*;
import java.util.*;

/**
 * @author Anthony Ilchev and Alex Palmer 
 * the company class represnts everthring in its entirery, org, people, employee, managers etc 
 * Beginning of code that was Stack Overlowed 
 */
public class Company {
    private List<Employee> employees; // list of all employees
    private List<Manager> managers; // list of all managers
    private Department department; // main department of the company 
    /*
     * constructs a company object with def values
     */
    public Company() {
        employees = new ArrayList<>();
        managers = new ArrayList<>();
        department = new Department("General");
    } /** end of code that was stack overlfowed */

    /**
     * 
     * beginning of code that was fused between chatgpt where the prompt was "Explain how to add to two different files based on a given object"
     * also this code Anthony's family friend helped write out as well as chatgpt we used two sources 
     * @param filename name of file containting employee data 
     */
    public void loadInitialData(String filename) {
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                switch (data[0]) {
                    case "Employee":
                        Employee employee = new Employee(data[1], data[2], Double.parseDouble(data[3]));
                        employees.add(employee);
                        department.addEmployee(employee);
                        break;
                    case "Manager":
                        Manager manager = new Manager(data[1], data[2], Double.parseDouble(data[3]), data[4]);
                        managers.add(manager);
                        department.addEmployee(manager);
                        break;
                }
            }
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }
    }

    /**
     * 
     *
     * @param filename saves employee data 
     */
    public void saveData(String filename) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filename))) {
            for (Employee employee : employees) {
                bw.write("Employee," + employee.getName() + "," + employee.getId() + "," + employee.getSalary() + "\n");
            }
            for (Manager manager : managers) {
                bw.write("Manager," + manager.getName() + "," + manager.getId() + "," + manager.getSalary() + "," + manager.getDepartment() + "\n");
            }
        } catch (IOException e) {
            System.err.println("Error writing file: " + e.getMessage());
        }
    }
     /** this is where the code ends for the chatgpt and family friend  */
    /**
     * displays the entriety of the payroll
     */
    public void displayPayroll() {
        List<Payroll> payrolls = new ArrayList<>();
        for (Employee employee : employees) {
            payrolls.add(new Payroll(employee));
        }
        for (Manager manager : managers) {
            payrolls.add(new Payroll(manager));
        }
        Collections.sort(payrolls);
        for (Payroll payroll : payrolls) {
            System.out.println(payroll);
        }
    }

    /**
     * main method to run the entire program 
     *
     * @param args command line 
     */
    public static void main(String[] args) {
        Company company = new Company();
        company.loadInitialData("input.txt");
        company.displayPayroll();
        company.saveData("output.txt");
    }
}
