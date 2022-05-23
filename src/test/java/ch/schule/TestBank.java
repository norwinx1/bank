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

        migros.writeAccountsSortedAscending();
        migros.writeAccountsSortedDescending();

        migros.deposit("A-1002", 10);
        migros.deposit("A-1002", 100);
        migros.deposit("A-1002", 19837635);

        migros.printAccount("A-1002");
        migros.printAccount("A-1002", 2022, 05);
    }

}
