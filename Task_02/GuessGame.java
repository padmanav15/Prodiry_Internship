package com.jsp.Task_02;

import java.util.Scanner;

public class GuessGame {
	    public static void main(String[] args) {
	        Scanner scanner = new Scanner(System.in);
	        int randomnumber = (int) (Math.random() * 100) + 1;
	        int guesses = 0;
	        boolean CorrectGuess = false;

	        System.out.println("Welcome to the Guessing Game!");
	        System.out.println("Select a number between 1 and 100. Try to guess it!");

	        while (!CorrectGuess) {
	            System.out.print("Enter the guess: ");
	            int guess = scanner.nextInt();
	            guesses++;

	            if (guess == randomnumber) {
	                System.out.println("Congratulations! You guessed the correct number in " + guesses + " guesses.");
	                CorrectGuess = true;
	            } else if (guess < randomnumber) {
	                System.out.println("Guessing Too Low Number! Try again.");
	            } else {
	                System.out.println("Guessing Too High Number! Try again.");
	            }
	        }

	        scanner.close();
	    }
	}
