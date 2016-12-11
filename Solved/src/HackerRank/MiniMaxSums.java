package HackerRank;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class MiniMaxSums
{
	
	public static void main(String[] args)
	{
		
		Scanner sc = new Scanner(System.in);
		long[] nums = new long[5];
		ArrayList<Long> sums = new ArrayList<Long>();
		
		for(int i = 0; i < 5; i++)
			nums[i] = sc.nextInt();
		
		long sum = 0;
		for(int j = 0; j < 5; j++)
		{
			for(int k = 0; k < nums.length; k++)
				if(j != k)
				{
					sum += nums[k];
				}
			
			sums.add(sum);
			sum = 0;
		}
		
		Collections.sort(sums);
		
		System.out.println(sums.get(0) +" " + sums.get(sums.size() - 1));
		
	}
	
}
