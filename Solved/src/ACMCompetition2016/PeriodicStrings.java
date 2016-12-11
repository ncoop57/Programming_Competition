package ACMCompetition2016;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class PeriodicStrings {

	public static void main(String[] args)
	{
		
		Scanner sc = new Scanner(System.in);
		
		String src = sc.nextLine();
		ArrayList<Integer> ks = new ArrayList<Integer>();
		
		for(int i = 1; i < src.length(); i++)
			if(src.length() % i == 0)
				ks.add(i);
		
		int min = src.length();
		for(Integer k : ks)
		{
			
			String original = src.substring(0, k);
			char[] tmp = original.toCharArray();
			
			if(min < src.length())
				break;
			
			for(int j = k; j < src.length(); j+=k)
			{
				
				
				char[] rotated = new char[tmp.length];
				try
				{
					rotated = src.substring(j, j + k).toCharArray();
				}
				catch(Exception e){}
				char firstChar = rotated[0];
				for(int i = 0; i < rotated.length - 1; i++)
					rotated[i] = rotated[i + 1];
				rotated[rotated.length - 1] = firstChar;
				
				if(Arrays.equals(rotated, tmp))
				{
					if(k < min)
						min = k;
				}
				else
				{
						min = src.length();
						break;
				}
				
				try
				{
					tmp = src.substring(j, j + k).toCharArray();
				}
				catch(Exception e){}
				
			}
			
			
		}
		
		System.out.println(min);
		
	}

}
