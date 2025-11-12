import operations.AddButton;
import operations.EqualButton;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



public class SimpleGUI {
    public static void main(String[] args) {
        // Bonne pratique : exécuter la création de la GUI sur l'EDT
        SwingUtilities.invokeLater(SimpleGUI::createAndShowGUI);
    }

    private static void createAndShowGUI() {

        Font myFont = new Font("Arial", Font.BOLD, 16);
        Border blackline = BorderFactory.createLineBorder(Color.black);
        // Create a new window (JFrame)
        JFrame frame = new JFrame("GUI Calculator");
        frame.setSize(500, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null); // absolute positioning

        // buttons
        JButton button0 = new JButton("0");
        button0.setFont(myFont);
        button0.setBounds(70, 200, 50, 40);


        JButton button1 = new JButton("1");
        button1.setFont(myFont);
        button1.setBounds(20, 160, 50, 40);
        JButton button2 = new JButton("2");
        button2.setFont(myFont);
        button2.setBounds(70, 160, 50, 40);
        JButton button3 = new JButton("3");
        button3.setFont(myFont);
        button3.setBounds(120, 160, 50, 40);


        JButton button4 = new JButton("4");
        button4.setFont(myFont);
        button4.setBounds(20, 120, 50, 40);
        JButton button5 = new JButton("5");
        button5.setFont(myFont);
        button5.setBounds(70,120, 50, 40);
        JButton button6 = new JButton("6");
        button6.setFont(myFont);
        button6.setBounds(120, 120, 50, 40);


        JButton button7 = new JButton("7");
        button7.setFont(myFont);
        button7.setBounds(20, 80, 50, 40);
        JButton button8 = new JButton("8");
        button8.setFont(myFont);
        button8.setBounds(70, 80, 50, 40);
        JButton button9 = new JButton("9");
        button9.setFont(myFont);
        button9.setBounds(120, 80, 50, 40);


        JButton buttonDelete = new JButton("C");
        buttonDelete.setFont(myFont);
        buttonDelete.setBounds(190, 80, 50, 40);

        JButton buttonDeleteOne = new JButton("AC");
        buttonDeleteOne.setFont(myFont);
        buttonDeleteOne.setBounds(240, 80, 60, 40);

        JButton buttonMinus = new JButton("-");
        buttonMinus.setFont(myFont);
        buttonMinus.setBounds(190, 160, 50, 40);

        JButton buttonMultiply = new JButton("*");
        buttonMultiply.setFont(myFont);
        buttonMultiply.setBounds(240, 120, 50, 40);





        // label
        JLabel label = new JLabel();
        label.setBounds(20, 20, 150, 25);
        label.setText("0");
        label.setBorder(blackline);
        label.setFont(myFont);
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

        //button add
        AddButton buttonAdd = new AddButton("+",label);
        buttonAdd.setFont(myFont);
        buttonAdd.setBounds(190, 120, 50, 40);


        //boutton egal
        EqualButton buttonEqual = new EqualButton("=",label);
        buttonEqual.setFont(myFont);
        buttonEqual.setBounds(190, 200, 50, 40);

        //function to delete only one digit
        buttonDeleteOne.addActionListener(e -> {
            String currentText = label.getText();
            if (currentText.length() > 1){
                String newText = currentText.substring(0, currentText.length() - 1); //permet de retirer un chiffre (prends en gros la totalite du texte et enleve le dernier)
                label.setText(newText);
            }

            else if (currentText.length() == 1) {
                label.setText("0");
            }
        });

        //ajout evenement pour remettre le compteur à zéro
        buttonDelete.addActionListener(e -> {
            label.setText("0");
        });

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


        //ajout des boutons sur l'application
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
        frame.add(buttonDelete);
        frame.add(buttonDeleteOne);
        frame.add(buttonEqual);
        frame.add(buttonAdd);
        frame.add(buttonMinus);
        frame.add(buttonMultiply);
        frame.add(label);
        frame.setVisible(true);
    }
}