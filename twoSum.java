/* LeetCode 1. Two Sum */

class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> hash = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];

            if (hash.containsKey(complement)) return new int[]{i, hash.get(complement)};
            if (!hash.containsKey(nums[i])) hash.put(nums[i], i);
        }

        return null;
    }
}