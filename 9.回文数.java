class Solution {
    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        
        if (x == 0) {
            return true;
        }
        
        int temp = x;
        int result = 0;
        while (temp != 0) {
            result = result * 10 + (temp % 10);
            temp /= 10;
        }
        
        return x == result;
    }
}