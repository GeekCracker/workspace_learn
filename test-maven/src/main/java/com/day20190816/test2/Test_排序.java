package com.day20190816.test2;

import java.util.Arrays;

public class Test_排序 {

    public static void main(String[] args) {
        long curtime = System.currentTimeMillis();
        Integer [] arr = new Integer[1000000];
        int index = 0;
        while(true){
            Integer num = (int)Math.ceil(Math.random()*1000000);
            if(!Arrays.asList(arr).contains(num)){
                arr[index++] = num;
            }
            if(index == arr.length){
                break;
            }
        }
        System.out.println("===数组创建成功===耗时:"+(System.currentTimeMillis()-curtime));
        System.out.println("==开始排序==");
        long currentTime = System.currentTimeMillis();
        Integer [] result = sort4(arr,0,arr.length-1);
        System.out.println("排序耗时："+(System.currentTimeMillis()-currentTime));
        //sort3(arr);

        String str = "a";

    }

    /**
     *      4   3   1   7   6
     *  1   4   3   1   7   6
     *  2   3   4   1   7   6
     *  3   1   3   4   7   6
     *  4   1   3   4   7   6
     *  5   1   3   4   6   7
     */
    public static Integer [] sort1(Integer [] arr){

        int num = 0;
        for(int i = 0;i<arr.length;i++){
            for(int j = 0;j<i;j++){
                num++;
                if(arr[j] > arr[i]){
                    /*arr[i] = arr[i]^arr[j];
                    arr[j] = arr[i]^arr[j];
                    arr[i] = arr[i]^arr[j];*/
                    arr[i] = arr[i]+arr[j]-(arr[j]=arr[i]);
                }
            }
        }
        //1249975000
        //5046
        System.out.println(num);
        return arr;
    }

    /**
     * 选择排序
     * @param arr
     * @return
     */
    public static Integer [] sort2(Integer [] arr){
        int num = 0;
        for(int i = 0 ;i<arr.length-1;i++){
            for(int j = i;j<arr.length;j++){
                num ++;
                if(arr[i]>arr[j]){
                    /*arr[i]=arr[i]^arr[j];
                    arr[j]=arr[i]^arr[j];
                    arr[i]=arr[i]^arr[j];*/
                    arr[i] = arr[i]+arr[j]-(arr[j]=arr[i]);
                }
            }
        }
        //1250024999次
        //6237ms
        System.out.println(num);
        return arr;
    }
    /**
     * 冒泡排序
     *
     *  i   j       4   3   1   7   6
     *  0   0       3   1   4   6   7       第一轮比较4次
     *              1   3   4   6   7       第二轮比较3次
     *
     *
     */
    public static Integer [] sort3(Integer [] arr){
        int num = 0;
        boolean sorted = true;
        for(int i = 0;i<arr.length-1;i++){
            sorted = true;
            for(int j = 0;j<arr.length-i-1;j++){
                num++;
                if(arr[j]>arr[j+1]){
                    /*arr[j] = arr[j]^arr[j+1];
                    arr[j+1] = arr[j]^arr[j+1];
                    arr[j] = arr[j]^arr[j+1];*/
                    arr[j] = arr[j]+arr[j+1]-(arr[j+1]=arr[j]);
                    sorted = false;
                }
            }
            if(sorted){
                break;
            }
        }
        //1249935660    10746
        //1249973289    10673
        //1249975000    10227

        System.out.println("累加次数："+num);
        return arr;
    }


    /**
     * 快速排序
     *
     *
     */
    public static Integer [] sort4(Integer [] arr,int left,int right){
        if(left < right){
            int i = left,j = right,x = arr[left];
            while (i < j){
                while (i < j && arr[j] >= x)
                    j--;
                if(i < j)
                    arr[i++] = arr[j];
                while (i < j && arr[i] < x)
                    i++;
                if(i < j)
                    arr[j--] = arr[i];
            }
            arr[i] = x;
            sort4(arr,left,i-1);
            sort4(arr,i + 1,right);
        }
        //50000数字  16ms
        return arr;
    }
}
