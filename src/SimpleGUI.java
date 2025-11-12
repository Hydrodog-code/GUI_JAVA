import operations.AddButton;
import operations.DivisionButton;
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
        JButton[] button = new JButton[10];
        Font myFont = new Font("Arial", Font.BOLD, 16);
        Border blackline = BorderFactory.createLineBorder(Color.black);
        // Create a new window (JFrame)
        JFrame frame = new JFrame("GUI Calculator");
        frame.setSize(500, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null); // absolute positioning

        // buttons



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

        DivisionButton buttonDivision = new DivisionButton("/",label);
        buttonDivision.setFont(myFont);
        buttonDivision.setBounds(240, 160, 50, 40);

        // premier [] on cherche l'index, dexuieme [] sert de l'element
        int[][] bounds = {
                {70, 200, 50, 40},
                {20, 160, 50, 40},
                {70, 160, 50, 40},
                {120, 160, 50, 40},
                {20, 120, 50, 40},
                {70, 120, 50, 40},
                {120, 120, 50, 40},
                {20, 80, 50, 40},
                {70, 80, 50, 40},
                {120, 80, 50, 40}
        };

        for (int i = 0; i < 10 ; i++) {
            // 1. INITIALISATION: Crée l'objet JButton
            button[i] = new JButton(String.valueOf(i));

            // 2. POSITIONNEMENT
            button[i].setBounds(bounds[i][0], bounds[i][1], bounds[i][2], bounds[i][3]);
            button[i].setFont(myFont);

            // 3. ECOUTEUR
            button[i].addActionListener(numberListener);

            // 4. AJOUT AU FRAME
            frame.add(button[i]);
        }

        //ajout des boutons sur l'application
        frame.add(buttonDivision);
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