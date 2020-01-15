package leetcode.sample.array;

/**
 * @Description:
 * @Author: 吴开云
 * @Date: 2020/1/9 0009
 * @Version： 1.0
 */
public class one_new {
    public static void main(String[] args) {
        int[] ints = {1,1,2,2,3,4,5,6};
        int i = sort(ints);
        System.out.println(i);
        for (int j:ints) {
            System.out.println(j);
        }
    }

    public  static int sort(int[] nums){
        if(nums.length == 0){
            return  0;
        }else if(nums.length == 1){
            return 1;
        }
        int i = 0;
        for (; i < nums.length ; i ++ ) {
            //j 从 i+1 往后遍历
            for (int j = i + 1; j < nums.length; j++) {
                //遇到num[i]与num[j]相等的
                if(nums[i] == nums[j]){
                    //j 自增 并 开始下一轮循环
                    continue;
                }
                //遇到num[i] 与 num[j] 不相等的

                //将num[j] 赋值给 num[i + 1]

            }

        }
        return  i;
    }
}
