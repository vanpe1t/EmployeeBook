import java.util.Arrays;

public class EmployeeBook {
    private final Employee[] employees = new Employee[10];

    public void deleteEmployeeByName(String name) {
        boolean isDelete = false;
        Employee employee;
        for (int i = 0; i < employees.length; i++) {
            employee = employees[i];
            if (employee != null && name.equals(employee.getName())) {
                employees[i] = null;
                isDelete = true;
            }
        }
        if (!isDelete) {
            System.out.println("Не найден сотрудник наименованием: " + name + " удаление не произведено!");
        }
    }
    public void deleteEmployee(Employee employee) {
        boolean isDelete = false;
        int employeeIndex = Arrays.asList(employees).indexOf(employee);
        if (employeeIndex != -1) {
            employees[employeeIndex] = null;
            isDelete = true;
        }
        if (!isDelete) {
            System.out.println("Не найден сотрудник : " + employee + " удаление не произведено!");
        }
     }
    public void addEmployee(Employee employee) {

        if (!Arrays.asList(employees).contains(employee)) {
            int freeIndex = Arrays.asList(employees).indexOf(null);

            if (freeIndex == -1) {
                System.out.println("Книга сотрудников полна, перед добавлением нового сотрудника, " +
                        " нужно удалить не актуального сотрудника или завести новую книгу!");
            } else {
                employees[freeIndex] = employee;
            }
        } else {
            System.out.println("В книге уже есть такой сотрудник, Вам необходимо воспользоваться методом редактирования" +
                    " для изменения его параметров.");
        }
    }

    public Employee getMaxSalaryEmployee(int department) {
        double maxSalary = 0;
        Employee maxEmployee = null;
        for (Employee employee : employees) {
            if (employee != null && (department >= 0 && department <= 5) && (department == 0 || department == employee.getDepartment())) {
                if (maxSalary < employee.getSalary()) {
                    maxEmployee = employee;
                    maxSalary = employee.getSalary();
                }
            }
        }
        return maxEmployee;
    }
    public Employee getMinSalaryEmployee(int department) {
        double minSalary = 0.0;
        double thisSalary;
        Employee minEmployee = null;

        for (Employee employee : employees) {
            if (employee != null && (department >= 0 && department <= 5) && (department == 0 || department == employee.getDepartment())) {
                thisSalary = employee.getSalary();
                if (minSalary == 0) {
                    minSalary = thisSalary;
                }

                if (minSalary >= thisSalary) {
                    minEmployee = employee;
                    minSalary = thisSalary;
                }
            }
        }
        return minEmployee;
    }
    public void editEmployee(String name, double value, String fieldName) {
        Employee employee = findEmployeeByName(name);
        if (employee == null) {
            return;
        }
        if (fieldName.equals("salary")) {
            employee.setSalary(value);
        } else if (fieldName.equals("department")) {
            employee.setDepartment((int) value);
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

        for (Employee employee : employees) {
            if (employee != null && (department >= 0 && department <= 5) && (department == 0 || department == employee.getDepartment())) {
                totalSum += employee.getSalary();
            }
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

    public void getEmployeesList(int department) {
        for (Employee employee : employees) {
            if (employee != null && (department >= 0 && department <= 5) && (department == 0 || department == employee.getDepartment())) {
                System.out.println(employee);
            }
        }
    }

    public int getAmountOfEmployee(int department) {
        int amount = 0;
        for (Employee employee : employees) {
            if (employee != null && (department >= 0 && department <= 5) && (department == 0 || department == employee.getDepartment())) {
                amount++;
            }
        }
        return amount;
    }
    public int getAverageSalary(int department) {
        int employeeAmount = getAmountOfEmployee(department);
        int salaryAmount = getMonthlyExpensesOnSalary(department);
        return employeeAmount == 0 ? 0 : salaryAmount / employeeAmount;
    }
    
    public void indexSalary(double percent, int department) {
        double thisSalary;
        for (Employee employee : employees) {
            if (employee != null && (department >= 0 && department <= 5) && (department == 0 || department == employee.getDepartment())) {
                thisSalary = employee.getSalary();
                employee.setSalary(thisSalary + thisSalary * (percent / 100));
            }
        }
    }

    public void getListOfEmployeesWithSalaryByCondition(double condition, boolean type) {
        for (Employee employee : employees) {
            if (employee != null && type && employee.getSalary() >= condition) {
                System.out.println(employee);
            } else if (employee != null && !type && employee.getSalary() <= condition) {
                System.out.println(employee);
            }
        }
    }

}
