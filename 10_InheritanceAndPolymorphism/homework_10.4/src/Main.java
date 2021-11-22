import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Company company = new Company();

        List<Employee> workers = new ArrayList<>();

        for (int i = 0; i < 180; i++) {
            company.hire(new Operator());
        }

        for (int i = 0; i < 80; i++) {
            company.hire(new Manager(company));
        }

        for (int i = 0; i < 10; i++) {
            company.hire(new TopManager(company));
        }

        company.hireAll(workers);

        DecimalFormat dF = new DecimalFormat("###,###");

        System.out.println("Список из самых высоких зарплат в компании");
        for (Employee employee : company.getTopSalaryStaff(13)) {
            System.out.println(dF.format(employee.getMonthSalary()) + " руб.");
        }

        System.out.println("Список из самых низких зарплат в компании");
        for (Employee employee : company.getLowestSalaryStaff(30)) {
            System.out.println(dF.format(employee.getMonthSalary()) + " руб.");
        }

        int reduce = company.getEmployees().size() / 2;
        company.fireAll(reduce);

        System.out.println("Список из самых высоких зарплат в компании после увольнений");
        for (Employee employee : company.getTopSalaryStaff(13)) {
            System.out.println(dF.format(employee.getMonthSalary()) + " руб.");
        }

        System.out.println("Список из самых низких зарплат в компании после увольнений");
        for (Employee employee : company.getLowestSalaryStaff(30)) {
            System.out.println(dF.format(employee.getMonthSalary()) + " руб.");
        }
    }
}
