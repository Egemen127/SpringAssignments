package com.company;
//Return the Product of Array Except Self.
//        Given an array nums of n integers where n > 1,  return an array output such that
//        output[i] is equal to the product of all the elements of nums except nums[i].
//        Constraint: cannot use division.
//public static void main(String[] args) {
//        int[] test = {2, 5, 6, 4};
//        }
//public static int[] product(int[] nums) {
//        return null;
//        }
//        Input => {2, 5, 6,  4}
//        Output => [120, 48, 40, 60]


public class Main {

    public static void main(String[] args) {
	// write your code here

        int[] num = product(new int[3]);
        for(int i:num)
            System.out.println(i);
    }
    public static int[] product(int[] nums){
        int[] result = new int[nums.length];
        for(int i=0;i< nums.length;i++){
            int product = 1;
            for(int j=0;j<nums.length;j++){
                if(i!=j)
                    product=product*nums[j];
            }
            result[i]=product;
        }
        return result;
    }
}
