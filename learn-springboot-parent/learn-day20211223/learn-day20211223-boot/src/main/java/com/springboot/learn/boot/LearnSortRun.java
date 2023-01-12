package com.springboot.learn.boot;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * @description: 排序算法
 * @author: 朱俊亮
 * @time: 2021-12-23 16:00
 */
public class LearnSortRun {

    public static void main(String[] args) {
        int [] nums = {1,3,2,5,4,7,6,13,22,12,15};
        //System.out.println(Arrays.toString(selectSort(nums)));//选择排序
        //System.out.println(Arrays.toString(bubbleSort(nums)));//冒泡排序
        quickSort(nums,0,nums.length-1);//快速排序
        System.out.println(Arrays.toString(nums));
    }

    /**
     * 选择排序（升序排序）
     * 当前下标值与后面所有的下标数值进行比较，如果大于，则交换位置
     */
    public static int [] selectSort(int [] nums){
        int len = nums.length;
        for(int i = 0;i<len;i++){
            for(int j = i+1;j<len;j++){
                if(nums[i] > nums[j]){
                    nums[i] = (nums[i] + nums[j]) - (nums[j] = nums[i]);
                }
            }
        }
        return nums;
    }

    /**
     * 冒泡排序（升序排序）
     * 当前下标与相邻下标相比较
     */
    public static int [] bubbleSort(int [] nums){
       int len = nums.length;
       boolean flag = true;
       for(int i = 0;i<len && flag;i++){
           flag = false;
           for(int j = 0;j< len - i - 1;j++){
               if(nums[j] > nums[j+1]){
                   nums[j] = (nums[j] + nums[j+1]) - (nums[j+1] = nums[j]);
                   flag = true;
               }
           }
       }
       return nums;
    }

    /**
     * 快速排序
     * @param nums 需要排序的数组
     * @param low 起始位置
     * @param high 结束位置
     */
    public static void quickSort(int [] nums,int low,int high){
        int i,j,temp;
        if(low > high){
            return;
        }
        i = low;
        j = high;
        //以当前下标最小的位置的值为基准
        temp = nums[low];
        while(i < j){
            //从右边开始，找比temp小的值的下标，当找到比temp小时跳出循环
            while (temp <= nums[j] && i < j){
                j--;
            }
            //从左边开始，找比temp大的值的下标，当找到比temp大时跳出循环
            while(temp >= nums[i] && i < j){
                i++;
            }
            if(i < j){
                nums[i] = (nums[i] + nums[j]) - (nums[j] = nums[i]);
            }
        }
        System.out.println(i +">>" +j);
        //将基准位置和i与j相等位置的值交换
        nums[low] = nums[i];
        nums[i] = temp;
        quickSort(nums,low,j-1);
        quickSort(nums,j+1,high);
    }
}
