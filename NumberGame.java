import java.util.Random;
import java.util.Scanner;

public class NumberGame {

    public static void main(String[] args) {
        
        try (Scanner scanner = new Scanner(System.in)) {
            Random random = new Random();
            
            final int MIN_RANGE = 1;
            final int MAX_RANGE = 100;
            final int MAX_ATTEMPTS = 5;
            
            int roundsWon = 0;
            boolean playAgain;

            System.out.println("Number Guessing Game!");

            do { 
                int numberToGuess = random.nextInt(MAX_RANGE - MIN_RANGE + 1) + MIN_RANGE;
                int attempts = 0;
                boolean guessedCorrectly = false;

                System.out.printf("\nI have generated a number between %d and %d.\n", MIN_RANGE, MAX_RANGE);
                System.out.printf("You have %d attempts to guess it. Good luck!\n", MAX_ATTEMPTS);

                while (attempts < MAX_ATTEMPTS && !guessedCorrectly) {
                    
                    System.out.printf("\nAttempt %d/%d - Enter your guess: ", attempts + 1, MAX_ATTEMPTS);
                    
                    if (!scanner.hasNextInt()) {
                        System.out.println("Invalid input. Please enter a number.");
                        scanner.next();
                        continue;
                    }
                    
                    int userGuess = scanner.nextInt();
                    attempts++;

                    if (userGuess == numberToGuess) {
                        System.out.printf("Correct! You guessed the number %d in %d attempts.\n", numberToGuess, attempts);
                        guessedCorrectly = true;
                        roundsWon++; 
                    } else if (userGuess < numberToGuess) {
                        System.out.println("Too low!");
                    } else {
                        System.out.println("Too high!");
                    }
                }

                if (!guessedCorrectly) {
                    System.out.printf("Game over! You've used all %d attempts. The number was %d.\n", MAX_ATTEMPTS, numberToGuess);
                }

                System.out.printf("Your current score: %d round(s) won.\n", roundsWon);
                System.out.print("\nDo you want to play another round? (yes/no): ");
                String response = scanner.next();
                playAgain = response.equalsIgnoreCase("yes");

            } while (playAgain);

            System.out.println("\nThank you for playing!");
        }
    }
}