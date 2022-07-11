package ch.schule;

import javax.swing.*;

public class Main {
    private static void initLookAndFeel() {
        try {
            UIManager.setLookAndFeel(
                    UIManager.getSystemLookAndFeelClassName());
        } catch (Exception E) {
            // ignored
        }
    }

    public static void main(String[] args) {
        // 1. Look and Feel initialisieren
        initLookAndFeel();

        // 2. Model initialisieren
        Bank bank = Bank.getInstance();

        bank.createSavingsAccount();
        bank.createSavingsAccount();

        // 3. Viewer initialisieren
        MainFrame mf = new MainFrame();

        mf.setVisible(true);
    }
}
