public class Operator implements Employee {
    private static final int FIXED_SALARY = 50_000;
    private int salary;

    @Override
    public int getMonthSalary() {
        salary = FIXED_SALARY;
        return salary;
    }
}
