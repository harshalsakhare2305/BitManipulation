/*Why check for similar masks?
Definition of a "similar mask":
A "similar mask" is a mask that is identical to the current mask. When two identical masks appear at different positions in the string, it means the digits between these two positions have canceled each other out (appearing in pairs). This is because XORing the same value cancels it out.


How we will decide the this string can make palindrome or not ?
Count of Digits is Even 
Count of digint is even except one bit 


So for this we will the bitmasking number of set bit suggest us number of odd number of bits
*/

//https://leetcode.com/problems/find-longest-awesome-substring/

import java.util.*;

class Solution {
    public int longestAwesome(String s) {
        int n = s.length();
        int ans = 0, mask = 0;
        
        // Initialize memo array with large value and set memo[0] to -1
        int[] memo = new int[1024];
        Arrays.fill(memo, n);
        memo[0] = -1;

        for (int i = 0; i < n; i++) {
            // Update mask with the current digit
            mask ^= 1 << (s.charAt(i) - '0');

            // Case 1: Check if we've seen this mask before
            ans = Math.max(ans, i - memo[mask]);

            // Case 2: Check for masks that differ by one bit
            for (int j = 0; j < 10; j++) {
                int testMask = mask ^ (1 << j);
                ans = Math.max(ans, i - memo[testMask]);
            }

            // Save the earliest position of this mask
            memo[mask] = Math.min(memo[mask], i);
        }

        return ans;
    }
}
