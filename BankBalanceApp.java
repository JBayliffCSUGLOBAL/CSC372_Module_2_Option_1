import javax.swing.;
import java.awt.;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BankBalanceApp {
    private JFrame frame;
    private JPanel panel;
    private JLabel balanceLabel;
    private JTextField amountField;
    private JButton depositButton;
    private JButton withdrawButton;
    private BankAccount account;

    public BankBalanceApp() {
        account = new BankAccount(0);  // Start with a balance of 0

        frame = new JFrame("Bank Balance Application");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 200);

        panel = new JPanel();
        panel.setLayout(new GridLayout(3, 2));

        balanceLabel = new JLabel("Balance: $" + account.getBalance());
        panel.add(balanceLabel);

        amountField = new JTextField();
        panel.add(amountField);

        depositButton = new JButton("Deposit");
        withdrawButton = new JButton("Withdraw");

        depositButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                double amount = Double.parseDouble(amountField.getText());
                account.deposit(amount);
                updateBalance();
            }
        });

        withdrawButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                double amount = Double.parseDouble(amountField.getText());
                account.withdraw(amount);
                updateBalance();
            }
        });

        panel.add(depositButton);
        panel.add(withdrawButton);

        frame.add(panel);
        frame.setVisible(true);
    }

    private void updateBalance() {
        balanceLabel.setText("Balance: $" + account.getBalance());
    }

    public static void main(String[] args) {
        new BankBalanceApp();
    }
}
