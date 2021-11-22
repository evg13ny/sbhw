public class BankAccount {
    private double money;

    public double getAmount() {
        // верните значение количества денег не счету

        return money;
    }

    public void put(double amountToPut) {
        // метод зачисляет деньги на счет

        if (amountToPut > 0) {
            money += amountToPut;
        }
    }

    public boolean take(double amountToTake) {
        // метод списывает деньги со счета

        if (amountToTake <= money && amountToTake > 0) {
            money -= amountToTake;
            return true;
        } else {
            return false;
        }
    }

    public boolean send(BankAccount receiver, double amount) {
        if (take(amount)) {
            receiver.put(amount);
            return true;
        } else {
            return false;
        }
    }
}
