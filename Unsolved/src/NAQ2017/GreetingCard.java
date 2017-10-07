package NAQ2017;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class GreetingCard
{

    public static class Point implements Comparable<Point>
    {

        public long x;
        public long y;

        public Point(long x, long y)
        {

            this.x = x;
            this.y = y;

        }

        public double getDist(Point point)
        {

            return Math.sqrt((Math.pow(this.x - point.x, 2) + Math.pow(this.y - point.y, 2)));

        }


        @Override
        public int compareTo(Point point)
        {
            double dist = Math.sqrt((Math.pow(this.x - point.x, 2) + Math.pow(this.y - point.y, 2)));
            if (dist < 0)
                return -1;
            else if (dist > 0)
                return 1;
            else
                return 0;
        }

        public String toString()
        {

            return "x: " + this.x + " y: " + this.y;

        }
    }

    public static class XPoint implements Comparable<XPoint>
    {

        public Point pt;

        public XPoint(Point pt)
        {

            this.pt = pt;

        }

        @Override
        public int compareTo(XPoint xpt)
        {
            return (int) (this.pt.x - xpt.pt.x);
        }

        public String toString()
        {

            return this.pt.toString();

        }

    }

    public static class YPoint implements Comparable<YPoint>
    {

        public Point pt;

        public YPoint(Point pt)
        {
            this.pt = pt;
        }

        @Override
        public int compareTo(YPoint ypt)
        {
            return (int) (this.pt.y - ypt.pt.y);
        }

        public String toString()
        {

            return this.pt.toString();

        }
    }

    public static void main(String[] args)
    {

        Scanner sc = new Scanner(System.in);

        int total = 0;
        int n = sc.nextInt();
        ArrayList<Point> points = new ArrayList<>();
        ArrayList<XPoint> xpoints = new ArrayList<>();
        ArrayList<YPoint> ypoints = new ArrayList<>();
        for (int i = 0; i < n; i++)
        {

            points.add(new Point(sc.nextLong(), sc.nextLong()));


        }

        Collections.sort(points);

        for (int i = 0; i < n; i++)
        {
            xpoints.add(new XPoint(points.get(i)));
            ypoints.add(new YPoint(points.get(i)));
        }

        Collections.sort(xpoints);
        Collections.sort(ypoints);

        System.out.println(points.toString());
        System.out.println(xpoints.toString());
        System.out.println(ypoints.toString());

        for (int j = 0; j < points.size() - 1; j++)
        {

            for (int k = j + 1; k < points.size(); k++)
                if (xpoints.get(j).pt.getDist(xpoints.get(k).pt) == 2018)
                    total++;
                else if (ypoints.get(j).pt.getDist(ypoints.get(k).pt) == 2018)
                    total++;
                else if (points.get(j).getDist(points.get(k)) > 2018)
                    break;

        }

        System.out.println(total);

    }



}
