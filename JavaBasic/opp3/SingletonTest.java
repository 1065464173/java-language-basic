/*
 * @Author: Sxuet
 * @Date: 2021-05-30 17:14:14
 * @LastEditTime: 2021-05-30 17:28:23
 * @LastEditors: Sxuet
 * @FilePath: /JavaSE_learning/Javasource_SGG/opp3/SingletonTest.java
 * @Description: 
 */
public class SingletonTest {
    public static void main(String[] args) {
        //恶汉式
        Bank b1 = Bank.getInstance();
        Bank b2 = Bank.getInstance();
        System.out.println(b1 == b2);
        //懒汉式
        Orders o1 = Orders.getInstance();
        Orders o2 = Orders.getInstance();
        System.out.println(o1 == o2);
    }
}

/**
 * @description: 恶汉式 上来就有
 * @Author: Sxuet
 * @Date: 2021-05-30 17:21:41
 * @param {*}
 * @return {*}
 */
class Bank {
    // 1、私有化构造器
    private Bank() {
    }

    // 2、内部创建类对象
    private static Bank instance = new Bank();

    // 3、静态方法提供内部对象
    public static Bank getInstance() {
        return instance;
    }
}

/**
 * @description: 懒汉式：啥时候用啥时候造
 * @Author: Sxuet
 * @Date: 2021-05-30 17:24:55
 * @param {*}
 * @return {*}
 */
class Orders {
    private Orders() {
    }

    private static Orders instance = null;

    public static Orders getInstance() {
        if (instance == null) {
            instance = new Orders();
        }
        return instance;
    }
}
