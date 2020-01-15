/**
 * @Description:
 * @Author: 吴开云
 * @Date: 2019/10/14 0014
 * @Version： 1.0
 */
public class Test1 {
    public static void main(String[] args) {
        FreqStack freqStack = new FreqStack();
        freqStack.push(5);freqStack.push(7);freqStack.push(5);
        freqStack.push(7);freqStack.push(4);freqStack.push(5);
        System.out.println(freqStack.pop());
        System.out.println(freqStack.pop());
        System.out.println(freqStack.pop());
        System.out.println(freqStack.pop());
        System.out.println(freqStack.pop());
        System.out.println(freqStack.pop());
    }
}
