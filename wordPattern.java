/* LeetCode 290. Word Pattern */

class Solution {
    public boolean wordPattern(String pattern, String s) {
        HashMap<Character, String> hash = new HashMap<>();

        // Splits the string into an array of separate words
        String[] words = s.split(" ");

        // If the length of the array is not the same as the number of characters
        if (words.length != pattern.length()) return false;

        for (int i = 0; i < words.length; i++) {
            Character c = pattern.charAt(i);
            
            // If the current character has not yet been recorded
            if (!hash.containsKey(c)) { 
                // If the hash already contains the word, but corresponds to a different character
                if (hash.containsValue(words[i])) return false;
                hash.put(c, words[i]);
            }
            // If the character matches a different word
            else if (!hash.get(c).equals(words[i])) return false; 

        }

        return true;
    }
}