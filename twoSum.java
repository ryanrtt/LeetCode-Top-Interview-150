/* LeetCode 1. Two Sum */

class Solution {
    public int[] twoSum(int[] nums, int target) {
        // Hashmap to store indices
        HashMap<Integer, Integer> hash = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];

            // If the hash contains the complement, return both indices
            if (hash.containsKey(complement)) return new int[]{i, hash.get(complement)};

            // If the hash does not contain the current number, add to the hashset
            if (!hash.containsKey(nums[i])) hash.put(nums[i], i);
        }

        return null;
    }
}