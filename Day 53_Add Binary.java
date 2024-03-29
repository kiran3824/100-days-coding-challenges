class Solution {
    public String addBinary(String a, String b) {
        char carry = '0';
        StringBuilder sb = new StringBuilder();
        char[] aCh = a.toCharArray();
        char[] bCh = b.toCharArray();
        int i = aCh.length - 1;
        int j = bCh.length - 1;
        while (i >= 0 || j >= 0) {
            char tempA = i >= 0 ? aCh[i] : '0';
            char tempB = j >= 0 ? bCh[j] : '0';
            if (tempA == tempB) {
                if (carry == '0') {
                    sb.append("0");
                } else {
                    sb.append('1');
                }
                carry = tempA;
            } else if (tempA != tempB) {
                if (carry == '0') {
                    sb.append("1");
                } else {
                    sb.append("0");
                    carry = '1';
                }
            }
            i--;
            j--;
        }
        if (carry == '1')
            sb.append("1");
        sb.reverse();
        return sb.toString();
    }
}