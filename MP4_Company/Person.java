import java.util.Objects;

/**
 * the person class defines the employee wiht their name and id 
 * 
 */
public abstract class Person {
    private String name; // The name of the person
    private String id; // The identification number of the person

    /**
     * Constructs a person object with a name and an id 
     *
     * @param name parameter name of the person 
     * @param id   the id of the person 
     */
    public Person(String name, String id) {
        this.name = name;
        this.id = id;
    }

    /**
     * 
     *
     * @return the name of the employee 
     */
    public String getName() {
        return name;
    }

    /**
     * 
     *
     * @param name the name of employee 
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 
     *
     * @return The id of the number of the employee 
     */
    public String getId() {
        return id;
    }

    /**
     * 
     *
     * @param id is the idenification number of the employee
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * equals method 
     *
     * @param o reference object 
     * @return returns true if the object argument is correct, and false otherwise
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return id.equals(person.id);
    }

    /**
     * 
     * Begin code from Anthony's dad's friend
     * @return a hash code of the object
     */ 
    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
    /**
     * 
     *
     * @return a string that represents the person, by name id and the person itself 
     */
    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", id='" + id + '\'' +
                '}';
    }

    /**
     *
     * method is implemented by subclasses
     * 
     * @return the role of the person
     */
    public abstract String getRole();
}
/** end of code from Anthony's dad's friend */