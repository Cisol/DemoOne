package com.cisol.algorithm;

public class MergeSort {
    //递归方法
    public static void mergeSort(int[] nums, int start, int end) {
        if(start >= end) return;
        int mid = start + (end - start) / 2;
        mergeSort(nums, start, mid);
        mergeSort(nums, mid+1, end);
        merge(nums, start, end);
    }

    public static void merge(int[] nums, int start ,int end) {
        if(start >= end) return;
        int mid = start + (end - start) / 2;
        int count = 0;
        int left = start, right = mid + 1;
        int[] result = new int[end - start + 1];
        while (left <= mid && right <= end) {
            if (nums[left] < nums[right]) {
                result[count++] = nums[left++];
            } else {
                result[count++] = nums[right++];
            }
        }
        while (left <= mid)
            result[count++] = nums[left++];
        while (right <= end)
            result[count++] = nums[right++];
        count = 0;
        while (start <= end) {
            nums[start++] = result[count++];
        }
    }

    //非递归方法
    public static void mergeSort_no_recursive(int[] nums) {
        int start = 0, end = nums.length;
        if(start >= end) return;
        int increment = 1;
        while (increment < nums.length) {
            for (int i = start; i < end; i = i + increment * 2) {
                merge_no_recursive(nums, i, increment);
            }
            increment = increment * 2;
        }
    }

    public static void merge_no_recursive(int[] nums, int left, int increment) {
        int i = left, i_range = Math.min(nums.length, i + increment);
        int j = i_range, j_range = Math.min(nums.length, j + increment);
        int[] result = new int[increment * 2];
        int count = 0;
        while (i < i_range && j < j_range) {
            if(nums[i] < nums[j]) {
                result[count++] = nums[i++];
            } else {
                result[count++] = nums[j++];
            }
        }
        while (i < i_range)
            result[count++] = nums[i++];
        while (j < j_range)
            result[count++] = nums[j++];
        count = 0;
        while (left < j_range) {
            nums[left++] = result[count++];
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{8, 7, 9, 2, 4, 10, 5, 14, 1, 3};
//        mergeSort(nums, 0, nums.length-1);
        mergeSort_no_recursive(nums);
        prinf(nums);
    }

    public static void prinf(int[] nums) {
        for(int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " ");
        }
    }
}
