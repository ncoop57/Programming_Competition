package Kattis;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * @author nac33
 */
public class Grid_BFS
{

    static int[][] grid;
    static int[][] dist;

    public static void main(String[] args) throws IOException
    {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] dimensions = br.readLine().split(" ");
        int n = Integer.parseInt(dimensions[0]);
        int m = Integer.parseInt(dimensions[1]);
        grid = new int[n][m];
        dist = new int[n][m];

        for (int i = 0; i < n; i++)
            Arrays.fill(dist[i], -1);

        for (int i = 0; i < n; i++)
        {

            for (int j = 0; j < m; j++)
                grid[i][j] = br.read() - '0';

            br.read();

        }

//        System.out.println(Arrays.deepToString(grid));
        bfs();
//        System.out.println(Arrays.deepToString(dist));


        System.out.println(dist[n - 1][m-1]);

    }

    static void bfs()
    {

        Queue<Integer[]> q = new LinkedList<>();
        Integer[] start = {0, 0};
        dist[start[0]][start[1]] = 0;
        q.offer(start);

        while(!q.isEmpty())
        {

            Integer[] current = q.poll();
//            System.out.println(Arrays.toString(current));

            if (grid[current[0]][current[1]] == 0) continue;

            if (moveUp(current))
            {

                Integer[] next = {current[0] - grid[current[0]][current[1]], current[1]};

                if (dist[next[0]][next[1]] == -1)
                {
                    //System.out.println("Go up");
                    q.offer(next);

                    dist[next[0]][next[1]] = dist[current[0]][current[1]] + 1;

                }
            }

            if (moveDown(current))
            {
                Integer[] next = {current[0] + grid[current[0]][current[1]], current[1]};

                if (dist[next[0]][next[1]] == -1)
                {
                    //System.out.println("Go down");

                    q.offer(next);

                    dist[next[0]][next[1]] = dist[current[0]][current[1]] + 1;

                }
            }

            if (moveLeft(current))
            {

                Integer[] next = {current[0], current[1] - grid[current[0]][current[1]]};
                if (dist[next[0]][next[1]] == -1)
                {
//                    System.out.println("Go left");

                    q.offer(next);

                    dist[next[0]][next[1]] = dist[current[0]][current[1]] + 1;

                }
            }

            if (moveRight(current))
            {

                Integer[] next = {current[0], current[1] + grid[current[0]][current[1]]};

                if (dist[next[0]][next[1]] == -1)
                {
                    //System.out.println("Go right");

                    q.offer(next);

                    dist[next[0]][next[1]] = dist[current[0]][current[1]] + 1;

                }
            }

        }


    }

    static boolean moveUp(Integer[] current)
    {

        if (current[0] - grid[current[0]][current[1]] < 0)
            return false;

        return true;

    }

    static boolean moveDown(Integer[] current)
    {



        if (current[0] + grid[current[0]][current[1]] >= grid.length)
            return false;

//        System.out.println("Can go down: " + (current[0] + grid[current[0]][current[1]]));
//        System.out.println();

        return true;

    }

    static boolean moveLeft(Integer[] current)
    {

        if (current[1] - grid[current[0]][current[1]] < 0)
            return false;

        return true;

    }

    static boolean moveRight(Integer[] current)
    {

        if (current[1] + grid[current[0]][current[1]] >= grid[0].length)
            return false;

        return true;

    }

}