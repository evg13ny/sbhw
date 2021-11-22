import java.util.ArrayList;
import java.util.List;

public class Company {
    private double income;

    private List<Employee> employees = new ArrayList<>();

    public void hire(Employee employee) {
        employees.add(employee);
    }

    public void hireAll(List<Employee> employeesList) {
        for (Employee employee : employeesList) {
            hire(employee);
        }
    }

    public void fire(Employee employee) {
        employees.remove(employee);
    }

    public List<Employee> getEmployees() {
        return new ArrayList<>(employees);
    }

    public List<Employee> fireAll(int count) {
        for (int i = 0; i < count; i++) {
            employees.remove(i);
        }
        return employees;
    }

    public double generateIncome() {
        income = 0;
        for (Employee employee : employees) {
            if (employee instanceof Manager) {
                income += ((Manager) employee).getSales();
            }
        }
        return income;
    }

    public List<Employee> getTopSalaryStaff(int count) {
        if (count > 0 && count < employees.size()) {
            employees.sort(new EmployeeComparator());
        }
        return employees.subList(0, count);
    }

    public List<Employee> getLowestSalaryStaff(int count) {
        if (count > 0 && count < employees.size()) {
            employees.sort(new EmployeeComparator().reversed());
        }
        return employees.subList(0, count);
    }
}
