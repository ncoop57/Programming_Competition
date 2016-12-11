package UVaJudge;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class PointsInFiguresRectangle // UVa Judge: 476
{
	
	public static void main(String[] args) throws NumberFormatException, IOException
	{
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		ArrayList<String> input = new ArrayList<String>();
		double[][] rectangles;
		double[][] points;
		int count = 0;

		input.add(reader.readLine());
		while(!input.get(count).equals("*"))
		{
			input.add(reader.readLine());
			count++;
		}
		
		input.remove(input.size() - 1);
		
		rectangles = new double[input.size()][4];
		for(int i = 0; i < input.size(); i++)
		{
			
			String[] values = input.get(i).split(" ");
			
			for(int j = 0; j < values.length; j++)
			{
				
				try
				{
					
					rectangles[i][j] = Double.parseDouble(values[j]);
					
				}
				catch(Exception e){}
				
			}
			
		}
		
		input.clear();
		count = 0;
		
		input.add(reader.readLine());
		while(!input.get(count).equals("9999.9 9999.9"))
		{
			input.add(reader.readLine());
			count++;
		}
		
		points = new double[input.size()][4];
		for(int i = 0; i < input.size() - 1; i++)
		{
			
			String[] values = input.get(i).split(" ");
			
			for(int j = 0; j < values.length; j++)
			{
				
				try
				{
					
					points[i][j] = Double.parseDouble(values[j]);
					
				}
				catch(Exception e){}
				
			}
			
		}
		
		for(int i = 0; i < points.length; i++)
			for(int j = 0; j < 2; j++)
				System.out.println(points[i][j]);
		for(int i = 0; i < rectangles.length; i++)
		{
			
			for(int j = 0; j < points.length - 1; j++)
			{
				
				
				if(points[j][0] > rectangles[i][0] && points[j][0] < rectangles[i][2])
					if(points[j][1] < rectangles[i][1] && points[j][1] > rectangles[i][3])
						System.out.println("Good job mane!");
				
				System.out.println("Bad job mane! " + points.length + " " + rectangles.length);
			
			}
			
		}
		
	}
	
}
