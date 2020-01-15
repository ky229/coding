package java8;

import java.util.Objects;
import java.util.Optional;

/**
 * @Description:
 * @Author: 吴开云
 * @Date: 2019/12/31 0031
 * @Version： 1.0
 */
public class OptionalsCode {
    public static void main(String[] args) {
        Integer i = null;
        User user = new User().setName("张三");
        User user1 = new User();
        int j = Optional.ofNullable(i).orElse(1);
        String userName = Optional.ofNullable(user)
                .map(a -> a.getName())
                .orElse("user null name");
        String user1Name = Optional.ofNullable(user1)
                .map(a -> a.getName())
                .orElse("user 1 null name");
        System.out.println(j);
        System.out.println(userName);
        System.out.println(user1Name);
    }
}

class User{
    int age;
    String name;

    public int getAge() {
        return age;
    }

    public User setAge(int age) {
        this.age = age;
        return this;
    }

    public String getName() {
        return name;
    }

    public User setName(String name) {
        this.name = name;
        return this;
    }
}