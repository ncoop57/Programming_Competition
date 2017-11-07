package Kattis;

import java.util.*;

public class PokemonGoGo
{

    static HashMap<Integer, HashMap<Integer, Integer>> memo;
    static ArrayList<PokeStop> pokestops;
    static int n;

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
        n = sc.nextInt();
        sc.nextLine();

        memo = new HashMap<>();
        pokestops = new ArrayList<>();
        for (int i = 0; i < n; i++)
        {
            pokestops.add(new PokeStop(sc.nextInt(), sc.nextInt()));
            pokestops.get(i).pokemons.add(sc.nextLine().trim());
            try
            {
                while (!sc.hasNextInt())
                    pokestops.get(i).pokemons.add(sc.nextLine().trim());
            } catch (Exception e) {}

        }


        Set<String> caught = new HashSet<>();
        int dist = traveling_pokemon(0, 0, caught);
        System.out.println(dist);
        System.out.println(memo);

        System.out.println((1 << n) - 1);
//        System.out.println(pokestops.toString());


    }

    static int traveling_pokemon(int start, int mask, Set<String> caught)
    {

        if (mask == (1 << n) - 1)
        {
            System.out.println("Visited all");
            return Math.abs(pokestops.get(start).r) + Math.abs(pokestops.get(start).c);
        }

        if (memo.containsKey(start))
            if (memo.get(start).containsKey(mask))
                return memo.get(start).get(mask);

        int d = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++)
        {

            int visited = mask & (1 << i);
//            System.out.println(visited);
//            System.out.println(Integer.toBinaryString(mask));
            if (visited == 0)
            {

                if (!caught.isEmpty() && !shouldVisit(caught, new HashSet<>(pokestops.get(i).pokemons))) continue;
                Set<String> new_caught = new HashSet<>(caught);
                new_caught.addAll(pokestops.get(i).pokemons);
                //            System.out.print(new_caught);

                int dist_to = Math.abs(pokestops.get(start).r - pokestops.get(i).r) + Math.abs(pokestops.get(start).c - pokestops.get(i).c);
                d = Math.min(d, traveling_pokemon(i, mask | (1 << i), new_caught) + dist_to);

            }

        }

        HashMap<Integer, Integer> temp = new HashMap<>();
        temp.put(mask, d);
        memo.put(start, temp);
        return d;

    }

    public static boolean shouldVisit(Set<String> caught, Set<String> pokemons)
    {

//        System.out.println(caught + " " + pokemons);
        pokemons.removeAll(caught);

        if (pokemons.isEmpty()) return false;
        else return true;

    }



    /*

    public static int traveling_pokemon(ArrayList<PokeStop> pokestops, Set<String> caught, int r, int c)
    {

        if (pokestops.isEmpty()) return Math.abs(r) + Math.abs(c);

        int d = Integer.MAX_VALUE;
        for (int i = 0; i < pokestops.size(); i++)
        {


            PokeStop temp = pokestops.get(i);
            if (!caught.isEmpty() && !shouldVisit(caught, new HashSet<>(temp.pokemons))) continue;
            Set<String> new_caught = new HashSet<>(caught);
            new_caught.addAll(temp.pokemons);
//            System.out.print(new_caught);
            pokestops.remove(i);

            d = Math.min(d, traveling_pokemon(pokestops, new_caught, temp.r, temp.c) + Math.abs(r - temp.r) + Math.abs(c - temp.c));
//            System.out.println(pokestops);
            pokestops.add(i, temp);
//            System.out.println(new_caught + " R: " + temp.r + " C: " + temp.c);
//            System.out.println(pokestops);


        }
//        System.out.println(d);

        return (d == Integer.MAX_VALUE) ? Math.abs(r) + Math.abs(c) : d;

    }
*/
}
