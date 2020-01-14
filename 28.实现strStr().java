class Solution {
    public int strStr(String haystack, String needle) {
        if (haystack.equals(needle)) {
            return 0;
        }
        
        int i, j, k;
        for (i = 0; i < haystack.length(); ++i) {
            for (j = 0, k = i; j < needle.length() && k < haystack.length(); ++j, ++k) {
                if (haystack.charAt(k) != needle.charAt(j)) {
                    break;
                }
            }
            if (j == needle.length()) {
                return i;
            }
            if (k == haystack.length()) {
                return -1;
            }
        }
        return -1;
    }
}