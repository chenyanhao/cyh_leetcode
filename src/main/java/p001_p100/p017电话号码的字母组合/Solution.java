package p001_p100.p017电话号码的字母组合;

import java.util.*;

class Solution {
    public List<String> letterCombinations(String digits) {
        Map<Character, List<String>> letterMap = new HashMap<>();
        letterMap.put('2', Arrays.asList("a", "b", "c"));
        letterMap.put('3', Arrays.asList("d", "e", "f"));
        letterMap.put('4', Arrays.asList("g", "h", "i"));
        letterMap.put('5', Arrays.asList("j", "k", "l"));
        letterMap.put('6', Arrays.asList("m", "n", "o"));
        letterMap.put('7', Arrays.asList("p", "q", "r", "s"));
        letterMap.put('8', Arrays.asList("t", "u", "v"));
        letterMap.put('9', Arrays.asList("w", "x", "y", "z"));

        List<String> ans = new ArrayList<>();
        if (digits.length() == 0) {
            return ans;
        }

        dfs(digits, letterMap, 0, new StringBuilder(), ans);
        return ans;
    }

    private void dfs(String digits, Map<Character, List<String>> letterMap, int index, StringBuilder path, List<String> ans) {
        if (index == digits.length()) {
            ans.add(path.toString());
            return;
        }

        List<String> letters = letterMap.get(digits.charAt(index));
        for (String letter : letters) {
            path.append(letter);
            dfs(digits, letterMap, index+1, path, ans);
            path.deleteCharAt(path.length()-1);
        }
    }

}