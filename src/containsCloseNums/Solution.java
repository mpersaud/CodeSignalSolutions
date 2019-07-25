package containsCloseNums;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    static boolean containsCloseNums(int[] nums, int k) {


        if(nums.length==0)
            return false;
        Map<Integer,Integer> map = new HashMap<>();

        for(int i =0; i<nums.length; i++){

            if(map.containsKey(nums[i])) {
                int num = map.get(nums[i]);
                if (Math.abs(num - i) <= k) {
                    return true;
                }
                map.put(nums[i], i);
            }
        }
        return false;

    }


    public static void main(String[] args) {


        int[]nums = {1, 0, 1, 1};
        int k = 1;
        System.out.print(containsCloseNums(nums,k));
    }

}
