package p001_p100.p022括号生成;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        dfs(n, n, new StringBuilder(), ans);
        return ans;
    }

    private void dfs(int leftRest, int rightRest, StringBuilder path, List<String> ans) {
        if (leftRest == 0 && rightRest == 0) {
            ans.add(path.toString());
            return;
        }

        // 剪枝（左括号可以使用的个数严格大于右括号可以使用的个数，才剪枝，注意这个细节）
        if (leftRest > rightRest) {
            return;
        }

        if (leftRest > 0) {
            path.append("(");
            dfs(leftRest-1, rightRest, path, ans);
            path.deleteCharAt(path.length() - 1);
        }

        if (rightRest > 0) {
            path.append(")");
            dfs(leftRest, rightRest-1, path, ans);
            path.deleteCharAt(path.length()-1);
        }
    }
}