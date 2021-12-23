import java.util.Scanner;
import java.util.Random;

public class RandomNumberGuesser extends RNG {

	public static void main(String[] args) {
		String tryAgain;
		do {
			int randNum = RNG.rand();
			int nextGuess;
			int highGuess = 100;
			int lowGuess = 0;
			int count = 0;
			RNG.rand();

			Scanner userInput = new Scanner(System.in);

			System.out.println("Enter your first guess: ");
			nextGuess = userInput.nextInt();
			RNG.getCount();
			count++;
			System.out.println("Number of guesses is " + count);
			count++;

			if (nextGuess > randNum) {
				System.out.println("Your guess is too high");
				highGuess = nextGuess;
			} else if (nextGuess < randNum) {
				System.out.println("Your guess is too low");
				lowGuess = nextGuess;
			}

			while (nextGuess != randNum) {
				System.out.println("Enter your next guess between " + lowGuess + " and " + highGuess);
				nextGuess = userInput.nextInt();
				System.out.println("Number of guesses is " + count);
				RNG.inputValidation(nextGuess, lowGuess, highGuess);
				if (nextGuess > randNum && nextGuess < highGuess) {
					System.out.println("Your guess is too high");
					highGuess = nextGuess;
				} else if (nextGuess < randNum && nextGuess > lowGuess) {
					System.out.println("Your guess is too low");
					lowGuess = nextGuess;
				}
				count++;
				RNG.getCount();
			}

			Scanner tryAgainInput = new Scanner(System.in);

			System.out.println("Congratulations, you guessed correctly");
			System.out.println("Try again? (yes or no)");
			tryAgain = tryAgainInput.nextLine();

			if (tryAgain.equals("yes")) {
				RNG.resetCount();
			} else if (tryAgain.equals("no")) {
				System.out.println("Thanks for playing...");
			}
		} while (tryAgain.equals("yes"));
		System.exit(0);

	}

}