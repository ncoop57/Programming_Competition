/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 *
 * @author nac33
 */
public class BigTruck
{

    static Node cities[];
    static int[] city_items;
    
    static class Node implements Comparable<Node>
    {
    
        int items;
        int dist;
        int id;
        ArrayList<Edge> adjList;
        
        public Node(int items, int dist, int id)
        {
        
            this.items = items;
            this.dist = dist;
            this.adjList = new ArrayList<>();
        
        }

        @Override
        public int compareTo(Node n)
        {
            
            return this.dist - n.dist;
            
        }
    
    }
    
    static class Edge
    {
    
        Node from;
        Node to;
        int weight;
        
        public Edge(Node from, Node to, int weight)
        {
        
            this.from = from;
            this.to = to;
            this.weight = weight;
        
        }
    
    }
    
    public static void main(String[] args)
    {
    
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        cities = new Node[n];
        String junk = sc.nextLine();
        city_items = new int[n];
        
        String[] item_line = sc.nextLine().split(" ");
        for (int i = 0; i < n; i++)
        {
            city_items[i] = Integer.parseInt(item_line[i]);
            cities[i] = new Node(city_items[i], Integer.MAX_VALUE, i);
        }
        
        int m = sc.nextInt();
        for (int j = 0; j < m; j++)
        {
        
            int a = sc.nextInt() - 1;
            int b = sc.nextInt() - 1;
            int d = sc.nextInt();
            cities[a].adjList.add(new Edge(cities[a], cities[b], d));
            //cities[b].adjList.add(new Edge(cities[b], cities[a], d));

        }
        
        Node last = dijkstra(0, n - 1);
        
        System.out.println(last.dist + " " + last.items);
        
    }
    
    static Node dijkstra(int s, int t)
    {
    
        PriorityQueue<Node> pq = new PriorityQueue<>();
        cities[0].dist = 0;
        pq.offer(cities[0]);
        
        while(!pq.isEmpty())
        {
        
            Node current = pq.poll();
            for (Edge e : current.adjList)
            {
            
                if (e.to.dist > current.dist + e.weight)
                {
                
                    e.to.dist = current.dist + e.weight;
                    e.to.items += current.items;
                    pq.offer(e.to);
                
                }
                else if (e.to.dist == current.dist + e.weight)
                {
                    
                    e.to.items = Math.max(e.to.items, city_items[e.to.id] + current.items);
                    
                }
                
            }
        
        }
        
        return cities[t];
        
    }
    
}
