package com.company;

import java.util.Arrays;

public class BigInt {

    public static void main(String[] args){
        int[] digits = {1,2,3};
        String value = Arrays.toString(digits).replaceAll(",","");
        System.out.println(value);

        int newValue = Integer.parseInt(value) + 1;
        char[] nums = String.valueOf(newValue).toCharArray();
        int[] result = new int[nums.length];
        for(int i = 0;i< nums.length;i++){
            result[i] = nums[i];
            System.out.println(result[i]);
        }
    }
}
