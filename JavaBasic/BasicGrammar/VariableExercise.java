/**
 * VariableExercise
 */
public class VariableExercise {
    public static void main(String[] args) {
        // 判断对错
        // String str1 = 4; // Type mismatch: cannot convert from int to String
        
        String str2 = 3.5f + ""; 
        System.out.println(str2);
        
        short s = 5;
        System.out.println(s);
        // s = s-2 ; //Type mismatch: cannot convert from int to short 

        byte b = 3;
        // b = b+4 ;//Type mismatch: cannot convert from int to byte
        b = (byte)(b+4);

        // s = s+b;//Type mismatch: cannot convert from int to byte

        char c = '1';
        // c =c+2; // Type mismatch: cannot convert from int to char 会改变数据类
        // c+=2; //不会改变数据类型
        System.out.println((int)c);

        

    }

}