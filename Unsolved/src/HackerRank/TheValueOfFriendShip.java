package HackerRank;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by natha on 1/14/2017.
 */
public class TheValueOfFriendShip
{

    private Node[] graph;

    private class Node
    {

        private ArrayList<Edge> adjList;

        private int id;
        private int layer;

        private boolean visited;

        public Node(int id)
        {
            adjList = new ArrayList<Edge>();
            this.id = id;
            this.visited = false;
        }

    }

    private class Edge
    {

        private int to_id;

        public Edge(int id)
        {
            this.to_id = id;
        }

    }

    private void initGraph(int n)
    {

        this.graph = new Node[n];

        for (int i = 0; i < n; i++)
            graph[i] = new Node(i);

    }

    private void addEdge(int start_id, int to_id)
    {

        graph[start_id].adjList.add(new Edge(to_id));
        graph[to_id].adjList.add(new Edge(start_id));

    }

    public static void main(String[] args)
    {

        Scanner sc = new Scanner(System.in);
        TheValueOfFriendShip friendShip = new TheValueOfFriendShip();

        int q = sc.nextInt();
        for (int i = 0; i < q; i++)
        {
            int n = sc.nextInt();
            int m = sc.nextInt();

            friendShip.initGraph(n);

            for (int j = 0; j < m; j++)
            {

                friendShip.addEdge(sc.nextInt(), sc.nextInt());

            }

        }

    }

}
