public class Main {
    public static void main(String[] args) {

        Employee petrPetrovPetrovich = createEmployee("Петр Петрович Петров", 5, 500);//new Employee("Петр Петрович Петров", 10);
        if (petrPetrovPetrovich == null) {
            System.out.println("Не удалось создать работника!");
            return;
        }
        //System.out.println(petrPetrovPetrovich);

        Employee ivanIvanovIvanovich = createEmployee("Иванов Иван Иванович", 4, 1000);//new Employee("Иванов Иван Иванович", 10);
        if (ivanIvanovIvanovich == null) {
            System.out.println("Не удалось создать работника!");
            return;
        }
        //System.out.println(ivanIvanovIvanovich);

        EmployeeBook bookPart1 = new EmployeeBook();
        bookPart1.addEmployee(ivanIvanovIvanovich);
        bookPart1.addEmployee(petrPetrovPetrovich);

        //bookPart1.printEmployeesList();

        //bookPart1.deleteEmployee(ivanIvanovIvanovich);
        bookPart1.printEmployeesList();
        System.out.println(bookPart1.getMaxSalaryEmployee());

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