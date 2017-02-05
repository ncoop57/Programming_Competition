package Miscellaneous;

import java.util.*;

/**
 * Created by Nathan on 11/29/2016.
 */
public class BallsAndBuckets
{

    static int[] buckets;
    static int balls;

    public static void main(String[] args)
    {

        Scanner sc = new Scanner(System.in);

        balls = sc.nextInt();

        int n = sc.nextInt();
        buckets = new int[n];

        generateBuckets(balls, n);

    }

    private static void generateBuckets(int m, int n)
    {

        if (n == 1)
        {

            buckets[n - 1] = m;

            for (Integer in: buckets)
            {

                System.out.print(in + " ");

            }

            System.out.println();

            for (Integer in: buckets)
                if(in != 0)
                    fillBucket(in);
                else System.out.println("empty");

            System.out.println();
            return;

        }

        for (int i = 0; i <= m; i++)
        {

            buckets[n - 1] = i;
            generateBuckets(m - i, n - 1);

        }

    }

    private static void fillBucket(int[] bucket, List<Integer> balls, int n)
    {

        if (n == bucket.length)
            return;

        if (bucket[n] != 0)
        {

            List<Integer> tmp = new ArrayList(balls);
           // generateSequence(bucket, tmp, n);


        }
        else fillBucket(bucket, balls, ++n);


    }

    private static void findWeights(List<Integer> list, int key, int n)
    {

        if (n == 0)
            return;

        for (int i = 0; i < list.size(); i++)
        {

            List<Integer> tmp = new ArrayList(list);
            int tmp_key = key;
            tmp_key += tmp.remove(i);
            findWeights(tmp.subList(i, tmp.size()), tmp_key, n - 1);
            //compareWeights(tmp, tmp_key, 0, n);

        }

    }

    private static void generateSequence(int[] bucket, List<Integer> balls, int n, int k)
    {

        if (k == bucket[n])
            return;

        for (int i = 0; i < balls.size(); i++)
        {



        }

        if (k != 0)
            fillBucket(bucket, balls, n + 1);

    }

    private static void fillBucket(int m)
    {

        int[] nums = new int[m];

        for (int i = 0; i < balls - (m - 1); i++)
        {

            for (int n = 0; n < m; n++)
            {
                nums[n] = n + i + 1;
            }

            System.out.println(Arrays.toString(nums));
            for (int j = m - 1; j >= 1; j--)
            {
                for (int k = nums[j - 1]; k < balls; k++)
                {
                    for (int l = nums[m - 1]; l < balls; l++)
                    {
                        nums[m - 1]++;
                        System.out.println(Arrays.toString(nums));
                    }

                    nums[j - 1]++;
                    for (int l = j; l < m; l++)
                    {
                        nums[l] = nums[l - 1] + 1;

                    }

                    if (nums[m - 1] > balls)
                        break;
                    System.out.println(Arrays.toString(nums));
                }

            }

        }

    }

    private static boolean isNum(int[] nums, int key)
    {

        for (int i = 0; i < nums.length; i++)
        {
            if (nums[i] == key)
                return true;
        }

        return false;

    }

}
