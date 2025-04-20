/* LeetCode 392. Is Subsequence */

class Solution {
    public boolean isSubsequence(String s, String t) {
        int sLength = s.length();
        int tLength = t.length();

        int p1, p2;
        p1 = p2 = 0;

        while (p1 < sLength && p2 < tLength) {
            if (s.charAt(p1) == t.charAt(p2)) {
                p1++;
                p2++;
            } else p2++;
        }

        return p1 == sLength;
    }
}