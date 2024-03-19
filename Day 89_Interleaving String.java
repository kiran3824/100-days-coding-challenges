class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        int a = s1.length(), b = s2.length();
        int[][] m = new int[a + 1][b + 1];
        for (int[] row : m) {
            Arrays.fill(row, -1);
        }
        return isInterleaveHelper(s1, s2, s3, 0, 0, 0, m);
    }

    private boolean isInterleaveHelper(String s1, String s2, String s3, int i, int j, int k, int[][] m) {
        if (m[i][j] != -1) {
            return m[i][j] == 1;
        }

        if (k == s3.length()) {
            return i == s1.length() && j == s2.length();
        }

        boolean x = false, y = false;
        if (i < s1.length() && s1.charAt(i) == s3.charAt(k)) {
            x = isInterleaveHelper(s1, s2, s3, i + 1, j, k + 1, m);
        }
        if (j < s2.length() && s2.charAt(j) == s3.charAt(k)) {
            y = isInterleaveHelper(s1, s2, s3, i, j + 1, k + 1, m);
        }

        m[i][j] = (x || y) ? 1 : 0;
        return m[i][j] == 1;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String s1 = "aabcc", s2 = "dbbca", s3 = "aadbbcbcac";
        System.out.println(solution.isInterleave(s1, s2, s3));
    }
}
