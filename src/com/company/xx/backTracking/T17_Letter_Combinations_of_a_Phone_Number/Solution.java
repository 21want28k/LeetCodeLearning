package com.company.xx.backTracking.T17_Letter_Combinations_of_a_Phone_Number;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    List<String> result = new ArrayList<>();
    String[] map = {"abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    StringBuilder builder = new StringBuilder();

    public List<String> letterCombinations(String digits) {
        int n = digits.length();
        if (n == 0) {
            return result;
        }
        this.backTracking(0, n, digits);
        return result;
    }

    /**
     * @param digits_index digits index
     * @param end
     * @param digits
     */
    public void backTracking(int digits_index, int end, String digits) {
        if (digits_index == end) {
            result.add(builder.toString());
            return;
        }
        int map_index = digits.charAt(digits_index) - '0' - 2;
        for (int i = 0; i < map[map_index].length(); i++) {
            builder.append(map[map_index].charAt(i));
            backTracking(digits_index + 1, end, digits);
            builder.deleteCharAt(builder.length() - 1);
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        s.letterCombinations("23");
    }
}
