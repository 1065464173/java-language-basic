import java.util.Scanner;

/*
 * @Author: Sxuet
 * @Date: 2021-06-05 11:09:44
 * @LastEditTime: 2021-06-05 16:56:52
 * @LastEditors: Sxuet
 * @FilePath: /JavaSE_learning/Javasource_SGG/error&exception/EcmDef.java
 * @Description: 
 */
public class EcmDef extends Exception{
    static final long serialVersionUID = -3123463124229948L;

    EcmDef(){
    }
    EcmDef(String msg){
        super(msg);
    }
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int num1 = 0;
        int num2 = 0;
        double result = 0;
        try {
            num1 = scan.nextInt();
            num2 = scan.nextInt();
            result = ecm(num1, num2);
        } catch (NumberFormatException e) {
            e.printStackTrace();
        } catch(ArrayIndexOutOfBoundsException e){
            e.printStackTrace();
        }catch(ArithmeticException e){
            e.printStackTrace();
        }catch(EcmDef e ){
            e.printStackTrace();
        }finally{
            scan.close();
        }
        System.err.println(result);
    }

    public static double ecm(int num1, int num2) throws EcmDef{
        if (num1<0||num2<0) {
            throw new EcmDef("分子或者分母为负数啦！");
        }
        return num1 / num2;
    }
}
