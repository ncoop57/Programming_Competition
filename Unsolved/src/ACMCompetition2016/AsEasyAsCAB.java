package ACMCompetition2016;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by natha on 12/12/2016.
 */
public class AsEasyAsCAB
{

    private Node[][] graph;
    private int total = 0;

    private class Node
    {

        private ArrayList<Edge> adjList;

        private int row;
        private int column;
        private int layer;

        private char value;

        private boolean visited;

        public Node(int row, int column)
        {
            adjList = new ArrayList<Edge>();
            this.row = row;
            this.column = column;
            this.value = 'C';
            this.visited = false;
        }

        public void setValue(char value)
        {
            this.value = value;
        }

    }

    private class Edge
    {

        private int to_column;
        private int to_row;

        public Edge(int column, int row)
        {
            this.to_column = column;
            this.to_row = row;
        }

    }

    private void initGraph(int rows, int columns)
    {

        this.graph = new Node[rows][columns];

        for (int i = 0; i < rows; i++)
            for (int j = 0; j < columns; j++)
                graph[i][j] = new Node(i, j);

    }

    private void addEdge(int start_row, int start_column, int to_row, int to_column)
    {

        graph[start_row][start_column].adjList.add(new Edge(to_row, to_column));
        graph[to_row][to_column].adjList.add(new Edge(start_row, start_column));

    }

    /* By last they mean how far in the alphabet the letters will be chosen from */
    public static void main(String[] args)
    {

        Scanner sc = new Scanner(System.in);

        char last = sc.next().charAt(0);
        int n = sc.nextInt();

        String junk = sc.nextLine();

        ArrayList<String> dictionary = new ArrayList<String>();

        for (int i = 0; i < n; i++)
            dictionary.add(sc.nextLine());



    }

}
