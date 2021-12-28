package com.company.xx.greed.T376;

import java.util.Arrays;

public class Solution {
    public static int wiggleMaxLength(int[] nums) {
        int n = nums.length;

        // dp[i][0] 前[0:i]，最后上升的序列的长度；
        // dp[i][1] 前[0:i]，最后下降的序列的长度
        int[][] dp = new int[n][2];

        dp[0][0] = 1;
        dp[0][1] = 1;
        for (int i = 1; i < n; i++) {
            if (nums[i] > nums[i - 1]) { // 来了一个大的数
                dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + 1);
                dp[i][1] = dp[i - 1][1];
            }
            if (nums[i] < nums[i - 1]) {
                dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] + 1);
                dp[i][0] = dp[i - 1][0];
            }
            if (nums[i] == nums[i - 1]) {
                dp[i][1] = dp[i - 1][1];
                dp[i][0] = dp[i - 1][0];
            }
        }

        return Math.max(dp[n - 1][0], dp[n - 1][1]);
    }

    public static int wiggleMaxLength2(int[] nums) {
        int n = nums.length;

        // dp[i][0] 以i结尾（i元素必选），最后上升的；dp[i][1] 以i结尾（i元素必选）最后下降的
        int[][] dp = new int[n][2];

        for (int i = 0; i < n; i++) {
            dp[i][0] = 1;
            dp[i][1] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) { //上升
                    dp[i][0] = Math.max(dp[i][0], dp[j][1] + 1);
                }
                if (nums[i] < nums[j]) { // 下降
                    dp[i][1] = Math.max(dp[i][1], dp[j][0] + 1);
                }
            }
        }

        System.out.println(Arrays.deepToString(dp));
        return Math.max(dp[n - 1][0], dp[n - 1][1]);
    }

    public static int wiggleMaxLength3(int[] nums) {
        int n = nums.length;

        // dp[i][0] 前[0:i]，最后上升的序列的长度；
        // dp[i][1] 前[0:i]，最后下降的序列的长度
        int[][] dp = new int[n][2];

        int up = 1;
        int down = 1;
        for (int i = 1; i < n; i++) {
            if (nums[i] > nums[i - 1]) {
                up = Math.max(up, down + 1);
            } else if (nums[i] < nums[i - 1]) {
                down = Math.max(down, up + 1);
            } else {
                // Todo 保持原值，不用做任何操纵。
            }
        }
        return Math.max(up, down);
    }

    /**
     * 贪心
     */
    public static int wiggleMaxLength4(int[] nums) {
        int n = nums.length;

        if (n == 1) {
            return 1;
        }

        int cur = 1;
        int pre = 0;
        int next = 2;
        int count = 0;
        while (next <= n - 1) {
            // 谷
            if (nums[pre] > nums[cur] && nums[next] > nums[cur]) {
                count++;
            }
            // 峰
            if (nums[pre] < nums[cur] && nums[next] < nums[cur]) {
                count++;
            }
            pre++;
            cur++;
            next++;
        }
        return count == 0 ? 1 : count + 2;
    }

    public static int wiggleMaxLength5(int[] nums) {
        int n = nums.length;

        if (n < 2) {
            return n;
        }

        int preDiff = nums[1] - nums[0];
        int result = preDiff != 0 ? 2 : 1;
        int i = 2;
        while (i < n) {
            int curDiff = nums[i] - nums[i - 1];
            if ((curDiff > 0 && preDiff <= 0) || (curDiff < 0 && preDiff >= 0)) {
                result++;
                preDiff = curDiff;
            }
            i++;
        }
        return result;
    }

    public static void main(String[] args) {
//        int[] nums = new int[]{1, 17, 5, 10, 13, 15, 10, 5, 16, 8};
//        int[] nums = new int[]{1, 3, 5, 5, 2, 1};
        int[] nums = new int[]{5, 5, 10, 10, 3};
        System.out.println(wiggleMaxLength5(nums));
    }
}