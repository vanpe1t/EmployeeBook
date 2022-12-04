public class Main {
    public static void main(String[] args) {

        Employee petrPetrovPetrovich = createEmployee("Петров Петр Петрович", 5, 500);//new Employee("Петр Петрович Петров", 10);
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

        Employee pupkinVasiliyVasilevich = createEmployee("Пупкин Василий Васильевич", 1, 4500);//new Employee("Иванов Иван Иванович", 10);
        if (pupkinVasiliyVasilevich == null) {
            System.out.println("Не удалось создать работника!");
            return;
        }


        EmployeeBook bookPart1 = new EmployeeBook();

        bookPart1.addEmployee(ivanIvanovIvanovich);
        bookPart1.addEmployee(petrPetrovPetrovich);
        bookPart1.addEmployee(sidorovSidrSidorovich);
        bookPart1.addEmployee(pupkinVasiliyVasilevich);

        System.out.println("Получить список всех сотрудников со всеми имеющимися по ним данными:");
        bookPart1.getEmployeesList(0);

        System.out.println();
        System.out.print("Cумма затрат на зарплаты в месяц: ");
        System.out.println(bookPart1.getMonthlyExpensesOnSalary(0));

        System.out.println();
        Employee minSalaryEmployee = bookPart1.getMinSalaryEmployee(3);
        System.out.println("Сотрудник с минимальной зарплатой: "
                + (minSalaryEmployee != null ? minSalaryEmployee.getName() : "не найден, возможно книга пуста или отдел без сотрудников."));

        System.out.println();
        Employee maxSalaryEmployee = bookPart1.getMaxSalaryEmployee(2);
        System.out.println("Сотрудник с максимальной зарплатой: "
                + (maxSalaryEmployee != null ? maxSalaryEmployee.getName() : "не найден, возможно книга пуста или отдел без сотрудников."));

        System.out.println();
        System.out.println("Среднее значение зарплаты за месяц: " + bookPart1.getAverageSalary(1));

        System.out.println();
        System.out.println("Список ФИО сотрудников:");
        bookPart1.getListOfNames();

        System.out.println();
        System.out.println("Индексация зарплаты:");
        bookPart1.indexSalary(10, 1);
        bookPart1.getEmployeesList(0);

        System.out.println(bookPart1.getAmountOfEmployee(0));

        System.out.println("Сотрудники с зарплатой больше 600" );
        bookPart1.getListOfEmployeesWithSalaryByCondition(600, true);

        System.out.println("Сотрудники с зарплатой меньше 600" );
        bookPart1.getListOfEmployeesWithSalaryByCondition(600, false);

        System.out.println();
        System.out.println("Удаление");
        bookPart1.deleteEmployee(ivanIvanovIvanovich);
        bookPart1.deleteEmployee(ivanIvanovIvanovich);
        bookPart1.getEmployeesList(0);

        System.out.println();
        System.out.println("Редактирование");
        bookPart1.editEmployee("Пупкин Василий Васильевич", 5000.0, "salary");
        try {
            bookPart1.editEmployee("Пупкин Василий Васильевич", 9, "department");
        } catch (IllegalArgumentException e) {
            System.out.println("Не удалось узменить департамент, номер департамента должен быть в пределах 1-5.");
        }
        bookPart1.getEmployeesList(0);

        System.out.println();
        System.out.println("Удаление по наименованию");
        bookPart1.deleteEmployeeByName("Петров Петр Петрович1");
        bookPart1.getEmployeesList(0);

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