/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Kattis;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 *
 * @author nac33
 */
public class Watchdogs
{

    static class Point implements Comparable<Point>
    {
    
        int x;
        int y;
        
        public Point(int x, int y)
        {
        
            this.x = x;
            this.y = y;
        
        }
        
        public double dist(Point p)
        {
        
            double dist = Math.sqrt(Math.pow(p.x - x, 2) + Math.pow(p.y - y, 2));
            
            return dist;
        
        }

        @Override
        public int compareTo(Point p)
        {
            return x - p.x;
        }
        
        public String toString()
        {
        
            return "X: " + x + " Y: " + y;
        
        }
    
    }
    
    public static void main(String[] args)
    {
    
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        
        for (int i = 0; i < n; i++)
        {
        
            int S = sc.nextInt();
            int H = sc.nextInt();
            
            ArrayList<Point> hatches = new ArrayList<>();
            for (int j = 0; j < H; j++)
            {
            
                hatches.add(new Point(sc.nextInt(), sc.nextInt()));
            
            }
            
            ArrayList<Point> possibles = new ArrayList<>();
            for (int k = 0; k <= S; k++)
                for (int l = 0; l <= S; l++)
                {
                
                    Point current = new Point(k, l);
                    double max_dist = Double.MIN_VALUE;
                    boolean onHatch = false;
                    
                    for (Point hatch : hatches)
                    {
                    
                        double dist = hatch.dist(current);
                        if ((current.x == hatch.x && current.y == hatch.y))
                        {
                            onHatch = true;
                            break;
                        }
                        
                        if (dist > max_dist)
                            max_dist = dist;
                    
                    }
                    
                    if (onHatch) continue;
                    
                    if (!((current.x - max_dist < 0 || current.x + max_dist > S) || (current.y - max_dist < 0 || current.y + max_dist > S)))
                        possibles.add(current);
                
                }
            
            Collections.sort(possibles);
            
            int min_y = Integer.MAX_VALUE;
            int index = 0;
            for (int o = 0; o < possibles.size(); o++)
            {
            
                if (possibles.get(o).y < min_y && possibles.get(o).x == possibles.get(0).x)
                {
                
                    index = 0;
                    min_y = possibles.get(o).y;
                
                }
            
            }
            
            System.out.println((possibles.isEmpty()) ? "poodle" : possibles.get(index).x + " " + possibles.get(index).y);
        
        }
    
    }
    
}
