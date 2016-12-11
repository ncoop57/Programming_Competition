package ACMCompetition2016;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

import javax.print.attribute.SetOfIntegerSyntax;

public class Barbells 
{
	
	public static void main(String[] args)
	{
		
		Scanner sc = new Scanner(System.in);
		
		int b = sc.nextInt();
		int p = sc.nextInt();

		HashSet<Integer> weights = new HashSet<Integer>();
		
		int[] bars = new int[b];
		for(int i = 0; i < b; i++)
		{
			
			bars[i] = sc.nextInt();
			weights.add(bars[i]);
			
		}
		
		int[] plates = new int[p];
		int maxSums = 0;
		for(int i = 0; i < p; i++)
		{
			
			plates[i] = sc.nextInt();
			maxSums += plates[i];
		}
		
		if(p % 2 != 0)
		{
			Arrays.sort(plates);
			maxSums -= plates[0];
		}
		
		ArrayList<Integer> sums = new ArrayList<Integer>();
		int place = 0;
		for(int j = 0; j < plates.length; j++)
		{
			
			int tmp = plates[j];
			for(int i = 0; i < plates.length - 1; i++)
				for(int m = i; m < plates.length - 1; m++)
				{
					if(m != j)
						if(j == 0)
						{
							sums.add(plates[i] + plates[m]);
							place++;
						}
						else
						{
							sums.add(sums.get(place - 1) + m);
							/*if(sums.get(sums.size() - 1) == tmp)
							{
								for(int n = 0; n < b; n++)
								{
									weights.add(bars[n] + tmp*2);
									//continue;
								}
							}*/
							place++;
						}
						
						
					}
		}
		
			for(Integer j : sums)
				for(Integer i : plates)
				if(j <= maxSums && j != i)
				{
					for(int n = 0; n < b; n++)
					{
						weights.add(bars[n] + j);
						//continue;
					}
				}
		
		
		for(Integer j : sums)
			System.out.println(j);
		Integer[] newWeights = new Integer[weights.size()];
		Arrays.sort(weights.toArray(newWeights));
		
		for(Integer weight : newWeights)
		{
			
			System.out.println(weight);
			
		}
		
	}
	
}
