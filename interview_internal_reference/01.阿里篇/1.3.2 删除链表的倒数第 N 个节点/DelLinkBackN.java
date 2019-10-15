import java.util.LinkedList;

/**
 * @Description:
 * @Author: 吴开云
 * @Date: 2019/10/14 0014
 * @Version： 1.0
 */
public class DelLinkBackN {
    private LinkedList<String> linkedList = new LinkedList();

    public DelLinkBackN(String ... args) {
        for (String perStr: args) {
            linkedList.add(perStr);
        }
    }

    public DelLinkBackN() {
        for (Integer i = 1; i < 6; i++) {
            linkedList.add(i.toString());
        }
    }

    public String removeBackN(Integer n){
        //查找当前节点是否足够长
        if(linkedList.size() < n){
            return null;
        }
        //循环遍历        //查询n个之后是否到达链表尾
        //是 -- 1、移除当前节点   2、续接节点  3、返回当前节点值
        //否 -- 继续遍历
        String result = linkedList.get(linkedList.size() - n);
        linkedList.remove(linkedList.size() - n);
        return result;
    }
}
