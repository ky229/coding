package leetcode.sample.array;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @Description:
 * @Author: 吴开云
 * @Date: 2020/1/7 0007
 * @Version： 1.0
 */
public class one {
    public static void main(String[] args) {
        /**
         * 给定一个排序数组，你需要在原地删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。
         * 不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。
         */
        int[] nums = {1,2};
        System.out.println(removeDuplicates(nums));

    }

    public static int removeDuplicates(int[] nums) {
        //从数组最后一个值开始向前遍历
        for(int i = nums.length - 1; i > 0; i --){
            int backNum = nums[i];
            for(int j = i - 1; j > -1; j --){
                //遍历到重复值时
                int indexNum = nums[j];
                if(backNum == indexNum){
                    //后续数组中不为空的元素前移 -- 最末尾删除不需要移动
                    int k = j + 1;
                    for(; (k < nums.length - 1) && nums[k] != Integer.MAX_VALUE ; k ++){
                        int temp = nums[k];
                        nums[k] = nums[k + 1];
                    }
                    //末尾置空
                    nums[k] = Integer.MAX_VALUE ;
                }
            }
        }
        int size = 0;
        for(int i = 0; i < nums.length && nums[i] != Integer.MAX_VALUE ; i ++){
            size ++;
        }
        for (int i:nums ) {
            System.out.println(i);
        }
        return size;
    }
}
