/* LeetCode 128. Longest Consecutive Sequence */

class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) return 0;
        
        // Add all values into the hashset
        HashSet<Integer> hash = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            hash.add(nums[i]);
        }

        int max = 1;

        // Iterate through all values in the hashset
        for (int i : hash) {
            int count = 1;

            // If this element is the starting element in the sequence, count the number of consecutive elements in the hashset
            if (!hash.contains(i - 1)) {
                while (hash.contains(i + count)) count++;
            }

            // Update maximum number
            max = Math.max(max, count); 
        }

        return max;
    }
}