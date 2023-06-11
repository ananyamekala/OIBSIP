import java.util.Random;
import javax.swing.JOptionPane;

public class GuessTheNumber {
    public static void main(String[] args) {
        int minNumber = 1;
        int maxNumber = 100;
        int maxAttempts = 10;
        int score = 0;
        
        JOptionPane.showMessageDialog(null, "Welcome to Guess the Number game!");
        
        Random random = new Random();
        int randomNumber = random.nextInt(maxNumber - minNumber + 1) + minNumber;
        
        boolean guessedCorrectly = false;
        
        while (!guessedCorrectly && maxAttempts > 0) {
            String guessString = JOptionPane.showInputDialog("Enter your guess (between " + minNumber + " and " + maxNumber + ")");
            
            if (guessString == null) {
                // User clicked on cancel or closed the dialog
                break;
            }
            
            int guess = Integer.parseInt(guessString);
            
            if (guess == randomNumber) {
                guessedCorrectly = true;
                score += maxAttempts * 10; // Increase score based on the remaining attempts
                JOptionPane.showMessageDialog(null, "Congratulations! You guessed the number " + randomNumber + " correctly!");
            } else if (guess < randomNumber) {
                JOptionPane.showMessageDialog(null, "Too low! Try again.");
            } else {
                JOptionPane.showMessageDialog(null, "Too high! Try again.");
            }
            
            maxAttempts--;
        }
        
        if (!guessedCorrectly) {
            JOptionPane.showMessageDialog(null, "Game over! You ran out of attempts. The number was " + randomNumber);
        }
        
        JOptionPane.showMessageDialog(null, "Your final score is: " + score);
    }
}
