package HackerRank;

import java.io.*;
import java.util.*;

public class SpiralWords {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        int rows = sc.nextInt();
        int columns = sc.nextInt();
        char[][] chars = new char[rows][columns];
        String st = "";
        String junk = sc.nextLine();
        for(int i = 0; i < rows; i++)
            chars[i] = sc.nextLine().toCharArray();
        
        int currentRow = 0;
        int currentColumn = 0;
        while(currentRow != rows && currentColumn != columns)
        {
        	
        	for(int i = rows - currentRow - 1; i >= currentRow; i--)
        		st += "" + chars[i][currentColumn];

        	if(++currentColumn*2 > columns)
        		break;
        	
        	for(int j = currentColumn; j <= columns - currentColumn; j++)
        		st += "" + chars[currentRow][j];
        	
        	if(++currentRow*2 > rows)
        		break;
        	
        	for(int k = currentRow; k <= rows - currentRow; k++)
        		st += "" + chars[k][columns - currentColumn];
        	
        	for(int l = columns - currentColumn - 1; l >= currentColumn; l--)
        		st += "" + chars[rows - currentRow][l];
        	
        	
        }
        
        String[] tmp = st.split("#");
        int total = 0;
        for(String word : tmp)
        {
        	if(!word.equals(""))
        		total++;
        }
        
        System.out.println(total);
        
    }
}