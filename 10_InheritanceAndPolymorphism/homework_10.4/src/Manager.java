public class Manager implements Employee {
    private static final int MIN_MANAGER_INCOME = 115_000;
    private static final int MAX_MANAGER_INCOME = 140_000;
    private static final int FIXED_SALARY = 50_000;
    private int salary;
    private static final double BONUS = 0.05;
    private Company company;
    private double sales;

    public Manager(Company company) {
        this.company = company;
        sales = Math.random() * (MAX_MANAGER_INCOME - MIN_MANAGER_INCOME) + MIN_MANAGER_INCOME;
    }

    public double getSales() {
        return sales;
    }

    @Override
    public int getMonthSalary() {
        salary = (int) (FIXED_SALARY + sales * BONUS);
        return salary;
    }
}
