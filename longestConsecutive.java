/* LeetCode 128. Longest Consecutive Sequence */

class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) return 0;
        
        HashSet<Integer> hash = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            hash.add(nums[i]);
        }

        int max = 1;
        for (int i : hash) {
            int count = 1;
            if (!hash.contains(i - 1)) {
                while (hash.contains(i + count)) count++;
            }

            max = Math.max(max, count); 
        }

        return max;
    }
}