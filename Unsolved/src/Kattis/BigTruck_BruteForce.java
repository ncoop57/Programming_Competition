/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Kattis;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author nac33
 */
public class BigTruck_BruteForce
{

    //static int[][] dist;
    //static boolean[] visited;
    //static int[] items;
    static int n = 0;

    static Node[] cities;

    static int min_dist = Integer.MAX_VALUE;
    static int max_items = Integer.MIN_VALUE;

    static class Node
    {

        int dist = Integer.MAX_VALUE;
        int items;
        ArrayList<Edge> edges = new ArrayList<>();

        public Node(int items)
        {

            this.items = items;

        }

    }

    static class Edge
    {

        Node to;
        int weight;

        public Edge(Node to, int weight)
        {

            this.to = to;
            this.weight = weight;

        }

    }
    
    //static ArrayList<Path> paths = new ArrayList<>();
    
//    static class Path implements Comparable<Path>
//    {
//
//        int length;
//        int items;
//
//        public Path(int length, int items)
//        {
//
//            this.length = length;
//            this.items = items;
//
//        }
//
//        @Override
//        public int compareTo(Path p)
//        {
//
//            return this.length - p.length;
//
//        }
//
//        public String toString()
//        {
//
//            return "Length: " + this.length + " Items: " + this.items;
//
//        }
//
//    }


    
    public static void main(String[] args)
    {
    
        Scanner sc = new Scanner(System.in);
        
        n = sc.nextInt();
        cities = new Node[n];
        String junk = sc.nextLine();
        //items = new int[n];
//        dist = new int[n][n];
//        visited = new boolean[n];
//
//        for (int i = 0; i < n; i++)
//            Arrays.fill(dist[i], -1);
//
//        Arrays.fill(visited, false);
        
        String[] item_nums = sc.nextLine().split(" ");
        for (int i = 0; i < n; i++)
        {
            //items[i] = Integer.parseInt(item_nums[i]);
            cities[i] = new Node(Integer.parseInt(item_nums[i]));

        }
        
        int m = sc.nextInt();
        for (int j = 0; j < m; j++)
        {
        
            int a = sc.nextInt() - 1;
            int b = sc.nextInt() - 1;
            int d = sc.nextInt();
            cities[a].edges.add(new Edge(cities[b], d));

//            dist[a][b] = d;
//            dist[b][a] = d;
        
        }
        
        traverse( cities[0], 0, cities[0].items);
        /*paths.sort(new Comparator<Path> () {
            @Override
            public int compare(Path o1, Path o2) {
                return o2.items - o1.items;
            }
        });*/
        /*Collections.sort(paths);

        int max_items = Integer.MIN_VALUE;
        int index = 0;
        for (int i = 0; i < paths.size(); i++)
        {
            if (paths.get(i).items > max_items && paths.get(i).length == paths.get(0).length)
            {
                max_items = paths.get(i).items;
                index = i;
            }
        }*/

       // System.out.println(paths.toString());

//        System.out.println((paths.isEmpty()) ? "impossible" : paths.get(index).length + " " + paths.get(index).items);
        System.out.println((min_dist == Integer.MAX_VALUE) ? "impossible" : min_dist + " " + max_items);


    }
    
    static void traverse(Node city, int steps, int t_items)
    {


        //visited[city] = true;
    
        if (city.equals(cities[n - 1]))
        {
            
            //paths.add(new Path(steps, t_items));
            if (min_dist > steps)
            {

                min_dist = steps;
                max_items = t_items;

            }
            else if (min_dist == steps)
                if (t_items > max_items)
                    max_items = t_items;

            return;
            
        }

        for (Edge e : city.edges)
        {

            if (steps + e.weight > min_dist) continue;

            traverse(e.to, steps + e.weight, t_items + e.to.items);

        }
        
//        for (int i = 0; i < n; i++)
//        {
//
//
//
////            if (dist[city][i] != -1 && !visited[i])
////            {
////
////                if (steps + dist[city][i] > min_dist) continue;
////
////                traverse(visited.clone(), i, steps + dist[city][i], t_items + items[i]);
////
////            }
//
//        }
    
    }

    
}
