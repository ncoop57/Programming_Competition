package ACMCompetition2016;

import java.util.*;

public class Barbells 
{

    private static SortedSet<Integer> weights = new TreeSet<Integer>();
    private static ArrayList<Integer> bars;


	public static void main(String[] args)
	{
		
		Scanner sc = new Scanner(System.in);
		
		int b = sc.nextInt();
		int p = sc.nextInt();
		
		bars = new ArrayList<Integer>();
		for(int i = 0; i < b; i++)
		{
			
			bars.add(sc.nextInt());
			weights.add(bars.get(i));
			
		}

		ArrayList<Integer> plates = new ArrayList<Integer>();
		int maxSums = 0;
		for(int i = 0; i < p; i++)
		{
			
			plates.add(sc.nextInt());

		}

		findWeights(plates, 0, plates.size());

        for (int i = 0; i < weights.size(); i++)
        {
            System.out.println(weights.toArray()[i]);
        }

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
            compareWeights(tmp, tmp_key, 0, n);

        }

    }

    private static void compareWeights(List<Integer> list, int test_key, int key, int n)
    {

        if (n == 0)
            return;

        for (int i = 0; i < list.size(); i++)
        {

            List<Integer> tmp = new ArrayList(list);
            int tmp_key = key;
            tmp_key += tmp.remove(i);

            if (tmp_key == test_key)
                for (int j = 0; j < bars.size(); j++)
                    weights.add(bars.get(j) + 2 * tmp_key);

            compareWeights(tmp.subList(i, tmp.size()), test_key, tmp_key, n - 1);

        }

    }


    /*
    private static void findWeights(ArrayList<Integer> weights, ArrayList<Integer> plates, int[] tmp_weights, int n)
    {

        int[] tmp = tmp_weights.clone();

        if (n == plates.size() - 1)
            return;

        if (weights.isEmpty())
        {
            for (int i = 0; i < plates.size(); i++)
                tmp_weights[i] = plates.get(i);
            for (int j = 0; j < tmp_weights.length; j++)
                weights.add(tmp_weights[j]);

            findWeights(weights, plates, tmp_weights, n + 1);
        }
        else
            for (int k = 0; k < plates.size(); k++)
            {
                for (int l = n + k; l < plates.size(); l++)
                    tmp[l] = tmp_weights[k] + plates.get(l);
                for (int m = 0; m < tmp.length; m++)
                    weights.add(tmp[m]);

                findWeights(weights, plates, tmp, n + 1);
            }

    }
    */

    /*
	public static int findInitWeight(int m, ArrayList<Integer> plates)
	{

		int[] nums = new int[m];
        ArrayList<Integer> tmp_plates = (ArrayList<Integer>) plates.clone();

		for (int i = 0; i < plates.size() - (m - 1); i++)
		{

			for (int n = 0; n < m; n++)
			{
				nums[n] = n + i + 1;
			}

            int total_weight = 0;
			System.out.println(Arrays.toString(nums));
            for (int j = 0; j < nums.length; j++)
            {
                try
                {
                    total_weight += tmp_plates.get(nums[j] - 1);
                    tmp_plates.remove(nums[j] - 1);
                }
                catch (Exception e)
                {
                    System.out.println("Even bigger dumbass....");
                }
            }
            for (int j = 0; j < tmp_plates.size(); j++)
            {
                if(findMatchWeight(j + 1, total_weight, tmp_plates))
                    return total_weight;
                else
                {
                    total_weight = 0;
                }
            }
            tmp_plates = (ArrayList<Integer>) plates.clone();
            for (int j = m - 1; j >= 1; j--)
			{
				for (int k = nums[j - 1]; k < plates.size(); k++)
				{
					for (int l = nums[m - 1]; l < plates.size(); l++)
					{
						nums[m - 1]++;
						System.out.println(Arrays.toString(nums));
                        for (int n = 0; n < nums.length; n++)
                        {
                            try
                            {
                                total_weight += tmp_plates.get(nums[n] - 1);
                                tmp_plates.remove(nums[n] - 1);
                            }
                            catch (Exception e)
                            {
                                System.out.println("Dumb ass....");
                            }
                        }
                        for (int n = 0; n < tmp_plates.size(); n++)
                        {
                            if(findMatchWeight(n + 1, total_weight, tmp_plates))
                                return total_weight;
                            else
                            {
                                total_weight = 0;
                            }
                        }
                        tmp_plates = (ArrayList<Integer>) plates.clone();
                    }

					nums[j - 1]++;
					for (int l = j; l < m; l++)
					{
						nums[l] = nums[l - 1] + 1;

					}

					if (nums[m - 1] > plates.size())
						break;
					System.out.println(Arrays.toString(nums));
                    for (int n = 0; n < nums.length; n++)
                    {
                        try
                        {
                            total_weight += tmp_plates.get(nums[n] - 1);
                            tmp_plates.remove(nums[n] - 1);
                        }
                        catch (Exception e)
                        {
                            System.out.println("My god you're a dumb ass...");
                        }
                    }
                    for (int n = 0; n < tmp_plates.size(); n++)
                    {
                        if(findMatchWeight(n + 1, total_weight, tmp_plates))
                            return total_weight;
                        else
                        {
                            total_weight = 0;
                        }
                    }
                    tmp_plates = (ArrayList<Integer>) plates.clone();
				}
                tmp_plates = (ArrayList<Integer>) plates.clone();
			}

		}

		return -1;

	}

    private static boolean findMatchWeight(int m, int total_weight, ArrayList<Integer> tmp_plates)
    {

        int[] nums = new int[m];

        for (int i = 0; i < tmp_plates.size() - (m - 1); i++)
        {

            for (int n = 0; n < m; n++)
            {
                nums[n] = n + i + 1;
            }

            int tmp_weight = 0;
            System.out.println(Arrays.toString(nums));
            for (int j = 0; j < nums.length; j++)
            {
                try
                {

                    tmp_weight += tmp_plates.get(nums[j] - 1);
                    tmp_plates.remove(nums[j] - 1);
                }
                catch (Exception e){
                    System.out.println("WHAT HAVE YOU DONE?!?");
                }
            }

            if (tmp_weight == total_weight)
                return true;
            else tmp_weight = 0;

            for (int j = m - 1; j >= 1; j--)
            {
                for (int k = nums[j - 1]; k < tmp_plates.size(); k++)
                {
                    for (int l = nums[m - 1]; l < tmp_plates.size(); l++)
                    {
                        nums[m - 1]++;
                        System.out.println(Arrays.toString(nums));
                        for (int n = 0; n < nums.length; n++)
                        {
                            tmp_weight += tmp_plates.get(nums[n] - 1);
                            tmp_plates.remove(nums[n] - 1);
                        }

                        if (tmp_weight == total_weight)
                            return true;
                        else tmp_weight = 0;
                    }

                    nums[j - 1]++;
                    for (int l = j; l < m; l++)
                    {
                        nums[l] = nums[l - 1] + 1;

                    }

                    if (nums[m - 1] > tmp_plates.size())
                        break;
                    System.out.println(Arrays.toString(nums));
                    for (int n = 0; n < nums.length; n++)
                    {
                        tmp_weight += tmp_plates.get(nums[n] - 1);
                        tmp_plates.remove(nums[n] - 1);
                    }

                    if (tmp_weight == total_weight)
                        return true;
                    else tmp_weight = 0;
                }

            }

        }

        return false;

    }

    */

}
