package UVaJudge;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class DNASorter // UVa Judge: 612
{
	public static void main(String[] args) throws IOException
	{
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		ArrayList<String> list1 = new ArrayList<String>();

		int t, m, n;
		
		t = Integer.parseInt(reader.readLine());
		for(int i = 0; i < t; i++)
		{
			ArrayList<String> list = new ArrayList<String>();
			String junk = reader.readLine();
			
			// BufferReader
			String data = reader.readLine();
			String[] info = data.split(" ");
			n = Integer.parseInt(info[0]);
			m = Integer.parseInt(info[1]);
			for(int j = 0; j < m; j++)
			{
				list.add(reader.readLine());
			}
			
			int[] count = new int[m];
			for(int k = 0; k < m; k++)
			{
				for(int l = 0; l < n - 1; l++)
				{
					for(int o = l + 1; o < n; o++)
					{
						if(list.get(k).charAt(l) - list.get(k).charAt(o) > 0)
							count[k]++;
					}
				}
			}
			
			for(int p = 0; p < count.length - 1; p++)
			{
				for(int q = 0; q < count.length - 1; q++)
				{
					if(count[q] > count[q + 1])
					{
						String tmp1 = list.get(q);
						int tmp2 = count[q];
						
						list.set(q, list.get(q + 1));
						list.set(q + 1, tmp1);
						
						count[q] = count[q + 1];
						count[q + 1] = tmp2;
					}
				}
			}
			
			for(int r = 0; r < list.size(); r++)
				list1.add(list.get(r));
			
			list1.add("");
			
		}

		for(int s = 0; s < list1.size() - 1; s++)
			System.out.println(list1.get(s));
		
	}
}
