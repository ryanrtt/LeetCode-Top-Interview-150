/* LeetCode 3. Longest Substring Without Repeating Characters */

class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> hash = new HashSet<Character>();
        int l = 0;
        int r = 0; 
        int max = 0;

        while (r < s.length()) {
            char c = s.charAt(r);

            if (hash.add(c)) r++;
            else hash.remove(s.charAt(l++));
    
            max = Math.max(r - l, max);
        }
 
        return max;
    }
}