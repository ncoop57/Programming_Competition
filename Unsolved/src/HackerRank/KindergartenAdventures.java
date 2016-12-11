package HackerRank;

import java.io.*;
import java.util.*;

public class KindergartenAdventures
{

	public static void main(String[] args)
	{
		
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] stu = new int[n];
		
		for(int i = 0; i < n; i++)
			stu[i] = sc.nextInt();
		
		int[] stuHolder= new int[n];
		int counter = 0;
		int startIndex = 0;
		int nextIndex = 1;
		
		while(nextIndex != startIndex)
		{
			
			if(nextIndex == n)
				nextIndex = 0;
			
			if(stu[startIndex] <= stu[nextIndex])
			{
				
				counter++;
				nextIndex++;
				
			}
			else
			{
				
				stuHolder[startIndex] = counter;
				startIndex = nextIndex;
				nextIndex++;
				counter = 0;
				
			}
			
		}
		
		stuHolder[startIndex] = counter;
		
		int maxIndex = 0;
		for(int j = 1; j < stuHolder.length; j++)
			if(stuHolder[j] > stuHolder[maxIndex])
				maxIndex = j;
		
		System.out.print(maxIndex + 1);
		
	}
	
}
