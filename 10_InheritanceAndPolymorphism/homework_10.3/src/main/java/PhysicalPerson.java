public class PhysicalPerson extends Client {
    @Override
    public void info() {
        System.out.println("Баланс: " + getAmount());
        System.out.println("Пополнение: без комиссии");
        System.out.println("Снятие: без комиссии");
    }
}
