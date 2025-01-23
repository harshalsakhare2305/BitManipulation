//https://leetcode.com/problems/split-array-into-maximum-number-of-subarrays/?envType=problem-list-v2&envId=bit-manipulation


//If the total ans value is non zero then it not possible to split the array with score less than the actual score of the array
class Solution {
    public int maxSubarrays(int[] nums) {
        int and = nums[0];
        for (int i : nums) {
            and &= i;
        }
        
        
        if (and != 0) return 1;

        int result = -1; 
        int count = 0;

        for (int num : nums) {
            result &= num;
            if (result == 0) {
                count++;
                result = -1;
            }
        }

        return count;
    }
}
