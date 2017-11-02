package Kattis;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

/**
 * Created by natha on 11/1/2017.
 */
public class Grid
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
            Arrays.fill(dist, Integer.MAX_VALUE);

        for (int i = 0; i < n; i++)
        {

            for (int j = 0; j < m; j++)
            {

                grid[i][j] = br.read() - '0';

            }

            br.read();

        }

//        for (int i = 0; i < n; i++)
//            System.out.println(Arrays.toString(grid[i]));

    }

    static void breadth_first_search()
    {

        int[] start = {0, 0};
        Queue<int[]> queue = new PriorityQueue<>();

        queue.offer(start);
        while(!queue.isEmpty())
        {

            int[] current = queue.poll();

            if (moveUp(current))
            {
                int[] next = {current[0] - grid[current[0]][current[1]], current[1]};
                if (dist[next[0]][next[1]] > dist[current[0]][current[1]])
                    dist[next[0]][next[1]] = dist[current[0]][current[1]] + 1;
            }

        }

    }

    static boolean moveUp(int[] current)
    {

        if (current[0] - grid[current[0]][current[1]] < 0)
            return false;

        return true;

    }

    static boolean moveDown(int[] current)
    {

        if (current[0] + grid[current[0]][current[1]] >= grid.length)
            return false;

        return true;

    }

    static boolean moveLeft(int[] current)
    {

        if (current[1] - grid[current[0]][current[1]] < 0)
            return false;

        return true;

    }

    static boolean moveRight(int[] current)
    {

        if (current[1] + grid[current[0]][current[1]] >= grid[0].length)
            return false;

        return true;

    }

}
