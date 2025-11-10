// Fichier: AddButton.java (ou le fichier qui contient la logique des boutons)

import javax.swing.*;

public class AddButton extends JButton {

    private static double firstNumber = 0;
    private static String operation = "";
    private static boolean startNewNumber = true;

    // Déclarer le JLabel pour l'affichage 
    private static JLabel label;

    // Constructeur pour créer le bouton et lui donner accès au JLabel
    public AddButton(String text, JLabel displayLabel) {
        super(text); // Crée le bouton avec le texte "+"
        AddButton.label = displayLabel;
        setupActionListener(); // Appelle la méthode pour ajouter l'écouteur
    }

    private void setupActionListener() {
        // Le listener utilise les champs statiques ci-dessus
        this.addActionListener(e -> {
            // 1. Lire et stocker le nombre actuellement affiché
            String currentText = label.getText();
            try {
                firstNumber = Double.parseDouble(currentText); // Utiliser Double pour les décimales
            } catch (NumberFormatException ex) {
                // Gérer l'erreur si le texte n'est pas un nombre
                label.setText("Erreur");
                return;
            }

            operation = "+";

            label.setText("0");

            startNewNumber = true;
        });
    }
}