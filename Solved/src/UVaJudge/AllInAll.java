package UVaJudge;

import java.util.Scanner;

public class AllInAll // UVa Judge: 10340
{

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		try
		{
			String str;
			while((str = sc.nextLine()) != null)
			{
				
				String[] s = str.split(" ");
				int j = 0;
				for(int i = 0; i < s[1].length(); i++)
				{
					
					if(str.charAt(j) == s[1].charAt(i))
						j++;
					
				}
				
				if(j == s[0].length())
					System.out.println("Yes");
				else System.out.println("No");
			}
			
		}
		catch(Exception e) {}
		
	}

}
