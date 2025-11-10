import javax.swing.*;

public class SimpleGUI {
    public static void main(String[] args) {

        // Create a new window (JFrame)
        JFrame frame = new JFrame("My First GUI");
        frame.setSize(500, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null); // absolute positioning
        // text field
//        JTextField textField = new JTextField();
//        textField.setBounds(20, 20, 150, 25);

        // buttons
        JButton button0 = new JButton("0");
        button0.setBounds(70, 200, 50, 40);
        JButton button1 = new JButton("1");
        button1.setBounds(20, 160, 50, 40);
        JButton button2 = new JButton("2");
        button2.setBounds(70, 160, 50, 40);
        JButton button3 = new JButton("3");
        button3.setBounds(120, 160, 50, 40);
        JButton button4 = new JButton("4");
        button4.setBounds(20, 120, 50, 40);
        JButton button5 = new JButton("5");
        button5.setBounds(70,120, 50, 40);
        JButton button6 = new JButton("6");
        button6.setBounds(120, 120, 50, 40);
        JButton button7 = new JButton("7");
        button7.setBounds(20, 80, 50, 40);
        JButton button8 = new JButton("8");
        button8.setBounds(70, 80, 50, 40);
        JButton button9 = new JButton("9");
        button9.setBounds(120, 80, 50, 40);


        // label
        JLabel label = new JLabel();
        label.setBounds(20, 20, 250, 25);
        label.setText("Hello !");
        button0.addActionListener(e -> {
            label.setText("0");
        });
        button1.addActionListener(e -> {
            label.setText("1");
        });
        button2.addActionListener(e -> {
            label.setText("2");
        });
        button3.addActionListener(e -> {
            label.setText("3");
        });
        button4.addActionListener(e -> {
            label.setText("4");
        });
        button5.addActionListener(e -> {
            label.setText("5");
        });
        button6.addActionListener(e -> {
            label.setText("6");
        });
        button7.addActionListener(e -> {
            label.setText("7");
        });
        button8.addActionListener(e -> {
            label.setText("8");
        });
        button9.addActionListener(e -> {
            label.setText("9");
        });

        frame.add(button0);
        frame.add(button1);
        frame.add(button2);
        frame.add(button3);
        frame.add(button4);
        frame.add(button5);
        frame.add(button6);
        frame.add(button7);
        frame.add(button8);
        frame.add(button9);
        frame.add(label);
        frame.setVisible(true);
    }
}