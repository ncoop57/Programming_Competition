package ACMCompetition2016;

import java.util.Scanner;

/**
 * Created by natha on 12/12/2016.
 */
public class MismatchedSocks
{

    public static void main(String[] args)
    {

        Scanner sc = new Scanner(System.in);

        int total = 0;
        int n = sc.nextInt();
        int[] socks = new int[n];

        int max_index = 0;
        int max;
        for (int i = 0; i < n; i++)
        {
            socks[i] = sc.nextInt();
            if (socks[i] > socks[max_index])
                max_index = i;
        }

        max = socks[max_index];
        socks[max_index] = 0;

        for (int j = 0; j < n; j++)
        {
            for (int k = 0; k < n; k++)
                if (socks[k] > socks[max_index])
                    max_index = k;

            if (max > socks[max_index])
                max -= socks[max_index];
            else max = socks[max_index] - max;

            total += socks[max_index];
            socks[max_index] = 0;

            if (max == 0)
                break;
        }

        System.out.println(total);

    }

}
