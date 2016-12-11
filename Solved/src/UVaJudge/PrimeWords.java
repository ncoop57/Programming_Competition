package UVaJudge;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

public class PrimeWords // UVa Judge: 10924
{

	public static void main(String[] args)
	{
		
		Scanner reader = new Scanner(System.in);
		ArrayList<String> input = new ArrayList<String>();
		int count = 0;

		int sums = 0;
		try
		{
		while(reader.hasNext())
		{
			input.add(reader.nextLine());
			count++;
		}
		}
		catch(Exception e) {}
		
		for(String lines : input)
		{
			boolean prime = true;
			for(Character chars : lines.toCharArray())
			{
				sums += (chars < 97) ? chars - 38 : chars - 96;
			}
			//System.out.println(sums);
			for(int i = 2; i < sums; i++)
			{
				
				if(sums % i == 0)
				{
					System.out.println("It is not a prime word.");
					prime = false;
					break;
				}
			}
			
			if(prime)
				System.out.println("It is a prime word.");
			sums = 0;
		}
		
		
		
	}

}
