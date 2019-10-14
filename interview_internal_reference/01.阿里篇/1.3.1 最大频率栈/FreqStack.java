import java.util.*;

/**
 * 实现 FreqStack，模拟类似栈的数据结构的操作的一个类。
 * FreqStack 有两个函数： push(int x)，将整数 x 推入栈中。
 * pop()，它移除并返回栈中出现最频繁的元素。如果最频繁的元素不只一个，则移除并返回最接近栈顶的元素。
 * ◼ 示例： push [5,7,5,7,4,5] pop() -> 返回 5，因为 5 是出现频率最高的。 
 * 栈变成 [5,7,5,7,4]。 pop() -> 返回 7，因为 5 和 7 都是频率最高的，但 7 最接近栈 顶。栈变成 [5,7,5,4]。
 * pop() -> 返回 5 。 栈变成 [5,7,4]。 pop() -> 返回 4 。 栈变成 [5,7]。
 */

class FreqStack{

    //存储已有键出现的次数 -- <键-次数> & <次数-键值数组>
    private Map<Integer,Integer> numShowTimes ;
    private Map<Integer, List<Integer>> timesWithNum ;

    //维护所有次数的List
    private List<Integer> showTimesList ;

    //维护所有数据的List
    private List<Integer> dataList ;

    public FreqStack() {
        numShowTimes = new HashMap<>();
        timesWithNum = new HashMap<>();
        showTimesList = new ArrayList<>();
        dataList = new ArrayList<>();
    }

    //入栈
    public void push(Integer inNum){
        //----存入数据的次数统计----
        // 根据键查找map  numShowTimes
        boolean inFlag = numShowTimes.containsKey(inNum);
        //查找为空 -- 新put入，次数为1
        if(!inFlag){
            numShowTimes.put(inNum,1);
        }
        //查找非空 -- 取值，并加1
        int times = 1;
        if(inFlag){
            times = numShowTimes.get(inNum);
            times ++;
            numShowTimes.put(inNum,times);
        }
        //----根据改变后的次数  修改次数-键值 map----
        //取次数的值 timesWithNum -- 根据次数查找该次数出现的数组
        boolean timesFlag = timesWithNum.containsKey(times);
        List<Integer> numList= timesWithNum.get(inNum);
        if (numList == null ){
            numList = new ArrayList<>();
        }
        //查找为空 -- 新put
        if(!timesFlag){
            numList.add(inNum);
            timesWithNum.put(times,numList);
        }
        //查找非空 -- 数组尾追加
        if(timesFlag){
            //如果数组未查到 -- 直接添加在最尾
            if(!numList.contains(inNum)){
                numList.add(inNum);
                timesWithNum.put(times,numList);
            }
        }
        //----修改维护次数的List的值----
        //判断是否包含该次数
        boolean showTimesListFlag = showTimesList.contains(times);
        //键入 & 重排List
        showTimesList.add(times);
        Collections.sort(showTimesList,Integer::compareTo);
        //存储数据
        dataList.add(inNum);
    }

    //出栈
    public Integer pop(){
        //判断队列长度 - 取出次数最大值
        if(dataList.size() < 1){
            return null;
        }
        //根据最大值取出数组最后一个值 -- 取记录数最大是多少
        showTimesList.clear();
        showTimesList.addAll(numShowTimes.values());
        Collections.sort(showTimesList);
        Integer outNumSize = showTimesList.get(showTimesList.size() - 1);
        //根据最大记录数 读取  该记录数的 list -- timesWithNum
        List<Integer> list = timesWithNum.get(outNumSize);
        //取记录数 list 的每一个值 判断最后一次在全部数据队列中出现的位置 并存储
        List<Integer> sortList = new ArrayList<>();
        for (Integer perNum:list) {
            sortList.add(dataList.lastIndexOf(perNum));
        }
        Collections.sort(sortList);
        //取出现位置最靠近尾端的值
        int outIndex = sortList.get(sortList.size() - 1);
        Integer outNum = dataList.get(outIndex);
        //移除   timesWithNum队列的目标值 & dataList队列目标值
        list.remove(outNum);
        timesWithNum.put(outNumSize,list);
        dataList.remove(outIndex);
        //低一次的队列目标值 新增 outNum
        if(outNumSize > 0){
            list = timesWithNum.get(Integer.valueOf(outNumSize - 1)) == null
                    ? new ArrayList<>() : timesWithNum.get(Integer.valueOf(outNumSize - 1));
            list.add(outNum);
            timesWithNum.put(outNumSize - 1, list);
        }
        //修改该值的记录数 -- numShowTimes
        numShowTimes.put(outNum, (numShowTimes.get(outNum) - 1));
        return outNum;
    }

}