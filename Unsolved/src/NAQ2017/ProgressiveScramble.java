package NAQ2017;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by natha on 10/8/2017.
 */
public class ProgressiveScramble
{

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        ArrayList<String> e_messages = new ArrayList<>();
        ArrayList<String> d_messages = new ArrayList<>();
        int n = sc.nextInt();
        for (int i = 0; i < n; i++)
        {
            String type = sc.next();
            String line = sc.nextLine().substring(1);

            if (type.equals("e"))
            {
                d_messages.add(line);
                int[] values = new int[line.length()];
                for (int j = 0; j < line.length(); j++)
                {
                    if (line.charAt(j) == ' ')
                        values[j] = 0;
                    else
                        values[j] = line.charAt(j) - 96;
                }
                //System.out.println(Arrays.toString(values));

                int[] u = new int[line.length()];
                u[0] = values[0];
                for (int k = 1; k < line.length(); k++)
                {
                    u[k] = u[k - 1] + values[k];
                }

                //System.out.println(Arrays.toString(u));

                String encoded = "";
                for (int l = 0; l < u.length; l++)
                {
                    int letter = u[l] % 27;
                    if (letter == 0)
                        encoded += " ";
                    else
                        encoded += (char) (letter + 96);
                }
                System.out.println(encoded);
                e_messages.add(encoded);
            }
            else
            {
                for (int j = 0; j < e_messages.size(); j++)
                {
                    if (e_messages.get(j).equals(line))
                        System.out.println(d_messages.get(j));
                }
            }
        }

    }

}
