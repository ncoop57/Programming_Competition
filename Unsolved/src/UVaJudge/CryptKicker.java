package UVaJudge;

import java.util.Hashtable;
import java.util.Scanner;

/**
 * Created by natha on 1/16/2017.
 */
public class CryptKicker // UVa Judge: 843
{

    public static void main(String[] args)
    {

        Scanner sc = new Scanner(System.in);

        int m = 8191;

        Hashtable<Integer, String> dictionary = new Hashtable<Integer, String>(m);

        int n = sc.nextInt();

        for (int i = 0; i < n; i++)
        {

            String word = sc.next();

            dictionary.put(word.hashCode() % m, word);

        }

        System.out.println(dictionary.toString());

    }

}
