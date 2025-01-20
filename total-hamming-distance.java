
//https://leetcode.com/problems/total-hamming-distance/

/*For each bit position 1-32 in a 32-bit integer belonging to the array, we count the number of integers in the array which have that bit set.

Then, if there are n integers in the array and k of them have a particular bit set and (n-k) do not, then that bit contributes nx(n-k) to the hamming distance. (Because for each of the 'k' numbers, we have 1 of the (n-k) numbers, that have a different bit and the number of ways to select 1 from k and (n-k) numbers is (kC1)x((n-k)C1)*/

class Solution {
    public int totalHammingDistance(int[] nums) {
        int n=nums.length;
        int distance=0;
        for(int i=0;i<32;i++){
            int count=0;
            for(int j=0;j<n;j++){
                boolean bitset =( nums[j] & (1<<i) )!=0;
                if(bitset)count++;
            }

            distance+=(count*(n-count));
        }

        return distance;
    }
}
