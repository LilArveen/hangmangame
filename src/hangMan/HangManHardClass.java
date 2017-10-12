package hangMan;
import java.io.File;
import java.io.IOException;
import java.util.*;

public class HangManHardClass{
	
	private String GameWord;
	Random randGenerator = new Random();
	static ArrayList<String> words = new ArrayList<String>();
	private int numberOfGuesses=0;
	public String str1 ="";
	private String filledWord = "";
	
public void readFile() throws IOException
{
	File file = new File("HangManWords.txt"); 
	Scanner reader = new Scanner(file );
	while(reader.hasNext())
	{
	words.add(reader.next());
	
	}
}
public void clearWord()
{
	words.clear();
}
public String decideGameWord()
{
	try {readFile();} catch(IOException e) {System.err.println("file exception");}
	int ArrayIndex = randGenerator.nextInt(31);

	GameWord = words.get(ArrayIndex);
	return GameWord;
}


public boolean checkGuess(String g)
{
	
	if(numberOfGuesses ==0)
	{
		decideGameWord();
		for(int i = 0; i < GameWord.length();i++)
		{
			filledWord +="_";
		}
	}
	
	char ch;
	ch = g.charAt(0);
	
	StringBuilder str4replace = new StringBuilder(filledWord);
	
	for(int i = 0; i < GameWord.length();i++)
	{
		
		
		if(ch==GameWord.charAt(i) && filledWord.charAt(i)=='_')
		{
			str4replace.setCharAt(i, ch);
			filledWord = str4replace.toString();
		}
	}
	
	numberOfGuesses ++;
	
	
	str1+= numberOfGuesses + " guess(es) and "+ "letters discovered: " + filledWord +"\n";

	return filledWord.equalsIgnoreCase(GameWord);
}

public boolean checkWord(String g)
{
	return g.equalsIgnoreCase(GameWord);
}

public String getGameWord()
{
	return GameWord;
}



public String toString()
{
	return str1;
}

}
