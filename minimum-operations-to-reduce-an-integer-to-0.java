//https://leetcode.com/problems/minimum-operations-to-reduce-an-integer-to-0/?envType=problem-list-v2&envId=bit-manipulation

class Solution {
    public int minOperations(int n) {  //Greedy Approach
        int steps = 0;
       for(int i=0;i<17;i++){
        if(Integer.bitCount(n+(1<<i)) < Integer.bitCount(n)){
            n=(n+(1<<i));
            steps++;
        }
       }

       return steps+Integer.bitCount(n);
    }
}

  /*  public int minOperations(int n) {
        int res = 0;
        while (n > 0) {
            if ((n & 3) == 3) {   // last two bit are 11 then that number is close to higher power of two
                n++;  //Simply incrementing the n to ahieve the next power of two
                res++;
            } else {
                res += n & 1;
                n >>= 1;
            }
        }
        return res;
    }*/


/*class Solution {
    public int minOperations(int n) {
        int steps = 0;
        while (n > 0) {
          
            int lowerPower = Integer.highestOneBit(n);
            // Find the smallest power of 2 > n
            int higherPower = lowerPower << 1;
            
            // Determine whether to subtract or add based on closeness
            if (n - lowerPower < higherPower - n) {
                n -= lowerPower; // Subtract the lower power of 2
            } else {
                n = higherPower - n; // Transform n closer to zero by subtracting from the higher power
            }
            steps++;
        }
        return steps;
    }
}
 */
