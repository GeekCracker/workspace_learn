package com.springboot.learn.boot;

import java.util.Arrays;

/**
 * @description: 算法
 * @author: 朱俊亮
 * @time: 2021-12-23 14:43
 */
public class LearnRun {

    public static void main(String[] args) {

        int [] nums = {1,1,1,2,2,3,3,3,3,3,4,4,4,5,5,5,5,5,5,5};
        System.out.println(removeDuplicates(nums));
        System.out.println("###");
        System.out.println(find(nums,1));
    }

    /**
     * 删除重复元素
     * 给你一个有序数组nums ，请你删除重复出现的元素，使每个元素只出现一次，返回删除后数组的新长度。
     * @param nums    数组
     * @return 删除之后的长度
     */
    public static int removeDuplicates(int [] nums){
        int len = nums.length;
        //left 下标的元素与right下标的元素进行对比，直到不相等时，将left下标值加1，并将right下标值放到加1后的left下标上
        int left = 0, right = 1;
        while (right < len) {
            if(nums[left] != nums[right]) {
                left++;
                nums[left] = nums[right];
            }
            right++;
            if(nums[left] == nums[len - 1]){
                break;
            }
        }
        int new_len = left + 1;
        int [] new_nums = new int[new_len];
        for(int i = 0;i<new_len;i++){
            new_nums[i] = nums[i];
        }
        System.out.println(Arrays.toString(nums));
        System.out.println(Arrays.toString(new_nums));
        return left + 1;
    }

    /**
     *二分查找
     *二分查找法,在有序数组arr中,查找target
     *
     * @param arr    数组
     * @param target 指定的target
     * @return 如果找到target, 返回相应的索引index，如果没有找到target,返回-1
     */

    public static int find(int[] arr, int target) {
        int l = 0, r = arr.length - 1;
        System.out.println(r);
        while (l <= r) {
            int mid = (r - l) / 2 + l;
            System.out.println("abc:"+mid);
            if (arr[mid] == target)
                return mid;
            else if (arr[mid] > target)
                r = mid - 1;
            else
                l = mid + 1;
        }
        return -1;
    }
}
