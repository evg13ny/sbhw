public class TopManager implements Employee {
    private static final double TARGET = 10_000_000;
    private static final int FIXED_SALARY = 50_000;
    private int salary;
    private static final double BONUS = 1.5;
    private Company company;

    public TopManager(Company company) {
        this.company = company;
    }

    @Override
    public int getMonthSalary() {
        if (company.generateIncome() > TARGET) {
            salary = (int) (FIXED_SALARY * (1 + BONUS));
        } else {
            salary = FIXED_SALARY;
        }
        return salary;
    }
}
