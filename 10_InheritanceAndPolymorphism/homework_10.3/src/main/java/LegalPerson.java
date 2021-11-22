public class LegalPerson extends Client {
    private static final double FEE = 0.01;

    public void take(double amountToTake) {
        super.take(amountToTake * (1 + FEE));
    }

    @Override
    public void info() {
        System.out.println("Баланс: " + getAmount());
        System.out.println("Пополнение: без комиссии");
        System.out.println("Снятие: комиссия 1%");
    }
}
