package UVaJudge;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class SubstitutionCypher // UVa Judge: 865
{
	
	public static void main(String[] args) throws IOException
	{
		int cases;
		char[] alpha;
		char[] subAlpha;
		boolean swapped = false;
		ArrayList<String> text = new ArrayList<String>();
		ArrayList<String> subText = new ArrayList<String>();
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		cases = Integer.parseInt(reader.readLine());
		String junk = reader.readLine();
		for(int num = 0; num < cases; num++)
		{
			
			String alph = reader.readLine();
			String subAlph = reader.readLine();
			
			subText.add(subAlph);
			subText.add(alph);
			alpha = alph.toCharArray();
			subAlpha = subAlph.toCharArray();
			
			text.add(reader.readLine());
			
			int index = 0;
			while(!text.get(index).equals(""))
			{
				text.add(reader.readLine().trim());
				index++;
			}
			
			text.remove(index);
			
			for(String line : text)
			{
				String substition = "";
				for(int i = 0; i < line.length(); i++)
				{
					swapped = false;
					for(int j = 0; j < alpha.length; j++)
					{
						if(line.charAt(i) == alpha[j])
						{
							substition += subAlpha[j];
							swapped = true;
							break;
						}
						
					}
					if(!swapped)
						substition += line.charAt(i);
				}
				subText.add(substition);
			}
			
			text.clear();
			subText.add("\n");

			subText.remove(subText.size() - 1);
			for(String line : subText)
				System.out.println(line);

		}

	}
	
}
