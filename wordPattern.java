/* LeetCode 290. Word Pattern */

class Solution {
    public boolean wordPattern(String pattern, String s) {
        HashMap<Character, String> hash = new HashMap<>();
        String[] words = s.split(" ");

        if (words.length != pattern.length()) return false;

        for (int i = 0; i < words.length; i++) {
            Character c = pattern.charAt(i);
            if (!hash.containsKey(c)) { 
                if (hash.containsValue(words[i])) return false;
                hash.put(c, words[i]);
            }
            else if (!hash.get(c).equals(words[i])) return false; 

        }

        return true;
    }
}