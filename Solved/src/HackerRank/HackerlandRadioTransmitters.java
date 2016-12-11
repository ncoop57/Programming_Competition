package HackerRank;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class HackerlandRadioTransmitters 
{
	
	private static class House implements Comparable<House>
	{
		
		private int num;
		ArrayList<Integer> adj = new ArrayList<Integer>();
		
		public House(int num)
		{
			
			this.num = num;
			
		}

		@Override
		public int compareTo(House house)
		{
			
			return this.num - house.num;
			
		}
		
	}
	
	public static void main(String[] args)
	{
		
		
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int k = sc.nextInt();
		String junk = sc.nextLine();
		
		HashMap<Integer, Boolean> map = new HashMap<Integer, Boolean>();
		ArrayList<Integer> houses = new ArrayList<Integer>();
		
		for(int i = 0; i < n; i++)
		{
			
			int x = sc.nextInt();
			
			map.put(x, false);
			if(!map.get(x))
				houses.add(x);
			map.put(x, true);
			
		}
		
		n = houses.size();
		
		Collections.sort(houses);
		
		int counter = 0;
		int current = 0;
		while(current < n)
		{
			
			int bound = houses.get(current) + k;
			
			for(int j = current; j < n; j++)
				if(bound < houses.get(j))
				{
	
					current = j - 1;
					break;
					
				}
			
			bound = houses.get(current) + k;
			
			for(int l = current; l < n; l++)
				if(bound < houses.get(l))
				{
					
					current = l;
					break;
					
				}
				else if(bound >= houses.get(n - 1))
					current = n;
			
			counter++;
			
		}
		
		System.out.println(counter);
		/*
		House[] houses = new House[n];
		for(int i = 0; i < n; i++)
				houses[i] = new House(sc.nextInt());
		
		
		Arrays.sort(houses);
		
		int counter = 0;
		for(int i = 0; i < n; i++)
		{
			
			for(int j = 0; j < n; j++)
				if(houses[j] != null)
					for(int l = 0; l < n; l++)
						if(l != j && houses[l] != null)
							if(Math.abs(houses[l].num - houses[j].num)  <= k)
								houses[j].adj.add(l);
			
			
			int maxIndex = 0;
			while(true)
				if(houses[maxIndex] == null)
					maxIndex++;
				else break;
			
			for(int m = 1; m < n; m++)
				if(houses[m] != null)
					if(houses[maxIndex].adj.size() < houses[m].adj.size())
						maxIndex = m;
			
			if(houses[maxIndex] != null)
				for(int p = 0; p < houses[maxIndex].adj.size(); p++)
					houses[houses[maxIndex].adj.get(p)] = null;
			
			houses[maxIndex] = null;
			counter++;
			boolean empty = true;
			for (House ob : houses) {
			  if (ob != null) {
			    empty = false;
			    break;
			  }
			}
			if(empty)
				break;
			/*
			for(int o = 0; o < n; o++)
				if(houses[o] != null)
					System.out.println(houses[o].adj.toString());
		}
		
		System.out.println(counter);
		
		/*
		int upperBound = i + k;
		for(int j = 0; j < houses.length; j++)
		{
			tmpHouses = houses.clone();
			int counter = 0;
			for(int k = j; k < houses.length; k++)
			{
				
				try
				{
					
					if(tmpHouses[k - 1] >= tmpHouses[k] - nk[1]*2 + 1)
						tmpHouses[k - 1] = 0;
					
				}
				catch(Exception e) {}
				
				try
				{
					
					if(tmpHouses[k + 1] <= tmpHouses[k] + nk[1]*2 + 1)
						tmpHouses[k + 1] = 0;
					
				}
				catch(Exception e) {}
				
				tmpHouses[k] = 0;
				counter++;
				
				if(Arrays.equals(houses, tmp))
					break;
			}
			
			ints.add(counter);
		}
			
		Collections.sort(ints);
		
		System.out.println(ints.get(0));*/
		
	}
	
}
