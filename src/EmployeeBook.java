import java.util.Arrays;

public class EmployeeBook {
    private final Employee[] employees = new Employee[10];

    public void deleteEmployeeByName(String name) {
        Employee employee;
        for (int i = 0; i < employees.length; i++) {
            employee = employees[i];
            if (employee != null && name.equals(employee.getName())) {
                employees[i] = null;
            }
        }
    }
    public void deleteEmployee(Employee employee) {
        int employeeIndex = Arrays.asList(employees).indexOf(employee);
        if (employeeIndex != -1) {
            employees[employeeIndex] = null;
        }
     }
    public void addEmployee(Employee employee) {

        if (!Arrays.asList(employees).contains(employee)) {
            int freeIndex = Arrays.asList(employees).indexOf(null);

            if (freeIndex == -1) {
                System.out.println("Книга сотрудников полна, перед добавлением нового сотрудника, " +
                        "прежде нужно удалить не актуального сотрудника или завести новую книгу!");
            } else {
                employees[freeIndex] = employee;
            }
        } else {
            System.out.println("В книге уже есть такой сотрудник, Вам необходимо воспользоваться методом редактирования" +
                    " для изменения его параметров.");
        }
    }

    public Employee getMaxSalaryEmployee() {
        double maxSalary = 0;
        Employee maxEmployee = null;
        for (Employee employee : employees) {

            if (employee == null) {
                continue;
            }

            if (maxSalary < employee.getSalary()) {
                maxEmployee = employee;
                maxSalary = employee.getSalary();
            }
        }
        return maxEmployee;
    }
    public Employee getMinSalaryEmployee() {
        double minSalary = 0.0;
        double thisSalary = 0.0;
        Employee minEmployee = null;

        for (Employee employee : employees) {

            if (employee == null) {
                continue;
            }

            thisSalary = employee.getSalary();
            if (minSalary == 0) {
                minSalary = thisSalary;
            }

            if (minSalary > thisSalary) {
                minEmployee = employee;
                minSalary = thisSalary;
            }
        }
        return minEmployee;
    }
    public void editEmployee(String name, int value, String fieldName) {
        Employee employee = findEmployeeByName(name);
        if (employee == null) {
            return;
        }
        if (fieldName.equals("salary")) {
            employee.setSalary(value);
        } else if (fieldName.equals("department")) {
            employee.setDepartment(value);
        } else {
            System.out.println("Не правильно указанно поле для редактирования !");
        }
    }
    public String getNameByEmployee(Employee employee) {
        String name = "";

        int indexOfEmployee = Arrays.asList(employees).indexOf(employee);
        if (indexOfEmployee != -1) {
            name = employees[indexOfEmployee].getName();
        }

        return name;
    }

    public void getListOfNames() {
        for (Employee employee : employees) {
            if (employee == null) {
                continue;
            }
            System.out.println(employee.getName());
        }
    }

    private Employee findEmployeeByName(String name) {
        for (Employee employee : employees) {
            if (employee != null && name.equals(employee.getName())) {
                return employee;
            }
        }
        return null;
    }

    public int getMonthlyExpensesOnSalary(int department) {
        int totalSum = 0;

        if (department < 0 && department > 5) {
            System.out.println("Неправильно задан отдел, номер отдела может быть указан равным 0, если собирается информация " +
                    "по всем отделам или в промежутке от 1-5. ");
            return totalSum;
        }
        for (Employee employee : employees) {
            if (employee == null) {
                continue;
        }
        if (department == 0 || department == employee.getDepartment())
            totalSum += employee.getSalary();
        }
        return totalSum;
    }
    public void getListOfEmployeeGroupedByDepartment() {
        //В этой задаче количество отделов задано жестко, поэтому тупо цикл
        for (int i = 1; i <= 5; i++) {
            System.out.println("Отдел номер " + i);
            for (Employee employee : employees) {
                if (employee != null && employee.getDepartment() == i) {
                    System.out.println(employee);
                }
            }
        }
    }

    public void getEmployeesList() {
        for (Employee employee : employees) {
            if (employee != null) {
                System.out.println(employee);
            }
        }
    }

    public void getListOfEmployeeByDepartment(int department) {
        for (Employee employee : employees) {
            if (employee != null && employee.getDepartment() == department) {
                System.out.println("name = " + employee.getName() + "; id = " + employee.getId()
                    + "; salary = " + employee.getSalary());
            }
        }
    }

    public int getAmountOfEmployee() {
        int amount = 0;
        for (Employee employee : employees) {
            if (employee != null) {
                amount++;
            }
        }
        return amount;
    }
    public int getAverageSalary() {
        int employeeAmount = getAmountOfEmployee();
        int salaryAmount = getMonthlyExpensesOnSalary(0);
        return employeeAmount == 0 ? 0 : salaryAmount / employeeAmount;
    }
    
    public void indexSalary(double percent) {
        double thisSalary;
        for (Employee employee : employees) {
            if (employee == null) {
                continue;
            }
            thisSalary = employee.getSalary();
            employee.setSalary(thisSalary + thisSalary * (percent / 100));
        }
    } 
}
