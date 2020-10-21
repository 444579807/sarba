package org.sarba.java.sort.quick;

import org.sarba.java.sort.ISortMethod;

public class QuickSortMethod implements ISortMethod{
    @Override
    public int[] sort(int[] arr) {
        if(arr == null){
            return new int[0];
        }
        //确定开始的两部分
        int start = 0;
        int end = arr.length -1;
        return quickSort(arr,start,end);
    }

    private int[] quickSort(int[] arr,int start,int end){
        if(start >= end){
          return arr;
        }
        //设定基准值
        int tmp = arr[start];
        //设定移动的下标
        int i = start;
        int j = end;
        //设置分界线
        while(i < j){
            //从后往前找，找到比基准值小的数，则和基准值交换位置
            while((i<j) &&(arr[j] <= tmp)){
                 j--;
            }
            //从前往后找，找到比基准值大的数，则和
            while((i<j) &&(arr[i] >= tmp)){
                i++;
            }
            //交换数据
            if(i < j){
               int temp = arr[i];
               arr[i] = arr[j];
               arr[j] = temp;
            }
        }
        arr[start] = arr[i];
        arr[i] = tmp;
        quickSort(arr,start,i-1);
        quickSort(arr,i+1,end);
        return arr;
    }
}
