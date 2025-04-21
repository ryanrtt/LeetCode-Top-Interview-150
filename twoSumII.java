/* LeetCode 167. Two Sum II - Input Array Is Sorted */

class Solution {
    public int[] twoSum(int[] numbers, int target) {
        // Two pointer approach 
        int l = 0;
        int r = numbers.length - 1;

        while (numbers[l] + numbers[r] != target) {
            int sum = numbers[l] + numbers[r];

            // If the current sum is less than the target, increment left pointer, otherwise decrement right pointer
            if (sum < target) l++;
            else r--;
        }

        // Return indices (1-indexed)
        return new int[]{++l, ++r};
    }
}