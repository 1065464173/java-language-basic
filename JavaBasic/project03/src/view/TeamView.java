/*
 * @Author: Sxuet
 * @Date: 2021-06-07 14:34:31
 * @LastEditTime: 2021-06-07 16:01:01
 * @LastEditors: Sxuet
 * @FilePath: /project03/src/view/TeamView.java
 * @Description: 
 */
package view;

import domain.*;
import service.*;

public class TeamView {
    private NameListService listSvc = new NameListService();
    private TeamService teamSvc = new TeamService();

    /**
     * @description: 显示主界面以及控制方法
     * @Author: Sxuet
     * @Date: 2021-06-07 14:45:20
     * @param {*}
     * @return {*}
     */
    public void enterMainMenu() {

        boolean loopFlag = true;
        char choice = 0;
        while (loopFlag) {
            if (choice != '1') {
                listAllEmployees();
            }
            System.out.println("1-团队成员 2-添加成员 3-删除成员 4-退出 请选择（1-4）");
            choice = TSUtility.readMenuSelection();
            switch (choice) {
                case '1':
                    getTeam();
                    break;
                case '2':
                    addMember();
                    break;
                case '3':
                    deleteMember();
                    break;
                case '4':
                    System.out.println("确认是否退出（Y/N）");
                    char isExit = TSUtility.readConfirmSelection();
                    if ('Y' == isExit) {
                        loopFlag = false;
                        System.out.println("Good Bye~");
                    }
                    break;

                default:
                    break;
            }
        }

    }

    /**
     * @description: 表格形式列出所有公司成员
     * @Author: Sxuet
     * @Date: 2021-06-07 14:45:41
     * @param {*}
     * @return {*}
     */
    private void listAllEmployees() {
        System.out.println("-------------------------------开发团队调度软件------------------------------");
        System.out.println("ID\t姓名\t年龄\t工资\t职位\t状态\t奖金\t股票\t领用设备\t");
        Employee[] employees = listSvc.getAllEmployees();
        if (employees == null || employees.length == 0) {
            System.out.println("暂无公司员工信息");
            return;
        }
        for (int i = 0; i < employees.length; i++) {
            System.out.println(employees[i]);
        }

    }

    /**
     * @description: 显示团队成员列表操作
     * @Author: Sxuet
     * @Date: 2021-06-07 14:46:03
     * @param {*}
     * @return {*}
     */
    private void getTeam() {
        System.out.println("-------------------------------查看当前团队信息------------------------------");
        Programmer[] team = teamSvc.getTeam();
        if (team == null || team.length == 0) {
            System.out.println("开发团队中暂无成员");
        }else{
            System.out.println("TID/ID\t姓名\t年龄\t工资\t职位\t奖金\t股票\t");
            for (int i = 0; i < team.length; i++) {
                System.out.println(team[i].getDetailForTeam());
            }

        }
    }

    /**
     * @description: 实现添加成员操作
     * @Author: Sxuet
     * @Date: 2021-06-07 14:46:22
     * @param {*}
     * @return {*}
     */
    private void addMember() {
        System.out.println("-------------------------------增加团队成员------------------------------");
        System.out.println("输入添加成员的id");
        int id = TSUtility.readInt();
        Employee employee;
        try {
            employee = listSvc.getEmployeeId(id);
            teamSvc.addMember(employee);
            System.out.println("添加成功！");

        } catch (TeamException e) {
            System.out.println(e.getMessage());
        }
        TSUtility.readReturn();

    }

    /**
     * @description: 实现删除成员操作
     * @Author: Sxuet
     * @Date: 2021-06-07 14:46:38
     * @param {*}
     * @return {*}
     */
    private void deleteMember() {
        System.out.println("-------------------------------删除指定团队成员------------------------------");
        System.out.println("输入删除成员的tid");
        int id = TSUtility.readInt();
        try {
            teamSvc.removeMember(id);
            System.out.println("删除成功！");
            TSUtility.readReturn();
        } catch (TeamException e) {
            System.out.println(e.getMessage());
        }

    }

    public static void main(String[] args) {
        TeamView teamView = new TeamView();
        teamView.enterMainMenu();
    }

}
