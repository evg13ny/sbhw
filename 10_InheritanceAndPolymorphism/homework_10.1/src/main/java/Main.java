public class Main {
    public static void main(String[] args) {
//        BankAccount bankAccount = new BankAccount();
//        CardAccount cardAccount = new CardAccount();
//        DepositAccount depositAccount = new DepositAccount();
//
//        System.out.println("Например, положил деньги");
//        bankAccount.put(1000);
//        System.out.println("bankAccount = " + bankAccount.getAmount());
//        cardAccount.put(3000);
//        System.out.println("cardAccount = " + cardAccount.getAmount());
//        depositAccount.put(5000);
//        System.out.println("depositAccount = " + depositAccount.getAmount());
//
//        System.out.println("\nНапример, снял деньги");
//        bankAccount.take(550);
//        System.out.println("bankAccount = (-550) " + bankAccount.getAmount());
//        cardAccount.take(650);
//        System.out.println("cardAccount = (-650 * 1.01) " + cardAccount.getAmount() + " 'с карты списана комиссия'");
//        depositAccount.take(750);
//        System.out.println("depositAccount = (-750) " + depositAccount.getAmount() + " 'деньги хранятся на депозитном счёте ещё меньше 30 дней'");
//
//        System.out.println("\nНапример, пополнил карту с расчётного счёта");
//        System.out.println("bankAccount = (-850) " + bankAccount.getAmount() + " 'сумма на расчётном счёте меньше суммы перевода'");
//        System.out.println("cardAccount = (+850) " + cardAccount.getAmount() + " '0 было отправлено'");
//
//        System.out.println("\nНапример, перевёл кэшбэк с карты на депозитный счёт");
//        cardAccount.send(depositAccount, 50.25);
//        System.out.println("cardAccount = (-50.25 * 1.01) " + cardAccount.getAmount() + " 'с карты списана комиссия'");
//        System.out.println("depositAccount = (+50.25) " + depositAccount.getAmount() + " 'комиссию забрал себе банк, на депозитном счёте появилась только сумма перевода'");
//
//        System.out.println("\nНапример, пополнил карту с депозитного счёта");
//        depositAccount.send(cardAccount,100.25);
//        System.out.println("depositAccount = (-100.25) " + depositAccount.getAmount() + " 'деньги хранятся на депозитном счёте ещё меньше 30 дней'");
//        System.out.println("cardAccount = (+100.25) " + cardAccount.getAmount() + " '0 было отправлено'");

        DepositAccount da = new DepositAccount();
        da.take(1.0);
        da.put(2.0);
        System.out.println(da.getAmount());
    }
}
