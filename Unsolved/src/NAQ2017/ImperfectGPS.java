package NAQ2017;

import java.util.ArrayList;
import java.util.Scanner;

public class ImperfectGPS
{

    public static class Point
    {

        public int x;
        public int y;
        public int t;

        public Point(int x, int y, int t)
        {

            this.x = x;
            this.y = y;
            this.t = t;

        }

        public double getDist(Point point)
        {

            return Math.sqrt((Math.pow(this.x - point.x, 2) + Math.pow(this.y - point.y, 2)));

        }

        public String toString()
        {

            return "x: " + this.x + " y: " + this.y + " t: " + this.t;

        }

    }

    public static void main(String[] args)
    {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int t = sc.nextInt();

        int r_current = 0;
        int gps_current = 0;

        Point[] r_points = new Point[n];
        for (int i = 0; i < n; i++)
            r_points[i] = new Point(sc.nextInt(), sc.nextInt(), sc.nextInt());

        double r_distance = 0;
        for (int j = 0; j < n - 1; j++)
            r_distance += r_points[j].getDist(r_points[j + 1]);

        ArrayList<Point> gps_points = new ArrayList<>();
        gps_points.add(r_points[0]);
        for (int k = 0; k < n - 1; k++)
        {
            int x_diff = r_points[k + 1].x - r_points[k].x;
            int y_diff = r_points[k + 1].y - r_points[k].y;

            if (r_points[k + 1].t < gps_current + t)
                continue;

            gps_current += t;
            int t_diff = r_points[k + 1].t - r_points[k].t;
            int new_x = r_points[k].x + (x_diff / t_diff) * (gps_current - r_points[k].t);
            int new_y = r_points[k].y + (y_diff / t_diff) * (gps_current - r_points[k].t);
            gps_points.add(new Point(new_x, new_y, gps_current));

            if (r_points[k + 1].t > gps_current)
                k--;

        }


        if (gps_points.get(gps_points.size() - 1).t != r_points[n - 1].t)
            gps_points.add(r_points[n - 1]);

        double gps_distance = 0;
        for (int j = 0; j < gps_points.size() - 1; j++)
            gps_distance += gps_points.get(j).getDist(gps_points.get(j + 1));

        System.out.println(gps_points.toString());
        System.out.println((double) 1 - (gps_distance / r_distance));

    }

}
