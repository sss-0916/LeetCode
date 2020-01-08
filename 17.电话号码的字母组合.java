class Solution {
    private String[] maps = {
        "", "", "abc", "def", "ghi", "jkl",
        "mno", "pqrs", "tuv", "wxyz"
    };

    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();

        backTrace(result, digits, new StringBuilder(), 0);

        return result;    
    }

    private void backTrace(
        List<String> result, String digits, StringBuilder curStr, int curDepth
    ) {
        if (curDepth == digits.length()) {
            if (curStr.length() != 0) {
                result.add(new String(curStr));
            }
            return;
        }

        int index = digits.charAt(curDepth) - '0';
        char[] curMap = this.maps[index].toCharArray();
        for (char ch : curMap) {
            backTrace(result, digits, curStr.append(ch), curDepth + 1);
            curStr.deleteCharAt(curStr.length() - 1);
        }
    }
}