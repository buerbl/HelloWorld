package com.test.letcode;

import org.junit.Test;

/**
 * @author boolean
 * Date: 2019/5/21 14:31
 * description:
 */
public class Solution {
    //https://leetcode-cn.com/problems/two-sum/
    @Test
    public  void  twoSumTest(){
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        twoSum(nums, target);
    }
    public int[] twoSum(int[] nums, int target) {
        for(int i = 0; i < nums.length; i ++){
            for (int j = i + 1; j < nums.length; j ++){
                boolean re = (nums[i] + nums[j] == target);
                if (re){
                    return new int[]{i, j};
                }
            }
        }
        return null;
    }

    @Test
    public void test1(){
      String name = "a";
      ifTest(name);
    }

    public String ifTest(String name){
        if (name.equals("a")){
            System.out.println(name);
            return name;
        }
        System.out.println("aaaaaaaaaa");
        return null;
    }
}
