package Miscellaneous;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by natha on 1/15/2017.
 */
public class HashTable
{

    public static void main(String[] args)
    {

        int m = 8191;

        ArrayList<String>[] table = new ArrayList[m];

        for (int i = 0; i < m; i++)
            table[i] = new ArrayList<String>();

        Scanner sc = null;
        try
        {
            sc = new Scanner(new File(".//Unsolved//src//Miscellaneous//words.txt"));

            while(sc.hasNextLine())
            {

                String[] words = sc.next().split(" ");

                for (String word : words)
                {

                    int key = hash(word) % m;
                    boolean flag = true;

                    for (int i = 0; i < table[key].size(); i++)
                        if (word.equals(table[key].get(i)))
                            flag = false;

                    if (flag)
                    {
                        table[key].add(word);
                        System.out.println(word);

                    }

                }

            }

        }
        catch (Exception e)
        {
            e.printStackTrace();
            return;
        }

    }

    public static int hash(String s)
    {

        int alpha = 26;
        int total = 0;

        for (int i = 0; i < s.length(); i++)
        {

            total += Math.pow(26, s.length() - (i + 1))*s.charAt(i);

        }

        return total;

    }

}
