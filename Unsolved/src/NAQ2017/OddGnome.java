package NAQ2017;

import java.util.Scanner;

/**
 * Created by natha on 10/8/2017.
 */
public class OddGnome
{

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        for (int i = 0; i < n; i++)
        {
            int g = sc.nextInt();
            int[] gnomes = new int[g];
            gnomes[0] = sc.nextInt();
            boolean king_found = false;
            for (int j = 1; j < g; j++)
            {
                gnomes[j] = sc.nextInt();
                if (!king_found)
                    if (gnomes[j] - gnomes[j - 1] < 0 || gnomes[j] - gnomes[j - 1] > 1)
                    {
                        System.out.println(j + 1);
                        king_found = true;
                    }
            }
        }
    }

}
