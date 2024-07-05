import java.util.Random;
import java.util.Scanner;

public class Guess_Number {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random rd = new Random();

        boolean playAgain = true;
        int Score = 0;

        while (playAgain) {
            int rd_number = rd.nextInt(100) + 1; 
            int numberOfTries = 0;
            int maxTries = 10; 
            boolean hasWon = false;

            System.out.println("Welcome to the Number Guessing Game!");
            System.out.println("I have randomly chosen a number between 1 and 100.");
            System.out.println("You have a maximum of " + maxTries + " attempts to guess it.");

            while (numberOfTries < maxTries && !hasWon) {
                System.out.print("Enter your guess: ");
                int guess = sc.nextInt();
                numberOfTries++;

                if (guess < 1 || guess > 100) {
                    System.out.println("Invalid input! Please enter a number between 1 and 100.");
                } else if (guess < rd_number) {
                    System.out.println("It's higher than " + guess + ". Try again.");
                } else if (guess > rd_number) {
                    System.out.println("It's lower than " + guess + ". Try again.");
                } else {
                    hasWon = true;
                    System.out.println("Congratulations! You've guessed the number.");
                    Score += maxTries - numberOfTries + 1;
                    System.out.println("It took you " + numberOfTries + " tries.");
                }
            }

            if (!hasWon) {
                System.out.println("Sorry, you've used all your attempts. The number was: " + rd_number);
            }

            System.out.println("Your current score is: " + Score);
            System.out.print("Do you want to play again? (yes/no): ");
            sc.nextLine(); 
            String response = sc.nextLine().trim().toLowerCase();
            if (!response.equals("yes")) {
                playAgain = false;
            }
        }

        System.out.println("Thank you for playing! Your final score is: " + Score);
        sc.close();
    }
}