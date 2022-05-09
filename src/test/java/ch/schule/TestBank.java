package ch.schule;

public class TestBank {

    public static void main(String[] args) {
        Bank migros = new Bank();
        migros.createAccount();
        migros.createAccount();
        migros.createAccount();
        migros.createAccount();

        System.out.println("Kontostand A-1001: " + migros.getAccount("A-1001").getBalance());

        migros.deposit("A-1001", 1000000000);
        System.out.println("Kontostand A-1001: " + migros.getAccount("A-1001").getBalance() / 100000 + " in Fr.");
    }

}
