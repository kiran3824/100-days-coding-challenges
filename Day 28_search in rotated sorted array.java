class Solution {
    public int search(int[] a, int target) {
        int l = 0, h = a.length - 1, m = 0;
        while (l <= h) {
            m = (l + h) / 2;
            if (target == a[m]) {
                return m;
            } else if (a[l] <= a[m]) {
                if (target >= a[l] && target < a[m]) {
                    h = m - 1;
                } else {
                    l = m + 1;
                }
            } else {
                if (target > a[m] && target <= a[h]) {
                    l = m + 1;
                } else {
                    h = m - 1;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Solution solution = new Solution(); 
        int arr[] = {4, 5, 6, 7, 8, 1, 2};
        System.out.println(solution.search(arr, 7));
    }
}
