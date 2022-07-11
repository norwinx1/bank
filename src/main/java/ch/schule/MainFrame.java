package ch.schule;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {
    /**
     *
     */
    private static final long serialVersionUID = 1L;

    private Font font;

    /**
     * Label f�r Kontonummer.
     */
    private JLabel lblAccount;

    /**
     * Eingabefeld f�r Kontonummer.
     */
    private JTextField txtAccount;

    /**
     * Schaltfl�che um Konto zu suchen.
     */
    private JButton btnSearch;

    /**
     * Label f�r Betrag.
     */
    private JLabel lblAmount;

    /**
     * Eingabefeld f�r Betrag.
     */
    private JTextField txtAmount;

    /**
     * Schaltfl�che f�r 'Einzahlen'.
     */
    private JButton btnDeposit;

    /**
     * Schaltfl�che f�r 'Abheben'.
     */
    private JButton btnWithdraw;

    private Account selectedAccount;

    /**
     * Erzeugt eine neue Instanz dieses Fensters.
     */
    public MainFrame() {
        super("Schalter-App");

        initUserInterface();
    }

    /**
     * Initialisiert den User-Interface-Teil
     * dieses Fensters.
     */
    private void initUserInterface() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        font = new Font("Verdana", Font.PLAIN, 20);

        Container cp = getContentPane();

        cp.setLayout(new BorderLayout());
        cp.add(createAccountArea(), BorderLayout.NORTH);
        cp.add(createAmountArea(), BorderLayout.CENTER);

        adjustSizes();

        pack();
    }

    private Component createDetailsArea() {
        JPanel area = new JPanel();
        area.setLayout(new FlowLayout(FlowLayout.LEADING, 8, 8));

        area.setBorder(BorderFactory.createTitledBorder("Details"));

        JLabel label = new JLabel();
        label.setFont(font);
        label.setText(selectedAccount.getId() + ": ");
        area.add(label);

        JLabel amount = new JLabel();
        amount.setFont(font);
        amount.setText(Long.toString(selectedAccount.getBalance()));
        area.add(amount);

        JButton btnReset = new JButton("Reset");
        btnReset.setFont(font);
        area.add(btnReset);
        btnReset.addActionListener(e -> {
            selectedAccount = null;
            getContentPane().removeAll();
            getContentPane().add(createAccountArea(), BorderLayout.NORTH);
            getContentPane().add(createAmountArea(), BorderLayout.CENTER);
            adjustSizes();
            pack();
        });

        return area;
    }

    private void adjustSizes() {
        Dimension sz1 = lblAccount.getPreferredSize();
        Dimension sz2 = lblAmount.getPreferredSize();
        Dimension sz3;

        sz1.width = sz2.width = Math.max(sz1.width, sz2.width);
        lblAccount.setPreferredSize(sz1);
        lblAmount.setPreferredSize(sz2);

        sz1 = btnSearch.getPreferredSize();
        sz2 = btnDeposit.getPreferredSize();
        sz3 = btnWithdraw.getPreferredSize();

        sz1.width = sz2.width = sz3.width =
                Math.max(sz1.width, Math.max(sz2.width, sz3.width));

        btnSearch.setPreferredSize(sz1);
        btnDeposit.setPreferredSize(sz2);
        btnWithdraw.setPreferredSize(sz3);
    }

    /**
     * Erzeugt den Bereich f�r die Kontonummer-Eingabe.
     *
     * @return Component der Bereich
     */
    private Component createAccountArea() {
        JPanel area = new JPanel();
        Dimension sz;

        area.setLayout(new FlowLayout(FlowLayout.LEADING, 8, 8));
        area.setBorder(BorderFactory.createTitledBorder("Konto"));

        lblAccount = new JLabel("Konto-Nr.");
        lblAccount.setFont(font);
        area.add(lblAccount);

        txtAccount = new JTextField();
        txtAccount.setFont(font);
        sz = txtAccount.getPreferredSize();
        sz.width = 5 * sz.height;
        txtAccount.setPreferredSize(sz);
        area.add(txtAccount);

        btnSearch = new JButton("Suchen");
        btnSearch.setFont(font);
        area.add(btnSearch);
        btnSearch.addActionListener(e -> {
            selectedAccount = Bank.getInstance().getAccount(txtAccount.getText());
            if (selectedAccount == null) {
                return;
            }
            getContentPane().removeAll();
            getContentPane().add(createDetailsArea(), BorderLayout.NORTH);
            getContentPane().add(createAmountArea(), BorderLayout.CENTER);
            adjustSizes();
            pack();
        });

        return area;
    }

    /**
     * Erzeugt den Bereich f�r die Kontonummer-Eingabe.
     *
     * @return Component der Bereich
     */
    private Component createAmountArea() {
        JPanel area = new JPanel();

        area.setBorder(BorderFactory.createTitledBorder("Action"));

        area.setLayout(new BorderLayout(0, 8));
        area.add(createAmountEntryArea(), BorderLayout.CENTER);
        area.add(createAmountButtonArea(), BorderLayout.EAST);

        return area;
    }

    private Component createAmountEntryArea() {
        JPanel area = new JPanel();
        Dimension sz;

        area.setLayout(new FlowLayout(FlowLayout.LEADING, 8, 8));

        lblAmount = new JLabel("Betrag:");
        lblAmount.setFont(font);
        area.add(lblAmount);

        txtAmount = new JTextField();
        txtAmount.setFont(font);
        sz = txtAmount.getPreferredSize();
        sz.width = 5 * sz.height;
        txtAmount.setPreferredSize(sz);
        area.add(txtAmount);

        return area;
    }

    private Component createAmountButtonArea() {
        JPanel area = new JPanel();

        area.setLayout(new GridLayout(2, 1, 8, 8));
        area.setBorder(BorderFactory.createEmptyBorder(8, 0, 8, 8));

        btnDeposit = new JButton("Einzahlen");
        btnDeposit.setForeground(new Color(0, 128, 0));
        btnDeposit.setFont(font);
        area.add(btnDeposit);
        btnDeposit.addActionListener(e -> {
            selectedAccount.setBalance(selectedAccount.getBalance() + Integer.parseInt(txtAmount.getText()));
            getContentPane().removeAll();
            getContentPane().add(createDetailsArea(), BorderLayout.NORTH);
            getContentPane().add(createAmountArea(), BorderLayout.CENTER);
            adjustSizes();
            pack();
        });

        btnWithdraw = new JButton("Abheben");
        btnWithdraw.setForeground(new Color(128, 0, 0));
        btnWithdraw.setFont(font);
        area.add(btnWithdraw);
        btnWithdraw.addActionListener(e -> {
            selectedAccount.setBalance(selectedAccount.getBalance() - Integer.parseInt(txtAmount.getText()));
            getContentPane().removeAll();
            getContentPane().add(createDetailsArea(), BorderLayout.NORTH);
            getContentPane().add(createAmountArea(), BorderLayout.CENTER);
            adjustSizes();
            pack();
        });

        return area;
    }

}
