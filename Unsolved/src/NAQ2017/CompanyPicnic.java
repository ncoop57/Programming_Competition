package NAQ2017;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class CompanyPicnic
{

    private static class Person
    {

        public String name;
        public double speed;
        public String member;

        public Person(String name, double speed, String member)
        {

            this.name = name;
            this.speed = speed;
            this.member = member;

        }

    }

    private static class Team
    {

        public Person p1;
        public Person p2;

        public Team(Person p1, Person p2)
        {

            this.p1 = p1;
            this.p2 = p2;

        }

    }

    public static void main(String[] args)
    {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        ArrayList<Person> people = new ArrayList<>();
        for (int i = 0; i < n; i++)
        {

            people.add(new Person(sc.next(), sc.nextDouble(), sc.next()));
            System.out.println(people.get(i).name + ": " + people.get(i).speed);

        }

        ArrayList<Team> teams = new ArrayList<>();
        for (int j = 0; j < n; j++)
        {

            for (int k = 0; k < n; k++)
            {
                if (people.get(j).member.equals(people.get(k).name))
                {
                    teams.add(new Team(people.get(j), people.get(k)));
                }
            }

        }

    }

}
