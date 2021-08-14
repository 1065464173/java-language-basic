/*
 * @Author: Sxuet
 * @Date: 2021-06-05 17:46:01
 * @LastEditTime: 2021-06-07 15:27:48
 * @LastEditors: Sxuet
 * @FilePath: /project03/src/service/NameListService.java
 * @Description: 
 */
package service;

import domain.*;

public class NameListService {
    
    private Employee[] employees;

    /**
     * @description: 给employee及数组元素初始化
     * @Author: Sxuet
     * @Date: 2021-06-05 20:18:48
     * @param {*}
     * @return {*}
     */
    public NameListService() {

        employees = new Employee[Data.EMPLOYEES.length];

        for (int i = 0; i < employees.length; i++) {

            int id = Integer.parseInt(Data.EMPLOYEES[i][1]);
            String name = Data.EMPLOYEES[i][2];
            int age = Integer.parseInt(Data.EMPLOYEES[i][3]);
            double salary = Double.parseDouble(Data.EMPLOYEES[i][4]);
            Status status = Status.FREE;
            Equipment equipment;
            double bonus;
            int stock;

            switch (Integer.parseInt(Data.EMPLOYEES[i][0])) {
                case Data.EMPLOYEE:
                    employees[i] = new Employee(id, name, age, salary);
                    break;
                case Data.PROGRAMMER:
                    equipment = creatEquipment(i);
                    employees[i] = new Programmer(id, name, age, salary,status, equipment);
                    break;
                case Data.DESIGNER:
                    bonus = Double.parseDouble(Data.EMPLOYEES[i][5]);
                    equipment = creatEquipment(i);
                    employees[i] = new Designer(id, name, age, salary,status, equipment, bonus);
                    break;
                case Data.ARCHITECT:
                    equipment = creatEquipment(i);
                    bonus = Double.parseDouble(Data.EMPLOYEES[i][5]);
                    stock = Integer.parseInt(Data.EMPLOYEES[i][6]);
                    employees[i] = new Architect(id, name, age, salary, status,equipment, bonus, stock);
                    break;
                default:
                    break;
            }

        }
    }

    /**
     * @description: 获取指定index员工的设备
     * @Author: Sxuet
     * @Date: 2021-06-05 21:03:49
     * @param {*}
     * @return {*}
     */
    private Equipment creatEquipment(int i) {
        int type = Integer.parseInt(Data.EQUIPMENTS[i][0]);
        String modelOrName = Data.EQUIPMENTS[i][1];
        String displayOrPriceOrType = Data.EQUIPMENTS[i][2];
        switch (type) {
            case Data.PC:
                return new PC(modelOrName, displayOrPriceOrType);
            case Data.NOTEBOOK:
                return new NoteBook(modelOrName, Double.parseDouble(displayOrPriceOrType));
            case Data.PRINTER:
                return new Printer(modelOrName, displayOrPriceOrType);
            default:
                break;
        }
        return null;
    }

    /**
     * @description: 获取当前所有员工
     * @Author: Sxuet
     * @Date: 2021-06-05 21:22:16
     * @param {*}
     * @return {*}
     */    
    public Employee[] getAllEmployees() {
        return employees;
    }

    /**
     * @description: 获取指定id 的员工
     * @Author: Sxuet
     * @Date: 2021-06-05 21:22:33
     * @param {int} id
     * @return {*}
     */    
    public Employee getEmployeeId(int id) throws TeamException {
        for (int i = 0; i < employees.length; i++) {
            if (employees[i].getId()==id) {
                return employees[i];
            }
        }
        throw new TeamException("找不到指定员工");
    }
}
