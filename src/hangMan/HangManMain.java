package hangMan;

import java.io.IOException;
import java.util.Scanner;

public class HangManMain 
{
	public static void main(String[] args)
	
	{
		
		String x, h="";
		
		Scanner input = new Scanner(System.in);
		
		do
		{
			System.out.println("Welcome to hangman. You have 5 gusses to guess the letters. ");
			System.out.println("After 5 turns and you have still not guessed all the letters, you will be prompted to guess the word.");
			System.out.println("This is very hard. Some words are MASSIVE. Don't be surprised if you fail and dishonor your famiry");
			System.out.println("If you repeat a letter, you will lose a life still.");
			HangManHardClass ALVIN = new HangManHardClass();
			System.out.println("");
			
			int lives = 6; int counter = 0;
			
			System.out.println("Guess a letter: ");
			h=input.next();
			counter++;
			
			while(!ALVIN.checkGuess(h))
			{
				System.out.println(ALVIN);
				
				if (counter==5) break;
				System.out.println("Guess a letter: ");
				h=input.next();
			    counter++;
			};
			System.out.println("Guess/enter the Word.");
			h=input.next();
			
			if(ALVIN.checkWord(h))
				System.out.println("You win.");
			else
				System.out.println("Lose, word was: " + ALVIN.getGameWord());
		
		
			System.out.println("Continue? Enter in y/n");
			x= input.next();
			ALVIN.clearWord();
		}
		while (x.equals("y")|| x.equals("Y"));

	
	}
}