package p101_200.p171Excel表列序号;

class Solution {
    public int titleToNumber(String s) {
        int res = 0;
        for (int i = 0; i < s.length(); ++i) {
            char c = s.charAt(i);
            int num = (c - 'A') + 1;
            res = res * 26 + num;
        }
        return res;
    }
}