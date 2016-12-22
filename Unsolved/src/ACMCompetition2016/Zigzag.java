package ACMCompetition2016;

import java.util.Scanner;

/**
 * Created by Nathan on 12/12/2016.
 */
public class Zigzag
{

    public static void main(String[] args)
    {

        Scanner sc = new Scanner(System.in);

        boolean increasing = false;
        boolean decreasing = false;

        int n = sc.nextInt();
        int max = 1;

        int current = sc.nextInt();
        int total = 0;
        for (int i = 0; i < n - 1; i++)
        {

            int next = sc.nextInt();
            if (current < next && !increasing)
            {

                increasing = true;
                decreasing = false;
                total++;

            }
            else if (current > next && !decreasing)
            {

                decreasing = true;
                increasing = false;
                total++;

            }
            else
            {

                increasing = false;
                decreasing = false;
                if (total > max)
                    max = total;

                total = 0;

            }

            current = next;

        }

        System.out.println(max);

    }

}
