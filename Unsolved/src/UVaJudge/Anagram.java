package UVaJudge;

import java.util.ArrayList;
import java.util.Scanner;

public class Anagram // UVa Judge: 195
{
 public static void main(String[] args)
 {
	 Scanner scanner = new Scanner(System.in);
	 ArrayList<String> userInput = new ArrayList<String>();
	 int[][] wordCount;
	 int counter = 0;
	 userInput.add(scanner.nextLine());
	 
	 while(!(userInput.get(counter).equals("#")))
	{
 		userInput.add(scanner.nextLine());
 		counter++;
	 }
	 
	 wordCount = new int[2][userInput.size() - 1];
	 for(int i = 0; i < userInput.size() - 1; i ++)
	 {
		 for( int j = 0; j < userInput.get(i).length(); i ++)
		 {
			 wordCount[0][i] += userInput.get(i).charAt(j);
		 }
		 wordCount[1][i] = userInput.get(i).length();
	 }
	 
	 ArrayList<String> phrases = new ArrayList<String>();
	 int k = 0;
	 int[][] phraseCount;
	 phrases.add(scanner.nextLine());
	 
	 while(!(phrases.get(k).equals("#")))
	{
		 phrases.add(scanner.nextLine().replace(" ", ""));
		 k++;
	}
  
	 phraseCount = new int[2][phrases.size() - 1];
	 for(int i = 0; i < phrases.size() - 1; i ++)
	 {
		 for( int j = 0; j < phrases.get(i).length(); i ++)
		 {
			 phraseCount[0][i] += phrases.get(i).charAt(j);
		 }
		 phraseCount[1][i] = userInput.get(i).length();
	 }
 }
}
