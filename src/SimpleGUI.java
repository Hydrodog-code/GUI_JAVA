import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SimpleGUI {
    public static void main(String[] args) {
        // Bonne pratique : exécuter la création de la GUI sur l'EDT
        SwingUtilities.invokeLater(() -> createAndShowGUI());
    }

    private static void createAndShowGUI() {

        // Create a new window (JFrame)
        JFrame frame = new JFrame("GUI Calculator");
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
        label.setText("0");
        ActionListener numberListener = e -> {
            // Récupère le bouton cliqué
            JButton source = (JButton) e.getSource();
            // Récupère la valeur du bouton (e.g., "7", "0")
            String digit = source.getText();
            String currentText = label.getText();

            // Logique de concaténation :
            if (currentText.equals("0")) {
                // Si l'écran affiche uniquement "0", on le remplace par le nouveau chiffre (sauf si c'est '0')
                if (!digit.equals("0")) {
                    label.setText(digit);
                }
            } else {
                // Sinon, on ajoute le nouveau chiffre à la fin
                label.setText(currentText + digit);
            }
        };

        //ajout des actions qui permet d'ecouter le boutons et d'afficher le chiffre inscrit dessus

        button0.addActionListener(numberListener);
        button1.addActionListener(numberListener);
        button2.addActionListener(numberListener);
        button3.addActionListener(numberListener);
        button4.addActionListener(numberListener);
        button5.addActionListener(numberListener);
        button6.addActionListener(numberListener);
        button7.addActionListener(numberListener);
        button8.addActionListener(numberListener);
        button9.addActionListener(numberListener);

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