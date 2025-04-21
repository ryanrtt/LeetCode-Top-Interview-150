/* LeetCode 392. Is Subsequence */

class Solution {
    public boolean isSubsequence(String s, String t) {
        int sLength = s.length();
        int tLength = t.length();

        int p1, p2;
        p1 = p2 = 0;

        // While both pointers are less than the respective lengths of their words
        while (p1 < sLength && p2 < tLength) {
            // If the values at both pointers match, advance both pointers
            if (s.charAt(p1) == t.charAt(p2)) {
                p1++;
                p2++;
            } else p2++; // Otherwise advance second pointer
        }

        // If the first pointer has traversed the entire word, it must be a subsequence
        return p1 == sLength;
    }
}