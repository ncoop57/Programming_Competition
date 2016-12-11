package HackerRank;

import java.util.HashSet;
import java.util.Scanner;

public class MegaTicTacToe
{
	
	public static void main(String[] args)
	{
		
		Scanner sc = new Scanner(System.in);
		int g = sc.nextInt();
		String junk = sc.nextLine();
		
		for(int i = 0; i < g; i++)
		{
			
			 int rows = sc.nextInt();
			 int columns = sc.nextInt();
			 int k = sc.nextInt();
			 
			 junk = sc.nextLine();
			 
			 String[] lines = new String[rows];
			 
			 for(int j = 0; j < rows; j++)
			 {
				 
				 lines[j] = sc.nextLine();
				 for(int l = 0; l < columns - k; l++)
				 {
					 
					 
					 
				 }
				 
			 }
			
		}
		/*
		for(int i = 0; i < n; i++)
		{
			
			String junk = sc.nextLine();
			String[] numbers = sc.nextLine().split(" ");
			
			int[] nums = new int[numbers.length];
			for(int j = 0; j < nums.length; j++)
				nums[j] = Integer.parseInt(numbers[j]);

			String[] lines = new String[nums[0]];
			char[][] board = new char[nums[0]][nums[1]];
			HashSet<Character> set = new HashSet<Character>();
			for(int j = 0; j < nums[0]; j++)
			{
				lines[j] = sc.nextLine();
				board[j] = lines[j].toCharArray();
				for(int k = 0; k < board[j].length; k++)
				{
					for(int l = 0; l < nums[0] - nums[2] + 1; l++)
					{
						set.add(board[j][l + k]);
					}
					if(set.size() == 1)
						break;
				}
			}
			
		}*/
		
	}
	
}
