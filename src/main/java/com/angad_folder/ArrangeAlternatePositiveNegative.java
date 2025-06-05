package com.angad_folder;

import java.util.Arrays;

public class ArrangeAlternatePositiveNegative {
    public static void main(String[] args) {
        int[] arr = {1,2,5,7,-2,-4,-5,-6,0};
        for(int i = 0 ; i < arr.length ; i++){
            for (int j = i+1   ; j< arr.length ; j++){
                if(i%2==0){
                    if (arr[i]<0){
                        int temp = arr[i];
                        arr[i]= arr[j];
                        arr[j] = temp;
                    }
                }
            }
        }
        System.out.println(Arrays.toString(arr));
    }
}