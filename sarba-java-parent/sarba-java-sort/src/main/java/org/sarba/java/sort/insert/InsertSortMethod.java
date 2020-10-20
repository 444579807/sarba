package org.sarba.java.sort.insert;

import org.sarba.java.sort.ISortMethod;

public class InsertSortMethod implements ISortMethod {
    @Override
    public int[] sort(int[] arr) {
        if(arr == null){
            return new int[0];
        }
        int num = 0;
        int preIndex = 0;
        for (int i = 0; i < arr.length ; i++) {
             preIndex = i - 1 ;
             num = arr[i];
             while(preIndex >= 0 && arr[preIndex] < num){
                 //如果待排序元素前一个元素比待排序元素大，则后移前一个元素
                 arr[preIndex + 1] = arr[preIndex];
                 //继续判断之前的元素
                 preIndex--;
             }
            //找到待排序元素的正确位置的前一个元素的下标，把待排序字段赋值给正确位置
            // 如果这里是arr[preIndex]，则会把小于num的修改
            arr[preIndex+1] = num;
        }
        return arr;
    }
}
