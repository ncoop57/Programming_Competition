package HackerRank;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Scanner;

/**
 * Created by natha on 1/14/2017.
 */
public class ChoosingWhiteBalls
{

    private static ArrayList<Double> scores = new ArrayList<Double>();
    private static double score = 0;

    public static void main(String[] args)
    {

        Scanner sc = new Scanner(System.in);

        int i = 1;
        int n = sc.nextInt();
        int k = sc.nextInt();

        String balls = sc.next();

        choose(n, k, i, balls, score);

        Collections.sort(scores);
        System.out.println(scores.toString());


    }

    public static void choose(int n, int k, int i, String balls, double score)
    {

        if (i > k)
        {

            scores.add(score);
            return;
        }

        HashSet<String> combos = new HashSet<String>();

        int x = n - i + 1;
        double total = 0;

        for (int j = 0; j < x; j++)
        {
            try
            {

                if (j == balls.length() - 1)
                {

                    combos.add(balls.substring(balls.length() - 1 - j + 1));
                    combos.add(balls.substring(0, j));

                }
                else if (j == 0)
                {

                    combos.add(balls.substring(0, balls.length() - 1));
                    combos.add(balls.substring(j + 1));

                }
                else
                {

                    combos.add(balls.substring(0, balls.length() - 1 - j) + balls.substring(balls.length() - j));
                    combos.add(balls.substring(0, j) + balls.substring(j + 1));

                }

                if (balls.charAt(j) == 'W' || balls.charAt(balls.length() - j - 1) == 'W')
                    total++;

            }
            catch (Exception e) {}
        }

        if (combos.size() != 0)
            score += (double) (1/combos.size())*(total/balls.length());

        for (String ball : combos)
        {
            choose(n - 1, k, i + 1, ball, score);
        }

    }

}
