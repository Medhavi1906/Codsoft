import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int roundsPlayed = 0;
        int totalScore = 0;

        System.out.println("=== Welcome to the Number Guessing Game! ===");

        boolean playAgain = true;

        while (playAgain) {
            int numberToGuess = random.nextInt(100) + 1; // Random number between 1 and 100
            int maxAttempts = 7;
            int attempts = 0;
            boolean guessedCorrectly = false;

            System.out.println("\nI have selected a number between 1 and 100.");
            System.out.println("You have " + maxAttempts + " attempts to guess it!");

            while (attempts < maxAttempts) {
                System.out.print("Attempt " + (attempts + 1) + ": Enter your guess: ");
                
                if (scanner.hasNextInt()) {
                    int guess = scanner.nextInt();
                    attempts++;

                    if (guess == numberToGuess) {
                        System.out.println("🎉 Correct! You guessed the number in " + attempts + " attempts.");
                        int roundScore = maxAttempts - attempts + 1; // Higher score for fewer attempts
                        totalScore += roundScore;
                        guessedCorrectly = true;
                        break;
                    } else if (guess < numberToGuess) {
                        System.out.println("Too low! Try again.");
                    } else {
                        System.out.println("Too high! Try again.");
                    }
                } else {
                    System.out.println("Please enter a valid number!");
                    scanner.next(); // Clear invalid input
                }
            }

            if (!guessedCorrectly) {
                System.out.println("❌ Sorry! You've used all attempts. The number was: " + numberToGuess);
            }

            roundsPlayed++;

            // Ask if the user wants to play again
            System.out.print("Do you want to play another round? (yes/no): ");
            String response = scanner.next().toLowerCase();

            if (!response.equals("yes") && !response.equals("y")) {
                playAgain = false;
            }
        }

        System.out.println("\n=== Game Over ===");
        System.out.println("Rounds played: " + roundsPlayed);
        System.out.println("Total score: " + totalScore);

        scanner.close();
    }
}
