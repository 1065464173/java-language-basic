package view;

import bean.Customer;
import service.CustomerList;
import util.CMUtility;

/*
 * @Author: Sxuet
 * @Date: 2021-05-19 20:04:34
 * @LastEditTime: 2021-05-22 23:31:40
 * @LastEditors: Sxuet
 * @FilePath: /JavaSE_learning/Javasource_SGG/customer-manager/src/view/CustomerView.java
 * @Description: 
 */
public class CustomerView {
    private CustomerList customerList = new CustomerList(10);

    CustomerView() {
    }

    /**
     * @description: 显示界面
     * @Author: Sxuet
     * @Date: 2021-05-19 21:24:36
     * @param {*}
     * @return {*}
     */
    public void enterMainMenu() {
        boolean isFlag = true;
        while (isFlag) {
            System.out.println("\n----------------信息管理系统--------------------");
            System.out.println("-----------------1 添加客户-------------------");
            System.out.println("-----------------2 修改客户-------------------");
            System.out.println("-----------------3 删除客户-------------------");
            System.out.println("-----------------4 客户列表-------------------");
            System.out.println("-----------------5 退   出-------------------");
            System.out.print("                  请选择（1-5):");
            char choice = CMUtility.readMenuSelection();
            switch (choice) {
                case '1':
                    addNewCustomer();
                    break;
                case '2':
                    modifyCustomer();
                    break;
                case '3':
                    deleteCustomer();
                    break;
                case '4':
                    listAllCustomers();
                    break;
                case '5':
                    System.out.println("是否确认退出？(Y/N)");
                    char confirm = CMUtility.readConfirmSelection();
                    if (confirm == 'Y') {
                        isFlag = false;
                    }
                    break;
                default:
                    break;
            }
        }

    }

    private void addNewCustomer() {
        String name;
        char gender;
        int age;
        String phone;
        String email;
        System.out.println("请输入添加的客户姓名");
        name = CMUtility.readString(5);
        System.out.println("请输入添加的客户姓别");
        gender = CMUtility.readChar();
        System.out.println("请输入添加的客户年龄");
        age = CMUtility.readInt();
        System.out.println("请输入添加的客户电话");
        phone = CMUtility.readString(11);
        System.out.println("请输入添加的客户邮箱");
        email = CMUtility.readString(30);
        Customer customer = new Customer(name, gender, age, phone, email);
        boolean isSuccess = customerList.addCustomer(customer);
        if (isSuccess) {
            System.out.println("添加成功");

        } else {
            System.out.println("添加失败");
        }

    }

    private void modifyCustomer() {
        System.out.println("请输入需要修改的客户的编号");
        int num = CMUtility.readInt();
        Customer[] customers = customerList.getAllCustomers();
        if (customers[num - 1] == null) {
            System.out.println("无该客户");
            return;
        }
        String name;
        char gender;
        int age;
        String phone;
        String email;
        System.out.println("请输入修改的客户姓名");
        name = CMUtility.readString(5);
        System.out.println("请输入修改的客户姓别");
        gender = CMUtility.readChar();
        System.out.println("请输入修改的客户年龄");
        age = CMUtility.readInt();
        System.out.println("请输入修改的客户电话");
        phone = CMUtility.readString(11);
        System.out.println("请输入修改的客户邮箱");
        email = CMUtility.readString(30);
        Customer customer = new Customer(name, gender, age, phone, email);
        boolean isSuccess = customerList.replaceCustomer(num - 1, customer);
        if (isSuccess) {
            System.out.println("修改成功");
        } else {
            System.out.println("修改失败");
        }
    }

    private void deleteCustomer() {
        System.out.println("请输入需要修改的客户的编号");
        int num = CMUtility.readInt();
        Customer[] customers = customerList.getAllCustomers();
        if (customers[num - 1] == null) {
            System.out.println("无该客户");
            return;
        }
        boolean isSucess = customerList.deleteCustomer(num - 1);
        if (isSucess) {
            System.out.println("删除成功");

        } else {
            System.out.println("删除失败");
        }
    }

    private void listAllCustomers() {

        System.out.println("list");
        System.out.println("-------------------客 户 列 表-------------------");
        int total = customerList.getTotal();
        if (total == 0) {
            System.out.println("没有客户记录");
            return;
        }
        System.out.println("编号\t姓名\t性别\t年龄\t电话\t\t邮箱");
        Customer[] customers = customerList.getAllCustomers();
        for (int i = 0; i < total; i++) {
            System.out.println((i + 1) + "\t" + customers[i].getName() + "\t" + customers[i].getGender() + "\t"
                    + customers[i].getAge() + "\t" + customers[i].getPhone() + "\t" + customers[i].getEmail());
        }
        System.out.println("-------------------客户列表完成-------------------");

    }

    public static void main(String[] args) {
        CustomerView cv = new CustomerView();
        cv.enterMainMenu();
    }
}
