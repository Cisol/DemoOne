package com.cisol.algorithm;

import java.util.Stack;

public class QuickSort {
    //递归方法
    public static void quickSort(int[] nums, int start, int end) {
        if(start >= end) return;
        int mid = partition(nums, start, end);
        if(start < mid)
            quickSort(nums, start, mid);
        if(mid+1 < end)
            quickSort(nums, mid+1, end);
    }
    public static int partition(int[] nums, int left, int right) {
        int mid = nums[left];
        while(left < right) {
            while(left < right && nums[right] >= mid)
                right--;
            nums[left] = nums[right];
            while (left < right && nums[left] <= mid)
                left++;
            nums[right] = nums[left];
        }
        nums[left] = mid;
        return left;
    }

    //非递归方法
    public static void quickSort(int[] nums) {
        int start = 0, end = nums.length-1;
        Stack<Integer> stack = new Stack<Integer>();
        stack.push(end);
        stack.push(start);
        while (!stack.isEmpty()) {
            int left = stack.pop();
            int right = stack.pop();
            int mid = partition(nums, left, right);
            if(left < mid) {
                stack.push(mid);
                stack.push(left);
            }
            if(mid < right) {
                stack.push(right);
                stack.push(mid + 1);
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{8, 7, 9, 2, 4, 10, 5, 14, 1, 3};
        quickSort(nums, 0, nums.length-1);
//        quickSort(nums);
        prinf(nums);
    }

    public static void prinf(int[] nums) {
        for(int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " ");
        }
    }
}
