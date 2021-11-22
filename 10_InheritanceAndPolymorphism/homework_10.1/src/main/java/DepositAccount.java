import java.time.LocalDate;

public class DepositAccount extends BankAccount {
    private LocalDate lastIncome = LocalDate.now().minusMonths(1);

    public void put(double amountToPut) {
        // метод зачисляет деньги на счет

        lastIncome = LocalDate.now();
        super.put(amountToPut);
    }

    public boolean take(double amountToTake) {
        // метод списывает деньги со счета

        if (LocalDate.now().isAfter(lastIncome.plusMonths(1))) {
            super.take(amountToTake);
            return true;
        } else {
            return false;
        }
    }
}
