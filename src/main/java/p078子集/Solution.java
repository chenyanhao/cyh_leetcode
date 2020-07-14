package p078子集;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

class Solution {
    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(nums, 0, new LinkedList<>(), res);
        return res;
    }

    private static void dfs(int[] nums, int start, LinkedList<Integer> path, List<List<Integer>> res) {
        res.add(new ArrayList<>(path));

        for (int i = start; i < nums.length; ++i) {
            path.addLast(nums[i]);
            dfs(nums, i + 1, path, res);
            path.removeLast();
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        List<List<Integer>> result = subsets(nums);
        System.out.println(result.size());
        for (List<Integer> r : result) {
            printList(r);
        }
    }

    private static void printList(List<Integer> list) {
        StringBuilder sb = new StringBuilder();
        for (Integer i : list) {
            sb.append(i);
        }
        System.out.println(sb.toString());
    }
}