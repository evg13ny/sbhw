public class Main {
    public static void main(String[] args) {
        final String PATH = "../files/movementList.csv";

        Movements movements = new Movements(PATH);
        System.out.println("Всего потрачено: " + movements.getExpenseSum());
        System.out.println("Всего получено: " + movements.getIncomeSum());
        System.out.println("\nСуммы расходов по организациям:");
        movements.getReport();
    }
}
