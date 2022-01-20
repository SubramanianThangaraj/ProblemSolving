/**
 * Problem Link: https://leetcode.com/problems/3sum/
 */
package Leetcode.random;
import java.util.*;

public class ThreeSum
{
    public List<List<Integer>> threeSum(int[] nums)
    {
        Arrays.sort(nums);
        List<List<Integer>> mainList = new ArrayList<>();
        List<Integer> triplet = new ArrayList<>();

        int sumValue;
        int requiredValue;
        int prevJ = 100001;
        int prevValue = 100001;
        for(int i=0; i<nums.length; i++)
        {
            if(nums[i]==prevValue)continue;
            prevValue = nums[i];
            for (int j=i+1; j<nums.length; j++)
            {
                if(nums[j] == prevJ)continue;
                prevJ = nums[j];
                sumValue = nums[i];
                sumValue = sumValue + nums[j];
                requiredValue = -1 * sumValue;
                for(int k=nums.length-1; k>j; k--)
                {
                    if(nums[k]==requiredValue)
                    {
                        triplet.add(nums[i]);
                        triplet.add(nums[j]);
                        triplet.add(nums[k]);
                        mainList.add(new ArrayList<>(triplet));
                        triplet.clear();

                        break;
                    }
                    else if(nums[k]<requiredValue)break;
                }
            }
        }

        return mainList;
    }
}
