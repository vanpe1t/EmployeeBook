public class Main {
    public static void main(String[] args) {

        Employee petrPetrovPetrovich = createEmployee("Петров Петр Петрович ", 5, 500);//new Employee("Петр Петрович Петров", 10);
        if (petrPetrovPetrovich == null) {
            System.out.println("Не удалось создать работника!");
            return;
        }

        Employee ivanIvanovIvanovich = createEmployee("Иванов Иван Иванович", 3, 1000);//new Employee("Иванов Иван Иванович", 10);
        if (ivanIvanovIvanovich == null) {
            System.out.println("Не удалось создать работника!");
            return;
        }

        Employee sidorovSidrSidorovich = createEmployee("Сидоров Сидр Сидорович", 1, 2000);//new Employee("Иванов Иван Иванович", 10);
        if (sidorovSidrSidorovich == null) {
            System.out.println("Не удалось создать работника!");
            return;
        }

        EmployeeBook bookPart1 = new EmployeeBook();

        bookPart1.addEmployee(ivanIvanovIvanovich);
        bookPart1.addEmployee(petrPetrovPetrovich);
        bookPart1.addEmployee(sidorovSidrSidorovich);

        System.out.println("Получить список всех сотрудников со всеми имеющимися по ним данными:");
        bookPart1.getEmployeesList();

        System.out.println();
        System.out.print("Cумма затрат на зарплаты в месяц: ");
        System.out.println(bookPart1.getMonthlyExpensesOnSalary(1));

        System.out.println();
        Employee minSalaryEmployee = bookPart1.getMinSalaryEmployee();
        System.out.println("Сотрудник с минимальной зарплатой: " + (minSalaryEmployee != null ? minSalaryEmployee.getName() : "не найден, возможно книга пуста."));

        System.out.println();
        Employee maxSalaryEmployee = bookPart1.getMaxSalaryEmployee();
        System.out.println("Сотрудник с максимальной зарплатой: " + (maxSalaryEmployee != null ? maxSalaryEmployee.getName() : "не найден, возможно книга пуста."));

        System.out.println();
        System.out.println("Среднее значение зарплаты за месяц: " + bookPart1.getAverageSalary());

        System.out.println();
        System.out.println("Список ФИО сотрудников:");
        bookPart1.getListOfNames();

        System.out.println();
        System.out.println("Индексация зарплаты:");
        bookPart1.indexSalary(10);
        bookPart1.getEmployeesList();

        //bookPart1.deleteEmployee(ivanIvanovIvanovich);
        /*System.out.println(bookPart1.getMaxSalaryEmployee());

        bookPart1.getListOfEmployeeByDepartment();

        System.out.println("Месячные затраты на зарплату составляют : " + bookPart1.getMonthlyExpensesOnSalary());

        System.out.println("Средняя зарплата за месяц составляет : " + bookPart1.getAverageSalary());
        System.out.println("Список ФИО сотрудников :");
        bookPart1.getListOfNames();*/

        /*bookPart1.indexSalary(10);
        bookPart1.getEmployeesList();

        System.out.println(bookPart1.getMinSalaryEmployee());
        System.out.println(bookPart1.getMaxSalaryEmployee());

        bookPart1.getListOfEmployeeGroupedByDepartment();
        bookPart1.getListOfEmployeeByDepartment(3);*/

    }



    public static Employee createEmployee(String name, int department, int salary) {

        Employee newEmployee;

        try {
            newEmployee = new Employee(name, department);
            newEmployee.setSalary(salary);
        } catch (IllegalArgumentException e) {
            System.out.println(e);
            return null;
        }

        return newEmployee;
    }

}