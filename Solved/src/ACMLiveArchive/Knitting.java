package ACMLiveArchive;

import java.util.ArrayList;
import java.util.Scanner;

public class Knitting // ACM-ICPC Live Archive: 4603
{
	public static void main(String[] args)
	{
		ArrayList<String> input = new ArrayList<String>();
		Scanner scan = new Scanner(System.in);
		
		input.add(scan.nextLine());
		while(!(input.get(input.size() - 1).equals("0 0 0")))
		{
			input.add(scan.nextLine());
		}
		
		input.remove(input.size() - 1);
		int[] total = new int[input.size()];
		for(int i = 0; i < input.size(); i++)
		{
			if((i + 1) % 2 == 0)
			{
				String[] project = input.get(i - 1).split(" ");
				String[] modifers = input.get(i).split(" ");
				
				int[] proj_nums = new int[project.length];
				int[] mod_nums = new int[modifers.length];
				
				for(int j = 0; j < project.length; j++)
					proj_nums[j] = Integer.parseInt(project[j]);
				
				for(int k = 0; k < modifers.length; k++)
					mod_nums[k] = Integer.parseInt(modifers[k]);
				
				int row_total = 0;
				int current_row = 0;
				for(int l = 0; l < proj_nums[1]; l++)
				{
					row_total = (l == 0) ? proj_nums[0] : row_total + mod_nums[current_row];
					total[i - 1] += row_total;
					//50 + 56 + 54 + 52 + 52 + 58
					
					if(current_row < proj_nums[2] - 1 && l != 0)
						current_row++;
					else current_row = 0;
					// current_row = 0, 0, 1, 2, 3, 0
				}	
			}
		}
		
		for(int m = 0; m < total.length; m++)
			if(m % 2 == 0)
				System.out.println(total[m]);
	}
}
