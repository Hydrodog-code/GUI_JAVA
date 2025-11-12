package operations;

import javax.swing.*;

import static operations.AddButton.firstNumber;
import static operations.AddButton.operation;
import static operations.AddButton.startNewNumber;

public class MultiplyButton extends JButton {

    // Déclarer le JLabel pour l'affichage
    static JLabel label;

    // Constructeur pour créer le bouton et lui donner accès au JLabel
    public MultiplyButton(String text, JLabel displayLabel) {
        super(text);
        MultiplyButton.label = displayLabel;
        setupActionListener();
    }

    private void setupActionListener() {
        // Le listener utilise les champs statiques ci-dessus
        this.addActionListener(e -> {
            String currentText = label.getText();
            try {
                firstNumber = Double.parseDouble(currentText); // Utiliser Double pour les décimales
            } catch (NumberFormatException ex) {
                // Gérer l'erreur si le texte n'est pas un nombre
                label.setText("Erreur");
                return;
            }

            operation = "*";

            label.setText("0");

            startNewNumber = true;
        });
    }
}