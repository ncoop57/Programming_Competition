package UVaJudge;

import java.util.Scanner;

public class AverageSpeed // UVa Judge: 10281
{
	
	public static void main(String[] args)
	{
		
		Scanner sc = new Scanner(System.in);
		
		try
		{
			String str;
			int total_seconds = 0;
			int start_seconds = 0;
			double speed = 0;
			double distance = 0;
			while(true)
			{
				
				str = sc.nextLine();
	
				String[] timelapse = str.split(" ");
				String[] time = timelapse[0].split(":");
				
				total_seconds += Integer.parseInt(time[0])*60*60;
				total_seconds += Integer.parseInt(time[1])*60;
				total_seconds += Integer.parseInt(time[2]);
				
				if(timelapse.length == 2)
				{
					
					distance += (double) speed*(total_seconds - start_seconds);
					speed = (double) Double.parseDouble(timelapse[1])/60/60;
					start_seconds = total_seconds;
					
				}
				
				 
				
				if(timelapse.length == 1)
				{
					
					distance += (double) speed*(total_seconds - start_seconds);
					System.out.println(String.format("%s %.2f km", timelapse[0].toString(), distance));
					start_seconds = total_seconds;
				
				}
				
				total_seconds = 0;
				
				
					
			}
			
		}
		catch(Exception e){
			
			//e.printStackTrace();
		}
		
	}
	
}
