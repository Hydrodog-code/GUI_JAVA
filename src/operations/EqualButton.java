package operations;

import javax.swing.*;

import static operations.AddButton.firstNumber;
import static operations.AddButton.operation;
import static operations.AddButton.startNewNumber;


public class EqualButton extends JButton{

    private static JLabel label;

    public EqualButton(String text, JLabel displayLabel){
        super(text); // Crée le bouton avec le texte "+"
        EqualButton.label = displayLabel;
        setupActionListener(); // Appelle la méthode pour ajouter l'écouteur
    }

    private void setupActionListener() {
        this.addActionListener(e -> {
            String currentText = label.getText();
            double secondNumber = 0;
            double resultat = 0;
            try {
                secondNumber = Double.parseDouble(currentText); // Utiliser Double pour les décimales
            } catch (NumberFormatException ex) {
                // Gérer l'erreur si le texte n'est pas un nombre
                label.setText("Erreur");
                return;
            }
            if (operation.equals("+")){
                resultat = firstNumber + secondNumber;
            } else {
                // Si l'opération est vide (clic sur = avant un opérateur), ne rien faire ou afficher le nombre
                if (operation.isEmpty()) {
                    resultat = secondNumber; // Le résultat est juste le nombre tapé
                } else {
                    if (operation.equals("/")) {
                        resultat = firstNumber / secondNumber;
                    }if (operation.equals("*")) {
                        resultat = firstNumber * secondNumber;
                    }if (operation.equals("-")) {
                        resultat = firstNumber - secondNumber;
                    }
                }
            }
            label.setText(String.valueOf(resultat));
            operation = "";
            startNewNumber = true;
        });
    }
}
