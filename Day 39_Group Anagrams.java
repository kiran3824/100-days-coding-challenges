class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs == null || strs.length == 0)
            return new ArrayList<>();
        Map<String, List<String>> frequencyStringsMap = new HashMap<>();
        for (String str : strs) {
            String frequencyString = getFrequencyString(str);
            if (frequencyStringsMap.containsKey(frequencyString)) {
                frequencyStringsMap.get(frequencyString).add(str);
            } else {
                List<String> strList = new ArrayList<>();
                strList.add(str);
                frequencyStringsMap.put(frequencyString, strList);
            }
        }
        return new ArrayList<>(frequencyStringsMap.values());
    }

    private String getFrequencyString(String str) {
        char[] charArray = str.toCharArray();
        Arrays.sort(charArray);
        return new String(charArray);
    }
}
