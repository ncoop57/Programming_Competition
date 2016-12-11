package ACMCompetition2016;

import java.util.Scanner;

public class Gravity
{
	
	public static void main(String[] args)
	{
		
		Scanner sc = new Scanner(System.in);
		
		
		int row = sc.nextInt();
		int column = sc.nextInt();
		
		String junk = sc.nextLine();
		
		char[][] board = new char[row][column];
		
		for(int i = 0; i < row; i++)
			board[i] = sc.nextLine().trim().toCharArray();
		
		for(int i = 0; i < column; i++)
		{
			int index = row - 1;
			for(int j = row - 1; j >= 0; j--)
			{
				if(board[j][i] == '#')
					index = j - 1;
				else if(board[j][i] == 'o')
				{
					

					board[j][i] = '.';
					board[index][i] = 'o';
					index--;
					
				}
				
			}
			
		}
		for(int i = 0; i < row; i++)
		{
			for(int j = 0; j < column; j++)
				System.out.print(board[i][j]);
			
			System.out.println("");
		}
	}
	
}
