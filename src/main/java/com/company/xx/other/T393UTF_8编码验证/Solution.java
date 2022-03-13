package com.company.xx.other.T393UTF_8编码验证;

public class Solution {

    public boolean validUtf8(int[] data) {
        int n = data.length;
        int index = 0;
        while (index < n) {
            int length = getByteLength(data[index]);
            if (length == 1) {
                if ((data[index] & 128) == 0) {
                    index++;
                    continue;
                } else {
                    return false;
                }
            }
            if (index + length > n || length >4) {
                return false;
            }
            for (int j = index + 1; j < index + length; j++) {
                if (!judge(data[j])) {
                    return false;
                }
            }
            index += length;
        }
        return true;
    }

    public int getByteLength(int number) {
        int m = 128;
        if ((number & m) == 0) {
            return 1;
        }
        int count = 0;
        while ((number & m) != 0) {
            count++;
            m >>= 1;
        }
        return count;
    }

    public boolean judge(int number) {
        return (number & 128) == 128;
    }

    static final int MASK1 = 1 << 7;
    static final int MASK2 = (1 << 7) + (1 << 6);

    public boolean validUtf82(int[] data) {
        int m = data.length;
        int index = 0;
        while (index < m) {
            int num = data[index];
            int n = getBytes(num);
            if (n < 0 || index + n > m) {
                return false;
            }
            for (int i = 1; i < n; i++) {
                if (!isValid(data[index + i])) {
                    return false;
                }
            }
            index += n;
        }
        return true;
    }

    public int getBytes(int num) {
        if ((num & MASK1) == 0) {
            return 1;
        }
        int n = 0;
        int mask = MASK1;
        while ((num & mask) != 0) {
            n++;
            if (n > 4) {
                return -1;
            }
            mask >>= 1;
        }
        return n >= 2 ? n : -1;
    }

    public boolean isValid(int num) {
        return (num & MASK2) == MASK1;
    }

    public static void main(String[] args) {
        int[] data = {250,145,145,145,145};
        System.out.println(new Solution().validUtf8(data));
    }
}