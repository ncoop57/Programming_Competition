
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author kms118
 */
public class Grid
{

    static int min = Integer.MAX_VALUE;
    
    static int[][] dist;
    
    public static void main(String[] args) throws Exception
    {
    
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String[] input = br.readLine().split(" ");
        
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);
        
        
        int[][] grid = new int[n][m];
        boolean[][] visited = new boolean[n][m];
        dist = new int[n][m];
        for (int i = 0; i < visited.length; i++)
        {
            Arrays.fill(visited[i], false);
            Arrays.fill(dist[i], Integer.MAX_VALUE);
        }
        for (int i = 0; i < n; i++)
        {
        
            for (int j = 0; j < m; j++)
            {
                
          
                char num = (char) br.read();
                String number = "" + num;
               // System.out.println(number);
                grid[i][j] = Integer.parseInt(number);
            
            }
            String junk = br.readLine();
        }
        
        //for (int k = 0; k < grid.length; k++)
          //  System.out.println(Arrays.toString(grid[k]));
          
          backtracking(grid, visited, 0, 0, 0);
          
          if (min == Integer.MAX_VALUE)
              System.out.println(-1);
          else
            System.out.println(min);
        
        
    
    }
    
    
    static void backtracking(int[][] grid, boolean[][] visited, int x, int y, int s)
    {
    
        if (y == grid.length - 1 && x == grid[0].length - 1)
        {
        
           // visited[y][x] = true;
            if (min > s)
                min = s;
            return;
            
        }
        
        if ((y >= grid.length || y < 0) || (x >= grid[0].length || x < 0))
            return;
        
        if (visited[y][x])
            return;
        
        if (grid[y][x] == 0)
        {
            visited[y][x] = true;
            return;
        }
        
        
        
        visited[y][x] = true;
        
        backtracking(grid, visited, x + grid[y][x], y, s + 1);
        backtracking(grid, visited, x - grid[y][x], y, s + 1);
        backtracking(grid, visited, x, y + grid[y][x], s + 1);
        backtracking(grid, visited, x, y - grid[y][x], s + 1);

    
    }
    
}
