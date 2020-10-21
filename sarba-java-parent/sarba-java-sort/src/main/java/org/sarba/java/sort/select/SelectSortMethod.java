package org.sarba.java.sort.select;

import org.sarba.java.sort.ISortMethod;

public class SelectSortMethod implements ISortMethod {
    @Override
    public int[] sort(int[] arr) {
        if(arr == null){
            return new int[0];
        }
        for (int i = 0; i < arr.length; i++) {
            //保存当前下标
            int index = i;
            //循环数组的i个元素之后的元素
            for (int j = i + 1; j < arr.length; j++) {
                if(arr[index] < arr[j]){
                    index = j;
                }
            }
            if(i != index){
                int tmp = arr[i];
                arr[i] = arr[index];
                arr[index] = tmp;
            }
        }

        return arr;
    }
}
