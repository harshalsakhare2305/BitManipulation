// p&(q^r^s^..)=== (p&q)^(p&r)^..
 //https://leetcode.com/problems/find-xor-sum-of-all-pairs-bitwise-and/
class Solution {
    public int getXORSum(int[] arr1, int[] arr2) {
        int xor2=0;
        for(int i:arr2){
            xor2^=i;
        }
    
    int xor =0;
    for(int i=0;i<arr1.length;i++){
        int ele =arr1[i];
        xor^=(ele&xor2);
    }

    return xor;


    }
}
