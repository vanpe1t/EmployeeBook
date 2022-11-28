public class Employee {
    private final String name;
    private int department;
    private int salary;
    private int id;
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

    public Employee(String name, int department) {
        this.name = name;

        //?? Доработать алгоритм проверки
        if (department <= 5 && department > 0) {
            this.department = department;
        } else {
            throw new IllegalArgumentException("Ltg");
        }
        this.id = keyCounter;
        keyCounter++;
    }

    public String getName() {
        return name;
    }

    public int getDepartment() {
        return department;
    }

    public int getSalary() {
        return salary;
    }

    public int getId() {
        return id;
    }

    public void setDepartment(int department) {
        this.department = department;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }
}
