package com.cisol.algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Administrator on 2017/7/27 0027.
 */
public class Subsets {
    /**
     * 递归方法
     * @param nums
     * @return
     */
    /*public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<Integer> perSet = new ArrayList<Integer>();
        Arrays.sort(nums);
        addElem(result, perSet, nums, 0);
        return result;
    }

    public void addElem(List<List<Integer>> result, List<Integer> perSet, int[] nums, int pos) {
        //添加子集
        if(pos <= nums.length)
            result.add(new ArrayList<Integer>(perSet));
        for(int i = pos; i < nums.length; i++) {
            //避免出现重复元素
            if(i > pos && nums[i] == nums[i-1]) continue;
            perSet.add(nums[i]);
            addElem(result, perSet, nums, i+1);
            //移除最后一个元素
            perSet.remove(perSet.size()-1);
        }
    }*/

    /**
     * 循环方法
     * @param nums
     * @return
     */
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        result.add(new ArrayList<Integer>());
        int size = 0;
        int startIndex;
        for(int i = 0; i < nums.length; i++) {
            //避免出现重复元素
            startIndex = (i >= 1 && nums[i] == nums[i-1])? size : 0;
            size = result.size();
            //在已有结果集的基础上添加元素
            for(int j = startIndex; j < size; j++) {
                List<Integer> perSet = new ArrayList<Integer>(result.get(j));
                perSet.add(nums[i]);
                result.add(perSet);
            }
        }
        return result;
    }



    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 2};
        List<List<Integer>> result = new Subsets().subsetsWithDup(nums);
        System.out.println(result.toString());
    }
}
