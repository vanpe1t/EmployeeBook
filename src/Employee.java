import java.util.Objects;

public class Employee {
    private final String name;
    private int department;
    private double salary;
    private final int id;
    private static int keyCounter = 0;

    @Override
    public String toString() {
        return "Employee{" +
                "id='" + id + '\'' +
                "name='" + name + '\'' +
                ", department=" + department +
                ", salary=" + salary +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return id == employee.id && Objects.equals(name, employee.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, id);
    }

    public Employee(String name, int department) {
        this.name = name;
        setDepartmentWithCondition(department);
        this.id = keyCounter;
        keyCounter++;
    }

    public String getName() {
        return name;
    }

    public int getDepartment() {
        return department;
    }

    public double getSalary() {
        return salary;
    }

    public int getId() {
        return id;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public void setDepartment(int department) {
        setDepartmentWithCondition(department);
    }
    private void setDepartmentWithCondition(int department) {
        if (department <= 5 && department > 0) {
            this.department = department;
        } else {
            throw new IllegalArgumentException("Номер департамента должен быть в пределах 1-5");
        }
    }
}
