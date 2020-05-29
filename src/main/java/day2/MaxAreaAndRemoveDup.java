package day2;

import java.util.Arrays;

public class MaxAreaAndRemoveDup {


    /**
     * 给你 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。在坐标内画 n 条垂直线，
     * 垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0)。找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
     1. 左右指针初始化为数组的左右边界
     2. 计算左右指针对应的面积：最小高度 * 两指针距离, 并更新最大面积
     3. 移动较小指针
     4. 重复2,3
     */
    public static int maxArea(int[] height) {
        int left = 0, right = height.length - 1;
        int maxArea = 0;

        while (left < right) {

            if(height[left]>height[right]){
                maxArea = height[right] * (right-left) > maxArea ? height[right] * (right-left) : maxArea;
                right--;
            }else {
                maxArea = height[left] * (right-left) > maxArea ? height[left] * (right-left) : maxArea;
                left++;
            }

//            maxArea = Math.max(maxArea, Math.min(height[left], height[right]) * (right - left));
//            if (height[left] < height[right]){
//                left++;
//            }else{
//                right--;
//            }
        }

        return maxArea;
    }

    /**
     * 给定一个排序数组，你需要在 原地 删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。
     * 不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。
     */
    public static  int removeDuplicates(int[] nums) {
        if(nums.length == 0){
            return 0;
        }
        int i=0;
        for(int j=1;j<nums.length;j++){
            if(nums[i] != nums[j]){
                nums[++i] = nums[j];
            }
        }
        return i+1;

    }

    /**
     *删除可重复次数的数据
     */
    public static int removeDuplicatesII(int[] nums,int k){
        int i = 0;
        for(int n:nums){
            if(i<k || n>nums[i-k]){
                nums[i++] = n;
            }
        }
        return i;
    }




    public static void main(String[] args) {
        int height[] = {1,8,6,2,5,4,8,3,7};

        System.out.println(maxArea(height));

        int nums[] = {1,2,2,2,4,5,6,6,7,8,9};
//        System.out.println(removeDuplicatesII(nums,1));
        System.out.println(removeDuplicates(nums));
        System.out.println(Arrays.toString(nums));

    }


}
