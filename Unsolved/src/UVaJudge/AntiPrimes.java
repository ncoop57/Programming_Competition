package UVaJudge;

import java.util.Scanner;
import java.util.ArrayList;

public class AntiPrimes
{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        ArrayList<String> sets = new ArrayList<String>();
        Scanner scan = new Scanner(System.in);
        boolean antiprime = true;
        
        sets.add(scan.nextLine());
        while(!(sets.get(sets.size() - 1).equals("0 0 0")))
        {
            sets.add(scan.nextLine());
        }
        
        sets.remove(sets.remove(sets.size() - 1));
        for(int i = 0; i < sets.size(); i++)
        {
            String[] domain_set = sets.get(i).split(" ");
            int[] num_set = new int[domain_set.length];
            
            for(int j = 0; j < num_set.length; j++)
            {
                num_set[j] = Integer.parseInt(domain_set[j]);
            }
            
            int[] num_sums = new int[num_set[1]];
            for(int k = 0; k < num_set[1]; k++)
            {
                num_sums[k] = num_set[0] + k;
            }
            
            int[] sorted_nums = new int[num_sums.length];
            int current_sum = 0;
            for(int l = 0; l < num_sums.length - 1; l++)
            {
                for(int m = 0; m < num_set[1]; m++)
                {
                    for(int n = 0 + m; n < num_set[2]; n++)
                    {
                        current_sum += num_sums[l + m];
                    }
                    
                    for(int n = 1; n <= current_sum; n++)
                    {
                        if(current_sum % n != 0 || current_sum % n != current_sum)
                            antiprime = false;
                    }
                    
                    if(antiprime)
                    {
                        sorted_nums[l] = num_sums[l];
                        sorted_nums[l + 1] = num_sums[l + 1];
                    }
                    
                    current_sum = 0;
                    antiprime = true;
                }
                
                
                
                
                /*
                for(int m = 1; m <= num_sums[l]; m ++)
                {
                    if(((num_sums[l] + num_sums[l + 1]) % m) == 0)
                        continue;
                    else prime = false;
                    
                    if(prime)
                    {
                        sorted_nums[l] = num_sums[l];
                        sorted_nums[l + 1] = num_sums[l + 1];
                    }
                }*/
                
                
            }
            
            for(int n = 0; n < sorted_nums.length; n++)
                System.out.println(sorted_nums[n]);
        }
        
        
    }
}
