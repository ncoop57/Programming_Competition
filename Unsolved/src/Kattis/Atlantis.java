package Kattis;

import java.util.ArrayList;
import java.util.Scanner;

public class Atlantis
{

    static class Store
    {

        int time;
        int height;

        public Store(int time, int height)
        {

            this.time = time;
            this.height = height;

        }

        @Override
        public String toString()
        {
            return "Time: " + time + " Height: " + height;
        }
    }

    public static void main(String[] args)
    {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        ArrayList<Store> stores = new ArrayList<>();
        int time_capacity = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++)
        {
            stores.add(new Store(sc.nextInt(), sc.nextInt()));
            time_capacity = Math.max(time_capacity, stores.get(i).height);
        }

        stores.sort((Store x, Store y) -> x.time - y.time);
        stores.sort((Store x, Store y) -> x.height - y.height);

        int counter = 0;
        int current_time = 0;
        for (Store store : stores)
        {
            if (time_capacity >= store.time && current_time + store.time <= store.height)
            {
                current_time += store.time;
                time_capacity -= store.time;
                counter++;
            }
        }

        stores.forEach((store)-> System.out.println(store));
        System.out.println(counter);

    }

}
