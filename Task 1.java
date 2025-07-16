import java.util.Scanner;
import java.util.Random;

public class NumberGame {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random rand = new Random();
        int min = 1, max = 100;
        int attempts, score = 0;

        System.out.println("Welcome to the Number Guessing Game!");

        char playAgain;
        do {
            int numberToGuess = rand.nextInt(max - min + 1) + min;
            attempts = 0;
            int guess;

            while (true) {
                System.out.print("Enter your guess (1-100): ");
                guess = sc.nextInt();
                attempts++;

                if (guess == numberToGuess) {
                    System.out.println("Correct! You guessed it in " + attempts + " attempts.");
                    score++;
                    break;
                } else if (guess > numberToGuess) {
                    System.out.println("Too high! Try again.");
                } else {
                    System.out.println("Too low! Try again.");
                }
            }

            System.out.print("Do you want to play again? (y/n): ");
            playAgain = sc.next().charAt(0);

        } while (playAgain == 'y' || playAgain == 'Y');

        System.out.println("Thanks for playing! Your score: " + score);
        sc.close();
    }
}
