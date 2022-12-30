package com.company.xx.other.T202快乐数;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    public static int getNum(int n) {
        int num = 0;
        while (n != 0) {
            int number = n % 10;
            num += number * number;
            n /= 10;
        }
        return num;
    }

    public boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();
        set.add(n);
        while (true) {
            int nextNum = getNum(n);
            if (nextNum == 1) {
                return true;
            }
            if (set.contains(nextNum)) {
                return false;
            }
            set.add(nextNum);
            n = nextNum;
        }
    }

    /**
     * 快慢指针的方法去做
     *
     * @param n
     * @return
     */
    public boolean isHappy2(int n) {
        int slow = getNum(n);
        int fast = getNum(getNum(n));
        while (slow != fast) {
            if (slow == 1 || fast == 1) {
                return true;
            }
            slow = getNum(slow);
            fast = getNum(getNum(fast));
        }
        return false;
    }

    public static void main(String[] args) {
//        new Solution().isHappy(19);
        getNum(100);
    }
}
