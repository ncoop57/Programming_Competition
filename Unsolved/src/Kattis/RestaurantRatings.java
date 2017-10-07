package Kattis;

import java.util.Scanner;

public class RestaurantRatings
{

    public static void main(String[] args)
    {

        Scanner sc = new Scanner(System.in);

        while (true)
        {

            int total = 0;
            int ways = 0;

            int n = sc.nextInt();
            if (n == 0) break;

            int[] ratings = new int[n];
            for (int i = 0; i < n; i++)
            {
                ratings[i] = sc.nextInt();
                total += ratings[i];
            }

            if (n == 1)
            {
                System.out.println(ratings[0] + 1);
                continue;
            }

            for (int j = 0; j < n; j++)
            {



                for (int k = 0; k < ratings[j] - 1; k++)
                {

                    if (k == 0)
                        ways += (total + 1) * (n - 1);
                    else
                        ways += ((total + 1) - k) * Math.pow(n - 1, 2);

                }

            }

            System.out.println(ways);

        }

    }

}
