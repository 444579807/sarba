package org.sarba.java.sort;

import org.sarba.java.sort.bubble.BubbleSortMethod;
import org.sarba.java.sort.insert.InsertSortMethod;
import org.sarba.java.sort.quick.QuickSortMethod;
import org.sarba.java.sort.select.SelectSortMethod;

public class SortMain {

    public static void main(String[] args) {
        int[] arr = {3,2,5,6,2,6,8,1,9,3,4,7};
        ISortMethod sortMethod = new QuickSortMethod();
        result(sortMethod.sort(arr));
    }

    private static void result(int[] arr){
        for (int i : arr) {
            System.out.print(i);
            System.out.print(",");
        }
    }

}
