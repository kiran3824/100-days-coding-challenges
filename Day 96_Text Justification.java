class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        int i = 0;
        List<String> res = new ArrayList<>();
        while (i < words.length) {
            int j = goRight(i, words, maxWidth);
            res.add(justify(i, j, words, maxWidth));
            i = j + 1;
        }
        return res;
    }

    public int goRight(int start, String[] words, int maxWidth) {
        int end = start;
        int sum = words[end++].length();
        while (end < words.length && sum + 1 + words[end].length() <= maxWidth) {
            sum += 1 + words[end++].length();
        }
        return end - 1;
    }

    public String justify(int start, int end, String[] words, int maxWidth) {
        if (start == end || end == words.length - 1) {
            return leftJustify(start, end, words, maxWidth);
        }

        int numWords = end - start + 1;
        int totalSpaces = maxWidth - wordsSpace(start, end, words);
        int spacesBetweenWords = totalSpaces / (numWords - 1);
        int extraSpaces = totalSpaces % (numWords - 1);

        StringBuilder sb = new StringBuilder();
        for (int i = start; i <= end; i++) {
            sb.append(words[i]);
            if (i < end) {
                int spacesToAdd = spacesBetweenWords + (extraSpaces-- > 0 ? 1 : 0);
                sb.append(blank(spacesToAdd));
            }
        }
        return padResult(sb.toString(), maxWidth);
    }

    public String leftJustify(int start, int end, String[] words, int maxWidth) {
        StringBuilder sb = new StringBuilder();
        for (int i = start; i <= end; i++) {
            sb.append(words[i]);
            if (i < end) {
                sb.append(" ");
            }
        }
        int remainingSpaces = maxWidth - sb.length();
        sb.append(blank(remainingSpaces));
        return sb.toString();
    }

    public int wordsSpace(int i, int j, String[] words) {
        int wordLength = 0;
        for (int w = i; w <= j; w++) {
            wordLength += words[w].length();
        }
        return wordLength;
    }

    public String padResult(String word, int maxWidth) {
        return word + blank(maxWidth - word.length());
    }

    public String blank(int space) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < space; i++) {
            sb.append(" ");
        }
        return sb.toString();
    }
}
