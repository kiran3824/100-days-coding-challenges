class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> result = new ArrayList<>();

        if (s == null || s.length() == 0 || words == null || words.length == 0) {
            return result;
        }

        int wordLength = words[0].length();
        int totalWords = words.length;
        int substringLength = wordLength * totalWords;
        int sLength = s.length();

        Map<String, Integer> wordCounts = new HashMap<>();

        for (String word : words) {
            wordCounts.put(word, wordCounts.getOrDefault(word, 0) + 1);
        }

        for (int i = 0; i <= sLength - substringLength; i++) {
            String substring = s.substring(i, i + substringLength);
            Map<String, Integer> seen = new HashMap<>();

            for (int j = 0; j < substringLength; j += wordLength) {
                String currentWord = substring.substring(j, j + wordLength);
                seen.put(currentWord, seen.getOrDefault(currentWord, 0) + 1);
            }

            if (seen.equals(wordCounts)) {
                result.add(i);
            }
        }

        return result;
    }
}