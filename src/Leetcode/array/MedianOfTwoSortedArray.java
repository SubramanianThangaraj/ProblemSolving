/**
 * Problem Link: https://leetcode.com/problems/median-of-two-sorted-arrays
 */
package Leetcode.array;

public class MedianOfTwoSortedArray
{
    public double findMedianSortedArrays(int[] nums1, int[] nums2)
    {
        int totalLength = nums1.length + nums2.length;
        int[] mergedArray = new int[totalLength];
        int halfLength = totalLength/2;
        boolean skipHandling = false;

        if(totalLength == 1)
        {
            if(nums1.length==1)return nums1[0];
            else return nums2[0];
        }
        else
        {
            if (nums1.length == 0)
            {
                mergedArray[halfLength-1] = nums2[halfLength-1];
                mergedArray[halfLength] = nums2[halfLength];
                skipHandling = true;
            }
            else if (nums2.length == 0)
            {
                mergedArray[halfLength-1] = nums1[halfLength-1];
                mergedArray[halfLength] = nums1[halfLength];
                skipHandling = true;
            }
        }
        int index1 = 0;
        int index2 = 0;
        int i;

        if(!skipHandling) {
            for (i = 0; i <= halfLength; i++) {
                if (nums1[index1] <= nums2[index2]) {
                    mergedArray[i] = nums1[index1];
                    index1++;
                    if (index1 == nums1.length) {
                        while (i < halfLength) {
                            i++;
                            mergedArray[i] = nums2[index2];
                            index2++;
                        }
                    }
                } else {
                    mergedArray[i] = nums2[index2];
                    index2++;
                    if (index2 == nums2.length) {
                        while (i < halfLength) {
                            i++;
                            mergedArray[i] = nums1[index1];
                            index1++;
                        }
                    }
                }
            }
        }
        double median;
        if(totalLength%2==0)
        {
            median = (double) (mergedArray[halfLength-1] + mergedArray[halfLength])/2;
        }
        else
        {
            median = (double) (mergedArray[halfLength]);
        }
        return median;
    }
}
