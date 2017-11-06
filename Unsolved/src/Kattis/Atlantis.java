package Kattis;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class Atlantis
{

    static Store[] stores;
//    static int[][] memo;
    static HashMap<Integer, HashMap<Integer, Integer>> memo;
    static int n;
/*
    static class Key
    {

        int id;
        int t;

        public Key(int id, int t)
        {

            this.id = id;
            this.t = t;

        }

        public boolean equals(Key k)
        {

            if (k.id == id && k.t == t) return true;

            return false;

        }

        public int hashCode()
        {

            return ;

        }

    }*/

    static class Store
    {

        int t;
        int h;
        boolean visited = false;

        public Store(int t, int h)
        {

            this.t = t;
            this.h = h;

        }

    }

    public static void main(String[] args)
    {

        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

        stores = new Store[n];
//        int t_max = Integer.MIN_VALUE;
//        int h_max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++)
        {
            stores[i] = new Store(sc.nextInt(), sc.nextInt());
//            t_max = Math.max(stores[i].t, t_max);
//            h_max = Math.max(stores[i].h, h_max);
        }

        memo = new HashMap<>();
//        memo = new int[n][h_max + 1];
//        for (int i = 0; i < n; i++)
//        {
//            Arrays.fill(memo[i], -1);
//        }
        int num_of_stores = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++)
        {
            stores[i].visited = true;
            num_of_stores = Math.max(num_of_stores, visitStore(i, stores[i].t, 0));
            stores[i].visited = false;
        }

        System.out.println(num_of_stores);
//        System.out.println(Arrays.deepToString(memo.keySet().toArray()));
//        System.out.println(Arrays.toString(memo.values().toArray()));



    }

    static int visitStore(int i, int t, int k)
    {

        if (t > stores[i].h) return 0;

        if (memo.containsKey(i))
            if (memo.get(i).containsKey(k))
            {
//                System.out.println("Memoizing");
                return memo.get(i).get(k);
            }


        int s = 1;
        for (int j = 0; j < n; j++)
            if (!stores[j].visited)
            {
                stores[j].visited = true;
                s = Math.max(s, 1 + visitStore(j, t + stores[j].t, k + 1));
                stores[j].visited = false;
            }

        HashMap<Integer, Integer> temp = new HashMap<>();
        temp.put(k, s);
        memo.put(i, temp);
        return s;

    }

    /*
    static int visitStore(int i, int j, int t, int m)
    {

        if (n == m) return 0;

        int total_time = t + stores[i].t;
        int time_left = stores[i].h - total_time;

        if (time_left < 0) return 0;

        int s = 0;
        for (int k = 0; k < n; k++)
        {
            if (!stores[k].visited)
            {
                stores[k].visited = true;
                s = Math.max(s, visitStore(k, i, total_time, m + 1) + 1);
                stores[k].visited = false;
            }
        }

        return s;

    }*/

}
