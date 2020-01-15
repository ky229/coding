
/**
 * @Description:
 * @Author: 吴开云
 * @Date: 2019/10/10 0010
 * @Version： 1.0
 */
public class Test2 {
    public static void main(String[] args) {
        DelLinkBackN delLinkBackN = new DelLinkBackN("1","2","3","4","5");
        System.out.println(delLinkBackN.removeBackN(2).toString());
        System.out.println(delLinkBackN.removeBackN(3).toString());
        System.out.println(delLinkBackN.removeBackN(1).toString());
        System.out.println(delLinkBackN.removeBackN(2).toString());
    }
}
