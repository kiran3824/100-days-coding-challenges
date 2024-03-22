class Solution {
    public int totalNQueens(int n) {
        boolean[] col = new boolean[n];
        boolean[] antiD = new boolean[2 * n - 1];
        boolean[] mainD = new boolean[2 * n - 1];
        int[] row = new int[n];
        Arrays.fill(col, true);
        Arrays.fill(antiD, true);
        Arrays.fill(mainD, true);
        int[] count = new int[1];
        dfs(0, row, col, mainD, antiD, count);
        return count[0];
    }

    void dfs(int i, int[] row, boolean[] col, boolean[] mainD, boolean[] antiD, int[] count) {
        int n = row.length;
        if (i == n) {
            count[0]++;
            return;
        }
        for (int j = 0; j < n; j++) {
            if (col[j] && mainD[i + j] && antiD[n - 1 - i + j]) {
                row[i] = j;
                col[j] = false;
                mainD[i + j] = false;
                antiD[n - 1 - i + j] = false;
                dfs(i + 1, row, col, mainD, antiD, count);
                col[j] = true;
                mainD[i + j] = true;
                antiD[n - 1 - i + j] = true;
            }
        }
    }
}
