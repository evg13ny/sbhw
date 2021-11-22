public class CardAccount extends BankAccount {
    // не забывайте, обращаться к методам и конструкторам родителя
    // необходимо используя super, например, super.put(10D);

    private static final double FEE = 0.01;

    public boolean take(double amountToTake) {
        // метод списывает деньги со счета

        return super.take(amountToTake * (1 + FEE));
    }
}
