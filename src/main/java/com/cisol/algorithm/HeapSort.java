package com.cisol.algorithm;

public class HeapSort {

    public static void heapSort(int[] nums) {
        for(int i = 0; i < nums.length - 1; i++) {
            createMaxHeap(nums, nums.length-i);
            int temp = nums[0];
            nums[0] = nums[nums.length-i-1];
            nums[nums.length-i-1] = temp;
        }
    }

    //构建最大堆
    private static void createMaxHeap(int[] nums, int size) {
        int current;
        for(int i = size/2-1; i >= 0; i--) {
            current = i;
            //求得父节点和两个子节点中的最大值
            while (current*2+1 < size) {
                int biggerIndex = current;
                if(nums[current*2+1] > nums[biggerIndex])
                    biggerIndex = current*2+1;
                if(current*2+2 < size && nums[current*2+2] > nums[biggerIndex])
                    biggerIndex = current*2+2;
                //如果子节点比父节点大，交换然后继续判断交换后的子节点
                if(biggerIndex != current) {
                    int temp = nums[current];
                    nums[current] = nums[biggerIndex];
                    nums[biggerIndex] = temp;
                    current = biggerIndex;
                } else {
                    break;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{8, 7, 9, 2, 4, 10, 5, 14, 1, 3, 6};
        heapSort(nums);
        prinf(nums);
    }

    public static void prinf(int[] nums) {
        for(int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " ");
        }
    }
}
