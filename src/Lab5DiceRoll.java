import java.util.Random;
import java.util.Scanner;

/**
 * @author Caroline
 **
 *
 *USE

The app asks the user to enter the number of sides for a pair of dice
prompts the user to roll the dice.
App rolls the 2 n-sided dice, displays the results of each, and then
asks the user if they want to roll the dice again.

BUILD SPEC

Use  static methods to implement the methods that generate the random number.
Try different random number generators.

HINTS

Use math random
Murach's Java Chapter 4

CHALLENGE

Display special messages for craps, snake eyes, and box cars.

*/

public class Lab5DiceRoll {

	static Scanner input = new Scanner(System.in);
	static String play;

	public static void main(String[] args) {

		System.out.println("Welcome to the Grand Circus Casino! Roll the dice? (y/n)");
		play = input.next();

		while (play.equalsIgnoreCase("y")) {
			
			int diceSides = validateRange();
			Random rnd = new Random();
			System.out.println(rnd.nextInt(diceSides)+1);
			System.out.println(rnd.nextInt(diceSides)+1);
			continueOrQuit(input);
		}
		System.out.println("Good-bye.");
	}

	private static void continueOrQuit(Scanner input) {
		System.out.println("Would you like to roll again? (y/n)");
		play = input.next();
	}

	private static int getInteger(String question) {
		System.out.println(question);
		while (!input.hasNextInt()) {
			System.out.println("You have entered invalid data. Please enter a whole number. ");
			input.next();
		}
		int answer = input.nextInt();
		return answer;
	}

	private static int validateRange() {
		int answer = getInteger("How many sides do you want the dice to have?");
		while (answer > 20 || answer < 4) {
			answer = getInteger("Where do you get dice like those? How about something between 4 and 20?");
		}
		return answer;
	}
}
