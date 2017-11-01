package UVaJudge;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * Created by natha on 10/25/2017.
 */
public class WhatGoesUp
{

    static ArrayList<Integer> sorted = new ArrayList<>();


    public static void main(String[] args)
    {

        Scanner sc = new Scanner(System.in);

        sorted.add(sc.nextInt());
        while (sc.hasNext())
        {

            int num = sc.nextInt();
            int index = Math.abs(Collections.binarySearch(sorted, num));

            if (index > sorted.size())
                sorted.add(index - 1, num);
            else if (index == sorted.size())
                if (num == sorted.get(index - 1))
                    continue;
            else sorted.add(index - 1, num);
            //if (num == sorted.get(index - 2)) sorted.remove(index - 2);
            //if (index < sorted.size()) sorted.remove(index);
            System.out.println(sorted.toString());

        }

    }

    public static void binaryInsert(int num, int start, int end)
    {

        if (start == end)
        {

            sorted.add(start + 1, num);
            return;

        }

        if (num > sorted.get((start + end) / 2))
            binaryInsert(num, (start + end) / 2, end);
        else if (num < sorted.get((start + end) / 2))
            binaryInsert(num, start, (start + end) / 2);
        else return;

    }

}
