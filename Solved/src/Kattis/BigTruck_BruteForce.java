/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Kattis;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

/**
 *
 * @author nac33
 */
public class BigTruck_BruteForce
{

    static int[][] dist;
    static boolean[] visited;
    static int[] items;
    static int n = 0;
    
    static ArrayList<Path> paths = new ArrayList<>();
    
    static class Path implements Comparable<Path>
    {
    
        int length;
        int items;

        public Path(int length, int items)
        {
        
            this.length = length;
            this.items = items;
        
        }
        
        @Override
        public int compareTo(Path p)
        {
            
            return this.length - p.length;
            
        }
        
        public String toString()
        {
        
            return "Length: " + this.length + " Items: " + this.items;
        
        }
        
    }
    
    public static void main(String[] args)
    {
    
        Scanner sc = new Scanner(System.in);
        
        n = sc.nextInt();
        String junk = sc.nextLine();
        items = new int[n];
        dist = new int[n][n];
        visited = new boolean[n];
        
        for (int i = 0; i < n; i++)
            Arrays.fill(dist[i], -1);
        
        Arrays.fill(visited, false);
        
        String[] item_nums = sc.nextLine().split(" ");
        for (int i = 0; i < n; i++)
            items[i] = Integer.parseInt(item_nums[i]);
        
        int m = sc.nextInt();
        for (int j = 0; j < m; j++)
        {
        
            int a = sc.nextInt() - 1;
            int b = sc.nextInt() - 1;
            int d = sc.nextInt();
            dist[a][b] = d;
            dist[b][a] = d;
        
        }
        
        traverse(visited, 0, 0, items[0]);
        paths.sort(new Comparator<Path> () {
            @Override
            public int compare(Path o1, Path o2) {
                return o2.items - o1.items;
            }
        });
        Collections.sort(paths);
        
        System.out.println((paths.isEmpty()) ? "impossible" : paths.get(0).length + " " + paths.get(0).items);
    
    }
    
    static void traverse(boolean[] visited, int city, int steps, int t_items)
    {
        
        visited[city] = true;
    
        if (city == n - 1)
        {
            
            paths.add(new Path(steps, t_items));
            return;
            
        }
        
        for (int i = 0; i < n; i++)
        {
        
            if (dist[city][i] != -1 && !visited[i])
            {
            
                traverse(visited.clone(), i, steps + dist[city][i], t_items + items[i]);
                
            }
        
        }
    
    }

    
}
