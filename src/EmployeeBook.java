import java.util.Arrays;

public class EmployeeBook {
    private Employee[] employees = new Employee[10];

    public void printEmployeesList() {
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null) {
                System.out.println(employees[i]);
            }
        }
    }

    public void deleteEmployeeByName(String name) {
        Employee employee;
        for (int i = 0; i < this.employees.length; i++) {
            employee = this.employees[i];
            if (employee != null && name.equals(employee.getName())) {
                this.employees[i] = null;
            }
        }
    }
    public void deleteEmployee(Employee employee) {
        int employeeIndex = Arrays.asList(this.employees).indexOf(employee);
        if (employeeIndex != -1) {
            this.employees[employeeIndex] = null;
        }
     }
    public void addEmployee(Employee employee) {

        if (Arrays.asList(this.employees).indexOf(employee) != -1) {
            System.out.println("В книге уже есть такой сотрудник, Вам необходимо воспользоваться методом редактирования" +
                    " для изменения его параметров.");
            return;
        }

        int freeIndex = Arrays.asList(this.employees).indexOf(null);
        if (freeIndex == -1) {
            System.out.println("Книга сотрудников полна, перед добавлением нового сотрудника, " +
                    "прежде нужно удалить не актуального сотрудника или завести новую книгу!");
            return;
        } else {
            this.employees[freeIndex] = employee;
        }
    }

    public Employee getMaxSalaryEmployee() {
        int maxSalary = 0;
        Employee employee = null;
        for (int i = 0; i < this.employees.length; i++) {

            if (this.employees[i] == null) {
                continue;
            }
            //что оптимальней, опрашивать массив и получать значение поля каждый раз или объявить переменную ???
            if (maxSalary < this.employees[i].getSalary()) {
                employee = this.employees[i];
                maxSalary = employee.getSalary();
            }
        }
        return employee;
    }
}
