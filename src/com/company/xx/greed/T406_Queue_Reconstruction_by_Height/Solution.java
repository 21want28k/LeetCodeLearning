package com.company.xx.greed.T406_Queue_Reconstruction_by_Height;

import java.util.ArrayList;
import java.util.Arrays;

public class Solution {
    public static int[][] reconstructQueue(int[][] people) {
        int row = people.length;
        int column = people[0].length;
        Arrays.sort(people, (person1, person2) -> {
            if (person1[0] > person2[0]) {
                return -1;
            } else if (person1[0] < person2[0]) {
                return 1;
            } else {
                if (person1[1] > person2[1]) {
                    return 1;
                } else if (person1[1] < person2[1]) {
                    return -1;
                } else {
                    return 0;
                }
            }
        });

        ArrayList<int[]> newPeople = new ArrayList<>();
        for (int[] person : people) {
            newPeople.add(person[1], person);
        }

        int[][] result = new int[row][column];

        return newPeople.toArray(result);
    }

    public static int[][] reconstructQueue2(int[][] people) {
        int row = people.length;
        int column = people[0].length;
        Arrays.sort(people, (o1, o2) -> {
            if (o1[0] != o2[0]) {
                // [0] 身高h，从大到小
                return o2[0] - o1[0];
            } else {
                // [1] k，在身高的基础上从小到大
                return o1[1] - o2[1];
            }
        });
        System.out.println(Arrays.deepToString(people));

        ArrayList<int[]> newPeople = new ArrayList<>(row);
        for (int[] person : people) {
            newPeople.add(person[1], person);
        }

        int[][] result = new int[row][column];

        return newPeople.toArray(result);
    }

    public static void main(String[] args) {
        int[][] people = new int[][]{{7, 0}, {4, 4}, {7, 1}, {5, 0}, {6, 1}, {5, 2}};
        System.out.println(Arrays.deepToString(reconstructQueue2(people)));
    }
}
