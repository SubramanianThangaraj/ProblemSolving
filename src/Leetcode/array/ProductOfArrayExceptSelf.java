/**
 * Problem Link: https://leetcode.com/problems/product-of-array-except-self/
 */
package Leetcode.array;

public class ProductOfArrayExceptSelf
{
    public int[] productExceptSelf(int[] nums)
    {
        int totalProduct = 1;
        int zeroCount = 0;
        for(int i=0; i<nums.length; i++)
        {
            if(zeroCount>=2)break;
            if(nums[i]==0)
            {
                zeroCount++;
                continue;
            }
            totalProduct = totalProduct * nums[i];
        }
        //if ZeroCount equals 1 then all the element in the resultant array will be zero except for the index which actually contains the value 'zero'
        if(zeroCount == 1)
        {
            for (int i=0; i<nums.length; i++)
            {
                if(nums[i]!=0) {
                    nums[i] = 0;
                }
                else {
                    nums[i] = totalProduct;
                }
            }
            return nums;
        }
        //if ZeroCount equals 2 or more then all the element in the resultant array will be zero
        if(zeroCount>=2)
        {
            for (int i=0; i<nums.length; i++)
            {
                nums[i] = 0;
            }
            return nums;
        }

        for (int i=0; i<nums.length; i++)
        {
            nums[i] = totalProduct/nums[i];
        }
        return nums;
    }
}
