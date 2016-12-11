package HackerRank;

import java.util.Scanner;

/**
 * Created by Nathan Cooper on 11/29/2016.
 */
public class CompareTheTriplets
{

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int[][] a = new int[2][3];
        int[] total = new int[2];
        for (int i = 0; i < 2; i++)
        {
            for (int j = 0; j < 3; j++)
            {
                a[i][j] = sc.nextInt();
            }
            try
            {
                String junk = sc.nextLine();
            }
            catch (Exception e)
            {

            }
        }

        for (int k = 0; k < 3; k++)
        {

            if(a[0][k] == a[1][k])
                continue;
            else if(a[0][k] > a[1][k])
                total[0]++;
            else total[1]++;

        }

        System.out.print(total[0] + " " + total[1]);

    }

}
