import java.util.regex.*;

class Solution {
    public boolean isNumber(String s) {
        String regex = "^\\s*[+-]?(\\d+\\.\\d*|\\.\\d+|\\d+)([eE][+-]?\\d+)?\\s*$";
        return Pattern.matches(regex, s);
    }
}
