/* LeetCode 136. Single Number */

class Solution {
    public int singleNumber(int[] nums) {
        int xor = 0;

        // Performs a bitwise XOR to all elements of the array, each matching pair will XOR to 0, leaving the outstanding number remaining as the result
        for (int i = 0; i < nums.length; i++) {
            xor ^= nums[i];
        }

        return xor;
    }
}