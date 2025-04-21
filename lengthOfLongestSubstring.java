/* LeetCode 3. Longest Substring Without Repeating Characters */

class Solution {
    public int lengthOfLongestSubstring(String s) {
        // Create new hashset to store seen characters
        HashSet<Character> hash = new HashSet<Character>();

        // 'Sliding window' approach
        int l = 0;
        int r = 0; 
        int max = 0;

        // While the right pointer is less than the length of s
        while (r < s.length()) {
            char c = s.charAt(r);
            
            // If the character has not been seen, expand the window to the right
            if (hash.add(c)) r++;

            // Otherwise, remove the character to the left of the window 
            else hash.remove(s.charAt(l++));
            
            // Update max length at each slide
            max = Math.max(r - l, max);
        }
 
        return max;
    }
}