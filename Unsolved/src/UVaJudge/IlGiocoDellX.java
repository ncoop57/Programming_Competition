package UVaJudge;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;


public class IlGiocoDellX // UVa Judge: 260
{

	private Node[][] graph;
	
	private class Node
	{
		
		private char weight;
		private int column;
		private int row;
		private int layer;

		private boolean visited;
		
		private ArrayList<Edge> adjList;
		
		public Node(int column, int row, char weight)
		{
			
			adjList = new ArrayList<Edge>();
			this.column = column;
			this.row = row;
			this.layer = 0;
			this.visited = false;
			
		}
		
	}
	
	private class Edge
	{
		
		private int to_column;
		private int to_row;
		
		public Edge(int to_column, int to_row)
		{
			
			this.to_column = to_column;
			this.to_row = to_row;
			
		}
		
	}
	
	private void initGraph(int num, char[][] weights)
	{
		
		graph = new Node[num][num];
		
		for(int i = 0; i < num; i++)
			for(int j = 0; j < num; j++)
				graph[i][j] = new Node(i, j, weights[i][j]);
		
	}
	
	private void addEdge(int start_column, int start_row, int to_column, int to_row)
	{
		
		graph[start_column][start_row].adjList.add(new Edge(to_column, to_row));
		graph[to_column][to_row].adjList.add(new Edge(start_column, start_row));
		
	}
	
	
	private int bfs(int column, int row, int end_column, int end_row)
	{
		
		Queue<Node> queue = new LinkedList<Node>();
		Node current = null;
		
		for(int i = 0; i < graph.length; i++)
			for(Node node : graph[i])
				node.visited = false;
		
		graph[column][row].layer = 0;
		
		queue.add(graph[column][row]);
		
		while(!queue.isEmpty())
		{
			
			current = queue.peek();
			current.visited = true;
			
			for(Edge edge : current.adjList)
			{
				
				if(!graph[edge.to_column][edge.to_row].visited && graph[edge.to_column][edge.to_row].weight == current.weight)
				{
					
					queue.add(graph[edge.to_column][edge.to_row]);
					graph[edge.to_column][edge.to_row].visited = true;
					graph[edge.to_column][edge.to_row].layer = current.layer + 1;
					
				}
					
			}
			
			queue.poll();
			
		}
		/*
		for(int i = 0; i < graph.length; i++)
			for(Node node : graph[i])
				for(Edge edge : node.adjList)
					System.out.println("Edge Layer: " + graph[edge.to_column][edge.to_row].column);*/
		return graph[end_column][end_row].layer;
		
	}
	
	public static void main(String[] args)
	{
		
		Scanner sc = new Scanner(System.in);
		IlGiocoDellX main = new IlGiocoDellX();
		
		int num;
		while((num = sc.nextInt()) != 0)
		{
			
			String junk = sc.nextLine();
			
			char[][] weights = new char[num][num];
			for(int i = 0; i < num; i++)
			{
				
				weights[i] = sc.nextLine().toCharArray();
				//System.out.println(Arrays.deepToString(weights));
				
			}
			
			main.initGraph(num, weights);
			
			for(int i = 0; i < num; i++)
				for(int j = 0; j < num - 1; j++)
				{
					
					main.addEdge(j, i, j + 1, i);
					main.addEdge(j + 1, i, j, i);
					
					if(i > 0)
					{

						main.addEdge(j, i, j, i - 1);
						main.addEdge(j, i - 1, j, i);
						
						main.addEdge(j, i, j + 1, i - 1);
						main.addEdge(j + 1, i - 1, j, i);
						
						if( j > 0)
						{
							
							main.addEdge(j, i, j - 1, i - 1);
							main.addEdge(j - 1, i - 1, j, i);
							
							//System.out.println("Edge Creation");
							
						}
						
					}
					
				}
			
			for(int i = 0; i < num; i++)
				for(int j = 0; j < num; j++)
				{
					
					
					
					if(main.bfs(i, 0, j, num - 1) != 0 && main.graph[i][0].weight == main.graph[j][num - 1].weight)
					{
						
						System.out.println("B Wins");
						break;
						
					}
					else if(main.bfs(0, j, num - 1, i) != 0 && main.graph[0][j].weight == main.graph[num - 1][i].weight)
					{
						
						System.out.println("W Wins");
						break;
						
					}
					
				}
			
			for(int i = 0; i < main.graph.length; i++)
				for(Node node : main.graph[i])
					for(Edge e : node.adjList)
						System.out.printf("Node: %d, %d Edge: %d, %d\n", node.column, node.row, e.to_column, e.to_row);
			
		}

	}

}
