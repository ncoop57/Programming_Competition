package UVaJudge;

import java.util.Scanner;
import java.util.ArrayList;

public class DaVinciCode // UVa Judge: 11385
{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        ArrayList<String> input = new ArrayList<String>();
        Scanner scan = new Scanner(System.in);
        
        input.add(scan.nextLine());
        input.add(scan.nextLine());
        while(!(input.get(input.size() - 1).equals("0")))
        {
            input.add(scan.nextLine());
        }
        
        input.remove(input.size() - 1);
        int[] nums = new int[input.size() / 2];
        String[] letters = new String[input.size() / 2];
        for(int i = 0; i < input.size(); i++)
        {
            if(((i + 1) % 2) != 0)
            {
                nums[i / 2] = Integer.parseInt(input.get(i));
            }
            else letters[i / 2] = input.get(i);
        }
        
        for(int j = 0; j < nums.length; j++)
        {
            char[][] sequence = new char[nums[j]][nums[j]];
            
            for(int k = 0; k < nums[j]; k++)
            {
                for(int l = 0; l < letters[j].length(); l++)
                {
                    if(k + 1 % 2 == 0)
                    {
                        sequence[k][l] = letters[j].charAt(l);
                        System.out.println(sequence[k][l]);
                    }
                    else
                    {
                        sequence[k][l] = letters[j].charAt((letters[j].length()) - l);
                        System.out.println(sequence[k][l]);
                    }
                }
            }
        }
        
        
    }
    
}
