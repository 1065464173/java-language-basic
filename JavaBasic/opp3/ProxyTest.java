/*
 * @Author: Sxuet
 * @Date: 2021-06-02 15:23:52
 * @LastEditTime: 2021-06-02 15:30:27
 * @LastEditors: Sxuet
 * @FilePath: /JavaSE_learning/Javasource_SGG/opp3/ProxyTest.java
 * @Description: 
 */

public class ProxyTest {
    public static void main(String[] args) {
        Serve serve = new Serve();
        ProxyServe ps = new ProxyServe(serve);
        ps.browser();
    }
}
interface Network{
    public void browser();
}
//被代理类
class Serve implements Network{

    @Override
    public void browser() {
        System.out.println("开始联网");        
    }

}
// 代理类
class ProxyServe implements Network{

    private Serve serve;
    ProxyServe(Serve serve){
        this.serve = serve;
    }
    private void check(){
        System.out.println("联网前检查工作");
    }
    @Override
    public void browser() {
        check();
        serve.browser();        
    }

}