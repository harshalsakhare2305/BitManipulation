
//https://leetcode.com/problems/longest-subarray-with-maximum-bitwise-and/

// the bitwise AND operation with a larger number and a smaller number would always result in a number less than or equal to the smaller number. Therefore, the maximum possible bitwise AND of a subarray can only be achieved when all the numbers in the subarray are equal to the maximum number in the array.
class Solution {
    public int longestSubarray(int[] nums) {
        int n = nums.length;
        int maxElement = 0;

        // Find the maximum element in the array
        for (int num : nums) {
            maxElement = Math.max(maxElement, num);
        }

        int maxLength = 0;
        int currentLength = 0;

        // Use a single pass to find the longest subarray with maximum AND
        for (int num : nums) {
            if (num == maxElement) {
                currentLength++;
                maxLength = Math.max(maxLength, currentLength);
            } else {
                currentLength = 0;
            }
        }

        return maxLength;
    }
}
