/*
 * @Author: Sxuet
 * @Date: 2021-05-31 14:38:17
 * @LastEditTime: 2021-05-31 14:42:44
 * @LastEditors: Sxuet
 * @FilePath: /JavaSE_learning/Javasource_SGG/opp3/CodeBlockTest.java
 * @Description: 
 */
public class CodeBlockTest {
    
    
}
class Father{
    static{
        System.out.println("1111111");
    }
    {
        System.out.println("2222222");
    }
    Father(){
        System.out.println("3333333");
    }
}
class Son extends Father{
    static{
        System.out.println("44444444");
    }
    {
        System.out.println("55555555");
    }
    Son(){
        System.out.println("66666666");
    }
    Son(int a){
        System.out.println("77777777");
    }
    public static void main(String[] args) {
        System.out.println("***********");
        Son f = new Son(1);
    }
}
