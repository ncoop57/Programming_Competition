package UVaJudge;

import java.util.*;

/**
 * Created by natha on 1/15/2017.
 */
public class JollyJumpers // UVa Judge: 10038
{

    public static void main(String[] args)
    {

        Scanner sc = new Scanner(System.in);
        SortedSet<Integer> numbers = new TreeSet<Integer>();

        try
        {

            while (sc.hasNext())
            {

                int n = sc.nextInt();
                int current = sc.nextInt();
                for (int i = 0; i < n - 1; i++)
                {

                    int next = sc.nextInt();

                    numbers.add(Math.abs(current - next));
                    current = next;

                }

                boolean flag = true;

                for (int j = 1; j < n; j++)
                {

                    if (!numbers.contains(j))
                        flag = false;

                }

                if (flag || n == 1)
                    System.out.println("Jolly");
                else System.out.println("Not jolly");

                numbers.clear();

            }
        }
        catch (Exception e) {}

    }

}
