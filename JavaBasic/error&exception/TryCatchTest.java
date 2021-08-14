import org.junit.Test;

/*
 * @Author: Sxuet
 * @Date: 2021-06-04 21:25:20
 * @LastEditTime: 2021-06-05 11:06:11
 * @LastEditors: Sxuet
 * @FilePath: /JavaSE_learning/Javasource_SGG/error&exception/TryCatchTest.java
 * @Description: 
 */
public class TryCatchTest {
    public static void main(String[] args) {
        
    }

    @Test
    public void test1() {
        String str = "123";
        str = "abc";
        try {
            int num = Integer.parseInt(str);

        } catch (NumberFormatException e) {
            // System.out.println("字符不能转换为数字哦！");
            System.out.println(e.getMessage());
            // System.out.println(e.getStackTrace());
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.out.println("ahha");
        }
    }

    @Test
    public void test2() {
        Animal a = new Animal();
        try {
            a.regist(-1001);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(a);
    }
}

class MyException extends Exception{
    static final long serialVersionUID = -7034891536735764539L;
    MyException(){

    }
    MyException(String massage){
        super(massage);
    }
}

class Animal{
    private int id;
    Animal(){
    }
    public void regist(int id) throws Exception {
        if (id > 0) {
            this.id = id;
        } else if(id==0) {
            // System.out.println("您输入了非法数据");
            // throw new RuntimeException("您输入了非法id");
            // throw new Exception("您输入了非法数据");
            throw new MyException("不能输入0");
        }else{
            throw new MyException("不能输入负数");
        }
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + id + "'" +
            "}";
    }

}

