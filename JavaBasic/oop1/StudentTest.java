/*
 * @Author: Sxuet
 * @Date: 2021-05-16 21:05:56
 * @LastEditTime: 2021-05-16 21:27:28
 * @LastEditors: Sxuet
 * @FilePath: /Javasource_SGG/oop/StudentTest.java
 * @Description: 
 */

public class StudentTest{
    /**
     * @description: 
     * @Author: Sxuet
     * @Date: 2021-05-16 21:27:18
     * @param {Student[]} students
     * @return {*}
     */
    public static void bubbleSort(Student[] students) {
        for (int i = 0; i < students.length-1; i++) {
            for (int j = 0; j < students.length-i-1; j++) {
                if (students[j].score>students[j+1].score) {
                    Student temp = students[j];
                    students[j] = students[j+1];
                    students[j+1]=temp;
                }
            }
        }
    }
    public static void main(String[] args) {
        int studentNum = 20;
        Student[] students = new Student[studentNum];
        //赋值
        for (int i = 0; i < studentNum; i++) {
            students[i] = new Student();
            students[i].number = i+1;
            students[i].score = (int)(Math.random()*(100-0+1));//[0,100]
            students[i].state = (int)(Math.random()*(6-1+1)+1);//[1,6]
        }

        //排序
        bubbleSort(students);

        //打印
        for (Student student : students) {
            System.out.println("student[number:"+student.number+",state:"+student.state+",score:"+student.score+"]");
        }



    }
}

class Student{
    int number;
    int state;
    int score;
}