class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> ans = new ArrayList<>();
        helper(s, 0, 0, "", ans);
        return ans;
    }

    public void helper(String s, int i, int par, String ans, List<String> res) {
        if (i == s.length() || par == 4) {
            if (i == s.length() && par == 4) {
                res.add(ans);
            }
            return;
        }
        helper(s, i + 1, par + 1, ans + s.charAt(i) + (par == 3 ? "" : "."), res);

        if (i + 1 < s.length() && isvalid(s.substring(i, i + 2)))
            helper(s, i + 2, par + 1, ans + s.substring(i, i + 2) + (par == 3 ? "" : "."), res);

        if (i + 2 < s.length() && isvalid(s.substring(i, i + 3)))
            helper(s, i + 3, par + 1, ans + s.substring(i, i + 3) + (par == 3 ? "" : "."), res);
    }

    public boolean isvalid(String str) {
        if (str.charAt(0) == '0') {
            return str.equals("0");
        }
        int val = Integer.parseInt(str);
        return val <= 255;
    }
}