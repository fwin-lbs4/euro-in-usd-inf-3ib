package quest.flo.lbs4.class3ib.currencyconversion;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Locale;

public class Calculator implements ActionListener {
    private String name;
    private int width;
    private int height;
    private final JFrame frame;

    private JLabel euroLabel;
    private JTextField euroField;
    private JLabel usdLabel;
    private JLabel usdResult;

    private JLabel messageLabel;

    private JButton calcButton;

    private final Float exchangeRate = 1.09F;

    public Calculator(String name, int width, int height) {
        this.name = name;
        this.width = width;
        this.height = height;

        this.frame = new JFrame(this.name);
        this.frame.applyComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
        this.frame.setSize(this.width, this.height);
        this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.frame.setLayout(new GridLayout(0, 2, 4, 4));
        this.frame.setLocationRelativeTo(null);

        this.euroLabel = new JLabel("Amount in euro");
        this.euroField = new JTextField();
        this.euroField.addActionListener(this);
        this.usdLabel = new JLabel("Amount in usd");
        this.usdResult = new JLabel("0");

        this.frame.add(this.euroLabel);
        this.frame.add(this.euroField);
        this.frame.add(this.usdLabel);
        this.frame.add(this.usdResult);

        this.messageLabel = new JLabel();

        this.calcButton = new JButton("Calculate");
        this.calcButton.addActionListener(this);

        this.frame.add(this.messageLabel);
        this.frame.add(this.calcButton);
    }

    public void start() {
        this.frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            String euroString = this.euroField.getText().replaceAll(",", ".");
            this.euroField.setText(this.euroField.getText().replaceAll(",", "."));
            Float euroValue = Float.parseFloat(euroString);

            float result = euroValue * this.exchangeRate;

            this.usdResult.setText(String.format(java.util.Locale.US, "%.02f", result));
            this.messageLabel.setText("");
        } catch (NumberFormatException exception) {
            this.euroField.setText("");
            this.usdResult.setText("0");
            this.messageLabel.setText("Set a valid value in input!");
            System.out.println("Error: " + exception.getMessage());
        }
    }
}
