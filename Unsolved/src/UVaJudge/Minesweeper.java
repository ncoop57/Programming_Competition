package UVaJudge;

import java.util.Arrays;
import java.util.Scanner;

public class Minesweeper // UVa Judge: 10189
{
	public static void main(String[] args)
	{
		
		Scanner sc = new Scanner(System.in);
		
		int row;
		int column;
		
		while((row = sc.nextInt())	!= 0 && (column = sc.nextInt())	!= 0)
		{
			
			char[][] board = new char[row][column];
			
			String junk = sc.nextLine();
			
			for(int i = 0; i < row; i++)
				board[i] = sc.nextLine().replace('.', '0').toCharArray();
			
			for(int i = 0; i < board.length; i++)
				for(int j = 0; j < board[i].length - 1; j++)
				{
					
					if(board[i][j] == '*')
					{
						
						if(board[i][j + 1] != '*')
							board[i][j + 1] = (char) (Character.getNumericValue(board[i][j + 1]) + 1);
						
						if(j > 0)
							if(board[i][j - 1] != '*')
								board[i][j - 1] = (char) (Character.getNumericValue(board[i][j - 1]) + 1);
						
						if(i < board.length - 1)
							if(board[i + 1][j] != '*')
								board[i + 1][j] = (char) (Character.getNumericValue(board[i + 1][j]) + 1);
						
						if(i > 0)
							if(board[i - 1][j] != '*')
								board[i - 1][j] = (char) (Character.getNumericValue(board[i - 1][j]) + 1);
						
					}
					
				}
			
			System.out.println(Arrays.deepToString(board));
			
		}
		
	}
}
