package UVaJudge;

import java.util.Scanner;

public class ThreeNPlusOne // UVa Judge: 100
{
	
	public static void main(String[] args)
	{
		
		Scanner sc = new Scanner(System.in);
		try
		{
			int low;
			int high;
			while((low = sc.nextInt()) != -1 && (high = sc.nextInt()) != -1)
			{
				int n;
				int max = 0;
				if(low < high)
					for(int i = high; i >= low; i--)
					{
	
						int counter = 0;
						n = i;
						while(n != 1)
						{
							
							if(n % 2 == 0)
							{
								n /= 2;
								
							}
							else
							{
								
								n = 3*n + 1;
								
							}
							counter++;
						}
						
						if(counter > max)
							max = counter;
					}
				else
					for(int i = low; i >= high; i--)
					{
	
						int counter = 0;
						n = i;
						while(n != 1)
						{
							
							if(n % 2 == 0)
							{
								n /= 2;
								
							}
							else
							{
								
								n = 3*n + 1;
								
							}
							counter++;
						}
						
						if(counter > max)
							max = counter;
					}
				
				System.out.printf("%d %d %d\n", low, high, max + 1);
				
			}
			
		}
		catch(Exception e) {}
		
	}
	
}
