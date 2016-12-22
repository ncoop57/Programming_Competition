package ACMCompetition2016;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * Created by natha on 12/12/2016.
 */
public class Islands
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

    private void bfs(int row, int column)
    {

        Queue<Node> queue = new LinkedList<Node>();
        Node current = null;

        graph[column][row].layer = 0;
        queue.add(graph[row][column]);

        while(!queue.isEmpty())
        {

            current = queue.peek();
            current.visited = false;

            for (Edge edge: current.adjList)
                if (!graph[edge.to_row][edge.to_column].visited && graph[edge.to_row][edge.to_column].value != 'W')
                {

                    queue.add(graph[edge.to_row][edge.to_column]);
                    graph[edge.to_row][edge.to_column].visited = true;
                    graph[edge.to_row][edge.to_column].layer = current.layer + 1;

                    if (graph[edge.to_row][edge.to_column].value == 'L')
                        total--;

                }

            queue.poll();

        }

    }

    public static void main(String[] args)
    {

        Islands islands = new Islands();
        Scanner sc = new Scanner(System.in);

        int rows = sc.nextInt();
        int columns = sc.nextInt();

        String junk = sc.nextLine();

        islands.initGraph(rows, columns);

        for (int i = 0; i < rows; i++)
        {
            String line = sc.nextLine();
            for (int j = 0; j < columns; j++)
            {

                islands.graph[i][j].value = line.charAt(j);
                try
                {
                    //if (i != rows - 1 && j != columns - 1)
                    islands.addEdge(i, j, i, j + 1);
                    islands.addEdge(i, j, i + 1, j);
                }
                catch (Exception e) {}

                if (islands.graph[i][j].value == 'L')
                    islands.total++;

            }
        }

        for (int k = 0; k < rows; k++)
        {
            for (int l = 0; l < columns; l++)
            {
                if (islands.graph[k][l].value == 'L' && !islands.graph[k][l].visited)
                    try
                    {
                        islands.bfs(k, l);
                    }
                    catch (Exception e) {}
            }
        }

        System.out.println(islands.total);

    }

}
