package p001_p100.p093复原IP地址;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<List<String>> res = new ArrayList<>();
        dfs(s, 0, 0, new ArrayDeque<>(), res);
        return res.stream()
                .map(l -> l.stream().collect(Collectors.joining(".")))
                .collect(Collectors.toList());
    }

    private void dfs(String s, int count, int start, ArrayDeque<String> path, List<List<String>> res) {
        if (count == 4) {
            if (start == s.length()) {
                res.add(new ArrayList<String>(path));
            } else {
                return;
            }
        }

        for (int i = 1; i <= 3; ++i) {
            if (start + i > s.length()) {
                continue;
            }

            String select = s.substring(start, start + i);
            int selection = Integer.parseInt(select);

            // 例如：010、00 等，这些值需要剪枝
            if (select.length() != (selection + "").length()) {
                continue;
            }

            // 数值范围不正确，剪枝
            if (selection > 255 || selection < 0) {
                continue;
            }

            path.addLast(select);
            dfs(s, count + 1, start + i, path, res);
            path.removeLast();
        }
    }
}