package jianzhioffer.t64;

import java.util.ArrayList;

/**
 * 数组中的重复数字
 */
public class S3_1 {
    public static void main(String[] args) {
        ArrayList<Integer[]> testData = new ArrayList<Integer[]>();
        testData.add(null);
        testData.add(new Integer[]{});
        testData.add(new Integer[]{0, 1, -1});
        testData.add(new Integer[]{0, 1, 1});
        testData.add(new Integer[]{0, 1, 2});
        testData.add(new Integer[]{0, 1, 3});
        testData.add(new Integer[]{2, 3, 1, 0, 2, 5, 3});
        for (int i = 0; i < (testData == null ? 0 : testData.size()); i++) {
            Integer[] numsI = testData.get(i);
            int[] nums = null;
            if (numsI == null || numsI.length <= 0) {
                System.out.println("空");
                System.out.println("不存在重复的数字");
            } else {
                int length = numsI.length;
                nums = new int[length];
                System.out.print("[");
                for (int j = 0; j < length; j++) {
                    if(j != 0) {
                        System.out.print(", ");
                    }
                    nums[j] = numsI[j];
                    System.out.print(nums[j]);
                }
                System.out.println("]");
                int result = S3_1.duplicate(nums);
                switch (result) {
                    case -1: {
                        System.out.println("不存在重复的数字");
                        break;
                    }
                    case -2: {
                        System.out.println("存在0~n-1之外的数字");
                        break;
                    }
                    default: {
                        System.out.println("重复数字：" + result);
                    }
                }
            }
            System.out.println();
        }
    }

    private static int duplicate(int[] nums) {
        if (nums == null || nums.length <= 0)
            return -1;
        for (int i = 0; i < nums.length; i++) {
            while (nums[i] != i) {
                if (nums[i] >= nums.length || nums[i] < 0) {
                    return -2;
                }
                if (nums[i] == nums[nums[i]]) {
                    return nums[i];
                }
                swap(nums, i, nums[i]);
            }
        }
        return -1;
    }

    private static void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }
}
