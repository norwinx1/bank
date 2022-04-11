package ch.schule;

public class TestAccount {

    public static void main(String[] args) {
        Account account = new Account("A-101");
        System.out.println("Konto Nummer ist: " + account.getId());
        account.deposit(1000000);
        System.out.println("Konto saldo ist: " + account.getBalance() / 100000 + " in CHF");
        account.withdraw(100000);
        System.out.println("Konto saldo ist: " + account.getBalance() / 100000 + " in CHF");
    }

}
