package UVaJudge;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

public class SimpleDivision // UVa Judge: 10407
{
	
	public static void main(String[] args) throws IOException
	{
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		ArrayList<String> input = new ArrayList<String>();
		int count = 0;

		input.add(reader.readLine());
		while(!input.get(count).equals("0"))
		{
			input.add(reader.readLine());
			count++;
		}
		
		
		input.remove(input.size() - 1);
		System.out.println(input.toString());
		for(String line : input)
		{
			String[] numbs = line.split(" ");
			long[] nums = new long[numbs.length - 1];
			long[] results = new long[nums.length - 1];
			
			for(int i = 0; i < nums.length; i++)
				nums[i] = Long.parseLong(numbs[i]);
			
			for(int j = 0; j < results.length; j++)
				results[j] = nums[j] - nums[j + 1];
			
			for(int k = 1; k < results.length; k++)
			{
				results[k] = egcd(k - 1, k);
			}
			
			System.out.print(results[results.length - 1]);
			System.out.println(results.toString());
			
		}
		
	}
	
	public static int egcd(int a, int b) {
	    if (a == 0)
	        return b;

	    while (b != 0) {
	        if (a > b)
	            a = a - b;
	        else
	            b = b - a;
	    }

	    return a;
	}
}
