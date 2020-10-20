package org.sarba.java.sort.bubble;

import org.sarba.java.sort.ISortMethod;

public class BubbleSortMethod implements ISortMethod {


    @Override
    public int[] sort(int[] arr) {
        if(arr == null){
           return new int[0];
        }
        int temp = 0;
        for (int i = 0; i < arr.length - 1 ; i++) {
            for (int j = 0; j < arr.length -i -1 ; j++) {
              if(arr[j] < arr[j + 1]){
                  temp = arr[j + 1];
                  arr[j+1] = arr[j];
                  arr[j] = temp;
              }
            }
        }
        return arr;
    }
}
