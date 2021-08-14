import java.util.Objects;
/*
 * @Author: Sxuet
 * @Date: 2021-05-25 19:25:30
 * @LastEditTime: 2021-05-26 19:16:35
 * @LastEditors: Sxuet
 * @FilePath: /JavaSE_learning/Javasource_SGG/opp2/ObjectTest.java
 * @Description: 
 */
public class ObjectTest {
    public static void main(String[] args) {
        Order order1 = new Order(1, "12");
        Order order2 = new Order(1, "12");
        // object中的equals和==一样，对于引用数据类型来说比较地址
        boolean isEquals = order1.equals(order2);// false 无重写equals
        isEquals = (order1 == order2) ? true : false;// false
        System.out.println(isEquals);
        // 重写equals后

        isEquals = order1.equals(order2);
        System.out.println(isEquals);
        /*
         * public String toString() { return getClass().getName() + "@" +
         * Integer.toHexString(hashCode()); }
         */
        System.out.println(order1.toString());
        System.out.println(order1.getClass().getSuperclass());
    }

}

class Order {
    private int oId;
    private String Name;

    public Order(int oId, String Name) {
        this.oId = oId;
        this.Name = Name;
    }

    public int getOId() {
        return this.oId;
    }

    public void setOId(int oId) {
        this.oId = oId;
    }

    public String getName() {
        return this.Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Order)) {
            return false;
        }
        Order order = (Order) o;
        return oId == order.oId && Objects.equals(Name, order.Name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(oId, Name);
    }

}