package ch.schule;

public class TestBank {

    public static void main(String[] args) {
        Bank migros = new Bank();
        migros.createAccount("M-301");
        migros.createAccount("M-302");
        migros.createAccount("M-303");
        migros.createAccount("M-304");

        System.out.println("Kontostand M-302: " + migros.getAccount("M-302").getBalance());

        migros.deposit("M-302", 1000000000);
        System.out.println("Kontostand M-302: " + migros.getAccount("M-302").getBalance() / 100000 + " in Fr.");
    }

}
