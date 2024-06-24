import java.util.Scanner;
import java.util.Random;

public class NumberGuessingGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        boolean playAgain = true;
        int totalScore = 0;
        int highScore = 0;

        while (playAgain) {
            int secretNumber = random.nextInt(100) + 1;

            System.out.println("Welcome to the Number Guessing Game!");
            System.out.println("I have generated a random number between 1 and 100. Can you guess it?");

            int attempts = 0;
            boolean guessedCorrectly = false;

            while (!guessedCorrectly && attempts < 10) { // Limit to 10 attempts
                System.out.print("Enter your guess: ");

                
                while (!scanner.hasNextInt()) {
                    System.out.println("Invalid input! Please enter an integer guess.");
                    System.out.print("Enter your guess: ");
                    scanner.next(); 
                }

                int guess = scanner.nextInt();
                scanner.nextLine();

                attempts++;

                if (guess == secretNumber) {
                    System.out.println("Congratulations! You guessed it right in " + attempts + " attempts!");
                    int score = 10 - attempts; // 
                    totalScore += score; 
                    if (score > highScore) {
                        highScore = score; 
                    }
                    guessedCorrectly = true;
                } else if (guess < secretNumber) {
                    System.out.println("Too low! Guess again.");
                } else {
                    System.out.println("Too high! Guess again.");
                }
            }

            if (!guessedCorrectly) {
                System.out.println("Sorry, you've used all your attempts. The number was " + secretNumber + ".");
            }

            
            System.out.println("Your total score is: " + totalScore);
            System.out.println("Your high score is: " + highScore);

            
            System.out.print("Do you want to play again? (yes/no): ");
            String playAgainInput = scanner.nextLine();

            
            while (!playAgainInput.equalsIgnoreCase("yes") && !playAgainInput.equalsIgnoreCase("no")) {
                System.out.println("Invalid input! Please enter 'yes' or 'no'.");
                System.out.print("Do you want to play again? (yes/no): ");
                playAgainInput = scanner.nextLine();
            }

            playAgain = playAgainInput.equalsIgnoreCase("yes");
        }

        System.out.println("Thank you for playing!");
        scanner.close();
    }
}