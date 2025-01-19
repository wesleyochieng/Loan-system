import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class loanSystem {
    public static void main(String[] args) {
        JFrame f = new JFrame("Loan system");
        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(Color.WHITE);
        f.setContentPane(panel);

        JLabel titleLabel = new JLabel("LOAN SYSTEM", JLabel.CENTER);
        titleLabel.setBounds(50, 10, 400, 40);
        titleLabel.setFont(titleLabel.getFont().deriveFont(18f));
        panel.add(titleLabel);

//        JLabel nameLabel = new JLabel("ENTER YOUR NAME :");
//        nameLabel.setBounds(50, 50, 150, 30);
//        panel.add(nameLabel);
//        JTextField nameField = new JTextField();
//        nameField.setBounds(250, 50, 150, 30);
//        panel.add(nameField


        JLabel client1NameLabel = new JLabel("Client 1 Name:");
        client1NameLabel.setBounds(50, 50, 150, 30);
        panel.add(client1NameLabel);
        JTextField client1NameField = new JTextField();
        client1NameField.setBounds(250, 50, 150, 30);
        panel.add(client1NameField);

        JLabel client1LoanLabel = new JLabel("Client 1 Loan Amount:");
        client1LoanLabel.setBounds(50, 90, 150, 30);
        panel.add(client1LoanLabel);
        JTextField client1LoanField = new JTextField();
        client1LoanField.setBounds(250, 90, 150, 30);
        panel.add(client1LoanField);

        JLabel client1DurationLabel = new JLabel("Client 1 Loan Duration (Months):");
        client1DurationLabel.setBounds(50, 130, 200, 30);
        panel.add(client1DurationLabel);
        JTextField client1DurationField = new JTextField();
        client1DurationField.setBounds(250, 130, 150, 30);
        panel.add(client1DurationField);

        JLabel client2NameLabel = new JLabel("Client 2 Name:");
        client2NameLabel.setBounds(50, 170, 150, 30);
        panel.add(client2NameLabel);
        JTextField client2NameField = new JTextField();
        client2NameField.setBounds(250, 170, 150, 30);
        panel.add(client2NameField);

        JLabel client2LoanLabel = new JLabel("Client 2 Loan Amount:");
        client2LoanLabel.setBounds(50, 210, 150, 30);
        panel.add(client2LoanLabel);
        JTextField client2LoanField = new JTextField();
        client2LoanField.setBounds(250, 210, 150, 30);
        panel.add(client2LoanField);

        JLabel client2DurationLabel = new JLabel("Client 2 Loan Duration (Months):");
        client2DurationLabel.setBounds(50, 250, 200, 30);
        panel.add(client2DurationLabel);
        JTextField client2DurationField = new JTextField();
        client2DurationField.setBounds(250, 250, 150, 30);
        panel.add(client2DurationField);


        JLabel client3NameLabel = new JLabel("Client 3 Name:");
        client3NameLabel.setBounds(50, 290, 150, 30);
        panel.add(client3NameLabel);
        JTextField client3NameField = new JTextField();
        client3NameField.setBounds(250, 290, 150, 30);
        panel.add(client3NameField);

        JLabel client3LoanLabel = new JLabel("Client 3 Loan Amount:");
        client3LoanLabel.setBounds(50, 330, 150, 30);
        panel.add(client3LoanLabel);
        JTextField client3LoanField = new JTextField();
        client3LoanField.setBounds(250, 330, 150, 30);
        panel.add(client3LoanField);

        JLabel client3DurationLabel = new JLabel("Client 3 Loan Duration (Months):");
        client3DurationLabel.setBounds(50, 370, 200, 30);
        panel.add(client3DurationLabel);
        JTextField client3DurationField = new JTextField();
        client3DurationField.setBounds(250, 370, 150, 30);
        panel.add(client3DurationField);



        JLabel interestRateLabel = new JLabel("INTEREST RATE IN %:");
        interestRateLabel.setBounds(50, 410, 150, 30);
        panel.add(interestRateLabel);
        JTextField interestRateField = new JTextField("1.5");
        interestRateField.setBounds(250, 410, 150, 30);
        interestRateField.setEditable(false);
        panel.add(interestRateField);


        JButton calculateAmountsButton = new JButton("Calculate Payable");
        calculateAmountsButton.setBounds(50, 450, 150, 30);
        panel.add(calculateAmountsButton);


//        JButton calculateMonthlyButton = new JButton("CALCULATE AMOUNT TO BE PAID PER MONTH");
//        calculateMonthlyButton.setBounds(50, 270, 300, 30);
//        panel.add(calculateMonthlyButton);


        JTextArea resultArea = new JTextArea();
        resultArea.setBounds(50, 490, 400, 200);
        resultArea.setEditable(false);
        panel.add(resultArea);

        f.setSize(550, 750);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);


        calculateAmountsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {

                    String name1 = client1NameField.getText();
                    String name2 = client2NameField.getText();
                    String name3 = client3NameField.getText();

                    double loan1 = Double.parseDouble(client1LoanField.getText());
                    double loan2 = Double.parseDouble(client2LoanField.getText());
                    double loan3 = Double.parseDouble(client3LoanField.getText());
                    double interestRate = Double.parseDouble(interestRateField.getText());


                    double payable1 = loan1 + (loan1 * interestRate / 100);
                    double payable2 = loan2 + (loan2 * interestRate / 100);
                    double payable3 = loan3 + (loan3 * interestRate / 100);


                    double profit1 = loan1 * interestRate / 100;
                    double profit2 = loan2 * interestRate / 100;
                    double profit3 = loan3 * interestRate / 100;
                    double totalProfit = profit1 + profit2 + profit3;


                    resultArea.setText(String.format(
                            "%s Amount Payable: %.2f\n" +
                                    "%s Amount Payable: %.2f\n" +
                                    "%s Amount Payable: %.2f\n\n" +
                                    "Total Profit: %.2f",
                            name1, payable1,
                            name2, payable2,
                            name3, payable3,
                            totalProfit
                    ));
                } catch (NumberFormatException ex) {
                    resultArea.setText("Please enter valid loan amounts.");
                }
            }
        });
    }
}
