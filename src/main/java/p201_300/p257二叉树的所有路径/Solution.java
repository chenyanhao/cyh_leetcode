package p201_300.p257二叉树的所有路径;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> paths = new ArrayList<>();
        dfs(root, "", paths);
        return paths;
    }

    private void dfs(TreeNode root, String path, List<String> paths) {
        if (root == null) {
            return;
        }

        StringBuilder sb = new StringBuilder(path);

        if (root.left == null && root.right == null) {
            sb.append(root.val);
            paths.add(sb.toString());
        } else {
            sb.append(root.val).append("->");
            dfs(root.left, sb.toString(), paths);
            dfs(root.right, sb.toString(), paths);
        }
    }
}