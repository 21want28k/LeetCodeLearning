package com.company.xx.backTracking.T491;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> path = new ArrayList<>();

    public List<List<Integer>> findSubsequences(int[] nums) {
        dfs(nums, Integer.MIN_VALUE, 0);
        return res;
    }

    private void dfs(int[] nums, int pre, int begin) {
        if (begin == nums.length) {
            if (path.size() > 1) {
                res.add(new ArrayList<>(path));
            }
            return;
        }
        
        //  选
        if (nums[begin] >= pre) {
            path.add(nums[begin]);
            dfs(nums, nums[begin], begin + 1);
            path.remove(path.size() - 1);
        }

        if (nums[begin] != pre) {
            dfs(nums, pre, begin + 1);
        }
    }
//
//        public void dfs(int[] num, int begin) {
//        if (path.size() >= 2) {
//            res.add(new ArrayList<>(path));
//        }
//        if (begin == num.length) {
//            return;
//        }
//        for (int i = begin; i < num.length; i++) {
//            if (i > begin && num[i] == num[i - 1]) {
//                continue;
//            }
//            if (!path.isEmpty()) {
//                Integer pre = path.get(path.size() - 1);
//                if (num[i] >= pre) {
//                    path.add(num[i]);
//                    dfs(num, i + 1);
//                    path.remove(path.size() - 1);
//                } else {
//                    continue;
//                }
//            } else {
//                path.add(num[i]);
//                dfs(num, i + 1);
//                path.remove(path.size() - 1);
//            }
//        }
//    }
//    public void dfs(int[] num, int begin) {
//
//        if (path.size() > 1) {
//            res.add(new ArrayList<>(path));
//        }
//        if (begin == num.length) {
//            return;
//        }
//        int[] visited = new int[201];
//        for (int i = begin; i < num.length; i++) {
//            if (visited[num[i] + 100] == 1) {
//                continue;
//            }
////            if (path.isEmpty()) {
////                path.add(num[i]);
////                visited[num[i]] = 1;
////                dfs(num, begin + 1);
////            }
//            if (!path.isEmpty() && path.get(path.size() - 1) > num[i]) {
//                continue;
//            }
//            // 这里就包含了path是空，以及非空的时候num[i] >= path.get(path.size() - 1)| 前一个数字|的情况
//            path.add(num[i]);
//            visited[num[i] + 100] = 1;
//            dfs(num, i + 1);
//            path.remove(path.size() - 1);
//        }
//    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 1, 1};
        System.out.println(new Solution().findSubsequences(nums));
    }

}
