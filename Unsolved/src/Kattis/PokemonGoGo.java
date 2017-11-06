package Kattis;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class PokemonGoGo
{

    static class PokeStop
    {

        int r;
        int c;

        Set<String> pokemons = new HashSet<>();

        public PokeStop(int r, int c)
        {

            this.r = r;
            this.c = c;

        }

        public String toString()
        {

            return "R: " + r + " C: " + c + " " + pokemons.toString();

        }

    }

    public static void main(String[] args)
    {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();

        ArrayList<PokeStop> pokestops = new ArrayList<>();
        for (int i = 0; i < n; i++)
        {
            String[] pokestop = sc.nextLine().split(" ");
            pokestops.add(new PokeStop(Integer.parseInt(pokestop[0]), Integer.parseInt(pokestop[1])));
            for (int j = 2; j < pokestop.length; j++)
                pokestops.get(i).pokemons.add(pokestop[j]);
        }


        Set<String> caught = new HashSet<>();
        int dist = traveling_pokemon(pokestops, caught, 0, 0);
        System.out.println(dist);
//        System.out.println(pokestops.toString());

    }

    public static boolean shouldVisit(Set<String> caught, Set<String> pokemons)
    {

//        System.out.println(caught + " " + pokemons);
        pokemons.removeAll(caught);

        if (pokemons.isEmpty()) return false;
        else return true;

    }

    public static int traveling_pokemon(ArrayList<PokeStop> pokestops, Set<String> caught, int r, int c)
    {

        if (pokestops.isEmpty()) return Math.abs(r) + Math.abs(c);

        int d = Integer.MAX_VALUE;
        for (int i = 0; i < pokestops.size(); i++)
        {


            PokeStop temp = pokestops.get(i);
            if (!caught.isEmpty() && !shouldVisit(caught, temp.pokemons)) continue;
            Set<String> new_caught = new HashSet<>(caught);
            new_caught.addAll(temp.pokemons);
//            System.out.print(new_caught);
            pokestops.remove(temp);

            d = Math.min(d, traveling_pokemon(pokestops, new_caught, temp.r, temp.c) + Math.abs(r - temp.r) + Math.abs(c - temp.c));
            System.out.println(pokestops);
            pokestops.add(i, temp);
            System.out.println(pokestops);


        }
//        System.out.println(d);

        return (d == Integer.MAX_VALUE) ? Math.abs(r) + Math.abs(c) : d;

    }

}
