public class IndividualBusinessman extends Client {
    private static final double LESS1000 = 0.01;
    private static final double MORE1000 = 0.005;

    public void put(double amountToPut) {
        if (amountToPut < 1000) {
            super.put(amountToPut * (1 - LESS1000));
        } else {
            super.put(amountToPut * (1 - MORE1000));
        }
    }

    @Override
    public void info() {
        System.out.println("Баланс: " + getAmount());
        System.out.println("Пополнение: комиссия 1%, если сумма пополнения меньше 1.000 рублей, в других случаях - 0,5%");
        System.out.println("Снятие: без комиссии");
    }
}
