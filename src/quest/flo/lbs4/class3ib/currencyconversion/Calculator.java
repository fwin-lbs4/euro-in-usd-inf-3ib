package quest.flo.lbs4.class3ib.currencyconversion;

import javax.swing.*;
import java.awt.*;

public class Calculator {
    private String name;
    private int width;
    private int height;
    private JFrame frame;
    public Calculator(String name, int width, int height) {
        this.name = name;
        this.width = width;
        this.height = height;

        this.frame = new JFrame(this.name);
        this.frame.applyComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
        this.frame.setSize(this.width, this.height);
        this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        GridLayout grid = new GridLayout(0, 2, 4, 4);
        this.frame.setLayout(grid);
        this.frame.setLocationRelativeTo(null);


        JLabel euroLabel = new JLabel("Amount in euro");
        JTextField euroField = new JTextField("Enter amount");
        JLabel usdLabel = new JLabel("Amount in usd");
        JLabel usdResult = new JLabel("0");


        this.frame.add(euroLabel);
        this.frame.add(euroField);
        this.frame.add(usdLabel);
        this.frame.add(usdResult);

        JButton calcButton = new JButton("Calculate");

        this.frame.add(new JLabel());
        this.frame.add(calcButton);
    }

    public void start() {
        this.frame.setVisible(true);
    }
}
