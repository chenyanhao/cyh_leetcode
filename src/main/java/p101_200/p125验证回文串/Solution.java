package p101_200.p125验证回文串;

class Solution {
    public boolean isPalindrome(String s) {
        int left = 0, right = s.length() - 1;
        while (left <= right) {
            char leftChar = s.charAt(left);
            char rightChar = s.charAt(right);
            if (! Character.isLetterOrDigit(leftChar)) {
                ++left;
                continue;
            }
            if (! Character.isLetterOrDigit(rightChar)) {
                --right;
                continue;
            }
            if (leftChar == rightChar || (Character.isLetter(leftChar) && Character.isLetter(rightChar) && Math.abs(leftChar - rightChar) == 32)) {
                ++left;
                --right;
            } else {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "0P";
        boolean res = new Solution().isPalindrome(s);
        System.out.println(res);
    }
}